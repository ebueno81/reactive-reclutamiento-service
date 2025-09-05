package com.rrhh.reclutamiento_sevice.application.usecase.catalog;

import com.rrhh.reclutamiento_sevice.application.dto.EstadoCivilDto;
import com.rrhh.reclutamiento_sevice.application.mapper.EstadoCivilMapper;
import com.rrhh.reclutamiento_sevice.domain.port.EstadoCivilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ListarEstadoCivil {

    @Autowired
    EstadoCivilRepository repository;

    public Flux<EstadoCivilDto> findAll(){
        return repository.findAll()
                .map(EstadoCivilMapper::toDto);
    }
}
