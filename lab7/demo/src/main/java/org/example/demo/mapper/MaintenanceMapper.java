package org.example.demo.mapper;

import org.example.demo.dto.MaintenanceDto;
import org.example.demo.model.Maintenance;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MaintenanceMapper {

    @Mapping(target = "vehicleId", source = "vehicle.id")
    MaintenanceDto toDto(Maintenance maintenance);

    @Mapping(target = "vehicle", ignore = true)
    Maintenance toEntity(MaintenanceDto maintenanceDto);
}

