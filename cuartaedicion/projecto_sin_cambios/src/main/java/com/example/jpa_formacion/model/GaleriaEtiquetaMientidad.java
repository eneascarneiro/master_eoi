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
@Table(name = "galeriaEtiquetaMientidad")
public class GaleriaEtiquetaMientidad {
    @Id
    Integer id;

    //Cruce con etiqueta
    @ManyToOne
    @MapsId("etiquetaMientId")
    @JoinColumn(name = "etiqueta_mient_id")
    EtiquetaMientidad etiquetaMientidad;

    //Cruce con Galeria
    @ManyToOne
    @MapsId("galeriaEmbedId")
    @JoinColumn(name = "galeria_mient_id")
    GaleriaMientidad galeriaMientidad;

    //Aqui las campos adicionales
    private ZonedDateTime fechaAlta;

    private String descripcion;
}
