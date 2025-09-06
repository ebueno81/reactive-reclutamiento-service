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

    public static Postulante fromEntity(PostulanteEntity entity) {
        return new Postulante(
                entity.getId(),
                entity.getNombres(),
                entity.getApellidos(),
                entity.getTipoDocumentoId(),
                entity.getNumeroDocumento(),
                entity.getFechaNacimiento(),
                entity.getEstadoCivilId(),
                entity.getSexoId(),
                entity.getNacionalidad(),
                entity.getTelefono(),
                entity.getCelular(),
                entity.getCorreo(),
                new DireccionDto(
                        entity.getDireccion(),
                        entity.getDistrito(),
                        entity.getProvincia(),
                        entity.getDepartamento(),
                        entity.getPais()
                ),
                entity.getSistemaPrevisionalId(),
                entity.getAfpId(),
                entity.getNumeroSeguro(),
                entity.getGradoInstruccionId(),
                entity.getInstitucionEducativa(),
                entity.getNombreConyuge(),
                entity.getNumeroHijos(),
                null
        );
    }

    public static PostulanteEntity toEntity(Postulante domain) {
        PostulanteEntity entity = new PostulanteEntity();
        entity.setId(domain.id());
        entity.setNombres(domain.nombres());
        entity.setApellidos(domain.apellidos());
        entity.setTipoDocumentoId(domain.tipoDocumentoId());
        entity.setNumeroDocumento(domain.numeroDocumento());
        entity.setFechaNacimiento(domain.fechaNacimiento());
        entity.setEstadoCivilId(domain.estadoCivilId());
        entity.setSexoId(domain.sexoId());
        entity.setNacionalidad(domain.nacionalidad());
        entity.setTelefono(domain.telefono());
        entity.setCelular(domain.celular());
        entity.setCorreo(domain.correo());
        if (domain.direccion() != null) {
            entity.setDireccion(domain.direccion().direccion());
            entity.setDistrito(domain.direccion().distrito());
            entity.setProvincia(domain.direccion().provincia());
            entity.setDepartamento(domain.direccion().departamento());
            entity.setPais(domain.direccion().pais());
        }
        entity.setSistemaPrevisionalId(domain.sistemaPrevisionalId());
        entity.setAfpId(domain.afpId());
        entity.setNumeroSeguro(domain.numeroSeguro());
        entity.setGradoInstruccionId(domain.gradoInstruccionId());
        entity.setInstitucionEducativa(domain.institucionEducativa());
        entity.setNombreConyuge(domain.nombreConyuge());
        entity.setNumeroHijos(domain.numeroHijos());
        return entity;
    }

    public static List<PostulanteResponseDto> toResponse(List<Postulante> postulantes){
        return postulantes.stream()
                .map(PostulanteMapper::toResponse)
                .toList();
    }
}
