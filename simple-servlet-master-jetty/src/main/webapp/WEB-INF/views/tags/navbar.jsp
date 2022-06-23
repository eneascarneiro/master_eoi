<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary" th:fragment="barranavegacion" >
    <div class="container fluid">
      <div class="logo">
        <img th:src="@{/img/eoilogo.png}">
      </div>
      <div class="navbar-header">
        <a class="navbar-brand" href="#">Lectores empedernidos</a>
      </div>
      <div class="collapse navbar-collapse">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <div class="menu">

              <li class="nav-item"><a href="<c:url value="/" />" class="nav-link active" >Home</a></li>
              <li class="nav-item"><a href="<c:url value="/loginfrm"  />" class="nav-link" >Login</a></li>
              <li class="nav-item"><a href="<c:url value="/login?opt=out" />" class="nav-link" >Logout</a></li>
              <li class="nav-item"><a href="<c:url value="/librosleidos" />" class="nav-link" >Libros leidos</a></li>

          </div>
        </ul>
      </div>
    </div>
  </nav>


