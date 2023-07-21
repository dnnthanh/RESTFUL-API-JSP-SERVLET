<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/home-page"
        >Trang chủ</a
        >
        <button
                class="navbar-toggler"
                type="button"
                data-toggle="collapse"
                data-target="#navbarResponsive"
                aria-controls="navbarResponsive"
                aria-expanded="false"
                aria-label="Toggle navigation"
        >
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <c:if test="${not empty USERMODEL}">
                    <div class="dropdown">
                        <button
                                class="btn btn-primary dropdown-toggle"
                                type="button"
                                id="dropdownMenuButton"
                                data-toggle="dropdown"
                                aria-haspopup="true"
                                aria-expanded="false"
                        >
                            Xin chào: ${USERMODEL.fullName}
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <a class="dropdown-item" href="#">Thông tin cá nhân</a>
                            <a class="dropdown-item" href="#">Đổi mật khẩu</a>
                            <a
                                    class="dropdown-item"
                                    href="${pageContext.request.contextPath}/logout"
                            >Thoát<span class="sr-only"></span>
                            </a>
                        </div>
                    </div>
                </c:if>

                <c:if test="${empty USERMODEL}">
                    <li class="nav-item">
                        <a
                                class="nav-link"
                                href="${pageContext.request.contextPath}/login?is_from_login=true"
                        >Đăng nhập<span class="sr-only"></span>
                        </a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="#"
                        >Đăng ký<span class="sr-only"></span>
                        </a>
                    </li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>
