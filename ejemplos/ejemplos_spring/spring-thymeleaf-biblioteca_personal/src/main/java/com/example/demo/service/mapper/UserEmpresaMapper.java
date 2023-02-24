package com.example.demo.service.mapper;


import com.example.demo.data.entity.Empresa;
import com.example.demo.data.entity.User;
import com.example.demo.data.entity.UserEmpresa;
import com.example.demo.dto.EmpresaDTO;
import com.example.demo.dto.UserEmpresaDTO;
import org.springframework.stereotype.Service;

@Service
public class UserEmpresaMapper extends  AbstractServiceMapper<UserEmpresa, UserEmpresaDTO> {


    @Override
    public UserEmpresa toEntity(UserEmpresaDTO dto) {
        final UserEmpresa entity = new UserEmpresa();
        entity.setId(dto.getId());
        entity.setTipo(dto.getTipo());
        //rel empresa
        /* solo se registran empresas*/
        Empresa empresa = new Empresa();
        empresa.setDescription(dto.getEmpresaDTO().getDescription());
        empresa.setId(dto.getEmpresaDTO().getId());
        entity.setEmpresa(empresa);

        return entity;
    }

    @Override
    public UserEmpresaDTO toDto(UserEmpresa entity) {
        final UserEmpresaDTO dto = new UserEmpresaDTO();
        dto.setId(entity.getId());
        dto.setTipo(entity.getTipo());
        //rel empresa
        EmpresaDTO empresaDTO = new EmpresaDTO();
        empresaDTO.setId(entity.getEmpresa().getId());
        empresaDTO.setDescription(entity.getEmpresa().getDescription());
        dto.setEmpresaDTO(empresaDTO);

        return dto;
    }
}
