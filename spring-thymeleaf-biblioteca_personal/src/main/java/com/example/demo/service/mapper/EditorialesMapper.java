package com.example.demo.service.mapper;


import com.example.demo.data.entity.BooksRead;
import com.example.demo.data.entity.Editoriasles;
import com.example.demo.dto.BooksReadDTO;
import com.example.demo.dto.EditoriaslesDTO;
import org.springframework.stereotype.Service;

@Service
public class EditorialesMapper extends  AbstractServiceMapper<Editoriasles, EditoriaslesDTO> {

    @Override
    public Editoriasles toEntity(EditoriaslesDTO dto) {
        final Editoriasles entity = new Editoriasles();
        entity.setId(dto.getId());
        entity.setNombre_editorial(dto.getNombre_editorial());
        return entity;
    }

    @Override
    public EditoriaslesDTO toDto(Editoriasles entity) {
        final EditoriaslesDTO dto = new EditoriaslesDTO();
        dto.setId(entity.getId());
        dto.setBooksID(entity.getBooks().getId());
        dto.setNombre_editorial(entity.getNombre_editorial());
        return dto;
    }
}
