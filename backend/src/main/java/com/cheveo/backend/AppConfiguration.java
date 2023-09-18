package com.cheveo.backend;

import com.cheveo.backend.persistence.repository.JpaEmployeeRepository;
import com.cheveo.backend.persistence.service.EmployeeService;
import com.cheveo.backend.rest.mapper.AddressResourceMapper;
import com.cheveo.backend.rest.mapper.EmployeeResourceMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories
public class AppConfiguration {

  @Bean
  EmployeeResourceMapper employeeResourceMapper() {
    return EmployeeResourceMapper.INSTANCE;
  }

  @Bean
  EmployeeService employeeService(JpaEmployeeRepository employeeRepository) {
    return new EmployeeService(employeeRepository);
  }

  @Bean
  AddressResourceMapper addressResourceMapper() {
    return AddressResourceMapper.INSTANCE;
  }

}
