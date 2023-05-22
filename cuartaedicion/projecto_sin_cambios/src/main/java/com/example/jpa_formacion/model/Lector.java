package com.example.jpa_formacion.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "lector")
public class Lector {
    @Id
    @Column(name ="id_lector")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column (name ="nombrelector",length = 50)
    private String nombreLector;

    @ManyToMany(mappedBy = "lectors")
    private List<Libro> libros = new ArrayList<>();

    public Lector(long id, String nombreLector, List<Libro> librosnm) {
        this.id = id;
        this.nombreLector = nombreLector;
        this.libros = librosnm;
    }
}
