package org.example.demo.service;

import org.example.demo.model.FuelLog;
import org.example.demo.repository.FuelLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuelLogService {
    private final FuelLogRepository repository;

    public FuelLogService(FuelLogRepository repository) { this.repository = repository; }

    public List<FuelLog> getAll() { return repository.findAll(); }

    public Optional<FuelLog> getById(Long id) { return repository.findById(id); }

    public FuelLog create(FuelLog f) { return repository.save(f); }

    public Optional<FuelLog> update(Long id, FuelLog updated) {
        return repository.findById(id).map(existing -> {
            updated.setId(id);
            return repository.save(updated);
        });
    }

    public Optional<FuelLog> patch(Long id, FuelLog patch) {
        return repository.findById(id).map(existing -> {
            if (patch.getDate() != null) existing.setDate(patch.getDate());
            if (patch.getLiters() > 0) existing.setLiters(patch.getLiters());
            if (patch.getCost() > 0) existing.setCost(patch.getCost());
            if (patch.getStation() != null) existing.setStation(patch.getStation());
            if (patch.getVehicleId() != null) existing.setVehicleId(patch.getVehicleId());
            return repository.save(existing);
        });
    }

    public boolean delete(Long id) { return repository.deleteById(id); }
}