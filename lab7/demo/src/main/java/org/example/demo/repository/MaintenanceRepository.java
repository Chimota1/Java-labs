package org.example.demo.repository;

import org.example.demo.model.Maintenance;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MaintenanceRepository {
    private final Map<Long, Maintenance> store = new HashMap<>();
    private final AtomicLong counter = new AtomicLong(1);

    public List<Maintenance> findAll() { return new ArrayList<>(store.values()); }

    public Optional<Maintenance> findById(Long id) { return Optional.ofNullable(store.get(id)); }

    public Maintenance save(Maintenance m) {
        if (m.getId() == null) m.setId(counter.getAndIncrement());
        store.put(m.getId(), m);
        return m;
    }

    public boolean deleteById(Long id) { return store.remove(id) != null; }
}