package com.rrhh.reclutamiento_sevice.service;

import com.rrhh.reclutamiento_sevice.application.dto.TipoDocumentoDto;
import com.rrhh.reclutamiento_sevice.application.usecase.catalog.BuscarTipoDocumento;
import com.rrhh.reclutamiento_sevice.application.usecase.catalog.ListarTipoDocumento;
import com.rrhh.reclutamiento_sevice.domain.model.TipoDocumento;
import com.rrhh.reclutamiento_sevice.domain.port.TipoDocumentoRepository;
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
public class TipoDocumentoServiceTest {

    @Mock
    TipoDocumentoRepository repository;

    @InjectMocks
    ListarTipoDocumento listarTipoDocumento;

    @InjectMocks
    BuscarTipoDocumento buscarTipoDocumento;

    @Test
    @DisplayName("Testear Listar Tipo de Documentos")
    void listarTipoDocumentoTest(){
        //Arrange
        List<TipoDocumento> datos = List.of(
                new TipoDocumento(1L,"DNI"),
                new TipoDocumento(2L,"RUC")
        );
        Flux<TipoDocumento> lista = Flux.fromIterable(datos);

        //Act
        when(repository.findAll()).thenReturn(lista);

        Flux<TipoDocumentoDto> result = listarTipoDocumento.findAll();

        //Assert
        assertNotNull(result);
        StepVerifier.create(lista)
                .expectNextMatches(dto->dto.descripcion().equals("DNI"))
                .expectNextMatches(dto->dto.descripcion().equals("RUC"))
                .verifyComplete();
    }

    @Test
    @DisplayName("Testear buscar tipo de documento")
    void buscarTipoDocumentoTest(){
        //Arrange
        TipoDocumento datos = new TipoDocumento(1L,"DNI");

        //Act
        when(repository.findById(1L)).thenReturn(Mono.just(datos));
        Mono<TipoDocumentoDto> result = buscarTipoDocumento.findById(1L);

        //Assert
        assertNotNull(result);
        StepVerifier.create(result)
                .expectNextMatches(dto->dto.descripcion().equals("DNI"))
                .verifyComplete();

    }
}
