<%@ page language="java" import="java.util.*, com.autotest.entity.*, com.opensymphony.xwork2.ActionContext;" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- 登陆后管理界面 -->
<html>
	<head>
		<title>Step</title>
	</head>
	<body>
		<div align="right">
			<a href="logoutAction">注销</a>
		</div>
		<%
			String loginName = (String) ActionContext.getContext().getSession().get("loginName");
			if (loginName != null && loginName.equals("vivo")) {
		%>
			<a href="manageUserAction">管理用户</a>
		<%
			} else if (loginName != null && !loginName.equals("vivo")) {
				
		%>
			<a href="TestLaunch.jsp">发起测试</a>
		<%
			}
			User user = (User) ActionContext.getContext().getSession().get("user");
			int id = user.getId();
		%>
		<a href="testResultAction">测试结果</a>
		<a href="userPasswordAction?id=<%=id %>">修改密码</a>
	</body>
</html>