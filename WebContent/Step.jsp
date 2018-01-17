<%@ page language="java"
	import="java.util.*, com.autotest.entity.*, com.opensymphony.xwork2.ActionContext;"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- 登陆后管理界面 -->
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, 
             initial-scale=1.0, 
             maximum-scale=1.0, 
             user-scalable=no">
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
<title>Home | 自动化测试系统</title>
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
		<div class="collapse navbar-collapse" id="stepNavbar">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active">
					<a class="nav-link" href="Step.jsp">Home</a>
				</li>
				<%
					String loginName = (String) ActionContext.getContext().getSession().get("loginName");
					if (loginName != null && loginName.equals("vivo")) {
				%>
				<li class="nav-item">
					<a class="nav-link" href="manageUserAction">管理用户</a>
				</li>
				<%
					} else if (loginName != null && !loginName.equals("vivo")) {
				%>
				<li class="nav-item">
					<a class="nav-link" href="TestLaunch.jsp">发起测试</a>
				</li>
				<%
					}
					User user = (User) ActionContext.getContext().getSession().get("user");
					int id = user.getId();
				%>
				<li class="nav-item">
					<a class="nav-link" href="testResultAction">测试结果</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="userPasswordAction?id=<%=id%>">修改密码</a>
				</li>
			</ul>
		</div>
		<div class="float-right">
			<a href="logoutAction" class="btn btn-outline-success" role="button">注销</a>
		</div>
	</nav>

	<!-- 
		<div align="right">
			<a href="logoutAction">注销</a>
		</div>
		<%//String loginName = (String) ActionContext.getContext().getSession().get("loginName");
			//if (loginName != null && loginName.equals("vivo")) {%>
			<a href="manageUserAction">管理用户</a>
		<%//} else if (loginName != null && !loginName.equals("vivo")) {%>
			<a href="TestLaunch.jsp">发起测试</a>
		<%//}
			//User user = (User) ActionContext.getContext().getSession().get("user");
			//int id = user.getId();%>
		<a href="testResultAction">测试结果</a>
		<a href="userPasswordAction?id=<%=id%>">修改密码</a>
		 -->
</body>
</html>