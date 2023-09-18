package com.cheveo.backend.rest.controller;

import com.cheveo.backend.persistence.entity.EmployeeEntity;
import com.cheveo.backend.persistence.service.EmployeeService;
import com.cheveo.backend.rest.mapper.EmployeeResourceMapper;
import com.cheveo.backend.rest.resource.EmployeeResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("${apiPrefix}/employees")
@RequiredArgsConstructor
public class EmployeeController {

  private final EmployeeService employeeService;
  private final EmployeeResourceMapper employeeResourceMapper;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<EmployeeResource>> getEmployees() {
    List<EmployeeEntity> employeeEntities = employeeService.getEmployees();
    return ResponseEntity.ok(employeeResourceMapper.toResource(employeeEntities));
  }

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<EmployeeResource> getEmployee(@PathVariable Long id) {
    Optional<EmployeeEntity> employeeEntity = employeeService.getEmployee(id);
    return employeeEntity.map(entity -> ResponseEntity.ok(employeeResourceMapper.toResource(entity))).orElse(null);
  }

  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<EmployeeResource> createEmployee(@RequestBody EmployeeResource employeeResource) {
    EmployeeEntity employeeEntity = employeeResourceMapper.fromResource(employeeResource);
    EmployeeEntity createdEmployeeEntity = employeeService.createEmployee(employeeEntity);
    return ResponseEntity.ok(employeeResourceMapper.toResource(createdEmployeeEntity));
  }

  @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<EmployeeResource> updateEmployee(@PathVariable Long id, @RequestBody EmployeeResource employeeResource) {
    EmployeeEntity employeeEntity = employeeResourceMapper.fromResource(employeeResource);
    EmployeeEntity updatedEmployeeEntity = employeeService.updateEmployee(employeeEntity, id);
    return ResponseEntity.ok(employeeResourceMapper.toResource(updatedEmployeeEntity));
  }

  @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> removeEmployee(@PathVariable Long id) {
    employeeService.removeEmployee(id);
    return ResponseEntity.noContent().build();
  }

}
