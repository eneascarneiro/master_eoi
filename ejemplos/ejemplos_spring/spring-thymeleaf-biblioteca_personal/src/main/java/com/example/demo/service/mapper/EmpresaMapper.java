package com.example.demo.service.mapper;


import com.example.demo.data.entity.Empresa;
import com.example.demo.dto.EmpresaDTO;
import org.springframework.stereotype.Service;

@Service
public class EmpresaMapper extends  AbstractServiceMapper<Empresa, EmpresaDTO> {

    @Override
    public Empresa toEntity(EmpresaDTO dto) {
        final Empresa entity = new Empresa();
        entity.setId(dto.getId());
        entity.setDescription(dto.getDescription());
        return entity;
    }

    @Override
    public EmpresaDTO toDto(Empresa entity) {
        final EmpresaDTO dto = new EmpresaDTO();
        dto.setId(entity.getId());
        dto.setDescription(entity.getDescription());
        return dto;
    }
}
