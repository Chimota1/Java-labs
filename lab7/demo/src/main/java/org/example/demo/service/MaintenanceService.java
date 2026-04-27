package org.example.demo.service;

import org.example.demo.model.Maintenance;
import org.example.demo.repository.MaintenanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceService {
    private final MaintenanceRepository repository;

    public MaintenanceService(MaintenanceRepository repository) { this.repository = repository; }

    public List<Maintenance> getAll() { return repository.findAll(); }

    public Optional<Maintenance> getById(Long id) { return repository.findById(id); }

    public Maintenance create(Maintenance m) { return repository.save(m); }

    public Optional<Maintenance> update(Long id, Maintenance updated) {
        return repository.findById(id).map(existing -> {
            updated.setId(id);
            return repository.save(updated);
        });
    }

    public Optional<Maintenance> patch(Long id, Maintenance patch) {
        return repository.findById(id).map(existing -> {
            if (patch.getType() != null) existing.setType(patch.getType());
            if (patch.getDate() != null) existing.setDate(patch.getDate());
            if (patch.getCost() > 0) existing.setCost(patch.getCost());
            if (patch.getDescription() != null) existing.setDescription(patch.getDescription());
            if (patch.getVehicleId() != null) existing.setVehicleId(patch.getVehicleId());
            return repository.save(existing);
        });
    }

    public boolean delete(Long id) { return repository.deleteById(id); }
}