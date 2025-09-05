package com.rrhh.reclutamiento_sevice.service;

import com.rrhh.reclutamiento_sevice.application.dto.DireccionDto;
import com.rrhh.reclutamiento_sevice.application.dto.PostulanteRequestDto;
import com.rrhh.reclutamiento_sevice.application.dto.PostulanteResponseDto;
import com.rrhh.reclutamiento_sevice.application.mapper.PostulanteMapper;
import com.rrhh.reclutamiento_sevice.application.usecase.postulante.ActualizarPostulante;
import com.rrhh.reclutamiento_sevice.application.usecase.postulante.BuscarPostulante;
import com.rrhh.reclutamiento_sevice.application.usecase.postulante.ListarPostulantes;
import com.rrhh.reclutamiento_sevice.application.usecase.postulante.RegistrarPostulante;
import com.rrhh.reclutamiento_sevice.domain.model.Postulante;
import com.rrhh.reclutamiento_sevice.domain.port.PostulanteRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PostulanteServiceTest {

    @Mock
    PostulanteRepository repository;

    @InjectMocks
    ListarPostulantes listarPostulantes;

    @InjectMocks
    BuscarPostulante buscarPostulante;

    @InjectMocks
    RegistrarPostulante registrarPostulante;

    @InjectMocks
    ActualizarPostulante actualizarPostulante;

    @Test
    @DisplayName(" Test para registrar postulantes")
    void registrarPostulanteTest(){
        //Arrange
        PostulanteRequestDto dto = new PostulanteRequestDto(
                "Edwin", "Bueno", 1L, "41005957",
                LocalDate.now(), 1L, 1L, "Peruana",
                "387-6949", "940252581", "ebueno81@hotmail.com",
                new DireccionDto("Mi calle", "Mi distrito", "Mi provincia", "Mi departamento", "Perú"),
                1L, 1L, "123456", 1L, "Liceo del carmen",
                "Julia Yrene", 0, List.of()
        );
        Postulante dominio = PostulanteMapper.fromRequestDto(dto);
        when(repository.save(dominio)).thenReturn(Mono.just(dominio));

        //Act
        var result = registrarPostulante.execute(dto);

        //Assert
        assertNotNull(result);
        StepVerifier.create(result)
                .expectNextMatches(r -> r.nombres().equals("Edwin") && r.apellidos().equals("Bueno"))
                .verifyComplete();
    }

    @Test
    @DisplayName("Test para actualizar registro")
    void actualizarPostulanteTest() {
        // Arrange
        PostulanteRequestDto dto = new PostulanteRequestDto(
                "Edwin", "Bueno", 1L, "41005957",
                LocalDate.now(), 1L, 1L, "Peruana",
                "387-6949", "940252581", "ebueno81@hotmail.com",
                new DireccionDto("Mi calle", "Mi distrito", "Mi provincia", "Mi departamento", "Perú"),
                1L, 1L, "123456", 1L, "Liceo del carmen",
                "Julia Yrene", 0, List.of()
        );

        Postulante existente = new Postulante(
                1L, "Antiguo", "Apellido", 1L, "00000000",
                LocalDate.now().minusYears(20), 1L, 1L, "Peruana",
                "111111", "222222", "old@mail.com",
                new DireccionDto("Calle vieja", "Distrito", "Provincia", "Depa", "Pais"),
                1L, 1L, "99999", 1L, "Colegio Antiguo",
                "Esposa Ant", 0, List.of()
        );

        Postulante actualizado = PostulanteMapper.fromRequestDto(dto).withId(1L);

        when(repository.findById(1L)).thenReturn(Mono.just(existente));
        when(repository.save(actualizado)).thenReturn(Mono.just(actualizado));

        // Act
        Mono<PostulanteResponseDto> result = actualizarPostulante.execute(1L, dto);

        // Assert (usando StepVerifier para flujos reactivos)
        StepVerifier.create(result)
                .expectNextMatches(r -> r.id().equals(1L) &&
                        r.nombres().equals("Edwin") &&
                        r.apellidos().equals("Bueno"))
                .verifyComplete();
    }

    @Test
    @DisplayName("Test para listar paginado Postulante Listar")
    void listarPostulantesTest(){
        //Arrange
        List<Postulante> existente = List.of(new Postulante(
                1L, "Edwin", "Bueno", 1L, "00000000",
                LocalDate.now().minusYears(20), 1L, 1L, "Peruana",
                "111111", "222222", "old@mail.com",
                new DireccionDto("Calle vieja", "Distrito", "Provincia", "Depa", "Pais"),
                1L, 1L, "99999", 1L, "Colegio Antiguo",
                "Esposa Ant", 0, List.of()
        ));
        Flux<Postulante> lista = Flux.fromIterable(existente);
        when(repository.findAll(1,10)).thenReturn(lista);

        //Act
        var result = listarPostulantes.execute(1,10);

        //Assert
        assertNotNull(result);
        StepVerifier.create(lista)
                .expectNextMatches(dto->dto.apellidos().equals("Bueno") && dto.nombres().equals("Edwin"))
                .verifyComplete();
    }

    @Test
    @DisplayName("Test buscar postulante")
    void buscarPostulateTest(){
        //Arrange
        Postulante existente = new Postulante(
                1L, "Edwin", "Bueno", 1L, "00000000",
                LocalDate.now().minusYears(20), 1L, 1L, "Peruana",
                "111111", "222222", "old@mail.com",
                new DireccionDto("Calle vieja", "Distrito", "Provincia", "Depa", "Pais"),
                1L, 1L, "99999", 1L, "Colegio Antiguo",
                "Esposa Ant", 0, List.of()
        );

        Mono<Postulante> datos = Mono.just(existente);
        when(repository.findById(1L)).thenReturn(datos);

        //Act
        var result = buscarPostulante.execute(1L);

        //Assert
        StepVerifier.create(result)
                .expectNextMatches(dto->dto.apellidos().equals("Bueno") && dto.nombres().equals("Edwin"))
                .verifyComplete();
        assertNotNull(result);
    }

}
