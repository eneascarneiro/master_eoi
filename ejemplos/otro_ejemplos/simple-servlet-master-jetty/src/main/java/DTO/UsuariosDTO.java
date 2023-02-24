package DTO;

import java.util.Date;

public class UsuariosDTO {
    int usuario_id;
    String usuario;
    String password;
    Date fecha_insert;
    Date fecha_update;

    public UsuariosDTO() {
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getFecha_insert() {
        return fecha_insert;
    }

    public void setFecha_insert(Date fecha_insert) {
        this.fecha_insert = fecha_insert;
    }

    public Date getFecha_update() {
        return fecha_update;
    }

    public void setFecha_update(Date fecha_update) {
        this.fecha_update = fecha_update;
    }
}
