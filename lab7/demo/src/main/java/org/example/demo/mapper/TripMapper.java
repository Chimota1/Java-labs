package org.example.demo.mapper;

import org.example.demo.dto.TripDto;
import org.example.demo.model.Trip;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TripMapper {
    TripDto toDto(Trip trip);
    Trip toEntity(TripDto tripDto);
}