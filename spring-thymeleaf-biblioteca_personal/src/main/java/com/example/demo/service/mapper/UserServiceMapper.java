package com.example.demo.service.mapper;


import com.example.demo.data.entity.User;
import com.example.demo.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
@Service
public class UserServiceMapper  extends AbstractServiceMapper<User, UserDTO>{
    private final RoleServiceMapper roleServiceMapper;

    public UserServiceMapper(RoleServiceMapper roleServiceMapper) {
        this.roleServiceMapper = roleServiceMapper;
    }

    @Override
    public User toEntity(UserDTO userDTO) {
        User entity = new User();
        entity.setId(userDTO.getId());
        entity.setUserName(userDTO.getUserName());
        entity.setPassword(userDTO.getPassword());
        entity.setActive(userDTO.isActive());
        entity.setRoles(this.roleServiceMapper.toEntity(userDTO.getRoles().
                                stream().collect(Collectors.toList())).stream()
                                .collect(Collectors.toSet()));
        return entity;
    }

    @Override
    public UserDTO toDto(User entity) {
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setActive(entity.isActive());
        dto.setUserName(entity.getUserName());
        dto.setDate(entity.getDate());
        //dto.setPassword(); la password no se edita ni se lista
        dto.setRoles(this.roleServiceMapper.toDto(entity.getRoles().
                        stream().collect(Collectors.toList())).stream()
                .collect(Collectors.toSet()));
        return dto;
    }
}
