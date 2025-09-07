package com.rrhh.reclutamiento_sevice.application.dto;

import java.time.LocalDate;

public record HijoDto(
        String nombres,
        String apellidos,
        LocalDate fechaNacimiento,
        Long sexoId
) {}
