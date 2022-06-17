package dao;

import model.Usuarios;

import java.sql.*;

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
}
