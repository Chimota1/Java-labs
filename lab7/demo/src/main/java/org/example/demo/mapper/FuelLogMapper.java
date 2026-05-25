package org.example.demo.mapper;

import org.example.demo.dto.FuelLogDto;
import org.example.demo.model.FuelLog;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface FuelLogMapper {

    @Mapping(target = "vehicleId", source = "vehicle.id")
    FuelLogDto toDto(FuelLog fuelLog);

    @Mapping(target = "vehicle", ignore = true)
    FuelLog toEntity(FuelLogDto fuelLogDto);
}

