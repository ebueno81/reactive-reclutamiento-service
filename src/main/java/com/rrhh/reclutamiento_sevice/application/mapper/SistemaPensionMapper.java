package com.rrhh.reclutamiento_sevice.application.mapper;

import com.rrhh.reclutamiento_sevice.application.dto.AfpDto;
import com.rrhh.reclutamiento_sevice.application.dto.SistemaPensionDto;
import com.rrhh.reclutamiento_sevice.domain.model.Afp;
import com.rrhh.reclutamiento_sevice.domain.model.SistemaPension;
import com.rrhh.reclutamiento_sevice.infrastructure.persistence.entity.AfpEntity;
import com.rrhh.reclutamiento_sevice.infrastructure.persistence.entity.SexoEntity;
import com.rrhh.reclutamiento_sevice.infrastructure.persistence.entity.SistemaPensionEntity;

public class SistemaPensionMapper {

    public static SistemaPension fromEntity(SistemaPensionEntity entity){
        return new SistemaPension(entity.id, entity.descripcion);
    }

    public static SistemaPensionEntity toDomain(SistemaPension domain){
        SistemaPensionEntity entity = new SistemaPensionEntity();
        entity.id = domain.id();
        entity.descripcion = domain.descripcion();
        return entity;
    }

    public static SistemaPensionDto toDto(SistemaPension domain){
        return new SistemaPensionDto(domain.id(), domain.descripcion());
    }

    public static SistemaPension fromDto(SistemaPensionDto dto){
        return new SistemaPension(dto.id(), dto.descripcion());
    }
}
