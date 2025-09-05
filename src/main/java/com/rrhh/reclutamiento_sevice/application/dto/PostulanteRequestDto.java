package com.rrhh.reclutamiento_sevice.application.dto;

import java.time.LocalDate;
import java.util.List;

public record PostulanteRequestDto(
        String nombres,
        String apellidos,
        Long tipoDocumentoId,         // ✅ agregado
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
        List<HijoDto> hijos
) {}
