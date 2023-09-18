package com.cheveo.backend.rest.mapper;

import com.cheveo.backend.persistence.entity.AddressEntity;
import com.cheveo.backend.persistence.entity.EmployeeEntity;
import com.cheveo.backend.rest.resource.AddressResource;
import com.cheveo.backend.rest.resource.EmployeeResource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EmployeeResourceMapper {

  EmployeeResourceMapper INSTANCE = Mappers.getMapper(EmployeeResourceMapper.class);
  AddressResourceMapper ADDRESS_RESOURCE_MAPPER = Mappers.getMapper(AddressResourceMapper.class);

  @Mapping(source = "address", target = "address", qualifiedByName = "mapToAddressResource")
  EmployeeResource toResource(EmployeeEntity employeeEntity);

  List<EmployeeResource> toResource(List<EmployeeEntity> employeeEntities);

  @Mapping(source = "address", target = "address", qualifiedByName = "mapFromAddressResource")
  EmployeeEntity fromResource(EmployeeResource employeeResource);

  @Named("mapToAddressResource")
  static AddressResource mapToAddressResource(AddressEntity addressEntity) {
    return ADDRESS_RESOURCE_MAPPER.toResource(addressEntity);
  }

  @Named("mapFromAddressResource")
  static AddressEntity mapFromAddressResource(AddressResource addressResource) {
    return ADDRESS_RESOURCE_MAPPER.fromResource(addressResource);
  }

}
