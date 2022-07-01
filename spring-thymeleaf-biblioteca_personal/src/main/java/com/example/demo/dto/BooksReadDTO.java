package com.example.demo.dto;

import java.time.ZonedDateTime;
import java.util.Date;

public class BooksReadDTO {
    private Integer id;

    private ZonedDateTime fechaLectura;

    private Integer booksId;

    private Integer userId;

    private String booksTitle;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ZonedDateTime getFechaLectura() {
        return fechaLectura;
    }

    public void setFechaLectura(ZonedDateTime fechaLectura) {
        this.fechaLectura = fechaLectura;
    }

    public Integer getBooksId() {
        return booksId;
    }

    public void setBooksId(Integer books_id) {
        this.booksId = books_id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer user_id) {
        this.userId = user_id;
    }

    public String getBooksTitle() {
        return booksTitle;
    }

    public void setBooksTitle(String booksTitle) {
        this.booksTitle = booksTitle;
    }
}
