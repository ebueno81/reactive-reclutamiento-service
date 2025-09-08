package com.rrhh.reclutamiento_sevice.application.usecase.direccion;

import com.rrhh.reclutamiento_sevice.application.dto.DepartamentoDto;
import com.rrhh.reclutamiento_sevice.application.mapper.DepartamentoMapper;
import com.rrhh.reclutamiento_sevice.domain.port.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ListarDepartamento {

    @Autowired
    DepartamentoRepository repository;

    public Flux<DepartamentoDto> findAll(){
        return repository.findByAll()
                .map(DepartamentoMapper::toDto);
    }
}
