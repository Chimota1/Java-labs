package org.example.demo.service;

import org.example.demo.dto.FuelLogDto;
import org.example.demo.mapper.FuelLogMapper;
import org.example.demo.model.FuelLog;
import org.example.demo.model.Vehicle;
import org.example.demo.repository.FuelLogRepository;
import org.example.demo.repository.VehicleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FuelLogService {
    private final FuelLogRepository repository;
    private final VehicleRepository vehicleRepository;
    private final FuelLogMapper mapper;

    public FuelLogService(FuelLogRepository repository, VehicleRepository vehicleRepository, FuelLogMapper mapper) {
        this.repository = repository;
        this.vehicleRepository = vehicleRepository;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<FuelLogDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Optional<FuelLogDto> getById(Long id) {
        return repository.findById(id).map(mapper::toDto);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public FuelLogDto create(FuelLogDto dto) {
        Vehicle vehicle = vehicleRepository.findById(dto.getVehicleId()).orElseThrow();
        FuelLog entity = mapper.toEntity(dto);
        entity.setVehicle(vehicle);
        return mapper.toDto(repository.save(entity));
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Optional<FuelLogDto> update(Long id, FuelLogDto updatedDto) {
        if (!repository.existsById(id)) {
            return Optional.empty();
        }

        Vehicle vehicle = vehicleRepository.findById(updatedDto.getVehicleId()).orElseThrow();
        FuelLog entity = mapper.toEntity(updatedDto);
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
    public List<FuelLogDto> getByVehicleIdViaJdbc(Long vehicleId) {
        return repository.findByVehicle_Id(vehicleId).stream().map(mapper::toDto).toList();
    }
}

