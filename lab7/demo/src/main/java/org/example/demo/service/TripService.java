package org.example.demo.service;

import org.example.demo.dto.TripDto;
import org.example.demo.mapper.TripMapper;
import org.example.demo.model.Trip;
import org.example.demo.repository.TripRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TripService {
    private final TripRepository repository;
    private final JdbcTemplate jdbcTemplate;
    private final TripMapper mapper;

    public TripService(TripRepository repository, JdbcTemplate jdbcTemplate, TripMapper mapper) {
        this.repository = repository;
        this.jdbcTemplate = jdbcTemplate;
        this.mapper = mapper;
    }

    public List<TripDto> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<TripDto> getById(Long id) {
        return repository.findById(id).map(mapper::toDto);
    }

    public TripDto create(TripDto dto) {
        Trip entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    public Optional<TripDto> update(Long id, TripDto updatedDto) {
        if (!repository.existsById(id)) return Optional.empty();

        Trip entity = mapper.toEntity(updatedDto);
        entity.setId(id);
        return Optional.of(mapper.toDto(repository.save(entity)));
    }

    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    // Метод через JdbcTemplate (Пошук за статусом)
    public List<TripDto> getByStatusViaJdbc(String status) {
        String sql = "SELECT * FROM trips WHERE status = ?";

        List<Trip> trips = jdbcTemplate.query(sql, (rs, rowNum) -> {
            Trip trip = new Trip();
            trip.setId(rs.getLong("id"));
            trip.setRoute(rs.getString("route"));
            trip.setDriverId(rs.getLong("driver_id"));
            trip.setVehicleId(rs.getLong("vehicle_id"));
            trip.setDistance(rs.getInt("distance"));
            trip.setStatus(rs.getString("status"));
            return trip;
        }, status);

        return trips.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}