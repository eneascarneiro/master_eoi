package DTO;

import java.util.Date;

public class LibrosLeidos {
    String usuario;
    Date fecha_insert;
    Date fecha_lectura;
    String book_title;

    public LibrosLeidos() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getFecha_insert() {
        return fecha_insert;
    }

    public void setFecha_insert(Date fecha_insert) {
        this.fecha_insert = fecha_insert;
    }

    public Date getFecha_lectura() {
        return fecha_lectura;
    }

    public void setFecha_lectura(Date fecha_lectura) {
        this.fecha_lectura = fecha_lectura;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }
}
