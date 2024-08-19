<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<link href="styles/style.css" rel="stylesheet" />
</head>
<body>
    <footer>
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
    </footer>
    <main>
        <form action="/ecSite/login" method="post">
            <div>
                <label for="userName">UserName</label>
                <input type="text" name="userName">
            </div>
            <div>
                <label for="password">Password</label>
                <input type="password" name="password">
            </div>
            <input type="submit">
        </form>
    </main>
    <footer>

    </footer>
</body>
</html>