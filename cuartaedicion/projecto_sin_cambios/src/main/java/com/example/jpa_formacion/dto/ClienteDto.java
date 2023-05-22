package com.example.jpa_formacion.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ClienteDto {

    private long id;
    private String nombreCliente;
    private String nombreContacto;
    private String apellidoContacto;
    private String telefono	;
    private String fax;
    private String lineaDireccion1;
    private String lineaDireccion2;
    private String ciudad;
    private String region;
    private String pais;
    private String codigoPostal;
    private int codigoEmpleado_rep_ventas;
    private Float limiteCredito;
    private Float limiteCreditoMin;
    private Float limiteCreditoMax;
    private Float limiteCreditoMax1;

    private Integer empleadoId;

    private String empleadoNombre;

    public ClienteDto(){

    }

    public ClienteDto(long id, String nombreCliente, String nombreContacto, String apellidoContacto, String telefono, String fax, String lineaDireccion1, String lineaDireccion2, String ciudad, String region, String pais, String codigoPostal, int codigoEmpleado_rep_ventas, Float limiteCredito, Float limiteCreditoMin, Float limiteCreditoMax, Float limiteCreditoMax1, Integer empleadoId, String empleadoNombre) {
        this.id = id;
        this.nombreCliente = nombreCliente;
        this.nombreContacto = nombreContacto;
        this.apellidoContacto = apellidoContacto;
        this.telefono = telefono;
        this.fax = fax;
        this.lineaDireccion1 = lineaDireccion1;
        this.lineaDireccion2 = lineaDireccion2;
        this.ciudad = ciudad;
        this.region = region;
        this.pais = pais;
        this.codigoPostal = codigoPostal;
        this.codigoEmpleado_rep_ventas = codigoEmpleado_rep_ventas;
        this.limiteCredito = limiteCredito;
        this.limiteCreditoMin = limiteCreditoMin;
        this.limiteCreditoMax = limiteCreditoMax;
        this.limiteCreditoMax1 = limiteCreditoMax1;
        this.empleadoId = empleadoId;
        this.empleadoNombre = empleadoNombre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getApellidoContacto() {
        return apellidoContacto;
    }

    public void setApellidoContacto(String apellidoContacto) {
        this.apellidoContacto = apellidoContacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getLineaDireccion1() {
        return lineaDireccion1;
    }

    public void setLineaDireccion1(String lineaDireccion1) {
        this.lineaDireccion1 = lineaDireccion1;
    }

    public String getLineaDireccion2() {
        return lineaDireccion2;
    }

    public void setLineaDireccion2(String lineaDireccion2) {
        this.lineaDireccion2 = lineaDireccion2;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public int getCodigoEmpleado_rep_ventas() {
        return codigoEmpleado_rep_ventas;
    }

    public void setCodigoEmpleado_rep_ventas(int codigoEmpleado_rep_ventas) {
        this.codigoEmpleado_rep_ventas = codigoEmpleado_rep_ventas;
    }

    public Float getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(Float limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public Float getLimiteCreditoMin() {
        return limiteCreditoMin;
    }

    public void setLimiteCreditoMin(Float limiteCreditoMin) {
        this.limiteCreditoMin = limiteCreditoMin;
    }

    public Float getLimiteCreditoMax() {
        return limiteCreditoMax;
    }

    public void setLimiteCreditoMax(Float limiteCreditoMax) {
        this.limiteCreditoMax = limiteCreditoMax;
    }

    public Float getLimiteCreditoMax1() {
        return limiteCreditoMax1;
    }

    public void setLimiteCreditoMax1(Float limiteCreditoMax1) {
        this.limiteCreditoMax1 = limiteCreditoMax1;
    }

    public Integer getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Integer empleadoId) {
        this.empleadoId = empleadoId;
    }

    public String getEmpleadoNombre() {
        return empleadoNombre;
    }

    public void setEmpleadoNombre(String empleadoNombre) {
        this.empleadoNombre = empleadoNombre;
    }
}
