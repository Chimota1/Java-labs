package org.example.demo.controller;

import jakarta.validation.Valid;
import org.example.demo.dto.TripDto;
import org.example.demo.service.TripService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trips")
public class TripController {
    private final TripService service;

    public TripController(TripService service) {
        this.service = service;
    }

    @GetMapping
    public List<TripDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TripDto> getById(@PathVariable Long id) {
        return service.getById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TripDto> create(@Valid @RequestBody TripDto dto) {
        return ResponseEntity.status(201).body(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TripDto> update(@PathVariable Long id, @Valid @RequestBody TripDto dto) {
        return service.update(id, dto).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.delete(id) ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }

    @GetMapping("/status/{status}")
    public List<TripDto> getByStatus(@PathVariable String status) {
        return service.getByStatusViaJdbc(status);
    }

    @GetMapping("/demo/n-plus-one")
    public List<TripDto> nPlusOneDemo() {
        return service.getNPlusOneDemo();
    }

    @GetMapping("/demo/optimized")
    public List<TripDto> optimizedDemo() {
        return service.getOptimizedDemo();
    }

    @GetMapping("/paged")
    public Page<TripDto> getPaged(@PageableDefault(size = 20) Pageable pageable) {
        return service.getPagedTrips(pageable);
    }
}

