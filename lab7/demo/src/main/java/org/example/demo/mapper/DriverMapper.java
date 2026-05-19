package org.example.demo.mapper;

import org.example.demo.dto.DriverDto;
import org.example.demo.model.Driver;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DriverMapper {
    DriverDto toDto(Driver driver);
    Driver toEntity(DriverDto driverDto);
}