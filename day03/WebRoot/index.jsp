<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>首页</title>
</head>
<body style="text-align:center;">
<h1>流星花园第一站</h1>
<br/>
	<div style="text-align:center;">
	<c:if test="${user != null }">
		欢迎您： ${user.nickname } <br><br> <a  href="${pageContext.request.contextPath }/servlet/LogoutServlet">注销</a>
	</c:if>
	
	<c:if test="${user == null }">
	<a style="color:red;" href="${pageContext.request.contextPath}/servlet/RegisterUIServlet">用户注册</a>
	&nbsp;&nbsp;
	<a style="color:red;" href="${pageContext.request.contextPath}/servlet/loginUIServlet">用户登陆</a>
	</c:if>
	</div>
	<hr>
</body>
</html>
