<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ProductList</title>
<link href="styles/style.css" rel="stylesheet" />
</head>
<body>
  <header>

  <c:out value="${ request.getContextPath() }" />

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
<!--    <div class="items">-->
<!--      <div class="item">-->
<!--        <img-->
<!--          src="image/image1.png"-->
<!--          alt="image1.jpgの写真"-->
<!--        />-->
<!--        <p>商品名</p>-->
<!--        <p>値段</p>-->
<!--        <form action="product" method="get">-->
<!--          <input type="hidden" name="id" value="1" />-->
<!--          <input type="submit" value="商品の説明を見る" />-->
<!--        </form>-->
<!--      <form action="cart" method="POST">-->
<!--      <input type="hidden" name="id" value="1" />-->
<!--        <input type="hidden" name="userId" value="2" />-->
<!--      <input type="submit" value="カートに入れる" />-->
<!--      </form>-->
<!--      </div>-->

<!--        <div class="item">-->
<!--        <img-->
<!--          src="image/image1.png"-->
<!--          alt="image1.jpgの写真"-->
<!--        />-->
<!--        <p>商品名</p>-->
<!--        <p>値段</p>-->
<!--        <form action="product" method="get">-->
<!--          <input type="hidden" name="id" value="1" />-->
<!--          <input type="submit" value="商品の説明を見る" />-->
<!--        </form>-->
<!--      <form action="cart" method="POST">-->
<!--      <input type="hidden" name="id" value="1" />-->
<!--        <input type="hidden" name="userId" value="2" />-->
<!--      <input type="submit" value="カートに入れる" />-->
<!--      </form>-->
<!--      </div>-->

<!--            <div class="item">-->
<!--        <img-->
<!--          src="image/image1.png"-->
<!--          alt="image1.jpgの写真"-->
<!--        />-->
<!--        <p>商品名</p>-->
<!--        <p>値段</p>-->
<!--        <form action="product" method="get">-->
<!--          <input type="hidden" name="id" value="1" />-->
<!--          <input type="submit" value="商品の説明を見る" />-->
<!--        </form>-->
<!--      <form action="cart" method="POST">-->
<!--      <input type="hidden" name="id" value="1" />-->
<!--        <input type="hidden" name="userId" value="2" />-->
<!--      <input type="submit" value="カートに入れる" />-->
<!--      </form>-->
<!--      </div>-->
<!--    </div>-->

  <div class="items">
    <c:forEach var="product" items="${ products }">
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
        <form action="productextension" method="GET">
          <input type="hidden" name="productId" value="<c:out value="${ product.id }"/>" />
          <input type="submit" value="商品の説明を見る" />
        </form>
        <form action="cart" method="POST">
          <input type="hidden" name="productId" value="<c:out value="${ product.id }"/>" />
          <input type="hidden" name="userId" value="<c:out value="${ user.id }" />" />
          <input type="submit" value="カートに入れる" />
        </form>
      </div>
    </c:forEach>
   </div>
<!-- ページ遷移 -->
   <div>
    <form action="product" method="GET">
      <input type="hidden" name="page" value="<c:out value="${ page.page - 1 }" />" />
      <input type="submit" value="戻る" />
    </form>
    <p>
      <c:out value="${ page.page }" />
    </p>
    <form action="product" method="GET">
      <input type="hidden" name="page" value="<c:out value="${ page.page + 1 }" />" />
      <input type="submit" value="進む">
    </form>
   </div>
  </main>
  <footer>
  </footer>
</body>
</html>