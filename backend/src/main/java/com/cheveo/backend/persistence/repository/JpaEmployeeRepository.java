package com.cheveo.backend.persistence.repository;

import com.cheveo.backend.persistence.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaEmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

}
