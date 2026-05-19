package org.example.demo.controller;

import jakarta.validation.Valid;
import org.example.demo.dto.FuelLogDto;
import org.example.demo.service.FuelLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fuel-logs")
public class FuelLogController {
    private final FuelLogService service;

    public FuelLogController(FuelLogService service) {
        this.service = service;
    }

    @GetMapping
    public List<FuelLogDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuelLogDto> getById(@PathVariable Long id) {
        return service.getById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<FuelLogDto> create(@Valid @RequestBody FuelLogDto dto) {
        return ResponseEntity.status(201).body(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuelLogDto> update(@PathVariable Long id, @Valid @RequestBody FuelLogDto dto) {
        return service.update(id, dto).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.delete(id) ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }

    @GetMapping("/vehicle/{vehicleId}")
    public List<FuelLogDto> getByVehicleId(@PathVariable Long vehicleId) {
        return service.getByVehicleIdViaJdbc(vehicleId);
    }
}