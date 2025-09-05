package com.rrhh.reclutamiento_sevice.infrastructure.persistence;

import com.rrhh.reclutamiento_sevice.application.mapper.SistemaPensionMapper;
import com.rrhh.reclutamiento_sevice.domain.model.SistemaPension;
import com.rrhh.reclutamiento_sevice.domain.port.SistemaPensionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class SistemaPensionImpl implements SistemaPensionRepository {

    @Autowired
    ReactiveSistemaPensionRepository repository;

    @Override
    public Flux<SistemaPension> findAll() {
        return repository.findByActivo(1)
                .map(SistemaPensionMapper::fromEntity);
    }

    @Override
    public Mono<SistemaPension> findById(Long id) {
        return repository.findById(id)
                .map(SistemaPensionMapper::fromEntity);
    }
}
