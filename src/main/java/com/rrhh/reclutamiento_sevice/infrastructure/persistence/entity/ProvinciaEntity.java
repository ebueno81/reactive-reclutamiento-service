package com.rrhh.reclutamiento_sevice.infrastructure.persistence.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name="provincia")
public class ProvinciaEntity {
    @Id
    public String id;

    public String descripcion;

    public Integer activo=1;
}
