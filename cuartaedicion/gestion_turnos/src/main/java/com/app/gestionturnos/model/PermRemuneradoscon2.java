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
public class PermRemuneradoscon2 {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column
  private String date;

  @ManyToOne
  @JoinColumn(name="empleado_id1", nullable=false)
  private Employee empleadopermc21;

  @ManyToOne
  @JoinColumn(name="empleado_id2", nullable=false)
  private Employee empleadopermc22;

}
