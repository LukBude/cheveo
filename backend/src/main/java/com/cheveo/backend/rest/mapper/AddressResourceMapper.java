package com.cheveo.backend.rest.mapper;/*
 * Copyright parcIT GmbH
 *
 * Dieser Source-Code steht unter dem alleinigen Urheberschutz der parcIT GmbH.
 * Die Nutzung und Weitergabe ist nur mit ausdrücklicher Erlaubnis der parcIT GmbH gestattet.
 */

import com.cheveo.backend.persistence.entity.AddressEntity;
import com.cheveo.backend.rest.resource.AddressResource;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressResourceMapper {

  AddressResourceMapper INSTANCE = Mappers.getMapper(AddressResourceMapper.class);

  AddressResource toResource(AddressEntity addressEntity);

  AddressEntity fromResource(AddressResource addressResource);

}
