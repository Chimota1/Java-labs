package org.example.demo.controller;

import org.example.demo.model.Maintenance;
import org.example.demo.service.MaintenanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maintenance")
public class MaintenanceController {
    private final MaintenanceService service;

    public MaintenanceController(MaintenanceService service) { this.service = service; }

    @GetMapping
    public List<Maintenance> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Maintenance> getById(@PathVariable Long id) {
        return service.getById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Maintenance> create(@RequestBody Maintenance maintenance) {
        return ResponseEntity.status(201).body(service.create(maintenance));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Maintenance> update(@PathVariable Long id, @RequestBody Maintenance maintenance) {
        return service.update(id, maintenance).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Maintenance> patch(@PathVariable Long id, @RequestBody Maintenance maintenance) {
        return service.patch(id, maintenance).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.delete(id) ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}