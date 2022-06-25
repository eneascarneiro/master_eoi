<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">
<ul class="nav nav-list">
  <li class="nav-header">Reference</li>
  <li class="nav-item"><a href="https://www.rae.es/" target="_blank">Rae</a></li>
  <li class="nav-item"><a href="https://es.wikipedia.org/wiki/Don_Quijote_de_la_Mancha" target="_blank">Don_Quijote_de_la_Mancha</a></li>
  <li class="nav-item"><a href="https://www.casadellibro.com/libros-mas-vendidos" target="_blank">Libros mas leidos</a></li>
  <li class="nav-item"><a href="<c:url value="/librosleidos" />" class="nav-link" >Libros leidos</a></li>
  <li class="nav-item"><a href="<c:url value="/libros" />" class="nav-link" >Venta de libros</a></li>
  <li class="nav-item"><a href="<c:url value="/sesion" />" class="nav-link" >Datos de sesión</a></li>
  <li class="nav-item"><a href="<c:url value="/cookies" />" class="nav-link" >Datos de cookies</a></li>
</ul>
</div>