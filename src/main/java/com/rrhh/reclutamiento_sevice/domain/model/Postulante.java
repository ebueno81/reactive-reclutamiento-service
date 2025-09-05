package com.rrhh.reclutamiento_sevice.domain.model;

import com.rrhh.reclutamiento_sevice.application.dto.DireccionDto;
import com.rrhh.reclutamiento_sevice.application.dto.HijoDto;


import java.time.LocalDate;
import java.util.List;

public record Postulante(
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
        List<HijoDto> hijos
) {
    public Postulante withId(Long id) {
        return new Postulante(
                id,
                this.nombres,
                this.apellidos,
                this.tipoDocumentoId,
                this.numeroDocumento,
                this.fechaNacimiento,
                this.estadoCivilId,
                this.sexoId,
                this.nacionalidad,
                this.telefono,
                this.celular,
                this.correo,
                this.direccion,
                this.sistemaPrevisionalId,
                this.afpId,
                this.numeroSeguro,
                this.gradoInstruccionId,
                this.institucionEducativa,
                this.nombreConyuge,
                this.numeroHijos,
                this.hijos
        );
    }
}
