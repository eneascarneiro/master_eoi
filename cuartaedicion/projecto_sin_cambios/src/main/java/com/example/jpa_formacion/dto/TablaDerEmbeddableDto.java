package com.example.jpa_formacion.dto;

import com.example.jpa_formacion.model.TablaIzqEmbeddable;
import com.example.jpa_formacion.model.TablaIzqTablaDerEmbeddable;
import jakarta.persistence.*;
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

public class TablaDerEmbeddableDto {
    private long id;
    private String descripcion;
    //Aqui las dependencias

    private Set<TablaIzqEmbeddable> tblizq = new HashSet<>();


}
