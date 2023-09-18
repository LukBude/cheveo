package com.cheveo.backend.rest.controller;

import com.cheveo.backend.persistence.entity.AddressEntity;
import com.cheveo.backend.persistence.entity.EmployeeEntity;
import com.cheveo.backend.persistence.service.EmployeeService;
import com.cheveo.backend.rest.mapper.EmployeeResourceMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@TestPropertySource(locations = {"classpath:application.yaml"})
class EmployeeControllerTest {

  @Value("${apiPrefix}")
  private String apiPrefix;
  private ObjectMapper objectMapper = new ObjectMapper();

  @Mock
  private EmployeeService employeeService;
  @Spy
  private EmployeeResourceMapper employeeResourceMapper = EmployeeResourceMapper.INSTANCE;
  @InjectMocks
  private EmployeeController controller;

  private MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    mockMvc = MockMvcBuilders
      .standaloneSetup(controller)
      .addPlaceholderValue("apiPrefix", apiPrefix)
      .build();
  }

  @Test
  void test_GetEmployee() throws Exception {
    when(employeeService.getEmployee(any(Long.class))).thenReturn(Optional.of(createEmployeeEntity()));
    String expectedResponse = objectMapper.readTree(getClass().getResource("/get-employee-response.json")).toString();

    String response = mockMvc.perform(get(apiPrefix + "/" + "employees" + "/" + "0"))
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
      .andReturn()
      .getResponse()
      .getContentAsString();

    assertThat(response).isEqualTo(expectedResponse);
  }

  private EmployeeEntity createEmployeeEntity() {
    EmployeeEntity employeeEntity = new EmployeeEntity();
    employeeEntity.setFirstName("Max");
    employeeEntity.setLastName("Mustermann");

    String birthDateString = "1992-02-24"; // Replace with your date string
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate birthDate = LocalDate.parse(birthDateString, dateTimeFormatter);
    employeeEntity.setBirthDate(birthDate);

    employeeEntity.setPhone("01234 473923");
    employeeEntity.setAddress(createAddressEntity());
    return employeeEntity;
  }

  private AddressEntity createAddressEntity() {
    AddressEntity addressEntity = new AddressEntity();
    addressEntity.setCity("Bonn");
    addressEntity.setZip("53225");
    addressEntity.setStreet("Musterstrasse");
    addressEntity.setNumber("1 A");
    return addressEntity;
  }

}