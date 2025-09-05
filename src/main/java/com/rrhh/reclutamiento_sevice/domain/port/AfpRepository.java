package com.rrhh.reclutamiento_sevice.domain.port;

import com.rrhh.reclutamiento_sevice.domain.model.Afp;
import com.rrhh.reclutamiento_sevice.domain.model.Sexo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AfpRepository {
    Flux<Afp> findAll();
    Mono<Afp> findById(Long id);
}

