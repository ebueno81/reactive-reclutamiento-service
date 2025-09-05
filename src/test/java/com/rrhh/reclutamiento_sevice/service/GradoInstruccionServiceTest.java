package com.rrhh.reclutamiento_sevice.service;

import com.rrhh.reclutamiento_sevice.application.dto.GradoInstruccionDto;
import com.rrhh.reclutamiento_sevice.application.dto.TipoDocumentoDto;
import com.rrhh.reclutamiento_sevice.application.usecase.catalog.BuscarGradoInstruccion;
import com.rrhh.reclutamiento_sevice.application.usecase.catalog.ListarGradoInstruccion;
import com.rrhh.reclutamiento_sevice.domain.model.GradoInstruccion;
import com.rrhh.reclutamiento_sevice.domain.model.TipoDocumento;
import com.rrhh.reclutamiento_sevice.domain.port.GradoInstruccionRepository;
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
public class GradoInstruccionServiceTest {

    @Mock
    GradoInstruccionRepository repository;

    @InjectMocks
    ListarGradoInstruccion listarGradoInstruccion;

    @InjectMocks
    BuscarGradoInstruccion buscarGradoInstruccion;

    @Test
    @DisplayName("Test listar grado de instruccion")
    void listarGradoDeInstruccion(){
        //Arrange
        List<GradoInstruccion> datos = List.of(
                new GradoInstruccion(1L,"Secundaria"),
                new GradoInstruccion(2L,"Superior")
        );

        Flux<GradoInstruccion> lista = Flux.fromIterable(datos);

        //Act
        when(repository.findAll()).thenReturn(lista);

        Flux<GradoInstruccionDto> result= listarGradoInstruccion.findAll();

        //Assert
        assertNotNull(result);
        StepVerifier.create(result)
                .expectNextMatches(dto-> dto.descripcion().equals("Secundaria"))
                .expectNextMatches(dto->dto.descripcion().equals("Superior"))
                .verifyComplete();
    }

    @Test
    @DisplayName("Test buscar grado de instruccion")
    void buscarGradoInstruccionTest(){
        //Arrange
        GradoInstruccion datos = new GradoInstruccion(1L,"Secundaria");

        //Act
        when(repository.findById(1L)).thenReturn(Mono.just(datos));
        Mono<GradoInstruccionDto> result = buscarGradoInstruccion.findById(1L);

        assertNotNull(result);

        StepVerifier.create(result)
                .expectNextMatches(dto->dto.descripcion().equals("Secundaria"))
                .verifyComplete();


    }
}
