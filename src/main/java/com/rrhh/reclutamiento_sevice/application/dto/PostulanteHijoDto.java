package com.rrhh.reclutamiento_sevice.application.dto;

import java.time.LocalDate;

public record PostulanteHijoDto(
        Long id,
        String nombres,
        String apellidos,
        LocalDate fechaNacimiento,
        Long sexoId
) {}
