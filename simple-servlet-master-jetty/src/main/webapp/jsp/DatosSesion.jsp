<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*"  session ="true" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Lectores</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

  <link href="/resources/css/main.css"   rel="stylesheet"  type="text/css" />
 <link href="<c:url value="/css/custom.css" />"         rel="stylesheet"  type="text/css" />
  <link href="<c:url value="/css/normalize.css" />"         rel="stylesheet"  type="text/css" />
   <link href="<c:url value="/css/skeleton.css" />"         rel="stylesheet"  type="text/css" />
</head>


<body>
      <div id="wrap">
            <div id="wra1p" >
                 <c:import url="/WEB-INF/views/tags/navbar.jsp"/>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-md-2">
                      <div class="well sidebar-nav">
                        <c:import url="/WEB-INF/views/tags/menu.jsp"/>
                      </div>
                    </div>
                    <div class="col-md-10">
                        <div class = "container  w-50">
                            <h1 class = "text-center"> Los datos de la sesion son: </h1>
                              <br/>
                               Session attributes:
                               <%
                               for (Enumeration e = session.getAttributeNames(); e.hasMoreElements(); )
                               {
                                    String attribName = (String) e.nextElement();
                                    Object attribValue = session.getAttribute(attribName);

                               %>
                                   <BR><%= attribName %> - <%= attribValue %>
                               <%
                               }
                               %>

                        </div>


                    </div><!--/col-->
                </div><!--/row-->
            </div>
      </div>
  <c:import url="/WEB-INF/views/tags/footer.jsp"/>

  <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/demo.js" />"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/json2.js" />"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/date.format.js" />"></script>
</body>

</html>

