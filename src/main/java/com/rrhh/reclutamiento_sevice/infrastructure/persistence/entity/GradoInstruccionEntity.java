package com.rrhh.reclutamiento_sevice.infrastructure.persistence.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "grado_instruccion")
public class GradoInstruccionEntity {

    @Id
    public Long id;

    public String descripcion;

    public Integer activo=1;
}
