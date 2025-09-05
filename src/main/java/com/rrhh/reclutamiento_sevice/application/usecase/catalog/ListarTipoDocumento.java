package com.rrhh.reclutamiento_sevice.application.usecase.catalog;

import com.rrhh.reclutamiento_sevice.application.dto.TipoDocumentoDto;
import com.rrhh.reclutamiento_sevice.application.mapper.TipoDocumentoMapper;
import com.rrhh.reclutamiento_sevice.domain.model.TipoDocumento;
import com.rrhh.reclutamiento_sevice.domain.port.TipoDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ListarTipoDocumento {

    @Autowired
    TipoDocumentoRepository repository;

    public Flux<TipoDocumentoDto> findAll(){
        return repository.findAll()
                .map(TipoDocumentoMapper::toDto);
    }
}
