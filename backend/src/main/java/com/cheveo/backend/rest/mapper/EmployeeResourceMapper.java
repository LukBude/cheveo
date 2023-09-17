package com.cheveo.backend.rest.mapper;/*
 * Copyright parcIT GmbH
 *
 * Dieser Source-Code steht unter dem alleinigen Urheberschutz der parcIT GmbH.
 * Die Nutzung und Weitergabe ist nur mit ausdrücklicher Erlaubnis der parcIT GmbH gestattet.
 */

import com.cheveo.backend.persistence.entity.EmployeeEntity;
import com.cheveo.backend.rest.resource.EmployeeResource;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EmployeeResourceMapper {

  EmployeeResourceMapper INSTANCE = Mappers.getMapper(EmployeeResourceMapper.class);

  EmployeeResource toResource(EmployeeEntity employeeEntity);

  List<EmployeeResource> toResource(List<EmployeeEntity> employeeEntities);

  EmployeeEntity fromResource(EmployeeResource employeeResource);

}
