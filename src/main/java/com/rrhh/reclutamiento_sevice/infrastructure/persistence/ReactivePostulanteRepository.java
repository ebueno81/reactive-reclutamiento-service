package com.rrhh.reclutamiento_sevice.infrastructure.persistence;

import com.rrhh.reclutamiento_sevice.infrastructure.persistence.entity.PostulanteEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ReactivePostulanteRepository extends ReactiveCrudRepository<PostulanteEntity, Long> {

    @Query("""
           SELECT * 
           FROM postulante
           ORDER BY id DESC
           LIMIT :size OFFSET :offset
           """)
    Flux<PostulanteEntity> findAllPaged(long size, long offset);
}
