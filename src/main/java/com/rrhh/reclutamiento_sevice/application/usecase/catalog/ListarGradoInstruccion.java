package com.rrhh.reclutamiento_sevice.application.usecase.catalog;

import com.rrhh.reclutamiento_sevice.application.dto.GradoInstruccionDto;
import com.rrhh.reclutamiento_sevice.application.mapper.GradoInstruccionMapper;
import com.rrhh.reclutamiento_sevice.domain.model.GradoInstruccion;
import com.rrhh.reclutamiento_sevice.domain.port.GradoInstruccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ListarGradoInstruccion {

    @Autowired
    GradoInstruccionRepository repository;

    public Flux<GradoInstruccionDto> findAll(){
        return repository.findAll()
                .map(GradoInstruccionMapper::toDto);
    }
}
