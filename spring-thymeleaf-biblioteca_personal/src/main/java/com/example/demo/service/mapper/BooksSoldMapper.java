package com.example.demo.service.mapper;


import com.example.demo.data.entity.BooksSold;
import com.example.demo.dto.BooksSoldDTO;
import com.example.demo.utils.DateUtil;
import org.springframework.stereotype.Service;

@Service
public class BooksSoldMapper extends  AbstractServiceMapper<BooksSold, BooksSoldDTO> {

    @Override
    public BooksSold toEntity(BooksSoldDTO dto) {
        final BooksSold entity = new BooksSold();
        entity.setId(dto.getId());
        entity.setPrecio(dto.getPrecio());
        entity.setDate(DateUtil.stringToDate(dto.getFechaVenta()));
        return entity;
    }

    @Override
    public BooksSoldDTO toDto(BooksSold entity) {
        final BooksSoldDTO dto = new BooksSoldDTO();
        dto.setId(entity.getId());
        dto.setBooksId(entity.getBooks().getId());
        dto.setPrecio(entity.getPrecio());
        //Tenemos que informar el bookTitle
        dto.setBooksTitle(entity.getBooks().getBooktitle());
        dto.setUserId(entity.getUser().getId());
        dto.setFechaVenta(DateUtil.dateToString(entity.getDate()));
        return dto;
    }
}
