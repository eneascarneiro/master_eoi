package com.jma.prolecto_sin_cambios_yml.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tablaIzqTablaDerEmbeddable")
public class TablaIzqTablaDerEmbeddable {
    @EmbeddedId
    TablaIzqTablaDerKey id;

    //Cruce con etiqueta
    @ManyToOne
    @MapsId("tablaizqId")
    @JoinColumn(name = "tablaizqId")
    TablaIzqEmbeddable reltablaizqEmbeddable;

    //Cruce con Galeria
    @ManyToOne
    @MapsId("tabladerId")
    @JoinColumn(name = "tabladerId")
    TablaDerEmbeddable reltabladerEmbeddable;

    //Aqui las campos adicionales
    private ZonedDateTime fechaAlta;

    private String descripcion;

}
