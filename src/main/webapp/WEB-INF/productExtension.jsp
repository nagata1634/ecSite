<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Extension</title>
<link href="styles/style.css" rel="stylesheet" />
</head>
<body>
  <header>
      <ul>
      <li>
        <a href="product">Top</a>
      </li>
      <li>
        <a href="login">Login</a>
      </li>
      <li>
        <a href="cart">Cart</a>
      </li>
      <li>
        <a href="userregistration">registration</a>
      </li>
      <c:if test="${ not empty sessionScope.user }">
        <a href="cart">Cart</a>
        <a>
          <c:out value="${ user.name }"/>
        </a>
      </c:if>
    </ul>
  </header>
  <main>
     <div class="item">
        <img
          srr="<c:out value="${ product.imagePath }"/>"
          alt="<c:out value="${ product.name }"/>の写真"
        />
        <p>
          <c:out value="${ product.name }"/>
        </p>
        <p>
          <c:out value="${ product.price }"/>
        </p>
        <p>
          <c:out value="${ product.extension }" />
        </p>
      </div>

 
  </main>
  <footer>
  </footer>
</body>
</html>