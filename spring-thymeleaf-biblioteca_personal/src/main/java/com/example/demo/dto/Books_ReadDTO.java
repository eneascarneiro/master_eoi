package com.example.demo.dto;

import com.example.demo.data.entity.Books;
import com.example.demo.data.entity.User;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.util.Date;

public class Books_ReadDTO {
    private Integer id;

    private Date fecha_lectura;

    private Integer books_id;

    private Integer user_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha_lectura() {
        return fecha_lectura;
    }

    public void setFecha_lectura(Date fecha_lectura) {
        this.fecha_lectura = fecha_lectura;
    }

    public Integer getBooks_id() {
        return books_id;
    }

    public void setBooks_id(Integer books_id) {
        this.books_id = books_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
