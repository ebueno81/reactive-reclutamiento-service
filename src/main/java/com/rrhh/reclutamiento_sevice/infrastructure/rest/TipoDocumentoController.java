package com.rrhh.reclutamiento_sevice.infrastructure.rest;

import com.rrhh.reclutamiento_sevice.application.dto.TipoDocumentoDto;
import com.rrhh.reclutamiento_sevice.application.usecase.catalog.BuscarTipoDocumento;
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
@RequestMapping("api/v1/contratacion/tipodocumento")
@RequiredArgsConstructor
public class TipoDocumentoController {

    @Autowired
    ListarTipoDocumento listarTipoDocumento;

    @Autowired
    BuscarTipoDocumento buscarTipoDocumento;

    @GetMapping
    public Flux<TipoDocumentoDto> listarTipoDocumento(){
        return listarTipoDocumento.findAll();
    }

    @GetMapping("/{id}")
    public Mono<ApiResponse<TipoDocumentoDto>> buscarTipoDocumento(Long id){
        return buscarTipoDocumento.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro no encontrado para el Id " + id)))
                .map(item->ApiResponse.ok("Registro encontrado",item));
    }
}
