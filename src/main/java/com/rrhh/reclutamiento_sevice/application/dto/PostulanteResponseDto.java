package com.rrhh.reclutamiento_sevice.application.dto;

import java.time.LocalDate;
import java.util.List;

public record PostulanteResponseDto(
        Long id,
        String nombres,
        String apellidos,
        Long tipoDocumentoId,
        String numeroDocumento,

        LocalDate fechaNacimiento,
        Long estadoCivilId,
        Long sexoId,
        String nacionalidad,
        String telefono,

        String celular,
        String correo,
        DireccionDto direccion,
        Long sistemaPrevisionalId,
        Long afpId,

        String numeroSeguro,
        Long gradoInstruccionId,
        String institucionEducativa,
        String nombreConyuge,
        Integer numeroHijos,

        List<PostulanteHijoDto> hijos
) {}
