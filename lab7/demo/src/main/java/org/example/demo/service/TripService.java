package org.example.demo.service;

import org.example.demo.model.Trip;
import org.example.demo.repository.TripRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripService {
    private final TripRepository repository;

    public TripService(TripRepository repository) { this.repository = repository; }

    public List<Trip> getAll() { return repository.findAll(); }

    public Optional<Trip> getById(Long id) { return repository.findById(id); }

    public Trip create(Trip t) { return repository.save(t); }

    public Optional<Trip> update(Long id, Trip updated) {
        return repository.findById(id).map(existing -> {
            updated.setId(id);
            return repository.save(updated);
        });
    }

    public Optional<Trip> patch(Long id, Trip patch) {
        return repository.findById(id).map(existing -> {
            if (patch.getRoute() != null) existing.setRoute(patch.getRoute());
            if (patch.getDate() != null) existing.setDate(patch.getDate());
            if (patch.getStatus() != null) existing.setStatus(patch.getStatus());
            if (patch.getDistanceKm() > 0) existing.setDistanceKm(patch.getDistanceKm());
            if (patch.getVehicleId() != null) existing.setVehicleId(patch.getVehicleId());
            if (patch.getDriverId() != null) existing.setDriverId(patch.getDriverId());
            return repository.save(existing);
        });
    }

    public boolean delete(Long id) { return repository.deleteById(id); }
}