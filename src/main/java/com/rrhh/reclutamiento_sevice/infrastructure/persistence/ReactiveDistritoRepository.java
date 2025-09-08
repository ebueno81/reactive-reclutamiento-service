package com.rrhh.reclutamiento_sevice.infrastructure.persistence;

import com.rrhh.reclutamiento_sevice.infrastructure.persistence.entity.DistritoEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactiveDistritoRepository extends ReactiveCrudRepository<DistritoEntity,String> {
}
