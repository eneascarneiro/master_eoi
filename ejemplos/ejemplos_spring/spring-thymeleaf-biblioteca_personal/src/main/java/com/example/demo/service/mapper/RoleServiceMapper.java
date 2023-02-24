package com.example.demo.service.mapper;

import com.example.demo.data.entity.Role;
import com.example.demo.dto.RoleDTO;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceMapper extends AbstractServiceMapper<Role, RoleDTO> {

    public Role toEntity(RoleDTO dto) {
        final Role entity = new Role();
        entity.setId(dto.getId());
        entity.setRoleName(dto.getRoleName());
        return entity;
    }

    public RoleDTO toDto(Role entity) {
        final RoleDTO dto = new RoleDTO();
        dto.setId(entity.getId());
        dto.setRoleName(entity.getRoleName());
        return dto;
    }
}
