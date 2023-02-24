package com.example.proyecto_spring_html_th;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Person {
    private String Nombre;
    private String Apellidos;
    private String Foto;
    private String Direc;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date   FechaNacimiento;

    public Person(String nombre, String apellidos, String foto, String direc, Date fechaNacimiento) {
        Nombre = nombre;
        Apellidos = apellidos;
        Foto = foto;
        Direc = direc;
        FechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public String getFoto() {
        return Foto;
    }

    public String getDirec() {
        return Direc;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public void setFoto(String foto) {
        Foto = foto;
    }

    public void setDirec(String direc) {
        Direc = direc;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        FechaNacimiento = fechaNacimiento;
    }
}
