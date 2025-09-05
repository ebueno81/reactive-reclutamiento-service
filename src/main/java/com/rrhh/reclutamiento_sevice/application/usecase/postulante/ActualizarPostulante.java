package com.rrhh.reclutamiento_sevice.application.usecase.postulante;

import com.rrhh.reclutamiento_sevice.application.dto.PostulanteRequestDto;
import com.rrhh.reclutamiento_sevice.application.dto.PostulanteResponseDto;
import com.rrhh.reclutamiento_sevice.application.mapper.PostulanteMapper;
import com.rrhh.reclutamiento_sevice.domain.model.Postulante;
import com.rrhh.reclutamiento_sevice.domain.port.PostulanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ActualizarPostulante {

    @Autowired
    PostulanteRepository repository;

    public Mono<PostulanteResponseDto> execute(Long id, PostulanteRequestDto dto){
        return repository.findById(id)
                .flatMap(existing->{
                   Postulante actualizado = PostulanteMapper.fromRequestDto(dto)
                           .withId(id);

                   return repository.save(actualizado)
                           .map(PostulanteMapper::toResponse);
                })
                .switchIfEmpty(Mono.empty());
    }
}
