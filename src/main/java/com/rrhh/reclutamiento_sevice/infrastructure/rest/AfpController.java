package com.rrhh.reclutamiento_sevice.infrastructure.rest;

import com.rrhh.reclutamiento_sevice.application.dto.AfpDto;
import com.rrhh.reclutamiento_sevice.application.usecase.catalog.BuscarAfp;
import com.rrhh.reclutamiento_sevice.application.usecase.catalog.ListarAfp;
import com.rrhh.reclutamiento_sevice.infrastructure.config.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/contratacion/afp")
public class AfpController {

    @Autowired
    ListarAfp listarAfp;

    @Autowired
    BuscarAfp buscarAfp;

    @GetMapping
    public Flux<ApiResponse<AfpDto>> listarAfp(){
        return listarAfp.findAll()
                .map(item-> ApiResponse.ok("Ok",item));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<ApiResponse<AfpDto>>> buscarAfp(Long id){
        return buscarAfp.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,"No existe el codigo " + id)))
                .map(item->ResponseEntity.ok(ApiResponse.ok("Ok",item)));
    }
}
