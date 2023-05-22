package com.example.jpa_formacion.service.mapper;


import com.example.jpa_formacion.dto.RoleDTO;
import com.example.jpa_formacion.model.Role;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceMapper extends AbstractServiceMapper<Role, RoleDTO> {

    public Role toEntity(RoleDTO dto) {
        final Role entidad = new Role();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad,dto);
        return entidad;
    }

    public RoleDTO toDto(Role entidad) {
        final RoleDTO dto = new RoleDTO();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad,dto);
        return dto;
    }
}
