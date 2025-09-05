package com.rrhh.reclutamiento_sevice.infrastructure.persistence;

import com.rrhh.reclutamiento_sevice.application.mapper.TipoDocumentoMapper;
import com.rrhh.reclutamiento_sevice.domain.model.TipoDocumento;
import com.rrhh.reclutamiento_sevice.domain.port.TipoDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class TipoDocumentoImpl implements TipoDocumentoRepository {

    @Autowired
    ReactiveTipoDocumentoRepository repository;

    @Override
    public Flux<TipoDocumento> findAll() {
        return repository.findByActivo(1)
                .map(TipoDocumentoMapper::fromEntity);
    }

    @Override
    public Mono<TipoDocumento> findById(Long id) {
        return repository.findById(id)
                .map(TipoDocumentoMapper::fromEntity);
    }
}
