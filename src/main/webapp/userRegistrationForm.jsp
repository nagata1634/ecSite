<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録</title>
<link href="styles/style.css" rel="stylesheet" />
</head>
<body>
    <header>
        <ul>
      <li>
        <a href="/<c:out value="${ request.getContextPath() }" />/product">Top</a>
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
        <form action="/ecSite/userregistration" method="POST">
            <div>
                <label for="name">ユーザー名</label>
                <input type="text" name="name" id="name" required>
            </div>
            <div>
                <label for="password">パスワード</label>
                <input type="password" name="password" id="password" required>
            </div>
            <div>
                <label>管理者権限:</label>
                <div>
                    <input type="radio" name="isAdmin" value="true" id="isAdminTrue" required>
                    <label for="isAdminTrue">はい</label>
                </div>
                <div>
                    <input type="radio" name="isAdmin" value="false" id="isAdminFalse" required>
                    <label for="isAdminFalse">いいえ</label>
                </div>
            </div>
            <input type="submit" value="登録">
        </form>

        <div class="errer">
          <c:if test="${ empty errer }">
            <p>
              正常に登録することが出来ませんでした。
            </p>
          </c:if>
        </div>
    </main>
    <footer>

    </footer>
</body>
</html>
