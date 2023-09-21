package com.cheveo.backend.rest.mapper;

import org.mapstruct.Mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Mapper
public interface DateMapper {

  default LocalDate stringToLocalDate(String dateStr) {
    if (dateStr == null) {
      return null;
    }
    return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
  }

  default String localDateToString(LocalDate date) {
    if (date == null) {
      return null;
    }
    return date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
  }

}
