package com.cheveo.backend;

import com.cheveo.backend.persistence.repository.JpaEmployeeRepository;
import com.cheveo.backend.persistence.service.EmployeeService;
import com.cheveo.backend.rest.mapper.AddressResourceMapper;
import com.cheveo.backend.rest.mapper.EmployeeResourceMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableJpaRepositories
public class AppConfiguration {

  @Bean
  public CorsFilter corsFilter() {
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    CorsConfiguration config = new CorsConfiguration();

    config.addAllowedOrigin("http://localhost:4200");
    config.addAllowedMethod("*");
    config.addAllowedHeader("*");

    source.registerCorsConfiguration("/**", config);
    return new CorsFilter(source);
  }

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
