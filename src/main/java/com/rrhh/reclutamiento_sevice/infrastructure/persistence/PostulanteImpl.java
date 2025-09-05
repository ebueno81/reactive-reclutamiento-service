package com.rrhh.reclutamiento_sevice.infrastructure.persistence;

import com.rrhh.reclutamiento_sevice.application.mapper.PostulanteMapper;
import com.rrhh.reclutamiento_sevice.domain.model.Postulante;
import com.rrhh.reclutamiento_sevice.domain.port.PostulanteRepository;
import com.rrhh.reclutamiento_sevice.infrastructure.persistence.entity.PostulanteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class PostulanteImpl implements PostulanteRepository {

    @Autowired
    ReactivePostulanteRepository repository;

    @Override
    public Mono<Postulante> save(Postulante postulante) {
        PostulanteEntity entity = PostulanteMapper.toEntity(postulante);
        return repository.save(entity).
                map(PostulanteMapper::fromEntity);
    }

    @Override
    public Flux<Postulante> findAll(int page, int size) {
        long offset = (long) page * size;
        return repository.findAllByActivoPaged(1, size, offset)
                .map(PostulanteMapper::fromEntity);
    }

    @Override
    public Mono<Postulante> findById(Long id) {
        return repository.findById(id)
                .map(PostulanteMapper::fromEntity);
    }

    @Override
    public Mono<Boolean> deleteById(Long id) {
        return repository.deleteById(id)
                .thenReturn(true);
    }
}
