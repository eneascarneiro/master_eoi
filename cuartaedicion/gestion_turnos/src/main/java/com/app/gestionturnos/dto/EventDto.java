package com.app.gestionturnos.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventDto {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="descripcion")
    private String descripcion;
    @Column(name="diames")
    private Integer diames;
    @Column(name="fecha_hora")
    private LocalDateTime fechahora;
    @Column(name="especializacion")
    private String especializacion;
    @Column(name="ubicacion")
    private String ubicacion;
    @Column(name="notificar")
    private Boolean notificar;
    @Column(name="notificar_tutor")
    private Boolean notificar_tutor;








}
