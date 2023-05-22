package com.example.jpa_formacion.model;



import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente  implements Serializable {
    @Id
    @Column(name ="codigo_cliente")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column (name ="nombre_cliente",length = 50)
    private String nombreCliente;
    @Column (name ="nombre_contacto",length = 30)
    private String nombreContacto;
    @Column (name ="apellido_contacto",length = 30)
    private String apellidoContacto;
    @Column (name ="telefono",length = 15)
    private String telefono	;
    @Column (name ="fax",length = 15)
    private String fax;
    @Column (name ="linea_direccion1",length = 50)
    private String lineaDireccion1;
    @Column (name ="linea_direccion2",length = 50)
    private String lineaDireccion2;
    @Column (name ="ciudad",length = 50)
    private String ciudad;
    @Column (name ="region",length = 50)
    private String region;
    @Column (name ="pais",length = 50)
    private String pais;
    @Column (name ="codigo_postal",length = 10)
    private String codigoPostal;
    @Column (name ="codigo_empleado_rep_ventas")
    private int codigoEmpleado_rep_ventas;
    @Column (name ="limite_credito")
    private Float limiteCredito;

    @Column (name ="limite_credito_min")
    private Float limiteCreditoMin;

    @Column (name ="limite_credito_max")
    private Float limiteCreditoMax;

    @Column (name ="limite_credito_max_1")
    private Float limiteCreditoMax1;


    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "codigo_empleado")
    Empleado empleado;

    @OneToMany(mappedBy = "cliente")
    List<Vehiculo> vehiculos;


}
