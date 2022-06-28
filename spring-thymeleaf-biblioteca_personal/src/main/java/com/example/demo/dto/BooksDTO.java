package com.example.demo.dto;

import javax.persistence.Column;

public class BooksDTO {
    private Integer id;
    private String book_title;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }
}
