package com.rrhh.reclutamiento_sevice.application.mapper;

import com.rrhh.reclutamiento_sevice.application.dto.PostulanteHijoDto;
import com.rrhh.reclutamiento_sevice.domain.model.Postulante;
import com.rrhh.reclutamiento_sevice.domain.model.PostulanteHijo;
import com.rrhh.reclutamiento_sevice.infrastructure.persistence.PostulanteHijoEntity;

public class PostulanteHijoMapper {

    public static PostulanteHijo fromEntity(PostulanteHijoEntity entity){
        return new PostulanteHijo(entity.id,entity.nombres, entity.apellidos,entity.fechaNacimiento, entity.sexoId);
    }

    public static PostulanteHijoEntity toDomain(PostulanteHijo domain){
        PostulanteHijoEntity entity = new PostulanteHijoEntity();
        entity.id=domain.id();
        entity.nombres= domain.nombres();
        entity.apellidos= domain.apellidos();
        entity.fechaNacimiento=domain.fechaNacimiento();
        entity.sexoId = domain.sexoId();

        return entity;
    }

    public static PostulanteHijoDto toDto(Postulante domain){
        return new PostulanteHijoDto(domain.id(), domain.nombres(), domain.apellidos(), domain.fechaNacimiento(), domain.sexoId());
    }

    public static PostulanteHijo fromDto(PostulanteHijoDto dto) {
        return new PostulanteHijo(dto.id(), dto.nombres(),dto.apellidos(), dto.fechaNacimiento(),dto.sexoId());
    }
}
