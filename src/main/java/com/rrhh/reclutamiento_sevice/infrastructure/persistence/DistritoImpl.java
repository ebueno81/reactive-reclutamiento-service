package com.rrhh.reclutamiento_sevice.infrastructure.persistence;

import com.rrhh.reclutamiento_sevice.application.mapper.DistritoMapper;
import com.rrhh.reclutamiento_sevice.domain.model.Distrito;
import com.rrhh.reclutamiento_sevice.domain.port.DistritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class DistritoImpl implements DistritoRepository {

    @Autowired
    ReactiveDistritoRepository repository;

    @Override
    public Flux<Distrito> findAll() {
        return repository.findAll()
                .map(DistritoMapper::fromEntity);
    }

    @Override
    public Mono<Distrito> findById(String id) {
        return repository.findById(id)
                .map(DistritoMapper::fromEntity);
    }
}
