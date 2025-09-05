package com.rrhh.reclutamiento_sevice.application.usecase.catalog;

import com.rrhh.reclutamiento_sevice.application.dto.EstadoCivilDto;
import com.rrhh.reclutamiento_sevice.application.mapper.EstadoCivilMapper;
import com.rrhh.reclutamiento_sevice.domain.port.EstadoCivilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class BuscarEstadoCivil {

    @Autowired
    EstadoCivilRepository repository;

    public Mono<EstadoCivilDto> findById(Long id){
        return repository.findById(id)
                .map(EstadoCivilMapper::toDto);
    }
}
