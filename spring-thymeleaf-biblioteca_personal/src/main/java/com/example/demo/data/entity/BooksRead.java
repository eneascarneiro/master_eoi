package com.example.demo.data.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity
public class BooksRead implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private ZonedDateTime fechaLectura;
    @ManyToOne
    private Books books;

    @ManyToOne
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    public ZonedDateTime getFechaLectura() {
        return fechaLectura;
    }

    public void setFechaLectura(ZonedDateTime fechaLectura) {
        this.fechaLectura = fechaLectura;
    }
}