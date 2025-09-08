package com.rrhh.reclutamiento_sevice.domain.model;

import java.time.LocalDate;

public record PostulanteHijo (
        Long id,
        String nombres,
        String apellidos,
        LocalDate fechaNacimiento,
        Long sexoId
) {
}
