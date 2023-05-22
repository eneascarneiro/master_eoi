package com.example.jpa_formacion.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "galeriaEtiquetaEmbeddable")
public class GaleriaEtiquetaEmbeddable {
    @EmbeddedId
    GaleriaEtiquetaKey id;

    //Cruce con etiqueta
    @ManyToOne
    @MapsId("etiquetaEmbedId")
    @JoinColumn(name = "etiqueta_embed_id")
    EtiquetaEmbeddable etiquetaEmbeddable;

    //Cruce con Galeria
    @ManyToOne
    @MapsId("galeriaEmbedId")
    @JoinColumn(name = "galeria_embed_id")
    GaleriaEmbeddable galeriaEmbeddable;

    //Aqui las campos adicionales
    private ZonedDateTime fechaAlta;

    private String descripcion;

    public GaleriaEtiquetaEmbeddable(EtiquetaEmbeddable item, GaleriaEmbeddable galeriaEmbeddable,
                                     ZonedDateTime lt, String miDescripcion) {
        this.etiquetaEmbeddable = item;
        this.galeriaEmbeddable = galeriaEmbeddable;
        this.fechaAlta = lt;
        this.descripcion = miDescripcion;

    }
}
