<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<div class="container">
    <div class="login-form">
        <div class="main-div">
            <c:if test="{not empty message}">
                <div class="alert alert-${alert}" role="alert">
                        ${message}
                </div>
            </c:if>

            <form id="formLogin" method="post" action="${pageContext.request.contextPath}/login">
                <div class="form-group">
                    <input type="text" class="form-control" id="username"
                           name="username" placeholder="Tên đăng nhập">
                </div>

                <div class="form-group">
                    <input type="password" class="form-control" id="password"
                           name="password" placeholder="Mật khẩu">
                </div>
                <input type="hidden" name="is_from_login" value="true">
                <button type="submit" class="btn btn-primary">Đăng nhập</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>