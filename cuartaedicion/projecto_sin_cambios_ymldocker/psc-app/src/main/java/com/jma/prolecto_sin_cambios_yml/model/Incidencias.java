package com.jma.prolecto_sin_cambios_yml.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Incidencia")
public class Incidencias {
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
    @JoinColumn(name = "usuariocreador")
    private Usuario usuarioincid;

}
