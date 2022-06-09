package com.example.demo.service.mapper;

import com.example.demo.data.entity.Menu;
import com.example.demo.dto.MenuDTO;
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

    public Menu toEntity(MenuDTO dto) {
        final Menu entity = new Menu();
        entity.setId(dto.getId());
        entity.setDescription(dto.getDescription());
        entity.setActive(dto.getActive());
        entity.setOrder(dto.getOrder());
        entity.setParent(toEntity(dto.getParent()));
        entity.setUrl(dto.getUrl());
        entity.setRoles(this.roleServiceMapper.toEntity(dto.getRoles().stream().collect(Collectors.toList())).stream()
                .collect(Collectors.toSet()));
        return entity;
    }

    public MenuDTO toDto(Menu entity) {
        final MenuDTO dto = new MenuDTO();
        dto.setId(entity.getId());
        dto.setDescription(entity.getDescription());
        dto.setActive(entity.getActive());
        dto.setOrder(entity.getOrder());
        dto.setParent(entity.getParent() != null ? toDto(entity.getParent()) : null);
        dto.setUrl(entity.getUrl());
        dto.setRoles(this.roleServiceMapper.toDto(entity.getRoles().stream().collect(Collectors.toList())).stream()
                .collect(Collectors.toSet()));
        return dto;
    }

}
