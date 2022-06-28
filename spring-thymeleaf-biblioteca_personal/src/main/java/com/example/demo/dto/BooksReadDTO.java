package com.example.demo.dto;

import java.util.Date;

public class BooksReadDTO {
    private Integer id;

    private Date fechaLectura;

    private Integer booksId;

    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaLectura() {
        return fechaLectura;
    }

    public void setFechaLectura(Date fechaLectura) {
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
}
