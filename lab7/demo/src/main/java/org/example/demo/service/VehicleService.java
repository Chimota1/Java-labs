package org.example.demo.service;

import org.example.demo.dto.VehicleDto;
import org.example.demo.mapper.VehicleMapper;
import org.example.demo.model.Vehicle;
import org.example.demo.repository.VehicleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    private final VehicleRepository repository;
    private final VehicleMapper mapper;

    public VehicleService(VehicleRepository repository, VehicleMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<VehicleDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Optional<VehicleDto> getById(Long id) {
        return repository.findById(id).map(mapper::toDto);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public VehicleDto create(VehicleDto dto) {
        Vehicle entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Optional<VehicleDto> update(Long id, VehicleDto updatedDto) {
        if (!repository.existsById(id)) {
            return Optional.empty();
        }

        Vehicle entity = mapper.toEntity(updatedDto);
        entity.setId(id);
        return Optional.of(mapper.toDto(repository.save(entity)));
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<VehicleDto> getByMakeViaJdbc(String make) {
        return repository.findByMake(make).stream().map(mapper::toDto).toList();
    }
}

