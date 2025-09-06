package com.rrhh.reclutamiento_sevice.infrastructure.rest;

import com.rrhh.reclutamiento_sevice.application.dto.PostulanteRequestDto;
import com.rrhh.reclutamiento_sevice.application.dto.PostulanteResponseDto;
import com.rrhh.reclutamiento_sevice.application.usecase.postulante.ActualizarPostulante;
import com.rrhh.reclutamiento_sevice.application.usecase.postulante.BuscarPostulante;
import com.rrhh.reclutamiento_sevice.application.usecase.postulante.ListarPostulantes;
import com.rrhh.reclutamiento_sevice.application.usecase.postulante.RegistrarPostulante;
import com.rrhh.reclutamiento_sevice.infrastructure.config.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;
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
    public Flux<ApiResponse<PostulanteResponseDto>> listar(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return listarPostulantes.execute(page, size)
                .map(item-> ApiResponse.ok("OK",item));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ResponseEntity<ApiResponse<PostulanteResponseDto>>> registrar(@RequestBody PostulanteRequestDto dto) {
        return registrarPostulante.execute(dto)
                .map(body->ResponseEntity.status(HttpStatus.CREATED)
                        .body(ApiResponse.ok("Postulante creado",body)));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<ApiResponse<PostulanteResponseDto>>> obtenerPorId(@PathVariable Long id) {
        return buscarPostulante.execute(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,"No existe el postulante con Id " + id)))
                .map(body -> ResponseEntity.ok(ApiResponse.ok("Postulante encontrado", body)));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<ApiResponse<PostulanteResponseDto>>> actualizar(
            @PathVariable Long id,
            @RequestBody PostulanteRequestDto dto) {
        return actualizarPostulante.execute(id, dto)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,"No existe el postulante con Id " + id)))
                .map(body->ResponseEntity.ok(ApiResponse.ok("Postulante actualizado",body)));
    }

}
