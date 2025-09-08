package com.rrhh.reclutamiento_sevice.infrastructure.rest;

import com.rrhh.reclutamiento_sevice.application.dto.ProvinciaDto;
import com.rrhh.reclutamiento_sevice.application.usecase.direccion.BuscarProvincia;
import com.rrhh.reclutamiento_sevice.application.usecase.direccion.ListarProvincia;
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
@RequestMapping("api/v1/provincia")
public class ProvinciaController {

    @Autowired
    BuscarProvincia buscarProvincia;

    @Autowired
    ListarProvincia listarProvincia;

    @GetMapping("/{id}")
    public Mono<ApiResponse<ProvinciaDto>> findById(@PathVariable("id")String id){
        return buscarProvincia.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado para el id " + id)))
                .map(item->ApiResponse.ok("Registro encontrado",item));
    }

    @GetMapping
    public Flux<ProvinciaDto> findAll(){
        return listarProvincia.findAll();
    }
}
