<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>注册界面</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsFile/Birthday.js" ></script>

<script>
	var xmlhttp = null;
	function CreateXmlHttp() {
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		}
		if (window.ActiveXObject) {
			try {
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
				try {
					xmlhttp = new ActiveXObject("msxml2.XMLHTTP");
				} catch (ex) {
			}}}
	}
	function ajax() {
		var data = document.getElementById("username").value;
		CreateXmlHttp();
		if (!xmlhttp) {
			alert("创建xmlhttp对象异常！");
			return false;
		}
		var url = "${pageContext.request.contextPath}/servlet/CheckServlet?username=" + data;
		xmlhttp.open("POST", url, false);
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4) {
				if (xmlhttp.status == 200) {
					alert(xmlhttp.responseText);
				}
			}
		};
		xmlhttp.send();
	}
</script>

<style>
body {
	margin: 0px;
	overflow: hidden;
	font-size: 14px;
}
#main {
	margin-left: 50px;
	margin-top: 30px;
}
</style>
</head>
<body>
	<div id="header">
		<h3>
			<p>各位帅哥美人，欢迎来到美丽新世界！前方高能，请继续往下进行注册，谢谢！</p>
		</h3>
	</div>

	<div id="main">
		<div id="notic">
			<h2>注册须知</h2>
			......你们各种装逼，各种牛×，各种风骚！在下不再一一赘述！以下省略几万字......
		</div>
		<br></br>

		<form
			action="${pageContext.request.contextPath}/servlet/RegiseterServlet" method="post">
			<table id="formtable">
				<tr>
					<td class="td1">登陆账号：</td>
					<td><input id="username" class="userinput" type="text" name="username" value="${form.username}" 
					onblur="ajax()">
						<span class="message">${form.errors.username}</span></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td class="td1">密码：</td>
					<td><input class="userinput" type="password" name="password" value="${form.password}">
						<span class="message">${form.errors.password} </span></td>
				</tr>

				<tr>
					<td class="td1">确认密码:</td>
					<td><input class="userinput" type="password" name="password2" value="${form.password2}">
						<span class="message">${form.errors.password2} </span></td>
				</tr>
				<tr>
					<td class="td1">电子邮箱：</td>
					<td><input class="userinput" type="text" name="email" value="aa@sina.com" value="${from.email }">
						<span class="message">${form.errors.email} </span></td>
				</tr>
				<tr>
					<td class="td1">出生日期：</td>
					<td><input class="userinput" type="text" name="birthday"
						id="birthday" title="点击选择" onclick="new Calendar().show(this);" value="${form.birthday }">
						<span class="message">${form.errors.birthday} </span>
					</td>

				</tr>
				<tr>
					<td class="td1">昵称：</td>
					<td><input class="userinput" type="text" name="nickname" value="${form.nickname }">
						<span class="message">${form.errors.nickname} </span></td>
				</tr>
				<tr>
					<td class="td1">图片认证：</td>
					<td><input class="userinput" type="text" name="checkcode"></td>
				</tr>
			</table>
			<div id="formsubmit">
				<span><input class="btn" type="reset" name="重置" value="重置"></span>
				&nbsp;&nbsp;
				 <span><input class="btn" type="submit" name="注册" value="注册"></span>
			</div>
		</form>
	</div>
	<div id="footer"></div>
</body>
</html>