package com.cheveo.backend.persistence.service;

import com.cheveo.backend.persistence.entity.AddressEntity;
import com.cheveo.backend.persistence.entity.EmployeeEntity;
import com.cheveo.backend.persistence.repository.JpaEmployeeRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class EmployeeService {

  private final JpaEmployeeRepository employeeRepository;

  public List<EmployeeEntity> getEmployees() {
    return this.employeeRepository.findAll();
  }

  public Optional<EmployeeEntity> getEmployee(Long id) {
    return employeeRepository.findById(id);
  }

  public EmployeeEntity createEmployee(EmployeeEntity employee) {
    return employeeRepository.save(employee);
  }

  public EmployeeEntity updateEmployee(EmployeeEntity updatedEmployee, Long id) {
    Optional<EmployeeEntity> requestedEmployee = employeeRepository.findById(id);
    if (requestedEmployee.isPresent()) {
      EmployeeEntity existingEmployee = requestedEmployee.get();

      existingEmployee.setFirstName(updatedEmployee.getFirstName());
      existingEmployee.setLastName(updatedEmployee.getLastName());
      existingEmployee.setBirthDate(updatedEmployee.getBirthDate());
      existingEmployee.setPhone(updatedEmployee.getPhone());

      AddressEntity existingAddress = existingEmployee.getAddress();
      AddressEntity updatedAddress = updatedEmployee.getAddress();
      existingAddress.setCity(updatedAddress.getCity());
      existingAddress.setZip(updatedAddress.getZip());
      existingAddress.setStreet(updatedAddress.getStreet());
      existingAddress.setNumber(updatedAddress.getNumber());
      existingEmployee.setAddress(existingAddress);

      return employeeRepository.save(existingEmployee);
    }
    return null;
  }

  public void removeEmployee(Long id) {
    Optional<EmployeeEntity> requestedEmployee = employeeRepository.findById(id);
    if (requestedEmployee.isPresent()) {
      employeeRepository.deleteById(id);
    }
  }

}
