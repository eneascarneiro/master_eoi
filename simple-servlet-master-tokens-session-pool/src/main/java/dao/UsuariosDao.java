package dao;

import DTO.BookDetalle;
import DTO.LibrosLeidos;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import model.Usuarios;
import utils.ConexionBaseDatos;


import javax.naming.NamingException;


import java.sql.*;

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
    public boolean ValidarUsuario (HttpServletRequest request) throws SQLException, NamingException, ExecutionException, InterruptedException {
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


    public Usuarios getUsuarios() {
        return usuarios;
    }
}
