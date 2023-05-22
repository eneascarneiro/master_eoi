package com.example.jpa_formacion.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "libro")
public class Libro {
    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column (name ="nombrelibro",length = 50)
    private String nombreLibro;

    //Falta la relacion N a 1 con autor
    @ManyToOne
    @JoinColumn(name = "codigo_autor")
    Autor autor;

    @ManyToMany
    @JoinTable(name = "libro_lector",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "lector_id"))
    private List<Lector> lectors = new ArrayList<>();


    //Falta la relacion 1 a 1
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "localizacion_id" , referencedColumnName ="id")
    private Localizacion localizacion;

    public Libro(long id, String nombreLibro, Autor autor, List<Lector> lectors, Localizacion localizacion) {
        this.id = id;
        this.nombreLibro = nombreLibro;
        this.autor = autor;
        this.lectors = lectors;
        this.localizacion = localizacion;
    }

    public Libro() {

    }
}
