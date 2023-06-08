package com.example.jpa_formacion.model;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.persistence.*;
import java.util.List;

@Entity
@EntityScan
@Table(name = "oficina")
public class Oficina {
    @Id
    @Column (name ="codigo_oficina")
    private long id;
    @Column (name ="ciudad",length = 30)
    private String ciudad	;
    @Column (name ="pais",length = 50)
    private String pais	;
    @Column (name ="region",length = 50)
    private String region	;
    @Column (name ="codigo_postal",length = 10)
    private String codigo_postal;
    @Column (name ="telefono",length = 20)
    private String telefono	;
    @Column (name ="linea_direccion1",length = 50)
    private String linea_direccion1;
    @Column (name ="linea_direccion2",length = 50)
    private String linea_direccion2;

    @OneToMany(mappedBy = "oficina")
    List<Empleado> empleados;



    public Oficina() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLinea_direccion1() {
        return linea_direccion1;
    }

    public void setLinea_direccion1(String linea_direccion1) {
        this.linea_direccion1 = linea_direccion1;
    }

    public String getLinea_direccion2() {
        return linea_direccion2;
    }

    public void setLinea_direccion2(String linea_direccion2) {
        this.linea_direccion2 = linea_direccion2;
    }

    //public List<Empleado> getEmpleados() {
    //    return empleados;
    //}

    //public void setEmpleados(List<Empleado> empleados) {
        //this.empleados = empleados;
    //}

    public Oficina(long id, String ciudad, String pais, String region, String codigo_postal, String telefono, String linea_direccion1, String linea_direccion2, List<Empleado> empleados) {
        this.id = id;
        this.ciudad = ciudad;
        this.pais = pais;
        this.region = region;
        this.codigo_postal = codigo_postal;
        this.telefono = telefono;
        this.linea_direccion1 = linea_direccion1;
        this.linea_direccion2 = linea_direccion2;
    }
}
