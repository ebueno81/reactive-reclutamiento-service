package com.rrhh.reclutamiento_sevice.infrastructure.persistence;

import com.rrhh.reclutamiento_sevice.application.mapper.GradoInstruccionMapper;
import com.rrhh.reclutamiento_sevice.domain.model.GradoInstruccion;
import com.rrhh.reclutamiento_sevice.domain.port.GradoInstruccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class GradoInstruccionImpl implements GradoInstruccionRepository {

    @Autowired
    ReactiveGradoInstruccion repository;

    @Override
    public Flux<GradoInstruccion> findAll() {
        return repository.findByActivo(1)
                .map(GradoInstruccionMapper::fromEntity);
    }

    @Override
    public Mono<GradoInstruccion> findById(Long id) {
        return repository.findById(id)
                .map(GradoInstruccionMapper::fromEntity);
    }
}
