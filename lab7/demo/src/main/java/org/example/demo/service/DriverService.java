package org.example.demo.service;

import org.example.demo.dto.DriverDto;
import org.example.demo.mapper.DriverMapper;
import org.example.demo.model.Driver;
import org.example.demo.repository.DriverRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {
    private final DriverRepository repository;
    private final DriverMapper mapper;

    public DriverService(DriverRepository repository, DriverMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<DriverDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Optional<DriverDto> getById(Long id) {
        return repository.findById(id).map(mapper::toDto);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public DriverDto create(DriverDto dto) {
        Driver entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Optional<DriverDto> update(Long id, DriverDto updatedDto) {
        if (!repository.existsById(id)) {
            return Optional.empty();
        }

        Driver entity = mapper.toEntity(updatedDto);
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
    public List<DriverDto> getByCategoryViaJdbc(String category) {
        return repository.findByCategoryWithProfile(category).stream().map(mapper::toDto).toList();
    }
}

