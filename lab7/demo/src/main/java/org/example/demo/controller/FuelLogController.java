package org.example.demo.controller;

import org.example.demo.model.FuelLog;
import org.example.demo.service.FuelLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fuel-logs")
public class FuelLogController {
    private final FuelLogService service;

    public FuelLogController(FuelLogService service) { this.service = service; }

    @GetMapping
    public List<FuelLog> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<FuelLog> getById(@PathVariable Long id) {
        return service.getById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<FuelLog> create(@RequestBody FuelLog fuelLog) {
        return ResponseEntity.status(201).body(service.create(fuelLog));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuelLog> update(@PathVariable Long id, @RequestBody FuelLog fuelLog) {
        return service.update(id, fuelLog).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<FuelLog> patch(@PathVariable Long id, @RequestBody FuelLog fuelLog) {
        return service.patch(id, fuelLog).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.delete(id) ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}