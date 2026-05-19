package org.example.demo.mapper;

import org.example.demo.dto.VehicleDto;
import org.example.demo.model.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VehicleMapper {
    VehicleDto toDto(Vehicle vehicle);
    Vehicle toEntity(VehicleDto vehicleDto);
}