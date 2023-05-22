package com.example.jpa_formacion.dto;

import jakarta.persistence.Column;

import java.util.Set;

public class EmpleadoDto {

    private long id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String extension;
    private String email;
    private int codigoJefe;
    private String puesto;

    //Necesito las referencias a los clientes ponemos un set
    private Set<ClienteDto> clientes;

    public EmpleadoDto(){

    }
    public EmpleadoDto(long id, String nombre, String apellido1, String apellido2, String extension, String email, int codigoJefe, String puesto) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.extension = extension;
        this.email = email;
        this.codigoJefe = codigoJefe;
        this.puesto = puesto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCodigoJefe() {
        return codigoJefe;
    }

    public void setCodigoJefe(int codigoJefe) {
        this.codigoJefe = codigoJefe;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Set<ClienteDto> getClienteDtoSet() {
        return clientes;
    }

    public void setClienteDtoSet(Set<ClienteDto> clienteDtoSet) {
        this.clientes = clienteDtoSet;
    }
}
