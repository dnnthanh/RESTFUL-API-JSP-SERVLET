<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<title><dec:title default="Trang chủ" /></title>
<!-- css -->
<link
	href="${pageContext.request.contextPath}/template/web/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" media="all" />

<link
	href="${pageContext.request.contextPath}/template/web/css/style.css"
	rel="stylesheet" type="text/css" media="all" />
<script src="${pageContext.request.contextPath}/template//axios/axios.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/common/configAPI/config.js"
	type="text/javascript"></script>

</head>
<body>
	<!-- header -->
	<%@ include file="/common/web/header.jsp"%>

	<!-- body -->
	<div class="container">
		<dec:body />
	</div>

	<!-- footer -->
	<%@ include file="/common/web/footer.jsp"%>

	<!-- JS -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/template/web/jquery/jquery.min.js"></script>

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/template/web/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>
</html>