package org.example.demo.repository;

import org.example.demo.model.Trip;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TripRepository {
    private final Map<Long, Trip> store = new HashMap<>();
    private final AtomicLong counter = new AtomicLong(1);

    public List<Trip> findAll() { return new ArrayList<>(store.values()); }

    public Optional<Trip> findById(Long id) { return Optional.ofNullable(store.get(id)); }

    public Trip save(Trip t) {
        if (t.getId() == null) t.setId(counter.getAndIncrement());
        store.put(t.getId(), t);
        return t;
    }

    public boolean deleteById(Long id) { return store.remove(id) != null; }
}