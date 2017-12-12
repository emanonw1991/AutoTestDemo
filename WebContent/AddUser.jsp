<%@ page language="java" import="java.util.*, com.opensymphony.xwork2.ActionContext, com.autotest.entity.User;" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>Add User</title>
	</head>
	<body>
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
	</body>
</html>