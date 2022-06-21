<%@page import="dto.LibrosLeidos"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collections"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="../css/miestilo.css"  rel="stylesheet" /link>
    <link href="cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <script src="cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
        crossorigin="anonymous"></script>
</head>
<body>
    <% ArrayList<LibrosLeidos> lista = (ArrayList<LibrosLeidos>) request.getAttribute("listaLibros"); %>
    <h1>LIBROS LEIDOS POR: <%=lista.get(0).getUsuario()%></h1>
    <table class="table table-striped table-hover">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Titulo</th>
                <th scope="col">Fecha_Insert</th>
                <th scope="col">Fecha_Lectura</th>
            </tr>
        </thead>

        <tbody>
            <%
            int cont = 1;
            for(LibrosLeidos libro:lista){%>
            <%-- Arranging data in tabular form
            --%>
            <tr>
                <th scope="row"><%=cont %></th>
                <td><%=libro.getBook_title() %></td>
                <td><%=libro.getFecha_insert() %></td>
                <td><%=libro.getFecha_lectura() %></td>
            </tr>
                <% cont++;} %>
            <tr>

                <td>Total de Libros: <%=cont-1 %></td>
            </tr>
        </tbody>
    </table>
</body>
</html>