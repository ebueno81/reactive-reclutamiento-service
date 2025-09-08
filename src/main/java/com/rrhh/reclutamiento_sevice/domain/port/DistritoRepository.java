package com.rrhh.reclutamiento_sevice.domain.port;

import com.rrhh.reclutamiento_sevice.domain.model.Distrito;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DistritoRepository {
    Flux<Distrito> findAll();
    Mono<Distrito> findById(String id);
}
