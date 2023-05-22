package com.app.gestionturnos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@DynamicUpdate
public class Mensajes {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column
  private String date;

  @ManyToOne
  @JoinColumn(name="emisor", nullable=false)
  private Employee empleadoemisor;

  @ManyToOne
  @JoinColumn(name="receptor", nullable=false)
  private Employee empleadoreceptor;

}
