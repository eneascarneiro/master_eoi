package com.jma.prolecto_sin_cambios_yml.dto;

import com.jma.prolecto_sin_cambios_yml.model.TablaIzqEmbeddable;
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
