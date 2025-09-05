package com.rrhh.reclutamiento_sevice.domain.port;

import com.rrhh.reclutamiento_sevice.domain.model.Postulante;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PostulanteRepository {
    Mono<Postulante> save(Postulante postulante);
    Flux<Postulante> findAll(int page, int size);
    Mono<Postulante> findById(Long id);
    Mono<Boolean> deleteById(Long id);
}
