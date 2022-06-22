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
  <link href="/resources/css/main.css"   rel="stylesheet"  type="text/css" />

</head>


<body>
<div id="wra1p" class="row">
        <c:import url="/WEB-INF/views/tags/navbar.jsp"/>
        </div>
<div id="wrap" class="row">





            <p>Now try the  <a href="count?acc=7&suma=55">servlet.Counter servlet</a></p>
            <p>Now try bad  <a href="count?accc=7&suma=55">servlet.Counter servlet</a></p>
            <p>Here is a <a href="jspcount"> simple JSP (Java Servlet Page)</a></p>
            <form action="login" method="get">
              <div class="imgcontainer">
                <img src="img_avatar2.png" alt="Avatar" class="avatar">
              </div>

              <div class="container">
                <label ><b>Username</b></label>
                <input type="text" placeholder="Enter Username" name="user" id="user" required>

                <label ><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="password" id="password" required>

                <button type="submit">Login</button>
                <label>
                  <input type="checkbox" checked="checked" name="remember"> Remember me
                </label>
              </div>
            </form>



      </div>

  <c:import url="/WEB-INF/views/tags/footer.jsp"/>

  <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/demo.js" />"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/json2.js" />"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/date.format.js" />"></script>
</body>

</html>

