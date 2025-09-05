package com.rrhh.reclutamiento_sevice.infrastructure.rest;

import com.rrhh.reclutamiento_sevice.application.dto.PostulanteRequestDto;
import com.rrhh.reclutamiento_sevice.application.dto.PostulanteResponseDto;
import com.rrhh.reclutamiento_sevice.application.usecase.postulante.ActualizarPostulante;
import com.rrhh.reclutamiento_sevice.application.usecase.postulante.BuscarPostulante;
import com.rrhh.reclutamiento_sevice.application.usecase.postulante.ListarPostulantes;
import com.rrhh.reclutamiento_sevice.application.usecase.postulante.RegistrarPostulante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/contratacion/postulantes")
public class PostulanteController {

    @Autowired
    ListarPostulantes listarPostulantes;
    @Autowired
    RegistrarPostulante registrarPostulante;
    @Autowired
    BuscarPostulante buscarPostulante;
    @Autowired
    ActualizarPostulante actualizarPostulante;

    @GetMapping
    public Flux<PostulanteResponseDto> listar(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return listarPostulantes.execute(page, size);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<PostulanteResponseDto> registrar(@RequestBody PostulanteRequestDto dto) {
        return registrarPostulante.execute(dto);
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<PostulanteResponseDto>> obtenerPorId(@PathVariable Long id) {
        return buscarPostulante.execute(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<PostulanteResponseDto>> actualizar(
            @PathVariable Long id,
            @RequestBody PostulanteRequestDto dto) {
        return actualizarPostulante.execute(id, dto)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

}
