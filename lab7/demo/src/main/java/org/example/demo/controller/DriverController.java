package org.example.demo.controller;

import org.example.demo.model.Driver;
import org.example.demo.service.DriverService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {
    private final DriverService service;

    public DriverController(DriverService service) { this.service = service; }

    @GetMapping
    public List<Driver> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Driver> getById(@PathVariable Long id) {
        return service.getById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Driver> create(@RequestBody Driver driver) {
        return ResponseEntity.status(201).body(service.create(driver));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Driver> update(@PathVariable Long id, @RequestBody Driver driver) {
        return service.update(id, driver).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Driver> patch(@PathVariable Long id, @RequestBody Driver driver) {
        return service.patch(id, driver).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.delete(id) ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}