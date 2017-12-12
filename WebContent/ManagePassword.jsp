<%@ page language="java" import="java.util.*, com.autotest.entity.*, com.opensymphony.xwork2.ActionContext;" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>Manage Password</title>
	</head>
	<body>
		<s:fielderror></s:fielderror>
		<s:form action="managePasswordAction">
			<table>
				<tr>
					当前用户名：<s:property value="loginName"/>
				</tr>
				<tr>
					当前密码：<s:property value="loginPassword"/>
				</tr>
				<tr>
					<s:textfield name="newPassword" label="请输入新密码"/>
				</tr>
				<tr>
					<s:textfield name="confirmPassword" label="请确认新密码"/>
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
	</body>
</html>