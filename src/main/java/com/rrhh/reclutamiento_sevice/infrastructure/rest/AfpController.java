package com.rrhh.reclutamiento_sevice.infrastructure.rest;

import com.rrhh.reclutamiento_sevice.application.dto.AfpDto;
import com.rrhh.reclutamiento_sevice.application.usecase.catalog.BuscarAfp;
import com.rrhh.reclutamiento_sevice.application.usecase.catalog.ListarAfp;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/contratacion/afp")
@RequiredArgsConstructor
public class AfpController {

    @Autowired
    ListarAfp listarAfp;

    @Autowired
    BuscarAfp buscarAfp;

    @GetMapping
    public Flux<AfpDto> listarAfp(){
        return listarAfp.findAll();
    }

    @GetMapping("/{id}")
    public Mono<AfpDto> buscarAfp(Long id){
        return buscarAfp.findById(id);
    }
}
