<%@ page language="java"
	import="java.util.*, com.autotest.entity.*, com.opensymphony.xwork2.ActionContext, com.autotest.entity.User;"
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
<title>管理用户 | 自动化测试系统</title>
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
		<div class="collapse navbar-collapse" id="manageUserNavbar">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item">
					<a class="nav-link" href="Step.jsp">Home</a>
				</li>
				<%
					String loginName = (String) ActionContext.getContext().getSession().get("loginName");
					if (loginName != null && loginName.equals("vivo")) {
				%>
				<li class="nav-item active">
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
	<div class="mx-auto col-sm-6 mt-5">
		<table class="table table-hover table-striped">
			<thead>
				<tr>
					<th scope="col" class="text-center">Id</th>
					<th scope="col" class="text-center">用户名</th>
					<th scope="col" class="text-center">密码</th>
					<th scope="col" class="text-center">管理用户</th>
					<th scope="col" class="text-center">删除用户</th>
			</thead>
			<tbody>
				<%
					List<User> userList = (List<User>) ActionContext.getContext().get("userList");
					for (User u : userList) {
				%>
				<tr>
					<th scope="row" class="text-center"><%=u.getId()%></th>
					<td class="text-center"><%=u.getLoginName()%></td>
					<td class="text-center"><%=u.getLoginPassword()%></td>
					<td class="text-center">
						<a href="userPasswordAction?id=<%=u.getId()%>" class="btn btn-outline-success" role="button">修改密码</a>
					</td>
					<td class="text-center">
						<%
							if (!u.getLoginName().equals("vivo")) {
						%> 
							<a href="deleteUserAction?id=<%=u.getId()%>" class="btn btn-outline-success" role="button" onClick="return confirm('确认删除？');">删除用户</a>
						<%
 							}
 						%>
					</td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
	<div class="col-sm-2 offset-sm-5 mt-5">
		<a href="AddUser.jsp" class="btn btn-outline-success btn-block" role="button">增加用户</a>
		<a href="Step.jsp" class="btn btn-outline-primary btn-block my-3" role="button">返回</a>
	</div>
	
	<!-- 
		<div align="right">
			<a href="logoutAction">注销</a>
		</div>
		<table border="1">
			<tr>
				<th>Id</th>
				<th>LoginName</th>
				<th>LoginPassword</th>
				<th>ManagePassword</th>
				<th>DeleteUser</th>
			</tr>
			<%//List<User> userList = (List<User>) ActionContext.getContext().get("userList");
			//for (User user : userList) {%>
			<tr>
				<td><%//=user.getId()%></td>
				<td><%//=user.getLoginName()%></td>
				<td><%//=user.getLoginPassword()%></td>
				<td><a href="userPasswordAction?id=<%//=user.getId()%>">管理用户</a></td>
				<td>
				<%//if (!user.getLoginName().equals("vivo")) {%>
					<a href="deleteUserAction?id=<%//=user.getId()%>" 
					onClick="return confirm('确认删除？');">删除用户</a>
				<%//}%>
				</td>
			</tr>
			<%//}%>
		</table>
		<a href="AddUser.jsp">增加用户</a>
		<a href="Step.jsp">返回管理界面</a>
	 -->

</body>
</html>