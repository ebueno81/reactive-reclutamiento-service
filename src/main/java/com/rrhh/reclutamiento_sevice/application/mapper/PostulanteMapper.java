package com.rrhh.reclutamiento_sevice.application.mapper;

import com.rrhh.reclutamiento_sevice.application.dto.DireccionDto;
import com.rrhh.reclutamiento_sevice.application.dto.PostulanteRequestDto;
import com.rrhh.reclutamiento_sevice.application.dto.PostulanteResponseDto;
import com.rrhh.reclutamiento_sevice.domain.model.Postulante;
import com.rrhh.reclutamiento_sevice.infrastructure.persistence.entity.PostulanteEntity;

import java.util.List;

public class PostulanteMapper {

    // 🔹 DTO → Dominio
    public static Postulante fromRequestDto(PostulanteRequestDto dto) {
        return new Postulante(
                null, // id todavía no existe en creación
                dto.nombres(),
                dto.apellidos(),
                dto.tipoDocumentoId(),
                dto.numeroDocumento(),
                dto.fechaNacimiento(),
                dto.estadoCivilId(),
                dto.sexoId(),
                dto.nacionalidad(),
                dto.telefono(),
                dto.celular(),
                dto.correo(),
                dto.direccion(),
                dto.sistemaPrevisionalId(),
                dto.afpId(),
                dto.numeroSeguro(),
                dto.gradoInstruccionId(),
                dto.institucionEducativa(),
                dto.nombreConyuge(),
                dto.numeroHijos(),
                dto.hijos()
        );
    }

    // 🔹 Dominio → DTO
    public static PostulanteResponseDto toResponse(Postulante domain) {
        return new PostulanteResponseDto(
                domain.id(),
                domain.nombres(),
                domain.apellidos(),
                domain.tipoDocumentoId(),
                domain.numeroDocumento(),

                domain.fechaNacimiento(),
                domain.estadoCivilId(),
                domain.sexoId(),
                domain.nacionalidad(),
                domain.telefono(),

                domain.celular(),
                domain.correo(),
                domain.direccion(),
                domain.sistemaPrevisionalId(),
                domain.afpId(),

                domain.numeroSeguro(),
                domain.gradoInstruccionId(),
                domain.institucionEducativa(),
                domain.nombreConyuge(),
                domain.numeroHijos(),
                domain.hijos()
        );
    }

    // 🔹 Entity → Dominio
    public static Postulante fromEntity(PostulanteEntity entity) {
        return new Postulante(
                entity.id,
                entity.nombres,
                entity.apellidos,
                entity.tipoDocumentoId,
                entity.numeroDocumento,
                entity.fechaNacimiento,
                entity.estadoCivilId,
                entity.sexoId,
                entity.nacionalidad,
                entity.telefono,
                entity.celular,
                entity.correo,
                new DireccionDto(
                        entity.direccion,
                        entity.distrito,
                        entity.provincia,
                        entity.departamento,
                        entity.pais
                ),
                entity.sistemaPrevisionalId,
                entity.afpId,
                entity.numeroSeguro,
                entity.gradoInstruccionId,
                entity.institucionEducativa,
                entity.nombreConyuge,
                entity.numeroHijos,
                null // hijos lo puedes mapear si tienes tabla aparte
        );
    }

    // 🔹 Dominio → Entity
    public static PostulanteEntity toEntity(Postulante domain) {
        PostulanteEntity entity = new PostulanteEntity();
        entity.id = domain.id();
        entity.nombres = domain.nombres();
        entity.apellidos = domain.apellidos();
        entity.tipoDocumentoId = domain.tipoDocumentoId();
        entity.numeroDocumento = domain.numeroDocumento();
        entity.fechaNacimiento = domain.fechaNacimiento();
        entity.estadoCivilId = domain.estadoCivilId();
        entity.sexoId = domain.sexoId();
        entity.nacionalidad = domain.nacionalidad();
        entity.telefono = domain.telefono();
        entity.celular = domain.celular();
        entity.correo = domain.correo();
        if (domain.direccion() != null) {
            entity.direccion = domain.direccion().direccion();
            entity.distrito = domain.direccion().distrito();
            entity.provincia = domain.direccion().provincia();
            entity.departamento = domain.direccion().departamento();
            entity.pais = domain.direccion().pais();
        }
        entity.sistemaPrevisionalId = domain.sistemaPrevisionalId();
        entity.afpId = domain.afpId();
        entity.numeroSeguro = domain.numeroSeguro();
        entity.gradoInstruccionId = domain.gradoInstruccionId();
        entity.institucionEducativa = domain.institucionEducativa();
        entity.nombreConyuge = domain.nombreConyuge();
        entity.numeroHijos = domain.numeroHijos();
        return entity;
    }

    public static List<PostulanteResponseDto> toResponse(List<Postulante> postulantes){
        return postulantes.stream()
                .map(PostulanteMapper::toResponse)
                .toList();
    }
}
