package dao;

import DTO.BookDetalle;
import DTO.LibrosLeidos;
import DTO.UsuariosDTO;
import model.Usuarios;
import utils.ConexionBaseDatos;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class UsuariosDao {

    private Connection conn;
    private Usuarios usuarios;

    private Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getConnection();
    }
    public UsuariosDao(String user, String password) {
        usuarios = new Usuarios();
        usuarios.setUsuario(user);
        usuarios.setPassword(password);
    }
    public boolean isDbConnected() {
        try {
            return conn != null && !conn.isClosed();
        } catch (SQLException ignored) {}

        return false;
    }
    private void getConn() throws SQLException {
        if (!isDbConnected()) {
            //Get connection
            conn = getConnection();
        }
    }
    public boolean ValidarUsuario (HttpServletRequest request) throws SQLException {
        if (usuarios.usr_informado > 0){
            getConn();
            //Continuamos
            System.out.print("en ValidarUsuario: " + usuarios.getUsuario());
            Statement st = conn.createStatement();
            String sqllogin = "SELECT * FROM Usuario where usuario = '" + usuarios.getUsuario() +
                    "' and password = '" + usuarios.getPassword() +"'";
            System.out.print(sqllogin);
            ResultSet rs = st.executeQuery(sqllogin );
            //Hemos encontrado algo?
            if (rs.next()){
                rs.close();
                st.close();
                //Creamos una cookie de sesion
                HttpSession session = request.getSession();
                session.setAttribute("usuario",usuarios.getUsuario());
                session.setAttribute("token",utils.token.generateRandomToken(25,usuarios.getUsuario()));
                //Cambia el token si lo vuelvo a crear?
                System.out.print("\n");
                System.out.print("Token nuevo\n");
                System.out.print(utils.token.generateRandomToken(25,usuarios.getUsuario())+"\n");
                System.out.print("Token sesion\n");
                System.out.print(session.getAttribute("token")+"\n");

                return true;
            }
            else {
                rs.close();
                st.close();
                return false;
            }
        }
        else {
            return false;
        }
    }

    public UsuariosDTO GetUserData(HttpServletRequest request) throws SQLException {
        getConn();
        //Leemos el usuario de la sesion
        //Se lee la sesion
        HttpSession session = request.getSession();
        String usuario = (String) session.getAttribute("usuario");
        UsuariosDTO usuariosDTO = new UsuariosDTO();
        //Continuamos
        System.out.println("en GetUserData: " );
        Statement st = conn.createStatement();
        String sql = "SELECT * FROM Usuario where usuario = '" + usuario + "'";
        System.out.print(sql);
        ResultSet rs = st.executeQuery(sql );
        if (rs.next()) {
            usuariosDTO.setUsuario_id (rs.getInt("usuario_id"));
            usuariosDTO.setUsuario(rs.getString("usuario"));
            usuariosDTO.setPassword(rs.getString("password"));
            usuariosDTO.setFecha_insert(rs.getDate("fecha_insert"));
            usuariosDTO.setFecha_update(rs.getDate("fecha_update"));
            rs.close();
            st.close();
            return usuariosDTO;
        }
        else {
            rs.close();
            st.close();
            return null;
        }
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }
}
