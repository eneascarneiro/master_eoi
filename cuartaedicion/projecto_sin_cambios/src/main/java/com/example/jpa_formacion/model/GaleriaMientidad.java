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
@Table(name = "galeriaMientidad")
public class GaleriaMientidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "urlImg")
    private String urlImg;
    @Column(name = "titulo")
    private String titulo;
    //Aqui las dependencias
    //Faltan relaciones
    @OneToMany(mappedBy = "galeriaMientidad" )
    private Set<GaleriaEtiquetaMientidad> galeriaEtiquetaMientidads;
}
