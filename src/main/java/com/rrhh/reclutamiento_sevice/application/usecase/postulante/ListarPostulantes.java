package com.rrhh.reclutamiento_sevice.application.usecase.postulante;

import com.rrhh.reclutamiento_sevice.application.dto.PostulanteResponseDto;
import com.rrhh.reclutamiento_sevice.application.mapper.PostulanteMapper;
import com.rrhh.reclutamiento_sevice.domain.port.PostulanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ListarPostulantes {

    @Autowired
    PostulanteRepository repository;

    public Flux<PostulanteResponseDto> execute(int page, int size){
        return repository.findAll(page,size)
                .map(PostulanteMapper::toResponse);
    }
}
