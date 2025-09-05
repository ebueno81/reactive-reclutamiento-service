package com.rrhh.reclutamiento_sevice.infrastructure.persistence;

import com.rrhh.reclutamiento_sevice.infrastructure.persistence.entity.GradoInstruccionEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ReactiveGradoInstruccion extends ReactiveCrudRepository<GradoInstruccionEntity, Long> {
    Flux<GradoInstruccionEntity> findByActivo(Integer activo);
}
