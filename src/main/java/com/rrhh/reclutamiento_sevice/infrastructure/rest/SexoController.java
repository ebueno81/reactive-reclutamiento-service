package com.rrhh.reclutamiento_sevice.infrastructure.rest;

import com.rrhh.reclutamiento_sevice.application.dto.EstadoCivilDto;
import com.rrhh.reclutamiento_sevice.application.dto.SexoDto;
import com.rrhh.reclutamiento_sevice.application.usecase.catalog.BuscarEstadoCivil;
import com.rrhh.reclutamiento_sevice.application.usecase.catalog.BuscarSexo;
import com.rrhh.reclutamiento_sevice.application.usecase.catalog.ListarEstadoCivil;
import com.rrhh.reclutamiento_sevice.application.usecase.catalog.ListarSexo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public Flux<SexoDto> listarSexo(){
        return listarSexo.findAll();
    }

    @Operation(summary = "Obtener sexo por ID")
    @GetMapping("/{id}")
    public Mono<SexoDto> buscarSexo(Long id){
        return buscarSexo.findById(id);
    }
}
