package servlet;

import DTO.BookDetalle;
import DTO.LibrosLeidos;
import dao.BooksDao;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

public class Libros extends HttpServlet {
    int accesses = 0;
    private  List<BookDetalle> listacarrito;
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

            switch (option) {
                case "comprar":
                    try {
                        System.out.println("option1 :" + option);
                        AnadirElemAlCarrito(request, response);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "vaciar":
                    try {
                        System.out.println("option1 :" + option);
                        VaciarCarrito(request, response);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "comparlista":
                    try {
                        System.out.println("option1 :" + option);
                        ComprarCarrito(request, response);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                default:
                    System.out.println("Opcion desconocida :" + option);
            }
        }
    }
    public void VaciarCarrito(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        //LImpiar en la sesion los datos del carrito
        HttpSession session = request.getSession();
        List<DTO.BookDetalle> listaCarrito  = (List<BookDetalle>) session.getAttribute("listacarrito");
        if (listaCarrito.size() >0 )
        {
            listaCarrito.clear();
        }
        session.setAttribute("listacarrito",listaCarrito );


        //Volvemos a mostrar los libros
        BooksDao booksDao = new BooksDao();
        List<DTO.BookDetalle> lista = null;
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
    public void ComprarCarrito(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        //Añadir a la sesion el elemento compras
        HttpSession session = request.getSession();
        List<DTO.BookDetalle> listaCarrito  = (List<BookDetalle>) session.getAttribute("listacarrito");
        //LLamar al método que inserta en la tabla books_sold
        BooksDao booksDao = new BooksDao();
        booksDao.ComprarLibros(request);

        //Limpiar en la sesion los datos del carrito
        if (listaCarrito.size() >0 )
        {
            listaCarrito.clear();
        }
        session.setAttribute("listacarrito",listaCarrito );
        // Mostrar los elementos comprados
        //Mirar en la base de datos las compras
            //1 .- creare dto para booksold
            //2 .- crear en BookDao un metodo que lea books_sold y
            //     devuelva List<BooksSoldDTO>
            // 3.- añadir mi lista a listacompra
        //mostrar la lista
        session.setAttribute("listacompra",listaCarrito );
        //Volvemos a mostrar los libros
        List<DTO.BookDetalle> lista = null;
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
    public void AnadirElemAlCarrito(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        //Leer la sesion
        HttpSession session = request.getSession();
        //Existe algun carrito?? : listacarrito
        List<BookDetalle> listacarrito = new ArrayList<>();
        BooksDao booksDao = new BooksDao();
        //Buscamos en la sesion
        if  (session.getAttribute ("listacarrito") == null){
            //Creamos la lista
            //Añadimos el primer elemento
            System.out.println("Añadiendo el primer elemento");
            int id = Integer.parseInt(request.getParameter("id_libro"));
            listacarrito.add(booksDao.Detalle_libro(id));
            session.setAttribute("listacarrito",listacarrito);
            /*
                                                        <%
                                             Object table_content = session.getAttribute("strlistacarrito");
                                            %>
                                            <%= table_content %>

            String contenido_carrito = "";
            contenido_carrito += "<tr> ";
            contenido_carrito +=  "<td>" + listacarrito.get(0).getBook_id() + "</td> ";
            contenido_carrito +=  "<td>" + listacarrito.get(0).getBook_title() + "</td> ";
            contenido_carrito += "<td>" +  listacarrito.get(0).getPrecio() + "</td>";
            contenido_carrito += "</tr>";
            session.setAttribute("strlistacarrito",contenido_carrito);             */
            System.out.println(listacarrito.size());
        } else{
            //Leer la lista de la sesion
            System.out.println("leyendo lista elemento");
            listacarrito = (List<BookDetalle>) session.getAttribute ("listacarrito");
            //Añadirle el libro
            int id = Integer.parseInt(request.getParameter("id_libro"));
            listacarrito.add(booksDao.Detalle_libro(id));
            /*
            //Genero el html
            String contenido_carrito = "";
            for(int indice = 0;indice<listacarrito.size();indice++)
            {
                contenido_carrito += "<tr> ";
                contenido_carrito +=  "<td>" + listacarrito.get(indice).getBook_id() + "</td> ";
                contenido_carrito +=  "<td>" + listacarrito.get(indice).getBook_title() + "</td> ";
                contenido_carrito += "<td>" +  listacarrito.get(indice).getPrecio() + "</td>";
                contenido_carrito += "</tr>";
            }
            session.setAttribute("strlistacarrito",contenido_carrito);

             */
            System.out.println(listacarrito.size());
            //Devolver la lista ampliada a la sesion
            session.setAttribute("listacarrito",listacarrito);

        }
        //Volvemos a mostrar los libros
        List<DTO.BookDetalle> lista = null;
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
}