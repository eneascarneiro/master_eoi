package com.example.jpa_formacion.model;

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
    @MapsId("etiquetaEmbedId")
    @JoinColumn(name = "tablaizq_embed_id")
    TablaIzqEmbeddable reltablaizqEmbeddable;

    //Cruce con Galeria
    @ManyToOne
    @MapsId("galeriaEmbedId")
    @JoinColumn(name = "tablader_embed_id")
    TablaDerEmbeddable reltabladerEmbeddable;

    //Aqui las campos adicionales
    private ZonedDateTime fechaAlta;

    private String descripcion;

}
