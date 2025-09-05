package com.rrhh.reclutamiento_sevice.domain.port;

import com.rrhh.reclutamiento_sevice.domain.model.SistemaPension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SistemaPensionRepository {
    Flux<SistemaPension> findAll();
    Mono<SistemaPension> findById(Long id);
}

