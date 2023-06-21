package com.jma.prolecto_sin_cambios_yml.service.mapper;

import com.jma.prolecto_sin_cambios_yml.dto.UsuarioDto;
import com.jma.prolecto_sin_cambios_yml.dto.UsuarioDtoPsw;
import com.jma.prolecto_sin_cambios_yml.model.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UsuarioMapper extends AbstractServiceMapper<Usuario,UsuarioDto> {
    //Convertir de entidad a dtoç
    @Override
    public UsuarioDto toDto(Usuario entidad){
        final UsuarioDto dto = new UsuarioDto();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad,dto);
        dto.setNombreEmail(entidad.getNombreUsuario() + entidad.getEmail());
        return dto;
    }
    //Convertir de dto a entidad
    @Override
    public Usuario toEntity(UsuarioDto dto){
        final Usuario entidad = new Usuario();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto,entidad);
        return entidad;
    }
    public Usuario toEntityPsw(UsuarioDtoPsw dto){
        final Usuario entidad = new Usuario();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto,entidad);
        return entidad;
    }

    public UsuarioMapper() {
    }
}
