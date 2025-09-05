package com.rrhh.reclutamiento_sevice.application.usecase.catalog;

import com.rrhh.reclutamiento_sevice.application.dto.AfpDto;
import com.rrhh.reclutamiento_sevice.application.dto.SexoDto;
import com.rrhh.reclutamiento_sevice.application.mapper.AfpMapper;
import com.rrhh.reclutamiento_sevice.application.mapper.SexoMapper;
import com.rrhh.reclutamiento_sevice.domain.port.AfpRepository;
import com.rrhh.reclutamiento_sevice.domain.port.SexoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class BuscarAfp {
    @Autowired
    AfpRepository repository;

    public Mono<AfpDto> findById(Long id){
        return repository.findById(id)
                .map(AfpMapper::toDto);
    }
}
