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

            <form action="${pageContext.request.contextPath}/login?is_from_login=true" method="post">
                <div class="form-group">
                    <input type="text" class="form-control" id="username" name="username"
                           placeholder="Tên đăng nhập">
                </div>

                <div class="form-group">
                    <input type="password" class="form-control" id="password" name="password"
                           placeholder="Mật khẩu">
                </div>
                <button type="submit" class="btn btn-primary btn-login">Đăng nhập</button>
            </form>
        </div>
    </div>
</div>

<script>
    $('.btn-login').click(function () {
        let username = $("#username").val();
        let password = $("#password").val();
        API.post(`\api/auth/login?username=\${username}&password=\${password}`)
            .then(function (response) {
                console.log(response);
            }).catch(function (error) {
            console.log(error);
        })
    });
</script>
</body>
</html>