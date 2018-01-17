<%@ page language="java"
	import="java.util.*, com.opensymphony.xwork2.*;"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- 用户登陆界面 -->
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, 
             initial-scale=1.0, 
             maximum-scale=1.0, 
             user-scalable=no">
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
<title>登陆 | 自动化测试系统</title>
<!-- 
	<link href="https://cdn.bootcss.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
	-->
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="jquery/3.2.1/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand py-3" href="#"> <img src="assets/logo.png"
			width="40" height="40" alt=""> 自动化测试系统
		</a>
	</nav>

	<h1 class="text-center py-5">人脸识别自动化测试系统</h1>
	<form action="userLoginAction" class="mx-auto form-horizontal col-sm-8"
		method="post" role="form">
		<div class="form-group">
			<label for="loginName" class="col-sm-2 offset-sm-4">用户名</label>
			<div class="col-sm-4 offset-sm-4">
				<input type="text" name="loginName" class="form-control"
					placeholder="请输入用户名" required>
			</div>
		</div>
		<div class="form-group">
			<label for="loginPassword" class="col-sm-2 offset-sm-4">密码</label>
			<div class="col-sm-4 offset-sm-4">
				<input type="password" name="loginPassword" class="form-control"
					placeholder="请输入密码" required>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-4 offset-sm-4 py-3">
				<button type="submit" class="btn btn-outline-primary btn-block">登录</button>
			</div>
		</div>
	</form>

	<%
		if (ActionContext.getContext().get("loginSuccess") != null) {
	%>
	<div class="col-sm-2 offset-sm-5 pb-3">
		<div class="alert alert-danger text-center" role="alert">用户名或密码错误，请重试</div>
	</div>
	<%
		}
	%>

	<!-- 
		<s:form action="userLoginAction">
			<table>
				<tr>
					<s:textfield name="loginName" label="用户名"/>
				</tr>
				<tr>
					<s:password name="loginPassword" label="密码" showPassword="true"/>
				</tr>
				<tr>
					<s:submit value="登陆"/>
				</tr>
			</table>
		</s:form>
		 -->

</body>
</html>