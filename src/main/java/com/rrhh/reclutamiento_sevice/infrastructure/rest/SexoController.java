package com.rrhh.reclutamiento_sevice.infrastructure.rest;

import com.rrhh.reclutamiento_sevice.application.dto.SexoDto;
import com.rrhh.reclutamiento_sevice.application.usecase.catalog.BuscarSexo;
import com.rrhh.reclutamiento_sevice.application.usecase.catalog.ListarSexo;
import com.rrhh.reclutamiento_sevice.infrastructure.config.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@RequestMapping("api/v1/contratacion/sexo")
@Tag(name = "Sexo", description = "Operaciones relacionadas con catálogo de sexos")
public class SexoController {

    @Autowired
    ListarSexo listarSexo;

    @Autowired
    BuscarSexo buscarSexo;

    @Operation(summary = "Listar todos los sexos")
    @GetMapping
    public Flux<SexoDto> listarSexo() {
        return listarSexo.findAll();
    }

    @Operation(summary = "Obtener sexo por ID")
    @GetMapping("/{id}")
    public Mono<ApiResponse<SexoDto>> buscarSexo(Long id) {
        return buscarSexo.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,"No existe el registro " + id)))
                .map(item->ApiResponse.ok("Se cargo correctamente",item));
    }
}
