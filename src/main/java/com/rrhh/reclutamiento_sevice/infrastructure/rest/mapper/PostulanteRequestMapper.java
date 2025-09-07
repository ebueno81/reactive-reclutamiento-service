package com.rrhh.reclutamiento_sevice.infrastructure.rest.mapper;

import com.rrhh.reclutamiento_sevice.application.dto.DireccionDto;
import com.rrhh.reclutamiento_sevice.application.dto.HijoDto;
import com.rrhh.reclutamiento_sevice.application.dto.PostulanteRequestDto;
import com.rrhh.reclutamiento_sevice.infrastructure.rest.dto.DireccionRequest;
import com.rrhh.reclutamiento_sevice.infrastructure.rest.dto.HijoRequest;
import com.rrhh.reclutamiento_sevice.infrastructure.rest.dto.PostulanteRequest;

import java.util.List;

public final class PostulanteRequestMapper {

    private PostulanteRequestMapper() {}

    public static PostulanteRequestDto toApplicationDto(PostulanteRequest r) {
        return new PostulanteRequestDto(
                r.nombres(),
                r.apellidos(),
                r.tipoDocumentoId(),
                r.numeroDocumento(),
                r.fechaNacimiento(),
                r.estadoCivilId(),
                r.sexoId(),
                r.nacionalidad(),
                r.telefono(),
                r.celular(),
                r.correo(),
                toDireccionDto(r.direccion()),
                r.sistemaPrevisionalId(),
                r.afpId(),
                r.numeroSeguro(),
                r.gradoInstruccionId(),
                r.institucionEducativa(),
                r.nombreConyuge(),
                r.numeroHijos(),
                null // hijos: ajusta cuando definas la estructura en application
        );
    }

    private static DireccionDto toDireccionDto(DireccionRequest d) {
        if (d == null) return null;
        return new DireccionDto(
                d.direccion(),
                d.distrito(),
                d.provincia(),
                d.departamento(),
                d.pais()
        );
    }

    private static List<HijoDto> toHijoDtoList(List<HijoRequest> hijos) {
        if (hijos == null) return null;
        return hijos.stream()
                .map(h -> new HijoDto(
                        h.nombres(),
                        h.apellidos(),
                        h.fechaNacimiento(),
                        h.sexoId()
                ))
                .toList();
    }
}
