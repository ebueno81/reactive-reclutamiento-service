package com.rrhh.reclutamiento_sevice.domain.port;

import com.rrhh.reclutamiento_sevice.domain.model.GradoInstruccion;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GradoInstruccionRepository {
    Flux<GradoInstruccion> findAll();
    Mono<GradoInstruccion> findById(Long id);
}
