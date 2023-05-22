package com.example.jpa_formacion.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "localizacionlibros")
public class Localizacion {
    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column (name ="estanteria",length = 50)
    private String estanteria;

    @Column (name ="balda",length = 50)
    private String balda;

    @Column (name ="numero")
    private long numero;

    //Falta la relacion 1 a 1
    @OneToOne(mappedBy ="localizacion")
    private Libro libro;

    public Localizacion(long id, String estanteria, String balda, long numero, Libro libro) {
        this.id = id;
        this.estanteria = estanteria;
        this.balda = balda;
        this.numero = numero;
        this.libro = libro;
    }
}
