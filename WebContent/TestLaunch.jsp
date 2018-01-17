<%@ page language="java"
	import="java.util.*, com.opensymphony.xwork2.ActionContext, com.autotest.entity.User;"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- 发起测试界面 -->
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, 
             initial-scale=1.0, 
             maximum-scale=1.0, 
             user-scalable=no">
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
<title>发起测试 | 自动化测试系统</title>
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
		var fileAlert = document.getElementById("fileAlert");
		fileAlert.style.display = "none";
		with (thisform) {
			if (uploadFile.value == "") {
				fileAlert.style.display = "";
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
		<div class="collapse navbar-collapse" id="testLaunchNavbar">
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
				<li class="nav-item active"><a class="nav-link"
					href="TestLaunch.jsp">发起测试</a></li>
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
	<form action="testLaunchAction" enctype="multipart/form-data"
		onsubmit="return validate_form(this)" method="post"
		class="mx-auto form-horizontal pt-5 col-sm-8" role="form">
		<div class="form-group">
			<label for="type" class="col-sm-2 offset-sm-4">版本类型</label>
			<div class="col-sm-4 offset-sm-4">
				<input type="text" name="type" class="form-control"
					placeholder="版本类型" required>
			</div>
		</div>
		<div class="form-group">
			<label for="serialNumber" class="col-sm-2 offset-sm-4">版本号</label>
			<div class="col-sm-4 offset-sm-4">
				<input type="text" name="serialNumber" class="form-control"
					placeholder="版本号" required>
			</div>
		</div>
		<div class="form-group">
			<label for="testSource" class="col-sm-2 offset-sm-4">测试集</label>
			<div class="col-sm-4 offset-sm-4">
				<input type="text" name="testSource" class="form-control"
					placeholder="测试集" required>
			</div>
		</div>
		<div class="form-group">
			<label for="uploadFile" class="col-sm-2 offset-sm-4">上传文件</label>
			<div class="col-sm-4 offset-sm-4">
				<input type="file" id="uploadFile" name="uploadFile"
					class="form-control">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-4 offset-sm-4">
				<button type="submit" class="btn btn-outline-primary btn-block my-3">提交测试</button>
				<a href="Step.jsp" class="btn btn-outline-success btn-block mb-3"
					role="button">返回</a>
			</div>
		</div>
	</form>
	<div id="fileAlert" style="display: none"
		class="alert alert-danger col-sm-2 offset-sm-5 text-center"
		role="alert">未选择文件</div>
	<!-- 
	<div align="right">
		<a href="logoutAction">注销</a>
	</div>
	<s:form action="testLaunchAction" enctype="multipart/form-data"
		method="post">
		<s:textfield name="type" label="版本类型"></s:textfield>
		<s:textfield name="serialNumber" label="版本号"></s:textfield>
		<s:textfield name="testSource" label="测试集"></s:textfield>
		<s:file name="uploadFile" label="上传文件" />
		<s:submit value="上传"></s:submit>
		<s:reset value="重置"></s:reset>
	</s:form>
	<a href="Step.jsp">返回管理界面</a>
	 -->
</body>
</html>