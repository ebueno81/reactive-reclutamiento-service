package com.rrhh.reclutamiento_sevice.infrastructure.persistence;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Data
@Table(name = "postulante_hijo")
public class PostulanteHijoEntity {
    @Id
    public Long id;
    public String nombres;
    public String apellidos;
    public LocalDate fechaNacimiento;
    public Long sexoId;
    public Integer activo=1;
}
