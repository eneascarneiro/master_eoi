package com.jma.prolecto_sin_cambios_yml.model;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reparaciones")
public class Reparaciones implements Serializable {
    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column (name ="repaciones",length = 50)
    private String repaciones;
    @Column(name ="id_vehiculo")
    private  long id_vehiculo;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "codigo_empleado")
    Empleado empleadoreparacion;

}
