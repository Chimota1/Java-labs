package org.example.demo.service;

import org.example.demo.dto.MaintenanceDto;
import org.example.demo.mapper.MaintenanceMapper;
import org.example.demo.model.Maintenance;
import org.example.demo.repository.MaintenanceRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MaintenanceService {
    private final MaintenanceRepository repository;
    private final JdbcTemplate jdbcTemplate;
    private final MaintenanceMapper mapper;

    public MaintenanceService(MaintenanceRepository repository, JdbcTemplate jdbcTemplate, MaintenanceMapper mapper) {
        this.repository = repository;
        this.jdbcTemplate = jdbcTemplate;
        this.mapper = mapper;
    }

    public List<MaintenanceDto> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<MaintenanceDto> getById(Long id) {
        return repository.findById(id).map(mapper::toDto);
    }

    public MaintenanceDto create(MaintenanceDto dto) {
        Maintenance entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    public Optional<MaintenanceDto> update(Long id, MaintenanceDto updatedDto) {
        if (!repository.existsById(id)) return Optional.empty();

        Maintenance entity = mapper.toEntity(updatedDto);
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

    // Метод через JdbcTemplate (Пошук ремонтів для конкретної машини)
    public List<MaintenanceDto> getByVehicleIdViaJdbc(Long vehicleId) {
        String sql = "SELECT * FROM maintenances WHERE vehicle_id = ?";

        List<Maintenance> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
            Maintenance entity = new Maintenance();
            entity.setId(rs.getLong("id"));
            entity.setVehicleId(rs.getLong("vehicle_id"));
            entity.setDescription(rs.getString("description"));
            entity.setCost(rs.getBigDecimal("cost"));
            entity.setStatus(rs.getString("status"));
            return entity;
        }, vehicleId);

        return list.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}