<%@ page language="java"
	import="java.util.*, com.opensymphony.xwork2.ActionContext, com.autotest.entity.User;"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, 
             initial-scale=1.0, 
             maximum-scale=1.0, 
             user-scalable=no">
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
<title>添加用户 | 自动化测试系统</title>
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
		<a class="navbar-brand py-3" href="Step.jsp"> <img
			src="assets/logo.png" width="40" height="40" alt=""> 自动化测试系统
		</a>
		<div class="collapse navbar-collapse" id="addUserNavbar">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="Step.jsp">Home</a>
				</li>
				<%
					String loginName = (String) ActionContext.getContext().getSession().get("loginName");
					if (loginName != null && loginName.equals("vivo")) {
				%>
				<li class="nav-item active"><a class="nav-link"
					href="manageUserAction">管理用户</a></li>
				<%
					} else if (loginName != null && !loginName.equals("vivo")) {
				%>
				<li class="nav-item"><a class="nav-link" href="TestLaunch.jsp">发起测试</a>
				</li>
				<%
					}
					User user = (User) ActionContext.getContext().getSession().get("user");
					int id = user.getId();
				%>
				<li class="nav-item"><a class="nav-link"
					href="testResultAction">测试结果</a></li>
				<li class="nav-item"><a class="nav-link"
					href="userPasswordAction?id=<%=id%>">修改密码</a></li>
			</ul>
		</div>
		<div class="float-right">
			<a href="logoutAction" class="btn btn-outline-success" role="button">注销</a>
		</div>
	</nav>
	<form action="addUserAction" method="post"
		class="mx-auto form-horizontal pt-5 col-sm-8" role="form">
		<div class="form-group">
			<label for="userName" class="col-sm-2 offset-sm-4">用户名</label>
			<div class="col-sm-4 offset-sm-4">
				<input type="text" name="userName" class="form-control"
					placeholder="请输入用户名" required>
			</div>
		</div>
		<div class="form-group">
			<label for="userPassword" class="col-sm-2 offset-sm-4">密码</label>
			<div class="col-sm-4 offset-sm-4">
				<input type="password" name="userPassword" class="form-control"
					placeholder="请输入密码" required>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-4 offset-sm-4">
				<button type="submit" class="btn btn-outline-primary btn-block my-3">确认增加</button>
				<a href="manageUserAction"
					class="btn btn-outline-success btn-block mb-3" role="button">返回</a>
			</div>
		</div>
	</form>
	<!-- 
		<s:form action="addUserAction">
			<table>
				<tr>
					<s:textfield name="userName">用户名</s:textfield>
				</tr>
				<tr>
					<s:textfield name="userPassword">密码</s:textfield>
				</tr>
				<tr>
					<s:submit value="确认"></s:submit>
				</tr>
				<tr>
					<s:reset value="重置"></s:reset>
				</tr>
			</table>
		</s:form>
		<a href="Step.jsp">返回管理界面</a>
		 -->
</body>
</html>