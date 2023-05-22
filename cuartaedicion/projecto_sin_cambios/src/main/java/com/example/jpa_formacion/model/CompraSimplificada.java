package com.example.jpa_formacion.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comprasimplificada")
public class CompraSimplificada {

    @Id
    @JsonProperty("id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pk;
    private Date fecha;
    private Double total;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comprasimplificada")
    Set<Producto> productos = new HashSet<>();

}