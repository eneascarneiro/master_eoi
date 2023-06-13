package com.app.gestionturnos.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityScan
@Table(name = "Empresa")
public class Empresa{
    @Id
    @Column (name ="codigooficina")
    private long id;
    @Column (name ="ciudad",length = 30)
    private String ciudad	;
    @Column (name ="pais",length = 50)
    private String pais	;
    @Column (name ="region",length = 50)
    private String region	;
    @Column (name ="codigopostal",length = 10)
    private String codigopostal;
    @Column (name ="telefono",length = 20)
    private String telefono	;
    @Column (name ="lineadireccion1",length = 50)
    private String lineadireccion1;
    @Column (name ="lineadireccion2",length = 50)
    private String lineadireccion2;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", insertable = false, updatable = false)
    private Set<Employee> employees;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<TipoEmpresa> tipoEmpresas;


}
