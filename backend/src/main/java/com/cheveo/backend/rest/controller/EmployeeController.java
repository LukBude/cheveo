/*
 * Copyright parcIT GmbH
 *
 * Dieser Source-Code steht unter dem alleinigen Urheberschutz der parcIT GmbH.
 * Die Nutzung und Weitergabe ist nur mit ausdrücklicher Erlaubnis der parcIT GmbH gestattet.
 */

package com.cheveo.backend.rest.controller;

import com.cheveo.backend.persistence.entity.EmployeeEntity;
import com.cheveo.backend.persistence.service.EmployeeService;
import com.cheveo.backend.rest.mapper.EmployeeResourceMapper;
import com.cheveo.backend.rest.resource.EmployeeResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

}
