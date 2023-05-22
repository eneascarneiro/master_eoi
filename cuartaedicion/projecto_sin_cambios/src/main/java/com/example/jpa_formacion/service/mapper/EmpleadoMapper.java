package com.example.jpa_formacion.service.mapper;

import com.example.jpa_formacion.dto.ClienteDto;
import com.example.jpa_formacion.dto.EmpleadoDto;
import com.example.jpa_formacion.model.Cliente;
import com.example.jpa_formacion.model.Empleado;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoMapper extends AbstractServiceMapper<Empleado, EmpleadoDto> {
    //Convertir de entidad a dtoç
    @Override
    public EmpleadoDto toDto(Empleado entidad){
        final EmpleadoDto dto = new EmpleadoDto();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad,dto);
        return dto;
    }
    //Convertir de dto a entidad
    @Override
    public Empleado toEntity(EmpleadoDto dto){
        final Empleado entidad = new Empleado();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto,entidad);

        return entidad;
    }

    public EmpleadoMapper() {
    }
}
