package com.cheveo.backend.rest.resource;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeResource {

  private String firstName;
  private String lastName;
  private String birthDate;
  private String phone;
  private AddressResource address;

}
