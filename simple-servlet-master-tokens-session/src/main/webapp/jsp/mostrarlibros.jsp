<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Lectores</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
        rel="stylesheet"  type="text/css" />
    <link href="<c:url value="/resources/css/main.css" />"
        rel="stylesheet"  type="text/css" />

</head>


<body>
    <div id="wrap">

        <c:import url="/WEB-INF/views/tags/navbar.jsp"/>

        <div class="container">
            <div class="row">
                <div class="col-md-2">
                  <div class="well sidebar-nav">
                    <c:import url="/WEB-INF/views/tags/menu.jsp"/>
                  </div>
                </div>

                <div class="col-md-10">
                    <div class = "container  w-50">
                                <h1 class = "text-center"> Libros leidos </h1>
                            </div>
                            <div class = "container  w-50 ">
                                <h2 class = "text-center"> Enhorabuena <Nombre> has leido <num> libros </h2>
                                <c:forEach items="${listaLibros}" var="lItem">
                                    <div class ="col-sm-3">
                                        <label>Usuario: </label>
                                        <c:out value="${lItem.usuario}"/>
                                    </div>
                                    <div class ="col-sm-3">
                                        <label>Fecha alta: </label>
                                        <c:out value="${lItem.fecha_insert}"/>
                                    </div>
                                    <div class ="col-sm-3">
                                        <label>Fecha lectura: </label>
                                        <c:out value="${lItem.fecha_lectura}"/>
                                    </div>
                                    <div class ="col-sm-3">
                                        <label>Nombre libro: </label>
                                        <c:out value="${lItem.book_title}"/>
                                    </div>
                                </c:forEach>
                            </div>
            </div><!--/col-->
          </div><!--/row-->

          <hr class="soften">
    </div>

    <c:import url="/WEB-INF/views/tags/footer.jsp"/>

	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/demo.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/json2.js" />"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/date.format.js" />"></script>
</body>

</html>