package com.example.jpa_formacion.dto;

import com.example.jpa_formacion.model.Etiqueta;
import com.example.jpa_formacion.model.EtiquetaEmbeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GaleriaEmbeddableDto {

    private long id;

    private String urlImg;
    private String titulo;
    //Aqui las dependencias

    private Integer empleadoId;
    private String  empleadoNombre;
    //Dependencia de las etiquetaDtos

    private Set<EtiquetaEmbeddable> etiquetas = new HashSet<>();

}
