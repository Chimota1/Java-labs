package org.example.demo.repository;

import org.example.demo.model.FuelLog;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class FuelLogRepository {
    private final Map<Long, FuelLog> store = new HashMap<>();
    private final AtomicLong counter = new AtomicLong(1);

    public List<FuelLog> findAll() { return new ArrayList<>(store.values()); }

    public Optional<FuelLog> findById(Long id) { return Optional.ofNullable(store.get(id)); }

    public FuelLog save(FuelLog f) {
        if (f.getId() == null) f.setId(counter.getAndIncrement());
        store.put(f.getId(), f);
        return f;
    }

    public boolean deleteById(Long id) { return store.remove(id) != null; }
}