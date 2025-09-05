package com.rrhh.reclutamiento_sevice.application.mapper;

import com.rrhh.reclutamiento_sevice.application.dto.TipoDocumentoDto;
import com.rrhh.reclutamiento_sevice.domain.model.TipoDocumento;
import com.rrhh.reclutamiento_sevice.infrastructure.persistence.entity.TipoDocumentoEntity;

public class TipoDocumentoMapper {

    public static TipoDocumento fromEntity(TipoDocumentoEntity entity){
        return new TipoDocumento(entity.id, entity.descripcion);
    }

    public static TipoDocumentoEntity toDomain(TipoDocumento domain){
        TipoDocumentoEntity entity = new TipoDocumentoEntity();
        entity.id = domain.id();
        entity.descripcion = domain.descripcion();
        return entity;
    }

    public static TipoDocumentoDto toDto(TipoDocumento domain){
        return new TipoDocumentoDto(domain.id(), domain.descripcion());
    }

    public static TipoDocumento toDomain(TipoDocumentoDto dto){
        return new TipoDocumento(dto.id(), dto.descripcion());
    }
}
