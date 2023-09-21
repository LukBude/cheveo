package com.cheveo.backend.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "addresses")
@Getter
@Setter
@NoArgsConstructor
public class AddressEntity {

  @Id
  @GeneratedValue
  private Long id;

  private String city;
  private String zip;
  private String street;
  private String number;

}
