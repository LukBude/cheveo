package com.cheveo.backend.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Entity(name = "employees")
@Getter
@Setter
@NoArgsConstructor
public class EmployeeEntity {

  @Id
  @GeneratedValue
  private Long id;

  private String firstName;
  private String lastName;
  private LocalDate birthDate;
  private String phone;

  @OneToOne
  private AddressEntity address;

}
