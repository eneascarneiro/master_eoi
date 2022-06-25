<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary"  >
    <div class="container expand-lg">
        <div class="col-md-2">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">Lectores empedernidos</a>



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
                                                <th>Eliminar</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:set var="listItem" scope="session" value="${listacarrito}"/>
                                            <c:forEach items="${listItem}" var="item">
                                            <tr>
                                                <th><c:out value="${item.book_id}" /></th>
                                                <th><c:out value="${item.book_title}" /></th>
                                                <th><c:out value="${item.precio}" /></th>
                                                <th><a href="#" >Eliminar elemento</a>   </th>
                                            </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>

                                    <a href="/libros?opt=vaciar" id="vaciar-carrito" class="button u-full-width">Vaciar Carrito</a>
                                    <a href="/libros?opt=comparlista" id="comprar-carrito" class="button u-full-width">Comprar</a>
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
                                        <tbody>
                                                <c:set var="listItem" scope="session" value="${listacompra}"/>
                                                <c:forEach items="${listItem}" var="item">
                                                <tr>
                                                <th><c:out value="${item.book_id}" /><th>
                                                <th><c:out value="${item.book_title}" /><th>
                                                <th><c:out value="${item.precio}" /><th>
                                                </tr>
                                                </c:forEach>
                                        </tbody>
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


