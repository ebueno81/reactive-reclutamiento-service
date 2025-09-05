package com.rrhh.reclutamiento_sevice.service;

import com.rrhh.reclutamiento_sevice.application.dto.SistemaPensionDto;
import com.rrhh.reclutamiento_sevice.application.usecase.catalog.BuscarSistemaPension;
import com.rrhh.reclutamiento_sevice.application.usecase.catalog.ListarSistemaPension;
import com.rrhh.reclutamiento_sevice.domain.model.SistemaPension;
import com.rrhh.reclutamiento_sevice.domain.port.SistemaPensionRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SistemaPensionServiceTest {

    @Mock
    SistemaPensionRepository repository;

    @InjectMocks
    ListarSistemaPension listarSistemaPension;

    @InjectMocks
    BuscarSistemaPension buscarSistemaPension;

    @Test
    @DisplayName("Testear Listar sistema de pension")
    void listarSistemaPension(){
        //Arrange
        List<SistemaPension> datos = List.of(
                new SistemaPension(1L,"ONP"),
                new SistemaPension(2L,"AFP")
        );

        Flux<SistemaPension> lista = Flux.fromIterable(datos);
        when(repository.findAll()).thenReturn(lista);

        //Act
        Flux<SistemaPensionDto> result = listarSistemaPension.findAll();

        //Assert
        assertNotNull(result);
        StepVerifier.create(lista)
                .expectNextMatches(dto->dto.descripcion().equals("ONP"))
                .expectNextMatches(dto->dto.descripcion().equals("AFP"))
                .verifyComplete();
    }

    @Test
    @DisplayName("Testear buscar SISTEMA DE PENSION")
    void buscarSistemaPensionTest(){
        //Arrange
        SistemaPension datos = new SistemaPension(1L,"ONP");
        when(repository.findById(1L)).thenReturn(Mono.just(datos));

        //Act
        Mono<SistemaPensionDto> result = buscarSistemaPension.findById(1L);

        //Assert
        assertNotNull(result);
        StepVerifier.create(result)
                .expectNextMatches(dto->dto.descripcion().equals("ONP"))
                .verifyComplete();

    }
}
