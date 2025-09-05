package com.rrhh.reclutamiento_sevice.infrastructure.rest;

import com.rrhh.reclutamiento_sevice.application.dto.EstadoCivilDto;
import com.rrhh.reclutamiento_sevice.application.usecase.catalog.BuscarEstadoCivil;
import com.rrhh.reclutamiento_sevice.application.usecase.catalog.ListarEstadoCivil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/contratacion/estadocivil")
@RequiredArgsConstructor
public class EstadoCivilController {

    @Autowired
    ListarEstadoCivil listarEstadoCivil;

    @Autowired
    BuscarEstadoCivil buscarEstadoCivil;

    @GetMapping
    public Flux<EstadoCivilDto> listarEstadoCivil(){
        return listarEstadoCivil.findAll();
    }

    @GetMapping("/{id}")
    public Mono<EstadoCivilDto> buscarEstadoCivil(Long id){
        return buscarEstadoCivil.findById(id);
    }
}
