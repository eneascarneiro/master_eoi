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
@Table(name = "tablaIzqTablaDerConDup")
public class TablaIzqTablaDerConDup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    //Cruce con etiqueta
    @ManyToOne
    @MapsId("etiquetaEmbedId")
    @JoinColumn(name = "tablaizq_dup_id")
    TablaIzqConDup reltablaizqConDup;

    //Cruce con Galeria
    @ManyToOne
    @MapsId("galeriaEmbedId")
    @JoinColumn(name = "tablader_dup_id")
    TablaDerConDup reltabladerConDup;

    //Aqui las campos adicionales
    private ZonedDateTime fechaAlta;

    private String descripcion;

}
