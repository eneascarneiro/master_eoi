package com.example.jpa_formacion.model;


import com.example.jpa_formacion.model.Libro;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "autor")
public class Autor {
    @Id
    @Column(name ="codigo_autor")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column (name ="nombreAutor",length = 50)
    private String nombreAutor;


    //Falta la relacion 1 a N con libro
    @OneToMany(mappedBy = "autor")
    List<Libro> libros;

    public Autor(long id, String nombreAutor, List<Libro> libros) {
        this.id = id;
        this.nombreAutor = nombreAutor;
        this.libros = libros;
    }
}
