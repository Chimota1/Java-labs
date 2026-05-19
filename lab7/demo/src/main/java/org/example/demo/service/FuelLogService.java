package org.example.demo.service;

import org.example.demo.dto.FuelLogDto;
import org.example.demo.mapper.FuelLogMapper;
import org.example.demo.model.FuelLog;
import org.example.demo.repository.FuelLogRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuelLogService {
    private final FuelLogRepository repository;
    private final JdbcTemplate jdbcTemplate;
    private final FuelLogMapper mapper;

    public FuelLogService(FuelLogRepository repository, JdbcTemplate jdbcTemplate, FuelLogMapper mapper) {
        this.repository = repository;
        this.jdbcTemplate = jdbcTemplate;
        this.mapper = mapper;
    }

    public List<FuelLogDto> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<FuelLogDto> getById(Long id) {
        return repository.findById(id).map(mapper::toDto);
    }

    public FuelLogDto create(FuelLogDto dto) {
        FuelLog entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    public Optional<FuelLogDto> update(Long id, FuelLogDto updatedDto) {
        if (!repository.existsById(id)) return Optional.empty();

        FuelLog entity = mapper.toEntity(updatedDto);
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
    public List<FuelLogDto> getByVehicleIdViaJdbc(Long vehicleId) {
        String sql = "SELECT * FROM fuel_logs WHERE vehicle_id = ?";

        List<FuelLog> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
            FuelLog entity = new FuelLog();
            entity.setId(rs.getLong("id"));
            entity.setVehicleId(rs.getLong("vehicle_id"));
            entity.setLiters(rs.getDouble("liters"));
            entity.setPricePerLiter(rs.getBigDecimal("price_per_liter"));
            entity.setRefuelDate(rs.getString("refuel_date"));
            return entity;
        }, vehicleId);

        return list.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}