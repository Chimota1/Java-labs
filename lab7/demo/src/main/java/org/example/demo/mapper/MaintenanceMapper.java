package org.example.demo.mapper;

import org.example.demo.dto.MaintenanceDto;
import org.example.demo.model.Maintenance;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MaintenanceMapper {
    MaintenanceDto toDto(Maintenance maintenance);
    Maintenance toEntity(MaintenanceDto maintenanceDto);
}