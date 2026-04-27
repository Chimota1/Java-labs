package org.example.demo.repository;

import org.example.demo.model.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class VehicleRepository {
    private final Map<Long, Vehicle> store = new HashMap<>();
    private final AtomicLong counter = new AtomicLong(1);

    public List<Vehicle> findAll() { return new ArrayList<>(store.values()); }

    public Optional<Vehicle> findById(Long id) { return Optional.ofNullable(store.get(id)); }

    public Vehicle save(Vehicle v) {
        if (v.getId() == null) v.setId(counter.getAndIncrement());
        store.put(v.getId(), v);
        return v;
    }

    public boolean deleteById(Long id) { return store.remove(id) != null; }
}