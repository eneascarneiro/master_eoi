package com.example.apirestbiblioteca.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Entity

@NamedQuery(name = "BooksRead.compras",
        query = "SELECT br.id,br.fechaLectura,  br.books.id as booksId , " +
                " br.user.id as userId, br.books.booktitle as booksTitle , " +
                " bs.date as fechaVenta , bs.precio " +
                "FROM BooksSold bs, BooksRead br  " +
                "where bs.books.id = br.books.id and " +
                " br.books.id > 10")
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