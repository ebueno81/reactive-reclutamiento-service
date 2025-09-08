package com.rrhh.reclutamiento_sevice.infrastructure.rest;

import com.rrhh.reclutamiento_sevice.application.dto.DepartamentoDto;
import com.rrhh.reclutamiento_sevice.application.usecase.direccion.BuscarDepartamento;
import com.rrhh.reclutamiento_sevice.application.usecase.direccion.ListarDepartamento;
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
@RequestMapping("api/v1/departamento")
public class DepartamentoController {

    @Autowired
    ListarDepartamento listarDepartamento;

    @Autowired
    BuscarDepartamento buscarDepartamento;

    @GetMapping("/{id}")
    public Mono<ApiResponse<DepartamentoDto>> findById(@PathVariable("id") String id){
        return buscarDepartamento.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro no encontrado " + id)))
                .map(item->ApiResponse.ok("Registro encontrado",item));
    }

    @GetMapping
    public Flux<DepartamentoDto> findAll(){
        return listarDepartamento.findAll();
    }
}
