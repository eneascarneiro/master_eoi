package com.example.jpa_formacion.service.mapper;

import com.example.jpa_formacion.dto.EtiquetaDto;
import com.example.jpa_formacion.dto.EtiquetaDtoApi;
import com.example.jpa_formacion.model.Etiqueta;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<EtiquetaDtoApi> toDtoApi(List<Etiqueta> e){
        return e.stream().map(this::toDtoApiEnt).collect(Collectors.toList());
    }
    public EtiquetaDtoApi toDtoApiEnt(Etiqueta entidad){
        final EtiquetaDtoApi dto = new EtiquetaDtoApi();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad,dto);

        return dto;
    }

}
