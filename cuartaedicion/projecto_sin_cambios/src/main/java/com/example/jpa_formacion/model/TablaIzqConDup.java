package com.example.jpa_formacion.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tablaIzqConDup")
public class TablaIzqConDup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToMany(mappedBy = "reltablaizqConDup" )
    private Set<TablaIzqTablaDerConDup> tablaIzqTablaDerConDups;


}
