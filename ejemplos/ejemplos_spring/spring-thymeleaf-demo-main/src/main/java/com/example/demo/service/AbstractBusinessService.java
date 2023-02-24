package com.example.demo.service;

import com.example.demo.service.mapper.AbstractServiceMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class AbstractBusinessService<E, ID, DTO, REPO extends JpaRepository<E, ID>, MAPPER extends AbstractServiceMapper<E, DTO>> {
    private final REPO repository;
    private final MAPPER serviceMapper;

    protected AbstractBusinessService(REPO repository,
            MAPPER serviceMapper) {
        this.repository = repository;
        this.serviceMapper = serviceMapper;
    }

    public List<DTO> findAll() {
        return this.repository.findAll().stream().map(serviceMapper::toDto).collect(Collectors.toList());
    }

    public Page<DTO> findAll(Pageable pageable) {
        return this.repository.findAll(pageable).map(serviceMapper::toDto);
    }

    public Optional<DTO> findById(ID id) {
        return this.repository.findById(id).map(this.serviceMapper::toDto);
    }

    public DTO save(DTO dto) {
        final E entity = this.serviceMapper.toEntity(dto);
        final E savedEntity = this.repository.save(entity);
        return this.serviceMapper.toDto(savedEntity);
    }

    public void delete(ID id) {
        this.repository.deleteById(id);
    }

    public REPO getRepository() {
        return repository;
    }

    public MAPPER getServiceMapper() {
        return serviceMapper;
    }
}
