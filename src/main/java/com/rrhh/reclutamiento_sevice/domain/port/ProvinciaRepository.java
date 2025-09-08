package com.rrhh.reclutamiento_sevice.domain.port;

import com.rrhh.reclutamiento_sevice.domain.model.Provincia;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProvinciaRepository {
    Flux<Provincia> findAll();
    Mono<Provincia> findById(String id);
}
