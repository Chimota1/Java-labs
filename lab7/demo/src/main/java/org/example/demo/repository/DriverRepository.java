package org.example.demo.repository;

import org.example.demo.model.Driver;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class DriverRepository {
    private final Map<Long, Driver> store = new HashMap<>();
    private final AtomicLong counter = new AtomicLong(1);

    public List<Driver> findAll() { return new ArrayList<>(store.values()); }

    public Optional<Driver> findById(Long id) { return Optional.ofNullable(store.get(id)); }

    public Driver save(Driver d) {
        if (d.getId() == null) d.setId(counter.getAndIncrement());
        store.put(d.getId(), d);
        return d;
    }

    public boolean deleteById(Long id) { return store.remove(id) != null; }
}