package com.rrhh.reclutamiento_sevice.application.usecase.catalog;

import com.rrhh.reclutamiento_sevice.application.dto.TipoDocumentoDto;
import com.rrhh.reclutamiento_sevice.application.mapper.TipoDocumentoMapper;
import com.rrhh.reclutamiento_sevice.domain.model.TipoDocumento;
import com.rrhh.reclutamiento_sevice.domain.port.TipoDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class BuscarTipoDocumento {

    @Autowired
    TipoDocumentoRepository repository;

    public Mono<TipoDocumentoDto> findById(Long id){
        return repository.findById(id)
                .map(TipoDocumentoMapper::toDto);
    }
}
