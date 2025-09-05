package com.rrhh.reclutamiento_sevice.infrastructure.persistence;

import com.rrhh.reclutamiento_sevice.infrastructure.persistence.entity.SexoEntity;
import com.rrhh.reclutamiento_sevice.infrastructure.persistence.entity.SistemaPensionEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ReactiveSistemaPensionRepository extends ReactiveCrudRepository<SistemaPensionEntity, Long> {
    Flux<SistemaPensionEntity> findByActivo(Integer activo);
    Mono<SistemaPensionEntity> findById(Long id);
}
