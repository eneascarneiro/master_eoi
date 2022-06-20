package dao;

import DTO.LibrosLeidos;
import model.Usuarios;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuariosDao {
    private  static String urlBBDD = "jdbc:mysql://localhost:3306/gestion_libros";
    private static  String usrBBDD = "root";
    private static  String usrPassword = "eneas2805";

    private Usuarios usuarios;


    private static Connection conn;
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(urlBBDD, usrBBDD, usrPassword);
        } catch (ClassNotFoundException e ) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public UsuariosDao(String user, String password) {
        usuarios = new Usuarios();
        usuarios.setUsuario(user);
        usuarios.setPassword(password);
    }

    public boolean ValidarUsuario () throws SQLException {
        if (usuarios.usr_informado > 0){

            System.out.print("en ValidarUsuario: " + usuarios.getUsuario());
            Statement st = conn.createStatement();
            String sqllogin = "SELECT * FROM Usuario where usuario = '" + usuarios.getUsuario() +
                    "' and password = '" + usuarios.getPassword() +"'";
            System.out.print(sqllogin);
            ResultSet rs = st.executeQuery(sqllogin );
            //Hemos encontrado algo?
            if (rs.next()){
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
    //Creamos un método para obtener todos los libros de un usuario
    public List<LibrosLeidos> MostrarLibrosLeidos() throws SQLException{
        System.out.print("en MostrarLibrosLeidos: " + usuarios.getUsuario());
        Statement st = conn.createStatement();
        String sql = "SELECT  u.usuario, u.fecha_insert, br.fecha_lectura, b.book_title " +
                "FROM usuario u " +
                "join books_read br on u.usuario_id = br.usuario_id " +
                "join books b on br.book_id = b.book_id " +
                "where usuario = '"+ usuarios.getUsuario() + "'";
        System.out.print(sql);
        ResultSet rs = st.executeQuery(sql );
        //Recorrer el rs (resultset) y generar una lista para componer en el jsp el código de forma dinámica
        List<LibrosLeidos>  milista = new ArrayList<>();
        while (rs.next()){

            LibrosLeidos elem = new LibrosLeidos();
            elem.setUsuario(rs.getString(1));
            elem.setFecha_insert(rs.getDate(2));
            elem.setFecha_lectura(rs.getDate(3));
            elem.setBook_title(rs.getString(4));

            /*
            elem.setUsuario(rs.getString("usuario"));
            elem.setFecha_insert(rs.getDate("fecha_insert"));
            elem.setFecha_lectura(rs.getDate("fecha_lectura"));
            elem.setBook_title(rs.getString("book_title"));
            */

            milista.add(elem);
        }
        return milista;
    }
}
