package com.rrhh.reclutamiento_sevice.infrastructure.persistence;

import com.rrhh.reclutamiento_sevice.infrastructure.persistence.entity.TipoDocumentoEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ReactiveTipoDocumentoRepository extends ReactiveCrudRepository<TipoDocumentoEntity, Long> {
    Flux<TipoDocumentoEntity> findByActivo(Integer activo);
}
