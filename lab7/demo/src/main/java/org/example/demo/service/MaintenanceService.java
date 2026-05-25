package org.example.demo.service;

import org.example.demo.dto.MaintenanceDto;
import org.example.demo.mapper.MaintenanceMapper;
import org.example.demo.model.Maintenance;
import org.example.demo.model.Vehicle;
import org.example.demo.repository.MaintenanceRepository;
import org.example.demo.repository.VehicleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceService {
    private final MaintenanceRepository repository;
    private final VehicleRepository vehicleRepository;
    private final MaintenanceMapper mapper;

    public MaintenanceService(MaintenanceRepository repository, VehicleRepository vehicleRepository, MaintenanceMapper mapper) {
        this.repository = repository;
        this.vehicleRepository = vehicleRepository;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<MaintenanceDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Optional<MaintenanceDto> getById(Long id) {
        return repository.findById(id).map(mapper::toDto);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public MaintenanceDto create(MaintenanceDto dto) {
        Vehicle vehicle = vehicleRepository.findById(dto.getVehicleId()).orElseThrow();
        Maintenance entity = mapper.toEntity(dto);
        entity.setVehicle(vehicle);
        return mapper.toDto(repository.save(entity));
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Optional<MaintenanceDto> update(Long id, MaintenanceDto updatedDto) {
        if (!repository.existsById(id)) {
            return Optional.empty();
        }

        Vehicle vehicle = vehicleRepository.findById(updatedDto.getVehicleId()).orElseThrow();
        Maintenance entity = mapper.toEntity(updatedDto);
        entity.setId(id);
        entity.setVehicle(vehicle);
        return Optional.of(mapper.toDto(repository.save(entity)));
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<MaintenanceDto> getByVehicleIdViaJdbc(Long vehicleId) {
        return repository.findByVehicle_Id(vehicleId).stream().map(mapper::toDto).toList();
    }
}

