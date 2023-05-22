package com.example.jpa_formacion.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "empleado")
public class Empleado implements Serializable {
  @Id
  @Column (name ="ID")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  @Column (name ="nombre",length = 50)
  private String nombre;
  @Column (name ="apellido1",length = 50 )
  private String apellido1;
  @Column (name ="apellido2",length = 50)
  private String apellido2;
  @Column (name ="extension",length = 10  )
  private String extension;
  @Column (name ="email",length = 100  )
  private String email;
  @Column (name ="puesto",length =  50)
  private String puesto;


  @OneToMany(mappedBy = "empleado" , fetch = FetchType.EAGER)
  private Set<Cliente> clientes;

  @OneToMany(mappedBy = "empleadoGaleria" )
  private Set<Galeria> galerias;

  @OneToMany(mappedBy = "empleadoGaleriaEmbed" )
  private Set<GaleriaEmbeddable> galeriaEmbeddables;

  @OneToOne(mappedBy = "empleado")
  private Usuario usuario;


  @ManyToOne
  @JoinColumn(name = "codigo_oficina")
  Oficina oficina;


  @OneToMany(mappedBy = "empleadoreparacion" )
  private Set<Reparaciones> reparaciones;
}
