package com.rrhh.reclutamiento_sevice.service;

import com.rrhh.reclutamiento_sevice.application.dto.EstadoCivilDto;
import com.rrhh.reclutamiento_sevice.application.usecase.catalog.BuscarEstadoCivil;
import com.rrhh.reclutamiento_sevice.application.usecase.catalog.ListarEstadoCivil;
import com.rrhh.reclutamiento_sevice.domain.model.EstadoCivil;
import com.rrhh.reclutamiento_sevice.domain.port.EstadoCivilRepository;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EstadoCivilServiceTest {

    @Mock
    EstadoCivilRepository repository;

    @InjectMocks
    ListarEstadoCivil listarEstadoCivil;

    @InjectMocks
    BuscarEstadoCivil buscarEstadoCivil;

    @Test
    @DisplayName("Listar todos estado civil")
    void listarEstadoCivilTest(){
        //Arrange
        List<EstadoCivil> datos = List.of(
                new EstadoCivil(1L,"Casado"),
                new EstadoCivil(2l, "Soltero")
        );

        Flux<EstadoCivil> listar = Flux.fromIterable(datos);

        //Act
        when(repository.findAll()).thenReturn(listar);
        Flux<EstadoCivilDto> result = listarEstadoCivil.findAll();

        //Assert
        assertNotNull(result);

        StepVerifier.create(result)
                .expectNextMatches(dto->dto.descripcion().equals("Casado"))
                .expectNextMatches(dto->dto.descripcion().equals("Soltero"))
                .verifyComplete();
    }

    @Test
    @DisplayName("Probar buscar por id estado civil")
    void buscarEstadoCivilTest(){
        //Arrange
        EstadoCivil datos = new EstadoCivil(1L,"Casado");

        //Act
        when(repository.findById(1L)).thenReturn(Mono.just(datos));
        Mono<EstadoCivilDto> result = buscarEstadoCivil.findById(1L);

        //Assert
        assertNotNull(result);
        StepVerifier.create(result)
                .expectNextMatches(dto->dto.descripcion().equals("Casado"))
                .verifyComplete();
    }
}
