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
public class RegistrarPostulante {

    @Autowired
    PostulanteRepository repository;

    public Mono<PostulanteResponseDto> execute(PostulanteRequestDto dto) {
        Postulante domain = PostulanteMapper.fromRequestDto(dto);
        return repository.save(domain)
                .map(PostulanteMapper::toResponse);
    }
}
