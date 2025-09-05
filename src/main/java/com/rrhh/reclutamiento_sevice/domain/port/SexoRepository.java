package com.rrhh.reclutamiento_sevice.domain.port;

import com.rrhh.reclutamiento_sevice.domain.model.Sexo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SexoRepository {
    Flux<Sexo> findAll();
    Mono<Sexo> findById(Long id);
}

