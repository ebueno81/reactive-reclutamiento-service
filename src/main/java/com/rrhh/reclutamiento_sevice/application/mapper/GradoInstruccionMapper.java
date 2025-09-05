package com.rrhh.reclutamiento_sevice.application.mapper;

import com.rrhh.reclutamiento_sevice.application.dto.GradoInstruccionDto;
import com.rrhh.reclutamiento_sevice.domain.model.GradoInstruccion;
import com.rrhh.reclutamiento_sevice.infrastructure.persistence.entity.GradoInstruccionEntity;

public class GradoInstruccionMapper {

    public static GradoInstruccion fromEntity(GradoInstruccionEntity entity){
        return new GradoInstruccion(entity.id,entity.descripcion);
    }

    public static GradoInstruccionEntity toDomain(GradoInstruccion domain){
        GradoInstruccionEntity entity = new GradoInstruccionEntity();
        entity.id= domain.id();
        entity.descripcion= domain.descripcion();
        return entity;
    }

    public static GradoInstruccionDto toDto(GradoInstruccion toDomain){
        return new GradoInstruccionDto(toDomain.id(), toDomain.descripcion());
    }

    public static GradoInstruccion fromDto(GradoInstruccionDto dto){
        return new GradoInstruccion(dto.id(), dto.descripcion());
    }
}
