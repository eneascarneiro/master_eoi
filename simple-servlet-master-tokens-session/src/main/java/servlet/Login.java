package servlet;

import DTO.LibrosLeidos;
import dao.UsuariosDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import javax.naming.NamingException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.ExecutionException;

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
                        /*response.setContentType("text/html");
                        PrintWriter out = response.getWriter();
                        //Compongo el html
                        out.print("  <!DOCTYPE html> " +
                                "<html lang='en'> " +
                                "<head> " +
                                "    <meta charset='UTF-8'> " +
                                "    <meta http-equiv='X-UA-Compatible' content='IE=edge'> " +
                                "    <meta name='viewport' content='width=device-width, initial-scale=1.0'> " +
                                "    <title>Document</title> " +
                                "    <link href='cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css' rel='stylesheet' " +
                                "        integrity='sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor' crossorigin='anonymous'> " +
                                "    <script src='cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js' " +
                                "        integrity='sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2' " +
                                "        crossorigin='anonymous'></script> " +
                                "</head> " +
                                "<body> " +
                                "    <h1>LIBROS LEIDOS POR: </h1> " +
                                "    <table class='table table-striped table-hover'> " +
                                "        <thead> " +
                                "            <tr> " +
                                "                <th scope='col'>#</th> " +
                                "                <th scope='col'>Titulo</th> " +
                                "                <th scope='col'>Fecha_Insert</th> " +
                                "                <th scope='col'>Fecha_Lectura</th> " +
                                "            </tr> " +
                                "        </thead> <tbody> ");
                        for (int i = 0; i < lista.size(); i++) {
                            String fila = "<tr>n" +
                                    "                <th scope=\"row\"></th>" +
                                    "                <td> " + lista.get(i).getBook_title()   + "</td>" +
                                    "                <td> " + lista.get(i).getFecha_insert()   + "</td>" +
                                    "                <td> " + lista.get(i).getFecha_lectura()  + "</td>" +
                                    "            </tr> ";
                            out.print(fila);
                        }
                        out.print(" </tbody>" +
                                "    </table>" +
                                "</body>" +
                                "</html>");*/
                    } catch (SQLException e ){
                        e.printStackTrace();
                    } catch (NamingException e) {
                        throw new RuntimeException(e);
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
            } catch (NamingException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}