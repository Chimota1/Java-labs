package org.example.demo.service;

import org.example.demo.model.Vehicle;
import org.example.demo.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    private final VehicleRepository repository;

    public VehicleService(VehicleRepository repository) {
        this.repository = repository;
    }

    public List<Vehicle> getAll() { return repository.findAll(); }

    public Optional<Vehicle> getById(Long id) { return repository.findById(id); }

    public Vehicle create(Vehicle v) { return repository.save(v); }

    public Optional<Vehicle> update(Long id, Vehicle updated) {
        return repository.findById(id).map(existing -> {
            updated.setId(id);
            return repository.save(updated);
        });
    }

    public Optional<Vehicle> patch(Long id, Vehicle patch) {
        return repository.findById(id).map(existing -> {
            if (patch.getBrand() != null) existing.setBrand(patch.getBrand());
            if (patch.getModel() != null) existing.setModel(patch.getModel());
            if (patch.getStatus() != null) existing.setStatus(patch.getStatus());
            if (patch.getLicensePlate() != null) existing.setLicensePlate(patch.getLicensePlate());
            return repository.save(existing);
        });
    }

    public boolean delete(Long id) { return repository.deleteById(id); }
}