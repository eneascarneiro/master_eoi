<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Todos</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
    <body>
        <div class = "container  w-50">
            <h1 class = "text-center"> Libros leidos </h1>
        </div>
        <div class = "container  w-50 ">
            <h2 class = "text-center"> Enhorabuena <Nombre> has leido <num> libros </h2>
            <c:forEach items="${listaLibros}" var="lItem">
                <div class ="row">
                    <div class="col-sm-3">
                        <label>Usuario</label>
                        <textfield   text="${lItem.usuario}"/>
                    </div>
                    <div class="col-sm-3">
                        <label>Fecha alta</label>
                        <textfield   text="${lItem.fecha_insert}"/>
                    </div>
                    <div class="col-sm-3">
                        <label>Fecha lectura</label>
                        <textfield   text="${lItem.fecha_lectura}"/>
                    </div>
                    <div class="col-sm-3">
                        <label>Nombre libro</label>
                        <text-field   text="${lItem.book_title}"/>
                    </div>
                </c:forEach>
            </div>
        </div>

    </body>
</html>