package com.example.jpa_formacion.service.mapper;


import com.example.jpa_formacion.dto.MenuDTO;
import com.example.jpa_formacion.model.Menu;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class MenuServiceMapper extends AbstractServiceMapper<Menu, MenuDTO> {

    private final RoleServiceMapper roleServiceMapper;

    @Autowired
    public MenuServiceMapper(RoleServiceMapper roleServiceMapper) {
        this.roleServiceMapper = roleServiceMapper;
    }

    public Menu toEntity(MenuDTO dto) throws Exception {
        final Menu entidad = new Menu();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad,dto);
        entidad.setRoles(this.roleServiceMapper.toEntity(dto.getRoles().stream().collect(Collectors.toList())).stream()
                .collect(Collectors.toSet()));
        return entidad;
    }

    public MenuDTO toDto(Menu entidad) {
        final MenuDTO dto = new MenuDTO();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad,dto);
        dto.setRoles(this.roleServiceMapper.toDto(entidad.getRoles().stream().collect(Collectors.toList())).stream()
                .collect(Collectors.toSet()));
        return dto;
    }

}
