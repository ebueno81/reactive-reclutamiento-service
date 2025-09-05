package com.rrhh.reclutamiento_sevice.service;


import com.rrhh.reclutamiento_sevice.application.dto.SexoDto;
import com.rrhh.reclutamiento_sevice.application.usecase.catalog.BuscarSexo;
import com.rrhh.reclutamiento_sevice.application.usecase.catalog.ListarSexo;
import com.rrhh.reclutamiento_sevice.domain.model.Sexo;
import com.rrhh.reclutamiento_sevice.domain.port.SexoRepository;
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
public class SexoServiceTest {
    @Mock
    SexoRepository repository;

    @InjectMocks
    ListarSexo listarSexo;

    @InjectMocks
    BuscarSexo buscarSexo;

    @Test
    void listarSexoTest(){
        //Arrange
        List<Sexo> datos = List.of(
                new Sexo(1L, "Masculino"),
                new Sexo(2L, "Femenino"),
                new Sexo(3L, "No Binario")
        );

        Flux<Sexo> lista = Flux.fromIterable(datos);

        when(repository.findAll()).thenReturn(lista);

        //Act
        var result = listarSexo.findAll();

        //Assert con StepVerifier
        StepVerifier.create(result)
                .expectNextMatches(dto-> dto.descripcion().equals("Masculino"))
                .expectNextMatches(dto->dto.descripcion().equals("Femenino"))
                .expectNextMatches(dto->dto.descripcion().equals("No Binario"))
                .verifyComplete();

        assertEquals(3,result.toStream().count());

    }

    @Test
    void buscarSexoTest(){
        //Arrange
        Sexo datos = new Sexo(1L, "Femenino");

        Mono<Sexo> lista = Mono.just(datos);

        //Act
        when(repository.findById(1L)).thenReturn(lista);
        var result = buscarSexo.findById(1L);

        //Asssert
        SexoDto dto = result.block();
        assertNotNull(dto);
        assertEquals(1,dto.id());
        assertEquals("Femenino", dto.descripcion());
    }
}
