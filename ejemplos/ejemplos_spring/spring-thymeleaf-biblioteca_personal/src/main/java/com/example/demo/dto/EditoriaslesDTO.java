package com.example.demo.dto;

import com.example.demo.data.entity.Books;

import javax.persistence.*;
import java.io.Serializable;


public class EditoriaslesDTO implements Serializable {


    private Integer id;

    private String nombre_editorial;

    private Integer booksID;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre_editorial() {
        return nombre_editorial;
    }

    public void setNombre_editorial(String nombre_editorial) {
        this.nombre_editorial = nombre_editorial;
    }

    public Integer getBooksID() {
        return booksID;
    }

    public void setBooksID(Integer booksID) {
        this.booksID = booksID;
    }
}