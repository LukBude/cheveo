package com.cheveo.backend.rest.resource;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddressResource {

  private String city;
  private String zip;
  private String street;
  private String number;

}
