package com.example.jpa_formacion.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "galeria")
public class Galeria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "urlImg")
    private String urlImg;
    @Column(name = "titulo")
    private String titulo;
    //Aqui las dependencias
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "codigoEmpleado")
    private Empleado empleadoGaleria;
    //Dependencia de las etiquetas
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "galeria_etiquetas",
            joinColumns = {@JoinColumn(name = "galeria_id") },
            inverseJoinColumns = {@JoinColumn(name = "etiqueta_id")}
    )
    private Set<Etiqueta> etiquetas = new HashSet<>();

}
