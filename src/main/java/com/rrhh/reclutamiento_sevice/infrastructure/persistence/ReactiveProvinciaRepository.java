package com.rrhh.reclutamiento_sevice.infrastructure.persistence;

import com.rrhh.reclutamiento_sevice.infrastructure.persistence.entity.ProvinciaEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactiveProvinciaRepository extends ReactiveCrudRepository<ProvinciaEntity, String> {

}
