package com.rrhh.reclutamiento_sevice.infrastructure.rest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DireccionRequest(
        @NotBlank(message = "La dirección es obligatoria")
        @Size(max = 255, message = "Dirección: máximo 255 caracteres")
        String direccion,

        @Size(max = 100, message = "Distrito: máximo 100 caracteres")
        String distrito,

        @Size(max = 100, message = "Provincia: máximo 100 caracteres")
        String provincia,

        @Size(max = 100, message = "Departamento: máximo 100 caracteres")
        String departamento,

        @Size(max = 100, message = "País: máximo 100 caracteres")
        String pais
) {}
