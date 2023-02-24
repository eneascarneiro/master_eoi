package dao;

import DTO.BookDetalle;
import DTO.LibrosLeidos;
import DTO.UsuariosDTO;
import model.Books;
import model.Usuarios;
import utils.ConexionBaseDatos;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class BooksDao {

    private Connection conn;
    private Books books;

    private Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getConnection();
    }
    public BooksDao() {
        books = new Books();
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

    public BookDetalle Detalle_libro(int id_libro)  throws SQLException {
        getConn();
        //Continuamos
        System.out.print("en Detalle_libro: ");
        Statement st = conn.createStatement();
        String sql = "SELECT  b.book_id, b.book_title, b.precio from   books b where  b.book_id =  " + id_libro;
        System.out.print(sql);
        ResultSet rs = st.executeQuery(sql);
        BookDetalle milibro = new BookDetalle();
        if (rs.next()) {
            milibro.setBook_id(rs.getInt("book_id"));
            milibro.setBook_tittle(rs.getString("book_title"));
            milibro.setPrecio(rs.getDouble("precio"));
            rs.close();
            st.close();
            return milibro;
        }
        else {
            rs.close();
            st.close();
            return null;
        }
    }
    //Creamos un método para obtener todos los libros de un usuario
    public  List<LibrosLeidos> MostrarLibrosLeidos(String usuario) throws SQLException, NamingException, ExecutionException, InterruptedException {
        getConn();



        System.out.print("en MostrarLibrosLeidos: " +usuario);
        Statement st = conn.createStatement();
        String sql = "SELECT  u.usuario, u.fecha_insert, br.fecha_lectura, b.book_title , b.book_id " +
                "FROM usuario u " +
                "join books_read br on u.usuario_id = br.usuario_id " +
                "join books b on br.book_id = b.book_id " +
                "where usuario = '"+ usuario + "'";
        System.out.print(sql);
        ResultSet rs = st.executeQuery(sql );
        //Recorrer el rs (resultset) y generar una lista para componer en el jsp el código de forma dinámica
        List<LibrosLeidos>  milista = new ArrayList<>();
        while (rs.next()){

            LibrosLeidos elem = new LibrosLeidos();

            elem.setUsuario(rs.getString("usuario"));
            elem.setFecha_insert(rs.getDate("fecha_insert"));
            elem.setFecha_lectura(rs.getDate("fecha_lectura"));
            elem.setBook_title(rs.getString("book_title"));
            elem.setBook_id(rs.getInt("book_id"));


            milista.add(elem);
        }
        //conn.close();
        rs.close();
        st.close();

        return milista;
    }

    public  List<BookDetalle> MostrarLibros() throws SQLException {
        getConn();
        System.out.print("en MostrarLibros: ");
        Statement st = conn.createStatement();
        String sql = "SELECT   b.book_title , b.book_id , b.precio FROM books b ";
        System.out.print(sql);
        ResultSet rs = st.executeQuery(sql );
        //Recorrer el rs (resultset) y generar una lista para componer en el jsp el código de forma dinámica
        List<BookDetalle>  milista = new ArrayList<>();
        while (rs.next()){
            BookDetalle elem = new BookDetalle();
            elem.setBook_tittle(rs.getString("book_title"));
            elem.setBook_id(rs.getInt("book_id"));
            elem.setPrecio(rs.getDouble("precio"));
            milista.add(elem);
        }
        //conn.close();
        rs.close();
        st.close();

        return milista;
    }
    public  boolean ComprarLibros(HttpServletRequest request) throws SQLException {
        //Se lee la sesion
        HttpSession session = request.getSession();
        List<BookDetalle> listacarrito = new ArrayList<>();
        listacarrito = (List<BookDetalle>) session.getAttribute("listacarrito");
        //Buscamos el usuario
        System.out.println("usr:" + session.getAttribute("usuario"));
        if (listacarrito.size() > 0) {
            //pedimos la conexion al pool
            try {
                getConn();
                Statement st = conn.createStatement();
                for (int indice = 0; indice < listacarrito.size(); indice++) {
                    //Por cada elemento se inserta en la bbdd
                    System.out.println("Inserting records into the table...");
                    String sql = "insert into books_sold (book_id, usuario_id, fecha_venta, precio) values ( " +
                            listacarrito.get(indice).getBook_id() + " , " +
                            " ( select usuario_id from usuario where  usuario = '" + session.getAttribute("usuario")  + "') ," +
                            " CURRENT_TIMESTAMP() , " +
                            listacarrito.get(indice).getPrecio() + " )";
                    System.out.println(sql);
                    st.executeUpdate(sql);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return true;
        } else {
            return false;
        }
    }
}
