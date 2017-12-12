<%@ page language="java" import="java.util.*, com.autotest.entity.*, com.opensymphony.xwork2.ActionContext" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- 查看测试结果界面 -->
<html>
	<head>
		<title>Test Result</title>
	</head>
	<body>
		<div align="right">
			<a href="logoutAction">注销</a>
		</div>
		<!-- 制表 -->
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
			<%
				List<Test> testResult = (List<Test>) ActionContext.getContext().get("testResult");
				for (Test test : testResult) {
					String fileName = test.getId() + ".json";
			%>
			<tr>
				<td><%=test.getId() %></td>
				<td><%=test.getVersionId() %></td>
				<td><%=test.getType() %></td>
				<td><%=test.getSerialNumber() %></td>
				<td><%=test.getState() %></td>
				<td><a href="fileDownloadAction?downloadFileFileName=<%=fileName %>">结果下载</a></td>
				<td><%=test.getTestSource() %></td>
			</tr>
			<%
				}
			%>
		</table>
		<a href="Step.jsp">返回管理界面</a>
	</body>
</html>