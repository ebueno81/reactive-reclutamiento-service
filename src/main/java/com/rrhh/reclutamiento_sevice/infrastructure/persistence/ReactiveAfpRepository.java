package com.rrhh.reclutamiento_sevice.infrastructure.persistence;

import com.rrhh.reclutamiento_sevice.infrastructure.persistence.entity.AfpEntity;
import com.rrhh.reclutamiento_sevice.infrastructure.persistence.entity.SistemaPensionEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ReactiveAfpRepository extends ReactiveCrudRepository<AfpEntity, Long> {
    Flux<AfpEntity> findByActivo(Integer activo);
    Mono<AfpEntity> findById(Long id);
}
