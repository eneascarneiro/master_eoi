package com.example.jpa_formacion.model;



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
@Table(name = "vehiculo")
public class Vehiculo implements Serializable {
    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column (name ="matricula",length = 50)
    private String matricula;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "codigo_cliente")
    Cliente cliente;

}
