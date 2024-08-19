<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Errer</title>
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
  </main>
  <footer>
  </footer>
</body>
</html>