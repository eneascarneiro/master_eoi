package servlet;

import DTO.BookDetalle;
import DTO.LibrosLeidos;
import dao.BooksDao;
import dao.UsuariosDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import javax.naming.NamingException;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

public class Login extends HttpServlet {
    int accesses = 0;

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        if (request.getParameter("user") == null || request.getParameter("user") == "" ||
                request.getParameter("password") == null || request.getParameter("password") == "") {
            response.sendRedirect("/");
        } else {

            //Si todo va bien consultamos la BBDD , tabla usuarios con usr y password
            UsuariosDao usuariosDao = new UsuariosDao(request.getParameter("user"), request.getParameter("password"));
            //Si son correctos pagina de entrada
            try {
                if (usuariosDao.ValidarUsuario(request)) {

                    //Quiero leer de usuariosdo mediante el método MostrarLibrosLeidos la lista de libros
                    List<LibrosLeidos> lista = null;
                    BooksDao booksDao = new BooksDao();
                    try {
                        lista = booksDao.MostrarLibrosLeidos(usuariosDao.getUsuarios().getUsuario());

                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (NamingException e) {
                        throw new RuntimeException(e);
                    }
                    //Preparar la salida para invocar al jsp
                    request.setAttribute("listaLibros", lista);
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/mostrarlibros.jsp");
                    requestDispatcher.forward(request, response);

                } else {
                    //Si no redirigimos al index
                    response.sendRedirect("/");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (NamingException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String action = request.getServletPath();
        System.out.println("accion:" + action );
        if (request.getParameter("opt") == null || request.getParameter("opt") == ""){
            //Comprobar si hemos introducido usuario y password
            if (request.getParameter("user") == null || request.getParameter("user") == "" ||
                    request.getParameter("password") == null || request.getParameter("password") == "") {
                response.sendRedirect("/");
            } else {

                //Si todo va bien consultamos la BBDD , tabla usuarios con usr y password
                UsuariosDao usuariosDao = new UsuariosDao(request.getParameter("user"), request.getParameter("password"));
                //Si son correctos pagina de entrada
                try {
                    if (usuariosDao.ValidarUsuario(request)) {

                        //Quiero leer de usuariosdo mediante el método MostrarLibrosLeidos la lista de libros
                        List<LibrosLeidos> lista = null;
                        BooksDao booksDao = new BooksDao();
                        try {
                            lista = booksDao.MostrarLibrosLeidos(usuariosDao.getUsuarios().getUsuario());

                        } catch (SQLException e) {
                            e.printStackTrace();
                        } catch (NamingException e) {
                            throw new RuntimeException(e);
                        }
                        //Preparar la salida para invocar al jsp
                        request.setAttribute("listaLibros", lista);
                        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/mostrarlibros.jsp");
                        requestDispatcher.forward(request, response);

                    } else {
                        //Si no redirigimos al index
                        response.sendRedirect("/");
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (NamingException e) {
                    throw new RuntimeException(e);
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        } else {
            String option = request.getParameter("opt");
            System.out.println("aqui llamaria a otra funcion option:" + option);
            if(Objects.equals(option, "out")) {
                try {
                    System.out.println("option1 :" + option);
                    LogOut(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public void LogOut(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        //Leer request id_libro
        if ( utils.token.ValidarSesion(request)) {
            //Quiero leer de usuariosdo mediante el método MostrarLibrosLeidos la lista de libros
            List<DTO.LibrosLeidos> lista = null;
            String usuario = utils.token.getUsuario();
            //Eliminamos datos de sesion
            utils.token.CerrarSeion(request);
            //Preparar la salida para invocar al jsp
            request.setAttribute("usuario", usuario);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/logout.jsp");
            requestDispatcher.forward(request, response);
        }
        else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/login.jsp");
            requestDispatcher.forward(request, response);
        }
    }

}