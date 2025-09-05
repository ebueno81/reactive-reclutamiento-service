package com.rrhh.reclutamiento_sevice.domain.port;

import com.rrhh.reclutamiento_sevice.domain.model.EstadoCivil;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EstadoCivilRepository {
    Flux<EstadoCivil> findAll();
    Mono<EstadoCivil> findById(Long id);
}
