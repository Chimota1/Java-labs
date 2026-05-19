package org.example.demo.service;

import org.example.demo.dto.DriverDto;
import org.example.demo.mapper.DriverMapper;
import org.example.demo.model.Driver;
import org.example.demo.repository.DriverRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DriverService {
    private final DriverRepository repository;
    private final JdbcTemplate jdbcTemplate; // Додаємо сюди напряму
    private final DriverMapper mapper;

    // Впроваджуємо всі необхідні залежності через конструктор
    public DriverService(DriverRepository repository, JdbcTemplate jdbcTemplate, DriverMapper mapper) {
        this.repository = repository;
        this.jdbcTemplate = jdbcTemplate;
        this.mapper = mapper;
    }

    public List<DriverDto> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<DriverDto> getById(Long id) {
        return repository.findById(id).map(mapper::toDto);
    }

    public DriverDto create(DriverDto dto) {
        Driver entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    public Optional<DriverDto> update(Long id, DriverDto updatedDto) {
        if (!repository.existsById(id)) return Optional.empty();

        Driver entity = mapper.toEntity(updatedDto);
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

    // --- Метод, що використовує JdbcTemplate (Вимога 7) ---
    public List<DriverDto> getByCategoryViaJdbc(String category) {
        String sql = "SELECT * FROM drivers WHERE category = ?";

        // Виконуємо запит та мапимо результати (ResultSet) на об'єкт Driver
        List<Driver> drivers = jdbcTemplate.query(sql, (rs, rowNum) -> {
            Driver driver = new Driver();
            driver.setId(rs.getLong("id"));
            driver.setFullName(rs.getString("full_name"));
            driver.setLicenseNumber(rs.getString("license_number"));
            driver.setCategory(rs.getString("category"));
            driver.setStatus(rs.getString("status"));
            return driver;
        }, category);

        // Перетворюємо отриманих Driver у DTO для відправки контролеру
        return drivers.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}