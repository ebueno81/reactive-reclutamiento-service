package com.rrhh.reclutamiento_sevice.infrastructure.config;

import org.springframework.web.server.ResponseStatusException;
import com.rrhh.reclutamiento_sevice.domain.exception.NotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.r2dbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ServerWebInputException;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class) // tu excepción de dominio
    public Mono<ResponseEntity<ApiResponse<Void>>> handleNotFound(NotFoundException ex) {
        return Mono.just(ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ApiResponse.error(ex.getMessage())));
    }

    @ExceptionHandler(ResponseStatusException.class)
    public Mono<ResponseEntity<ApiResponse<Void>>> handleRse(ResponseStatusException ex) {
        HttpStatus status = (HttpStatus) ex.getStatusCode();
        String msg = ex.getReason() != null ? ex.getReason() : ex.getMessage();
        return Mono.just(ResponseEntity
                .status(status)
                .body(ApiResponse.error(msg)));
    }

    @ExceptionHandler(ServerWebInputException.class) // parámetros inválidos (?page=abc)
    public Mono<ResponseEntity<ApiResponse<Void>>> handleBadInput(ServerWebInputException ex) {
        return Mono.just(ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ApiResponse.error("Parámetros inválidos: " + ex.getReason())));
    }

    @ExceptionHandler(BadSqlGrammarException.class) // ej: columna/SQL inválida
    public Mono<ResponseEntity<ApiResponse<Void>>> handleBadSql(BadSqlGrammarException ex) {
        return Mono.just(ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ApiResponse.error("Error en la consulta a BD. Revisa filtros/orden y nombres de columnas.")));
    }

    @ExceptionHandler(DataIntegrityViolationException.class) // FK/unique/etc
    public Mono<ResponseEntity<ApiResponse<Void>>> handleIntegrity(DataIntegrityViolationException ex) {
        return Mono.just(ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(ApiResponse.error("No se pudo completar por restricción de datos.")));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public Mono<ResponseEntity<ApiResponse<Void>>> handleIllegalArgument(IllegalArgumentException ex) {
        return Mono.just(ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ApiResponse.error(ex.getMessage())));
    }

    @ExceptionHandler(Throwable.class) // “catch-all”
    public Mono<ResponseEntity<ApiResponse<Void>>> handleAll(Throwable ex) {
        return Mono.just(ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiResponse.error("Error interno. Intenta más tarde.")));
    }

    @ExceptionHandler(org.springframework.web.bind.support.WebExchangeBindException.class)
    public reactor.core.publisher.Mono<org.springframework.http.ResponseEntity<ApiResponse<Void>>> handleValidation(
            org.springframework.web.bind.support.WebExchangeBindException ex) {

        String details = ex.getFieldErrors().stream()
                .map(err -> err.getField() + ": " + err.getDefaultMessage())
                .collect(java.util.stream.Collectors.joining("; "));

        return reactor.core.publisher.Mono.just(
                org.springframework.http.ResponseEntity
                        .status(org.springframework.http.HttpStatus.BAD_REQUEST)
                        .body(ApiResponse.error("Validación fallida: " + details))
        );
    }

}
