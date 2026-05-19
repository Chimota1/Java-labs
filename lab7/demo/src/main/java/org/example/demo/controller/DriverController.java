package org.example.demo.controller;

import jakarta.validation.Valid;
import org.example.demo.dto.DriverDto;
import org.example.demo.service.DriverService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {
    private final DriverService service;

    public DriverController(DriverService service) {
        this.service = service;
    }

    @GetMapping
    public List<DriverDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DriverDto> getById(@PathVariable Long id) {
        return service.getById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DriverDto> create(@Valid @RequestBody DriverDto driverDto) {
        return ResponseEntity.status(201).body(service.create(driverDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DriverDto> update(@PathVariable Long id, @Valid @RequestBody DriverDto driverDto) {
        return service.update(id, driverDto).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.delete(id) ?
                ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    // Новий ендпоінт для перевірки JdbcTemplate
    @GetMapping("/category/{category}")
    public List<DriverDto> getByCategory(@PathVariable String category) {
        return service.getByCategoryViaJdbc(category);
    }
}