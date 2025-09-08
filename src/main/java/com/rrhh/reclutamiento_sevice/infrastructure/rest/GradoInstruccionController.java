package com.rrhh.reclutamiento_sevice.infrastructure.rest;

import com.rrhh.reclutamiento_sevice.application.dto.GradoInstruccionDto;
import com.rrhh.reclutamiento_sevice.application.dto.TipoDocumentoDto;
import com.rrhh.reclutamiento_sevice.application.usecase.catalog.BuscarGradoInstruccion;
import com.rrhh.reclutamiento_sevice.application.usecase.catalog.BuscarTipoDocumento;
import com.rrhh.reclutamiento_sevice.application.usecase.catalog.ListarGradoInstruccion;
import com.rrhh.reclutamiento_sevice.application.usecase.catalog.ListarTipoDocumento;
import com.rrhh.reclutamiento_sevice.infrastructure.config.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/contratacion/gradoinstruccion")
@RequiredArgsConstructor
public class GradoInstruccionController {

    @Autowired
    ListarGradoInstruccion listarGradoInstruccion;

    @Autowired
    BuscarGradoInstruccion buscarGradoInstruccion;

    @GetMapping
    public Flux<GradoInstruccionDto> listarGradoInstruccion(){
        return listarGradoInstruccion.findAll();
    }

    @GetMapping("/{id}")
    public Mono<ApiResponse<GradoInstruccionDto>> buscarGradoInstruccion(Long id){
        return buscarGradoInstruccion.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,"No existe el registro para el Id " + id)))
                .map(item->ApiResponse.ok("Registro encontrado",item));
    }
}
