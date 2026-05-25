package org.example.demo.service;

import org.example.demo.dto.TripDto;
import org.example.demo.mapper.TripMapper;
import org.example.demo.model.Driver;
import org.example.demo.model.Trip;
import org.example.demo.model.Vehicle;
import org.example.demo.repository.DriverRepository;
import org.example.demo.repository.TripRepository;
import org.example.demo.repository.VehicleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TripService {
    private final TripRepository repository;
    private final DriverRepository driverRepository;
    private final VehicleRepository vehicleRepository;
    private final TripMapper mapper;

    public TripService(
            TripRepository repository,
            DriverRepository driverRepository,
            VehicleRepository vehicleRepository,
            TripMapper mapper
    ) {
        this.repository = repository;
        this.driverRepository = driverRepository;
        this.vehicleRepository = vehicleRepository;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<TripDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Optional<TripDto> getById(Long id) {
        return repository.findById(id).map(mapper::toDto);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public TripDto create(TripDto dto) {
        Driver driver = driverRepository.findById(dto.getDriverId()).orElseThrow();
        Vehicle vehicle = vehicleRepository.findById(dto.getVehicleId()).orElseThrow();

        Trip entity = mapper.toEntity(dto);
        entity.setDriver(driver);
        entity.setVehicle(vehicle);

        return mapper.toDto(repository.save(entity));
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Optional<TripDto> update(Long id, TripDto updatedDto) {
        if (!repository.existsById(id)) {
            return Optional.empty();
        }

        Driver driver = driverRepository.findById(updatedDto.getDriverId()).orElseThrow();
        Vehicle vehicle = vehicleRepository.findById(updatedDto.getVehicleId()).orElseThrow();

        Trip entity = mapper.toEntity(updatedDto);
        entity.setId(id);
        entity.setDriver(driver);
        entity.setVehicle(vehicle);

        return Optional.of(mapper.toDto(repository.save(entity)));
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<TripDto> getByStatusViaJdbc(String status) {
        return repository.findByStatusWithJoins(status).stream().map(mapper::toDto).toList();
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<TripDto> getNPlusOneDemo() {
        return repository.findAllForNPlusOne().stream().map(mapper::toDto).toList();
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<TripDto> getOptimizedDemo() {
        return repository.findAllWithDriverAndVehicle().stream().map(mapper::toDto).toList();
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Page<TripDto> getPagedTrips(Pageable pageable) {
        return repository.findTripPageDto(pageable);
    }
}

