package com.rrhh.reclutamiento_sevice.domain.port;

import com.rrhh.reclutamiento_sevice.domain.model.TipoDocumento;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TipoDocumentoRepository {
    Flux<TipoDocumento> findAll();
    Mono<TipoDocumento> findById(Long id);
}
