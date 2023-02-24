package com.example.apirestbiblioteca.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "books")
@NamedQuery(name = "Books.lista",
        query = "SELECT b " +
                "FROM Books b")
public class Books implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String booktitle;

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}