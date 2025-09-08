package com.rrhh.reclutamiento_sevice.application.usecase.direccion;

import com.rrhh.reclutamiento_sevice.application.dto.DistritoDto;
import com.rrhh.reclutamiento_sevice.application.mapper.DistritoMapper;
import com.rrhh.reclutamiento_sevice.domain.port.DistritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class BuscarDistrito {

    @Autowired
    DistritoRepository repository;

    public Mono<DistritoDto> findById(String id){
        return repository.findById(id)
                .map(DistritoMapper::toDto);
    }
}
