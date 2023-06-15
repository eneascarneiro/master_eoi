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
@Table(name = "tablaDerConDup")
public class TablaDerConDup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "descripcion")
    private String descripcion;
    //Aqui las dependencias

    @OneToMany(mappedBy = "reltabladerConDup" )
    private Set<TablaIzqTablaDerConDup> tablaIzqTablaDerConDup;


}
