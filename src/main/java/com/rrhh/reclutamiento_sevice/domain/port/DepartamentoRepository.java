package com.rrhh.reclutamiento_sevice.domain.port;

import com.rrhh.reclutamiento_sevice.domain.model.Departamento;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DepartamentoRepository {
    Flux<Departamento> findByAll();
    Mono<Departamento> findById(String id);
}
