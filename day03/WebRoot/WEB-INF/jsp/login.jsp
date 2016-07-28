<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>登陆页面</title>
</head>
<body>
	<p>欢迎您使用本系统
	<div id="from">
		<form action="${pageContext.request.contextPath }/servlet/LoginServlet" method="post">
			<div class="input">
				用户：<input class="inputtext" type="text" name="username" />
			</div>
			<div class="input">
				密码：<input class="inputtext" type="password" name="password" />
			</div>
			<div id="btn">
			<!-- 以下onclick中的地址为什么不能是WEB-INF下面的jsp页面呢？因为该目录下的jsp不允许用户直接访问
			而只能通过servlet来访问，故只要调用它的servlet即可！ -->
				<input class="btn" type="button" value="注册" 
					onclick="window.location.href='RegisterUIServlet'" /> 
					<input class="btn" type="submit" value="登陆" />
			</div>
		</form>

	</div>
</body>
</html>
