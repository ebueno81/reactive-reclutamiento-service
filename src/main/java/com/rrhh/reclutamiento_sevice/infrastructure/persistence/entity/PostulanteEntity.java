package com.rrhh.reclutamiento_sevice.infrastructure.persistence.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Data
@Table(name = "postulante")
public class PostulanteEntity{
    @Id
    public Long id;
    public String nombres;
    public String apellidos;
    public Long tipoDocumentoId;
    public String numeroDocumento;
    public LocalDate fechaNacimiento;
    public String nacionalidad;
    public Long estadoCivilId;
    public Long sexoId;
    public String telefono;
    public String celular;
    public String correo;
    public String direccion;
    public String distrito;
    public String provincia;
    public String departamento;
    public String pais;
    public Long sistemaPrevisionalId;
    public Long afpId;
    public String numeroSeguro;
    public Long gradoInstruccionId;
    public String institucionEducativa;
    public String nombreConyuge;
    public Integer numeroHijos;
}
