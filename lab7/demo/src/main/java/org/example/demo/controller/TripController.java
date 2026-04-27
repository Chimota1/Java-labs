package org.example.demo.controller;

import org.example.demo.model.Trip;
import org.example.demo.service.TripService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trips")
public class TripController {
    private final TripService service;

    public TripController(TripService service) { this.service = service; }

    @GetMapping
    public List<Trip> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Trip> getById(@PathVariable Long id) {
        return service.getById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Trip> create(@RequestBody Trip trip) {
        return ResponseEntity.status(201).body(service.create(trip));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trip> update(@PathVariable Long id, @RequestBody Trip trip) {
        return service.update(id, trip).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Trip> patch(@PathVariable Long id, @RequestBody Trip trip) {
        return service.patch(id, trip).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.delete(id) ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}