package com.rrhh.reclutamiento_sevice.application.usecase.postulante;

import com.rrhh.reclutamiento_sevice.application.dto.PostulanteResponseDto;
import com.rrhh.reclutamiento_sevice.application.mapper.PostulanteMapper;
import com.rrhh.reclutamiento_sevice.domain.port.PostulanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class BuscarPostulante {

    @Autowired
    PostulanteRepository repository;

    public Mono<PostulanteResponseDto> execute(Long id){
        return repository.findById(id)
                .map(PostulanteMapper::toResponse);
    }
}
