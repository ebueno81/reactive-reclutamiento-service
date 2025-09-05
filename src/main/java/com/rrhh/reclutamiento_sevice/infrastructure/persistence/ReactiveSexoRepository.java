package com.rrhh.reclutamiento_sevice.infrastructure.persistence;

import com.rrhh.reclutamiento_sevice.infrastructure.persistence.entity.SexoEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ReactiveSexoRepository extends ReactiveCrudRepository<SexoEntity, Long> {
    Flux<SexoEntity> findByActivo(Integer activo);
    Mono<SexoEntity> findById(Long id);
}
