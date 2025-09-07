package com.rrhh.reclutamiento_sevice.infrastructure.rest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record HijoRequest(

        @NotBlank(message = "Los nombres del hijo son obligatorios")
        @Size(min = 2, max = 100, message = "Los nombres del hijo deben tener entre 2 y 100 caracteres")
        String nombres,

        @NotBlank(message = "Los apellidos del hijo son obligatorios")
        @Size(min = 2, max = 100, message = "Los apellidos del hijo deben tener entre 2 y 100 caracteres")
        String apellidos,

        @NotNull(message = "La fecha de nacimiento del hijo es obligatoria")
        @Past(message = "La fecha de nacimiento del hijo debe ser en el pasado")
        LocalDate fechaNacimiento,

        @NotNull(message = "El sexo del hijo es obligatorio")
        Long sexoId
) {}
