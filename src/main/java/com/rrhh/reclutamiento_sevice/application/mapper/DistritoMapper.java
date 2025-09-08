package com.rrhh.reclutamiento_sevice.application.mapper;

import com.rrhh.reclutamiento_sevice.application.dto.DistritoDto;
import com.rrhh.reclutamiento_sevice.domain.model.Distrito;
import com.rrhh.reclutamiento_sevice.infrastructure.persistence.entity.DistritoEntity;

public class DistritoMapper {

    public static Distrito fromEntity(DistritoEntity entity){
        return new Distrito(entity.id, entity.descripcion);
    }

    public static DistritoEntity toEntity(Distrito domain){
        DistritoEntity entity=new DistritoEntity();
        entity.id= domain.id();
        entity.descripcion= domain.descripcion();
        return entity;
    }

    public static DistritoDto toDto(Distrito domain){
        return new DistritoDto(domain.id(), domain.descripcion());
    }

    public static Distrito fromDto(DistritoDto dto){
        return new Distrito(dto.id(), dto.descripcion());
    }
}
