package com.rrhh.reclutamiento_sevice.application.mapper;

import com.rrhh.reclutamiento_sevice.application.dto.AfpDto;
import com.rrhh.reclutamiento_sevice.application.dto.SexoDto;
import com.rrhh.reclutamiento_sevice.domain.model.Afp;
import com.rrhh.reclutamiento_sevice.domain.model.Sexo;
import com.rrhh.reclutamiento_sevice.infrastructure.persistence.entity.AfpEntity;
import com.rrhh.reclutamiento_sevice.infrastructure.persistence.entity.SexoEntity;

public class AfpMapper {

    public static Afp fromEntity(AfpEntity entity){
        return new Afp(entity.id, entity.descripcion);
    }

    public static AfpEntity toDomain(Afp domain){
        AfpEntity entity = new AfpEntity();
        entity.id = domain.id();
        entity.descripcion = domain.descripcion();
        return entity;
    }

    public static AfpDto toDto(Afp domain){
        return new AfpDto(domain.id(), domain.descripcion());
    }

    public static Afp fromDto(AfpDto dto){
        return new Afp(dto.id(), dto.descripcion());
    }
}
