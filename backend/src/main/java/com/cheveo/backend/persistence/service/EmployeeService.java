/*
 * Copyright parcIT GmbH
 *
 * Dieser Source-Code steht unter dem alleinigen Urheberschutz der parcIT GmbH.
 * Die Nutzung und Weitergabe ist nur mit ausdrücklicher Erlaubnis der parcIT GmbH gestattet.
 */

package com.cheveo.backend.persistence.service;

import com.cheveo.backend.persistence.entity.EmployeeEntity;
import com.cheveo.backend.persistence.repository.JpaEmployeeRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class EmployeeService {

  private final JpaEmployeeRepository employeeRepository;


  private List<EmployeeEntity> getEmployees() {
    return this.employeeRepository.findAll();
  }

  public Optional<EmployeeEntity> getEmployee(Long id) {
    return this.employeeRepository.findById(id);
  }
}
