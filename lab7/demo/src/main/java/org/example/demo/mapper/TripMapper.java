package org.example.demo.mapper;

import org.example.demo.dto.TripDto;
import org.example.demo.model.Trip;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TripMapper {

    @Mapping(target = "driverId", source = "driver.id")
    @Mapping(target = "vehicleId", source = "vehicle.id")
    @Mapping(target = "driverName", source = "driver.fullName")
    @Mapping(target = "vehicleLicensePlate", source = "vehicle.licensePlate")
    TripDto toDto(Trip trip);

    @Mapping(target = "driver", ignore = true)
    @Mapping(target = "vehicle", ignore = true)
    Trip toEntity(TripDto tripDto);
}

