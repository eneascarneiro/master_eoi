package servlet;

import DTO.LibrosLeidos;
import dao.UsuariosDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class Login extends HttpServlet {
    int accesses = 0;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        //Comprobar si hemos introducido usuario y password
        if (request.getParameter("user") == null || request.getParameter("user") =="" ||
                request.getParameter("password") == null || request.getParameter("password") ==""  ) {
                response.sendRedirect("/");
        }
        else {

            //Si todo va bien consultamos la BBDD , tabla usuarios con usr y password
            UsuariosDao usuariosDao = new UsuariosDao(request.getParameter("user"),request.getParameter("password") );
            //Si son correctos pagina de entrada
            try {
                if (usuariosDao.ValidarUsuario()){
                    /*response.setContentType("text/html");
                    PrintWriter out = response.getWriter();
                    //Compongo el html
                    out.print("   <!DOCTYPE html>   " +
                            "<html>  " +
                            "<body> " +
                            "<p>hola te ha logeado con exito"+
                            " </p> " +
                            " </body> " +
                            " </html>");*/
                   //Quiero leer de usuariosdo mediante el método MostrarLibrosLeidos la lista de libros
                    List<LibrosLeidos> lista = null;
                    try{
                        lista = usuariosDao.MostrarLibrosLeidos();
                    } catch (SQLException e ){
                        e.printStackTrace();
                    }
                    //Preparar la salida para invocar al jsp
                    request.setAttribute("listaLibros",lista);
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/mostrarlibros.jsp");
                    requestDispatcher.forward(request,response);

                }
                else {
                    //Si no redirigimos al index
                    response.sendRedirect("/");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }
}