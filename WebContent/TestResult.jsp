<%@ page language="java"
	import="java.util.*, com.autotest.entity.*, com.opensymphony.xwork2.ActionContext"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- 查看测试结果界面 -->
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, 
             initial-scale=1.0, 
             maximum-scale=1.0, 
             user-scalable=no">
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
<title>测试结果 | 自动化测试系统</title>
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
		<div class="collapse navbar-collapse" id="testResultNavbar">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item">
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
				<li class="nav-item active">
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
	<div class="mx-auto col-sm-8 mt-5">
		<table class="table table-hover table-striped">
			<thead>
				<tr>
					<th scope="col" class="text-center">Id</th>
					<%
						if (loginName != null && loginName.equals("vivo")) {
					%>
					<th scope="col" class="text-center">厂商</th>
					<%
						}
					%>
					<th scope="col" class="text-center">版本号</th>
					<th scope="col" class="text-center">版本类型</th>
					<th scope="col" class="text-center">版本号</th>
					<th scope="col" class="text-center">测试状态</th>
					<th scope="col" class="text-center">结果下载</th>
					<th scope="col" class="text-center">测试集</th>
			</thead>
			<tbody>
				<%
					List<Test> testResult = (List<Test>) ActionContext.getContext().get("testResult");
					for (Test test : testResult) {
						String fileName = test.getId() + ".json";
				%>
				<tr>
					<th scope="row" class="text-center"><%=test.getId()%></th>
					<%
						if (loginName != null && loginName.equals("vivo")) {
					%>
					<th scope="col" class="text-center"><%=test.getLoginName() %></th>
					<%
						}
					%>
					<td class="text-center"><%=test.getVersionId()%></td>
					<td class="text-center"><%=test.getType()%></td>
					<td class="text-center"><%=test.getSerialNumber()%></td>
					<td class="text-center"><%=test.getState()%></td>
					<td class="text-center"><a
						href="fileDownloadAction?downloadFileFileName=<%=fileName%>"
						class="btn btn-outline-success" role="button">结果下载</a></td>
					<td class="text-center"><%=test.getTestSource()%></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
	<div class="col-sm-2 offset-sm-5 my-5">
		<a href="Step.jsp" class="btn btn-outline-primary btn-block" role="button">返回</a>
	</div>

	<!-- 
		<div align="right">
			<a href="logoutAction">注销</a>
		</div>
		<table border="1">
			<tr>
				<th>Id</th>
				<th>VersionId</th>
				<th>Type</th>
				<th>SerialNumber</th>
				<th>State</th>
				<th>Download</th>
				<th>TestSource</th>
			</tr>
			<%/*
				List<Test> testResult = (List<Test>) ActionContext.getContext().get("testResult");
				for (Test test : testResult) {
					String fileName = test.getId() + ".json";
			*/%>
			<tr>
				<td><%//=test.getId()%></td>
				<td><%//=test.getVersionId()%></td>
				<td><%//=test.getType()%></td>
				<td><%//=test.getSerialNumber()%></td>
				<td><%//=test.getState()%></td>
				<td><a href="fileDownloadAction?downloadFileFileName=<%//=fileName%>">结果下载</a></td>
				<td><%//=test.getTestSource()%></td>
			</tr>
			<%//}%>
		</table>
		<a href="Step.jsp">返回管理界面</a>
	-->
</body>
</html>