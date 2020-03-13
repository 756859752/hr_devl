<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="table.css" type="text/css">
<script type="text/javascript" src="javascript/comm/comm.js"></script>
</head>
<body>
	<form method="post" action="humanfile.do" enctype="multipart/form-data">
		<table width="100%">
			<tr>
				<td colspan="2"><font color="#0000CC">您正在做的业务是：人力资源--人力资源档案管理--人力资源档案登记</font></td>
			</tr>
			<tr>
				<td width="65%">提交成功，如需上传附件，请选择上传(word文档、txt文档、pdf文档、jpg图片等，最大5.0MB)
					<input type="file" class="FILE_STYLE1" name="theAttach"
					width="100%">
				</td>
				<td width="41%" align="right"><input type="button" value="上传附件"
					class="BUTTON_STYLE1" onclick="doUpLoadAttach2('register');">
					<input type="button" value="上传照片" class="BUTTON_STYLE1"
					onclick="toUpLoadPhoto2('register');"> <input type="button"
					value="完成" class="BUTTON_STYLE1" onclick="finish();"></td>
			</tr>
		</table>
	</form>
</body>
</html>
