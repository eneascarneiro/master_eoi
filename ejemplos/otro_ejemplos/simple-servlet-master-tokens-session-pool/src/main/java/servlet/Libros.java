package servlet;

import DTO.BookDetalle;
import dao.BooksDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

public class Libros extends HttpServlet {
    int accesses = 0;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String action = request.getServletPath();
        System.out.println("accion:" + action );
        if (request.getParameter("opt") == null || request.getParameter("opt") == ""){
            //Esta será la accion ejecutada por defecto !!!!!!!!!!!!!!!!!

            //Comprobamos que la sesion coincide y en caso afirmativo recumepamos el usuario
            if ( utils.token.ValidarSesion(request)) {
                //Quiero leer de usuariosdo mediante el método MostrarLibrosLeidos la lista de libros
                List<DTO.BookDetalle> lista = null;

                BooksDao booksDao = new BooksDao();
                try {
                    lista = booksDao.MostrarLibros();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                //Preparar la salida para invocar al jsp
                request.setAttribute("listaLibros", lista);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/mostrarlibrosvender.jsp");
                requestDispatcher.forward(request, response);
            }
            else {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/login.jsp");
                requestDispatcher.forward(request, response);
            }
        } else {
            String option = request.getParameter("opt");
            System.out.println("No hay opciçiones");

        }
    }
    public void MostrarDetalle(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        //Leer request id_libro

        int id = Integer.parseInt(request.getParameter("id_libro"));
        System.out.println("MostrarDetalle:" + id );
        //Llamar al DAO para burcar los datos del libro
        BooksDao booksDao = new BooksDao();
        System.out.println("MostrarDetalle:" + id );
        BookDetalle det_libro = booksDao.Detalle_libro(id);
        System.out.println("MostrarDetalle:" + id );
        //LLamar al mostrardetalle jsp enviando la informacion del libro
        System.out.println("MostrarDetalle:" + id );
        request.setAttribute("book", det_libro);
        RequestDispatcher rd = request.getRequestDispatcher("/jsp/mostrardetalle.jsp");
        rd.forward(request, response);
    }
}