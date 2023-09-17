/*
 * Copyright parcIT GmbH
 *
 * Dieser Source-Code steht unter dem alleinigen Urheberschutz der parcIT GmbH.
 * Die Nutzung und Weitergabe ist nur mit ausdrücklicher Erlaubnis der parcIT GmbH gestattet.
 */

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

}
