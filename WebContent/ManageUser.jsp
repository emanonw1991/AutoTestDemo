<%@ page language="java" import="java.util.*, com.autotest.entity.*, com.opensymphony.xwork2.ActionContext, com.autotest.entity.User;" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>Manage User</title>
	</head>
	<body>
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
			<%
			List<User> userList = (List<User>) ActionContext.getContext().get("userList");
			for (User user : userList) {
			%>
			<tr>
				<td><%=user.getId() %></td>
				<td><%=user.getLoginName() %></td>
				<td><%=user.getLoginPassword() %></td>
				<td><a href="userPasswordAction?id=<%=user.getId() %>">管理用户</a></td>
				<td>
				<%
				if (!user.getLoginName().equals("vivo")) {
				%>
					<a href="deleteUserAction?id=<%=user.getId() %>" 
					onClick="return confirm('确认删除？');">删除用户</a>
				<%
				}
				%>
				</td>
			</tr>
			<%
			}
			%>
		</table>
		<a href="AddUser.jsp">增加用户</a>
		<a href="Step.jsp">返回管理界面</a>
	</body>
</html>