package com.example.demo.service.mapper;


import com.example.demo.data.entity.BooksRead;
import com.example.demo.data.entity.Mensajes;
import com.example.demo.dto.BooksReadDTO;
import com.example.demo.dto.MensajesDTO;
import org.springframework.stereotype.Service;

@Service
public class MensajesServiceMapper extends  AbstractServiceMapper<Mensajes, MensajesDTO> {

    @Override
    public Mensajes toEntity(MensajesDTO dto) {
        final Mensajes entity = new Mensajes();
        entity.setId(dto.getId());
        entity.setTexto(dto.getMensaje());
        return entity;
    }

    @Override
    public MensajesDTO toDto(Mensajes entity) {
        final MensajesDTO dto = new MensajesDTO();
        dto.setId(entity.getId());
        dto.setMensaje(entity.getTexto());
        dto.setUserId(entity.getUser().getId());
        return dto;
    }
}
