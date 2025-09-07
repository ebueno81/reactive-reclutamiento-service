package com.rrhh.reclutamiento_sevice.domain.service;

import com.rrhh.reclutamiento_sevice.domain.exception.BusinessRuleException;
import com.rrhh.reclutamiento_sevice.domain.model.Postulante;

import java.time.LocalDate;

public class PostulanteValidator {
    public static void validate(Postulante postulante) {
        if (postulante.fechaNacimiento().isAfter(LocalDate.now())) {
            throw new BusinessRuleException("La fecha de nacimiento no puede ser futura");
        }
        // revisar
        if ("CASADO".equalsIgnoreCase(postulante.institucionEducativa())
                && postulante.nombreConyuge() == null) {
            throw new BusinessRuleException("Debe ingresar nombre del cónyuge si está casado");
        }
    }
}
