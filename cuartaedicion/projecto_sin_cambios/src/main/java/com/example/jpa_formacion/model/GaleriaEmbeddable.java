package com.example.jpa_formacion.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "galeriaEmbeddable")
public class GaleriaEmbeddable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "urlImg")
    private String urlImg;
    @Column(name = "titulo")
    private String titulo;
    //Aqui las dependencias

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "codigoEmpleado")
    private Empleado empleadoGaleriaEmbed;

    @OneToMany(mappedBy = "galeriaEmbeddable", cascade = CascadeType.PERSIST )
    private Set<GaleriaEtiquetaEmbeddable> galeriaEtiquetaEmbeddables;


}
