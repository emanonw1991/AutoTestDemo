<%@ page language="java" import="java.util.*, com.opensymphony.xwork2.*;" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- 用户登陆界面 -->
<html>
	<head>
		<title>登陆</title>
	</head>
	<body>
		<%
			if (ActionContext.getContext().get("loginSuccess") != null) {
		%>
			<font color="red">用户名或密码错误，请重试！</font>
		<%
			}
		%>
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
	</body>
</html>