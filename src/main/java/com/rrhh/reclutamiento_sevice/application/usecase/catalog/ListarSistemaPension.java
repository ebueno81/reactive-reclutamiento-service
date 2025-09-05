package com.rrhh.reclutamiento_sevice.application.usecase.catalog;

import com.rrhh.reclutamiento_sevice.application.dto.SistemaPensionDto;
import com.rrhh.reclutamiento_sevice.application.mapper.SistemaPensionMapper;
import com.rrhh.reclutamiento_sevice.domain.port.SistemaPensionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ListarSistemaPension {

    @Autowired
    SistemaPensionRepository repository;

    public Flux<SistemaPensionDto> findAll(){
        return repository.findAll().map(SistemaPensionMapper::toDto);
    }
}
