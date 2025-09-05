package com.rrhh.reclutamiento_sevice.infrastructure.persistence;

import com.rrhh.reclutamiento_sevice.infrastructure.persistence.entity.EstadoCivilEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ReactiveEstadoCivilRepository extends ReactiveCrudRepository<EstadoCivilEntity,Long> {
    Flux<EstadoCivilEntity> findByActivo(Integer activo);
}
