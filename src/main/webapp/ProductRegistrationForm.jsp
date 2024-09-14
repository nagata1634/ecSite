<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品登録</title>
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
        <form action="productregistration" method="post">
            <div>
                <label for="name">ProductName</label>
                <input type="text" name="name">
            </div>
            <div>
                <label for="extension">Extension</label>
                <input type="text" name="extension">
            </div>
            <div>
                <label for="NumberPieces">Product pieces</label>
                <input type="number" name="pieces">
            </div>
            <div>
                <label for="price">Product price</label>
                <input type="number" name="price">
            </div>
            <input type="submit">
        </form>
    </main>
    <footer>

    </footer>
</body>
</html>