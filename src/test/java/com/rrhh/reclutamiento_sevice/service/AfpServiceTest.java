package com.rrhh.reclutamiento_sevice.service;

import com.rrhh.reclutamiento_sevice.application.dto.AfpDto;
import com.rrhh.reclutamiento_sevice.application.usecase.catalog.BuscarAfp;
import com.rrhh.reclutamiento_sevice.application.usecase.catalog.ListarAfp;
import com.rrhh.reclutamiento_sevice.domain.model.Afp;
import com.rrhh.reclutamiento_sevice.domain.port.AfpRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AfpServiceTest {

    @Mock
    AfpRepository repository;

    @InjectMocks
    ListarAfp listarAfp;

    @InjectMocks
    BuscarAfp buscarAfp;

    @Test
    @DisplayName("Probaremos el listado de AFP")
    void listarAfpTest(){
        //Arrange
        List<Afp> datos = List.of(
                new Afp(1L,"Integra"),
                new Afp(2L, "Prima")
        );

        Flux<Afp> lista = Flux.fromIterable(datos);

        //Act
        when(repository.findAll()).thenReturn(lista);

        var result = listarAfp.findAll();

        //Assert
        StepVerifier.create(result)
                        .expectNextMatches(dto->dto.descripcion().equals("Integra"))
                                .expectNextMatches(dto->dto.descripcion().equals("Prima"))
                                        .verifyComplete();
        assertEquals(2, result.toStream().count());
    }

    @Test
    @DisplayName("Prueba para realizar busqueda por id")
    void buscarAfpTest(){
        //Arrange
        Afp datos = new Afp(1L,"Integra");

        //Act
        when(repository.findById(1L)).thenReturn(Mono.just(datos));
        Mono<AfpDto> result = buscarAfp.findById(1L);

        //Assert
        assertNotNull(result);
        StepVerifier.create(result)
                .expectNextMatches(dto->dto.descripcion().equals("Integra"))
                .verifyComplete();
    }
}
