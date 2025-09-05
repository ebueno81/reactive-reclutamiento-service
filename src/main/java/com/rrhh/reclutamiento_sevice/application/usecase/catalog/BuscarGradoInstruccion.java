package com.rrhh.reclutamiento_sevice.application.usecase.catalog;

import com.rrhh.reclutamiento_sevice.application.dto.GradoInstruccionDto;
import com.rrhh.reclutamiento_sevice.application.mapper.GradoInstruccionMapper;
import com.rrhh.reclutamiento_sevice.domain.model.GradoInstruccion;
import com.rrhh.reclutamiento_sevice.domain.port.GradoInstruccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class BuscarGradoInstruccion {

    @Autowired
    GradoInstruccionRepository repository;

    public Mono<GradoInstruccionDto> findById(Long id){
        return repository.findById(id)
                .map(GradoInstruccionMapper::toDto);
    }
}
