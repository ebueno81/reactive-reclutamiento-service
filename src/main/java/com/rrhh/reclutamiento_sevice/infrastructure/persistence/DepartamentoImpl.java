package com.rrhh.reclutamiento_sevice.infrastructure.persistence;

import com.rrhh.reclutamiento_sevice.application.mapper.DepartamentoMapper;
import com.rrhh.reclutamiento_sevice.domain.model.Departamento;
import com.rrhh.reclutamiento_sevice.domain.port.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class DepartamentoImpl implements DepartamentoRepository {

    @Autowired
    ReactiveDepartamentoRepository repository;

    @Override
    public Flux<Departamento> findByAll() {
        return repository.findAll()
                .map(DepartamentoMapper::fromEntity);
    }

    @Override
    public Mono<Departamento> findById(String id) {
        return repository.findById(id)
                .map(DepartamentoMapper::fromEntity);
    }
}
