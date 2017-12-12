<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- 发起测试界面 -->
<html>
	<head>
		<title>Test Launch</title>
	</head>
	<body>
		<div align="right">
			<a href="logoutAction">注销</a>
		</div>
		<s:form action="testLaunchAction" enctype="multipart/form-data" method="post">
			<s:textfield name="type" label="版本类型"></s:textfield>
			<s:textfield name="serialNumber" label="版本号"></s:textfield>
			<s:textfield name="testSource" label="测试集"></s:textfield>
			<s:file name="uploadFile" label="上传文件"/>
			<s:submit value="上传"></s:submit>
			<s:reset value="重置"></s:reset>
		</s:form>
		<a href="Step.jsp">返回管理界面</a>
	</body>
</html>