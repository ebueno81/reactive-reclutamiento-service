package com.rrhh.reclutamiento_sevice.application.usecase.direccion;

import com.rrhh.reclutamiento_sevice.application.dto.DistritoDto;
import com.rrhh.reclutamiento_sevice.application.mapper.DistritoMapper;
import com.rrhh.reclutamiento_sevice.domain.port.DistritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ListarDistrito {

    @Autowired
    DistritoRepository repository;

    public Flux<DistritoDto> findAll(){
        return repository.findAll()
                .map(DistritoMapper::toDto);
    }
}
