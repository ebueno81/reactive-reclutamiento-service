package com.rrhh.reclutamiento_sevice.application.usecase.direccion;

import com.rrhh.reclutamiento_sevice.application.dto.DepartamentoDto;
import com.rrhh.reclutamiento_sevice.application.mapper.DepartamentoMapper;
import com.rrhh.reclutamiento_sevice.domain.port.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class BuscarDepartamento {

    @Autowired
    DepartamentoRepository repository;

    public Mono<DepartamentoDto> findById(String id){
        return repository.findById(id)
                .map(DepartamentoMapper::toDto);
    }
    ;

}
