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
@Table(name = "etiquetaMientidad")
public class EtiquetaMientidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    //Faltan relaciones
    @OneToMany(mappedBy = "etiquetaMientidad" )
    private Set<GaleriaEtiquetaMientidad> galeriaEtiquetaMientidads;
}
