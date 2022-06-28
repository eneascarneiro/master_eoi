package com.example.demo.service.mapper;


import com.example.demo.data.entity.Books;
import com.example.demo.dto.BooksDTO;
import org.springframework.stereotype.Service;

@Service
public class BooksMapper extends  AbstractServiceMapper<Books, BooksDTO> {

    @Override
    public Books toEntity(BooksDTO booksDTO) {
        final Books entity = new Books();
        entity.setId(booksDTO.getId());
        entity.setBooktitle(booksDTO.getBookTitle());
        return entity;
    }

    @Override
    public BooksDTO toDto(Books books) {
        final BooksDTO dto = new BooksDTO();
        dto.setId(books.getId());
        dto.setBookTitle(books.getBooktitle());
        return dto;
    }
}
