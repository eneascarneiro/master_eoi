package com.jma.prolecto_sin_cambios_yml.model;

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
@Table(name = "tablaDerEmbeddable")
public class TablaDerEmbeddable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "descripcion")
    private String descripcion;
    //Aqui las dependencias

    @OneToMany(mappedBy = "reltabladerEmbeddable" )
    private Set<TablaIzqTablaDerEmbeddable> tablaIzqTablaDerEmbeddables;


}
