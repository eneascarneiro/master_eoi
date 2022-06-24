<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.*" import= "DTO.BookDetalle" session ="true" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary"  >
    <div class="container expand-lg">
        <div class="col-md-2">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">Lectores empedernidos</a>
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
        </div>
        <div class="col-md-10">
            <div class="container">
                <div class="col-md-8">
                    <div class="collapse navbar-collapse">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <div class="menu">
                                <li class="nav-item"><a href="<c:url value="/" />" class="nav-link active" >Home</a></li>
                                <li class="nav-item"><a href="<c:url value="/loginfrm"  />" class="nav-link" >Login</a></li>
                                <li class="nav-item"><a href="<c:url value="/login?opt=out" />" class="nav-link" >Logout</a></li>
                                <li class="nav-item"><a href="<c:url value="/librosleidos" />" class="nav-link" >Libros leidos</a></li>
                                <li class="nav-item"><a href="<c:url value="/libros" />" class="nav-link" >Venta de libros</a></li>
                            </div>
                        </ul>
                    </div>
                </diV>
                <div class="col-md-2">
                    <div class = "container">
                        <ul>
                            <li class="submenu">
                                <img src="img/cart.png" id="img-carrito">
                                <div id="carrito">

                                    <table id="lista-carrito" class="u-full-width">
                                        <thead>
                                            <tr>
                                                <th>Id</th>
                                                <th>Nombre</th>
                                                <th>Precio</th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <%

                                             Object table_content = session.getAttribute("strlistacarrito");

                                                       %>
                                                            <%= table_content %>


                                        </tbody>
                                    </table>

                                    <a href="#" id="vaciar-carrito" class="button u-full-width">Vaciar Carrito</a>
                                    <a href="#" id="comprar-carrito" class="button u-full-width">Comprar</a>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div class = "container">
                        <ul>
                            <li class="submenu">
                                <img src="img/bolsa.png" width="30" id="img-bolsa">
                                <div id="compra">
                                    <table id="lista-compra" class="u-full-width">
                                        <thead>
                                            <tr>
                                                <th>Id</th>
                                                <th>Nombre</th>
                                                <th>Precio</th>
                                            </tr>
                                        </thead>
                                        <tbody></tbody>
                                    </table>
                                </div>
                            </li>
                        </ul>
                   </div>
                </div>
            </div>
        </div>
    </div>
</nav>


