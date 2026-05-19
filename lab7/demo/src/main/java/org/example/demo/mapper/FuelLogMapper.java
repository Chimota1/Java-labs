package org.example.demo.mapper;

import org.example.demo.dto.FuelLogDto;
import org.example.demo.model.FuelLog;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface FuelLogMapper {
    FuelLogDto toDto(FuelLog fuelLog);
    FuelLog toEntity(FuelLogDto fuelLogDto);
}