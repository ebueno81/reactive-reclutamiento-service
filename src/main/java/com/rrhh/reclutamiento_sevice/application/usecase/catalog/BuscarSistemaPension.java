package com.rrhh.reclutamiento_sevice.application.usecase.catalog;

import com.rrhh.reclutamiento_sevice.application.dto.AfpDto;
import com.rrhh.reclutamiento_sevice.application.dto.SistemaPensionDto;
import com.rrhh.reclutamiento_sevice.application.mapper.AfpMapper;
import com.rrhh.reclutamiento_sevice.application.mapper.SistemaPensionMapper;
import com.rrhh.reclutamiento_sevice.domain.port.AfpRepository;
import com.rrhh.reclutamiento_sevice.domain.port.SistemaPensionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class BuscarSistemaPension {
    @Autowired
    SistemaPensionRepository repository;

    public Mono<SistemaPensionDto> findById(Long id){
        return repository.findById(id)
                .map(SistemaPensionMapper::toDto);
    }
}
