package com.rrhh.reclutamiento_sevice.infrastructure.persistence;

import com.rrhh.reclutamiento_sevice.application.mapper.EstadoCivilMapper;
import com.rrhh.reclutamiento_sevice.domain.model.EstadoCivil;
import com.rrhh.reclutamiento_sevice.domain.port.EstadoCivilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class EstadoCivilImpl implements EstadoCivilRepository {

    @Autowired
    ReactiveEstadoCivilRepository repository;

    @Override
    public Flux<EstadoCivil> findAll() {
        return repository.findByActivo(1)
                .map(EstadoCivilMapper::fromEntity);
    }

    @Override
    public Mono<EstadoCivil> findById(Long id) {
        return repository.findById(id)
                .map(EstadoCivilMapper::fromEntity);
    }
}
