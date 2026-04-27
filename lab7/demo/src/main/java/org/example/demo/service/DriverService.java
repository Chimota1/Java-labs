package org.example.demo.service;

import org.example.demo.model.Driver;
import org.example.demo.repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {
    private final DriverRepository repository;

    public DriverService(DriverRepository repository) { this.repository = repository; }

    public List<Driver> getAll() { return repository.findAll(); }

    public Optional<Driver> getById(Long id) { return repository.findById(id); }

    public Driver create(Driver d) { return repository.save(d); }

    public Optional<Driver> update(Long id, Driver updated) {
        return repository.findById(id).map(existing -> {
            updated.setId(id);
            return repository.save(updated);
        });
    }

    public Optional<Driver> patch(Long id, Driver patch) {
        return repository.findById(id).map(existing -> {
            if (patch.getFullName() != null) existing.setFullName(patch.getFullName());
            if (patch.getLicenseNumber() != null) existing.setLicenseNumber(patch.getLicenseNumber());
            if (patch.getCategory() != null) existing.setCategory(patch.getCategory());
            if (patch.getStatus() != null) existing.setStatus(patch.getStatus());
            return repository.save(existing);
        });
    }

    public boolean delete(Long id) { return repository.deleteById(id); }
}