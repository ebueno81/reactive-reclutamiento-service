package com.rrhh.reclutamiento_sevice.application.mapper;

import com.rrhh.reclutamiento_sevice.application.dto.DepartamentoDto;
import com.rrhh.reclutamiento_sevice.domain.model.Departamento;
import com.rrhh.reclutamiento_sevice.infrastructure.persistence.entity.DepartamentoEntity;

public class DepartamentoMapper {

    public static Departamento fromEntity(DepartamentoEntity entity){
        return new Departamento(entity.id, entity.descripcion);
    }

    public static DepartamentoEntity toDomain(Departamento domain){
        DepartamentoEntity entity = new DepartamentoEntity();
        entity.id= domain.id();
        entity.descripcion= domain.descripcion();
        return entity;
    }

    public static DepartamentoDto toDto(Departamento domain){
        return new DepartamentoDto(domain.id(), domain.descripcion());
    }
    public static Departamento fromDto(DepartamentoDto dto){
        return new Departamento(dto.id(), dto.descripcion());
    }
}
