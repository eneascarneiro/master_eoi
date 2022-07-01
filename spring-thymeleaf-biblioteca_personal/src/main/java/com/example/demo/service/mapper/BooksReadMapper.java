package com.example.demo.service.mapper;


import com.example.demo.data.entity.BooksRead;
import com.example.demo.dto.BooksReadDTO;
import org.springframework.stereotype.Service;

@Service
public class BooksReadMapper extends  AbstractServiceMapper<BooksRead, BooksReadDTO> {

    @Override
    public BooksRead toEntity(BooksReadDTO booksReadDTO) {
        final BooksRead entity = new BooksRead();
        entity.setId(booksReadDTO.getId());
        entity.setFechaLectura(booksReadDTO.getFechaLectura());
        return entity;
    }

    @Override
    public BooksReadDTO toDto(BooksRead booksRead) {
        final BooksReadDTO dto = new BooksReadDTO();
        dto.setId(booksRead.getId());
        dto.setBooksId(booksRead.getBooks().getId());
        dto.setBooksTitle(booksRead.getBooks().getBooktitle());
        dto.setUserId(booksRead.getUser().getId());
        dto.setFechaLectura(booksRead.getFechaLectura());
        return dto;
    }
}
