package com.rrhh.reclutamiento_sevice.infrastructure.persistence;

import com.rrhh.reclutamiento_sevice.application.mapper.SexoMapper;
import com.rrhh.reclutamiento_sevice.domain.model.Sexo;
import com.rrhh.reclutamiento_sevice.domain.port.SexoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class SexoImpl implements SexoRepository {

    @Autowired
    ReactiveSexoRepository repository;

    @Override
    public Flux<Sexo> findAll() {
        return repository.findByActivo(1)
                .map(SexoMapper::fromEntity);
    }

    @Override
    public Mono<Sexo> findById(Long id) {
        return repository.findById(id)
                .map(SexoMapper::fromEntity);
    }
}
