package com.rrhh.reclutamiento_sevice.infrastructure.rest.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

public record PostulanteRequest(

        @NotBlank(message = "Los nombres son obligatorios")
        @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
        String nombres,

        @NotBlank(message = "Los apellidos son obligatorios")
        @Size(min = 2, max = 100, message = "El apellido debe tener entre 2 y 100 caracteres")
        String apellidos,

        @NotNull(message = "El tipo de documento es obligatorio")
        Long tipoDocumentoId,

        @NotBlank(message = "El número de documento es obligatorio")
        @Size(min = 8, max = 20, message = "El número de documento debe tener entre 8 y 20 caracteres")
        String numeroDocumento,

        @NotNull(message = "La fecha de nacimiento es obligatoria")
        @Past(message = "La fecha de nacimiento debe ser en el pasado")
        LocalDate fechaNacimiento,

        @NotNull(message = "El estado civil es obligatorio")
        Long estadoCivilId,

        @NotNull(message = "El sexo es obligatorio")
        Long sexoId,

        @NotBlank(message = "La nacionalidad es obligatoria")
        String nacionalidad,

        @Size(max = 30, message = "Teléfono: máximo 30 caracteres")
        String telefono,

        @Size(max = 30, message = "Celular: máximo 30 caracteres")
        String celular,

        @NotBlank(message = "El correo es obligatorio")
        @Email(message = "El correo no es válido")
        String correo,

        @NotNull(message = "La dirección es obligatoria")
        DireccionRequest direccion,

        Long sistemaPrevisionalId,
        Long afpId,

        @Size(max = 50, message = "Número de seguro: máximo 50 caracteres")
        String numeroSeguro,

        Long gradoInstruccionId,

        @Size(max = 255, message = "Institución educativa: máximo 255 caracteres")
        String institucionEducativa,

        String nombreConyuge,

        @Min(value = 0, message = "El número de hijos no puede ser negativo")
        Integer numeroHijos,

        // Si aún no manejas hijos, puedes omitir este campo del request.
        // Lo dejamos opcional; en el mapper lo pasamos como null a application.
        List<Object> hijos
) {}
