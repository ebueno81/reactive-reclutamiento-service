package com.rrhh.reclutamiento_sevice.infrastructure.rest;

import com.rrhh.reclutamiento_sevice.application.dto.SistemaPensionDto;
import com.rrhh.reclutamiento_sevice.application.usecase.catalog.BuscarSistemaPension;
import com.rrhh.reclutamiento_sevice.application.usecase.catalog.ListarSistemaPension;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/contratacion/sistemapension")
@RequiredArgsConstructor
public class SistemaPensionController {

    @Autowired
    ListarSistemaPension listarSistemaPension;

    @Autowired
    BuscarSistemaPension buscarSistemaPension;

    @GetMapping
    public Flux<SistemaPensionDto> listarSistemaPension(){
        return listarSistemaPension.findAll();
    }

    @GetMapping("/{id}")
    public Mono<SistemaPensionDto> buscarSistemaPension(Long id){
        return buscarSistemaPension.findById(id);
    }
}
