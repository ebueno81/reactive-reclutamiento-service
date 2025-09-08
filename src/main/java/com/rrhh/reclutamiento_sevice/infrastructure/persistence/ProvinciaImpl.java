package com.rrhh.reclutamiento_sevice.infrastructure.persistence;

import com.rrhh.reclutamiento_sevice.application.mapper.ProvinciaMapper;
import com.rrhh.reclutamiento_sevice.domain.model.Provincia;
import com.rrhh.reclutamiento_sevice.domain.port.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class ProvinciaImpl implements ProvinciaRepository {

    @Autowired
    ReactiveProvinciaRepository repository;

    @Override
    public Flux<Provincia> findAll() {
        return repository.findAll()
                .map(ProvinciaMapper::fromEntity);
    }

    @Override
    public Mono<Provincia> findById(String id) {
        return repository.findById(id)
                .map(ProvinciaMapper::fromEntity);
    }
}
