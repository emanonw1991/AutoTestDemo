<%@ page language="java"
	import="java.util.*, com.autotest.entity.*, com.opensymphony.xwork2.ActionContext;"
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
<title>修改密码 | 自动化测试系统</title>
<!-- 
	<link href="https://cdn.bootcss.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
	-->
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="jquery/3.2.1/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	function validate_form(thisform) {
		var matchAlert = document.getElementById("matchAlert");
		var sameAlert = document.getElementById("sameAlert");
		matchAlert.style.display = "none";
		sameAlert.style.display = "none";
		with (thisform) {
			if (newPassword.value != confirmPassword.value) {
				confirmPassword.focus();
				matchAlert.style.display = "";
				return false
			} else if (newPassword.value == oldPassword.value) {
				confirmPassword.focus();
				sameAlert.style.display = "";
				return false
			}
		}
	}
</script>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand py-3" href="Step.jsp"> <img
			src="assets/logo.png" width="40" height="40" alt=""> 自动化测试系统
		</a>
		<div class="collapse navbar-collapse" id="managePasswordNavbar">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="Step.jsp">Home</a>
				</li>
				<%
					String loginName = (String) ActionContext.getContext().getSession().get("loginName");
					if (loginName != null && loginName.equals("vivo")) {
				%>
				<li class="nav-item"><a class="nav-link"
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
				<li class="nav-item active"><a class="nav-link"
					href="userPasswordAction?id=<%=id%>">修改密码</a></li>
			</ul>
		</div>
		<div class="float-right">
			<a href="logoutAction" class="btn btn-outline-success" role="button">注销</a>
		</div>
	</nav>
	<%
		String userName = (String) ActionContext.getContext().get("loginName");
		if (userName != null && !userName.equals(loginName)) {
	%>
	<div class="alert alert-primary text-center" role="alert">
		当前用户名：
		<s:property value="loginName" />
		当前密码：
		<s:property value="loginPassword" />
	</div>
	<%
		} else {
	%>
	<div class="alert alert-info col-sm-2 offset-sm-5 text-center mt-3"
		role="alert">提示：修改密码后需要重新登录</div>
	<%
		}
	%>
	<form action="managePasswordAction"
		onsubmit="return validate_form(this)" method="post"
		class="mx-auto form-horizontal col-sm-8" role="form">
		<%
			if (userName != null && userName.equals(loginName)) {
		%>
		<div class="form-group">
			<label for="oldPassword" class="col-sm-2 offset-sm-4">请输入旧密码</label>
			<div class="col-sm-4 offset-sm-4">
				<input id="oldPassword" type="text" name="oldPassword"
					class="form-control" placeholder="旧密码" required>
			</div>
		</div>
		<%
			} else {
		%>
		<div class="form-group">
			<input id="oldPassword" type="hidden" value="<%=request.getAttribute("loginPassword")%>">
		</div>
		<%
			}
		%>
		<div class="form-group">
			<label for="newPassword" class="col-sm-2 offset-sm-4">请输入新密码</label>
			<div class="col-sm-4 offset-sm-4">
				<input id="newPassword" type="password" name="newPassword"
					class="form-control" placeholder="新密码" required>
			</div>
		</div>
		<div class="form-group">
			<label for="confirmPassword" class="col-sm-2 offset-sm-4">请再次输入新密码</label>
			<div class="col-sm-4 offset-sm-4">
				<input id="confirmPassword" type="password" name="confirmPassword"
					class="form-control" placeholder="再次输入新密码" required>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-4 offset-sm-4">
				<button type="submit" class="btn btn-outline-success btn-block my-3">修改</button>
				<a href="Step.jsp" class="btn btn-outline-primary btn-block mb-3"
					role="button">返回</a>
			</div>
		</div>
	</form>
	<div id="matchAlert" style="display: none"
		class="alert alert-danger col-sm-2 offset-sm-5 text-center"
		role="alert">两次输入的密码不一致</div>
	<div id="sameAlert" style="display: none"
		class="alert alert-danger col-sm-2 offset-sm-5 text-center"
		role="alert">新密码与原密码相同</div>

	<!-- 
	<s:fielderror></s:fielderror>
	<s:form action="managePasswordAction">
		<table>
			<tr>
				当前用户名：
				<s:property value="loginName" />
			</tr>
			<tr>
				当前密码：
				<s:property value="loginPassword" />
			</tr>
			<tr>
				<s:textfield name="newPassword" label="请输入新密码" />
			</tr>
			<tr>
				<s:textfield name="confirmPassword" label="请确认新密码" />
			</tr>
			<tr>
				<s:submit id="submit" value="提交"></s:submit>
			</tr>
			<tr>
				<s:reset id="reset" value="重置"></s:reset>
			</tr>
		</table>
	</s:form>
	<a href="Step.jsp">返回管理界面</a>
	 -->

</body>
</html>