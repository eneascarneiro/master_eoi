package com.example.apirestbiblioteca.entity;

import javax.persistence.*;

@Entity
@Table(name = "gatos")
public class Gatos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}