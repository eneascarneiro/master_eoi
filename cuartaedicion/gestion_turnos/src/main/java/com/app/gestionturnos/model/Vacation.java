package com.app.gestionturnos.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicUpdate
public class Vacation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @ManyToOne()
  private Employee employee;

  public Employee getEmployee() {
    return this.employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  @Column
  private String end;

  public String getEnd() {
    return this.end;
  }

  public void setEnd(String end) {
    this.end = end;
  }

  @Column
  private String start;

  public String getStart() {
    return this.start;
  }

  public void setStart(String start) {
    this.start = start;
  }

}
