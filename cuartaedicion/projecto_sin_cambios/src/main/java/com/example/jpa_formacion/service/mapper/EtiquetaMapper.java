package com.example.jpa_formacion.service.mapper;

import com.example.jpa_formacion.dto.EtiquetaDto;
import com.example.jpa_formacion.model.Etiqueta;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EtiquetaMapper extends AbstractServiceMapper<Etiqueta, EtiquetaDto> {
    //Convertir de entidad a dto

    public EtiquetaMapper() {

    }
    @Override
    public EtiquetaDto toDto(Etiqueta entidad){
        final EtiquetaDto dto = new EtiquetaDto();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad,dto);

        return dto;
    }
    //Convertir de dto a entidad
    @Override
    public Etiqueta toEntity(EtiquetaDto dto) throws Exception {
        final Etiqueta entidad = new Etiqueta();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto,entidad);

        return entidad;
    }

}
