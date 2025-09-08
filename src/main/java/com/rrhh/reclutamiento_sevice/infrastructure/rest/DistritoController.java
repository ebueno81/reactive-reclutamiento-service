package com.rrhh.reclutamiento_sevice.infrastructure.rest;

import ch.qos.logback.core.status.Status;
import com.rrhh.reclutamiento_sevice.application.dto.DistritoDto;
import com.rrhh.reclutamiento_sevice.application.usecase.direccion.BuscarDistrito;
import com.rrhh.reclutamiento_sevice.application.usecase.direccion.ListarDistrito;
import com.rrhh.reclutamiento_sevice.infrastructure.config.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/distrito")
public class DistritoController {

    @Autowired
    BuscarDistrito buscarDistrito;

    @Autowired
    ListarDistrito listarDistrito;

    @GetMapping("/{id}")
    public Mono<ApiResponse<DistritoDto>> findById(@PathVariable("id") String id){
        return buscarDistrito.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado para el Id " + id)))
                .map(item-> ApiResponse.ok("Registro encontrado",item));
    }

    @GetMapping
    public Flux<DistritoDto> findAll(){
        return listarDistrito.findAll();
    }

}
