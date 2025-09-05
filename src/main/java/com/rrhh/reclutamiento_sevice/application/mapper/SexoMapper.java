package com.rrhh.reclutamiento_sevice.application.mapper;

import com.rrhh.reclutamiento_sevice.application.dto.SexoDto;
import com.rrhh.reclutamiento_sevice.domain.model.Sexo;
import com.rrhh.reclutamiento_sevice.infrastructure.persistence.entity.SexoEntity;

public class SexoMapper {

    public static Sexo fromEntity(SexoEntity entity){
        return new Sexo(entity.id, entity.descripcion);
    }

    public static SexoEntity toDomain(Sexo domain){
        SexoEntity entity = new SexoEntity();
        entity.id = domain.id();
        entity.descripcion = domain.descripcion();
        return entity;
    }

    public static SexoDto toDto(Sexo domain){
        return new SexoDto(domain.id(), domain.descripcion());
    }

    public static Sexo fromDto(SexoDto dto){
        return new Sexo(dto.id(), dto.descripcion());
    }
}
