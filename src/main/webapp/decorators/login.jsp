<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/common/taglib.jsp" %>
<html>
<head>
    <title><dec:title default="Login"/></title>
    <link
            href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
            rel="stylesheet" id="bootstrap-css">
    <script
            src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script
            src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link href="${pageContext.request.contextPath}/template/login/style.css"
          rel="stylesheet" type="text/css" media="all"/>

    <script src="${pageContext.request.contextPath}/template//axios/axios.js"
            type="text/javascript"></script>
    <script
            src="${pageContext.request.contextPath}/common/configAPI/config.js"
            type="text/javascript"></script>

</head>
<body id="LoginForm">
<dec:body/>
</body>
</html>