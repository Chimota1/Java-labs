package org.example.demo.service;

import org.example.demo.dto.VehicleDto;
import org.example.demo.mapper.VehicleMapper;
import org.example.demo.model.Vehicle;
import org.example.demo.repository.VehicleRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleService {
    private final VehicleRepository repository;
    private final JdbcTemplate jdbcTemplate;
    private final VehicleMapper mapper;

    public VehicleService(VehicleRepository repository, JdbcTemplate jdbcTemplate, VehicleMapper mapper) {
        this.repository = repository;
        this.jdbcTemplate = jdbcTemplate;
        this.mapper = mapper;
    }

    public List<VehicleDto> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<VehicleDto> getById(Long id) {
        return repository.findById(id).map(mapper::toDto);
    }

    public VehicleDto create(VehicleDto dto) {
        Vehicle entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    public Optional<VehicleDto> update(Long id, VehicleDto updatedDto) {
        if (!repository.existsById(id)) return Optional.empty();

        Vehicle entity = mapper.toEntity(updatedDto);
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

    // Метод через JdbcTemplate
    public List<VehicleDto> getByMakeViaJdbc(String make) {
        String sql = "SELECT * FROM vehicles WHERE make = ?";

        List<Vehicle> vehicles = jdbcTemplate.query(sql, (rs, rowNum) -> {
            Vehicle vehicle = new Vehicle();
            vehicle.setId(rs.getLong("id"));
            vehicle.setMake(rs.getString("make"));
            vehicle.setModel(rs.getString("model"));
            vehicle.setLicensePlate(rs.getString("license_plate"));
            vehicle.setManufactureYear(rs.getInt("manufacture_year"));
            vehicle.setStatus(rs.getString("status"));
            return vehicle;
        }, make);

        return vehicles.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}