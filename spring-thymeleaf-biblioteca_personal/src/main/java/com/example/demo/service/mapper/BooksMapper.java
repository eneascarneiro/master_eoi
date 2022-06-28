package com.example.demo.service.mapper;


import com.example.demo.data.entity.Books;
import com.example.demo.data.entity.Books_Read;
import com.example.demo.data.entity.Task;
import com.example.demo.dto.BooksDTO;
import com.example.demo.dto.Books_ReadDTO;
import com.example.demo.dto.TaskDTO;
import com.example.demo.utils.DateUtil;

public class BooksMapper extends  AbstractServiceMapper<Books, BooksDTO> {

    @Override
    public Books toEntity(BooksDTO booksDTO) {
        final Books entity = new Books();
        entity.setId(booksDTO.getId());
        entity.setBook_title(booksDTO.getBook_title());
        return entity;
    }

    @Override
    public BooksDTO toDto(Books books) {
        final BooksDTO dto = new BooksDTO();
        dto.setId(books.getId());
        dto.setBook_title(books.getBook_title());
        return dto;
    }
}
