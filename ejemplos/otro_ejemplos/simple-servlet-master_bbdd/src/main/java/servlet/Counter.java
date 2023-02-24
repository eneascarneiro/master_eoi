package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.swing.*;

public class Counter extends HttpServlet {
    int accesses = 0;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
         throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //Leer el parámetro acc de request
        //Convertirlo a entero
        //Implementar la logica para controlar la entrada
        //“” (si no hay valor)
        //null (si no existe).
        //El valor en caso de haber sido establecido.
        //out.print("Este es el request");
        //out.print(request);
        int entrada_acc = -2;
        if (request.getParameter("acc") == null || request.getParameter("acc") =="" )
        {
            entrada_acc = 0;
            out.print("   <!DOCTYPE html>   " +
                    "<html>  " +
                    "<body> " +
                    "<p>Number of times this servlet has been accessed: desconocido "+
                    " </p> " +
                    " </body> " +
                    " </html>");
        } else
        {
            entrada_acc = Integer.parseInt(request.getParameter("acc")) + 27;
            out.print("   <!DOCTYPE html>   " +
                    "<html>  " +
                    "<body> " +
                    "<p>Number of times this servlet has been accessed:  "  + entrada_acc   +
                    " </p> " +
                    " </body> " +
                    " </html>");
        }




    }
} 