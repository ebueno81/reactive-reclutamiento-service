package com.rrhh.reclutamiento_sevice.application.usecase.catalog;

import com.rrhh.reclutamiento_sevice.application.dto.SexoDto;
import com.rrhh.reclutamiento_sevice.application.mapper.SexoMapper;
import com.rrhh.reclutamiento_sevice.domain.port.SexoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ListarSexo {

    @Autowired
    SexoRepository repository;

    public Flux<SexoDto> findAll(){
        return repository.findAll().map(SexoMapper::toDto);
    }
}
