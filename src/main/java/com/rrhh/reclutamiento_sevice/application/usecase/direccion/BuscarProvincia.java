package com.rrhh.reclutamiento_sevice.application.usecase.direccion;

import com.rrhh.reclutamiento_sevice.application.dto.ProvinciaDto;
import com.rrhh.reclutamiento_sevice.application.mapper.ProvinciaMapper;
import com.rrhh.reclutamiento_sevice.domain.port.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class BuscarProvincia {

    @Autowired
    ProvinciaRepository repository;

    public Mono<ProvinciaDto> findById(String id){
        return repository.findById(id)
                .map(ProvinciaMapper::toDto);
    }
}
