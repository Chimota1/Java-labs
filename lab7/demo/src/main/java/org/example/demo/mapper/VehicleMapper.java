package org.example.demo.mapper;

import org.example.demo.dto.VehicleDto;
import org.example.demo.model.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VehicleMapper {
    VehicleDto toDto(Vehicle vehicle);

    @Mapping(target = "trips", ignore = true)
    @Mapping(target = "fuelLogs", ignore = true)
    @Mapping(target = "maintenances", ignore = true)
    @Mapping(target = "assignedDrivers", ignore = true)
    Vehicle toEntity(VehicleDto vehicleDto);
}
