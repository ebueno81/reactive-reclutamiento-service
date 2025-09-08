package com.rrhh.reclutamiento_sevice.application.mapper;

import com.rrhh.reclutamiento_sevice.application.dto.ProvinciaDto;
import com.rrhh.reclutamiento_sevice.domain.model.Provincia;
import com.rrhh.reclutamiento_sevice.infrastructure.persistence.entity.ProvinciaEntity;

public class ProvinciaMapper {

    public static Provincia fromEntity(ProvinciaEntity entity){
        return new Provincia(entity.id, entity.descripcion);
    }

    public static ProvinciaEntity toDomain(Provincia domain){
        ProvinciaEntity entity = new ProvinciaEntity();
        entity.id=domain.id();
        entity.descripcion = domain.descripcion();;
        return entity;
    }

    public static ProvinciaDto toDto(Provincia dto){
        return new ProvinciaDto(dto.id(), dto.descripcion());
    }

    public static Provincia fromDto(ProvinciaDto domain){
        return new Provincia(domain.id(), domain.descripcion());
    }
}
