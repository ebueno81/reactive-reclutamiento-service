package com.rrhh.reclutamiento_sevice.application.mapper;

import com.rrhh.reclutamiento_sevice.application.dto.EstadoCivilDto;
import com.rrhh.reclutamiento_sevice.domain.model.EstadoCivil;
import com.rrhh.reclutamiento_sevice.infrastructure.persistence.entity.EstadoCivilEntity;

public class EstadoCivilMapper {

    public static EstadoCivil fromEntity(EstadoCivilEntity entity){
        return new EstadoCivil(entity.id,entity.descripcion);
    }

    public static EstadoCivilEntity toDomain(EstadoCivil domain){
        EstadoCivilEntity entity = new EstadoCivilEntity();
        entity.id= domain.id();
        entity.descripcion=domain.descripcion();
        return entity;
    }

    public static EstadoCivilDto toDto(EstadoCivil domain){
        return new EstadoCivilDto(domain.id(), domain.descripcion());
    }

    public static EstadoCivil fromDto(EstadoCivilDto dto){
        return new EstadoCivil(dto.id(), dto.descripcion());
    }
}
