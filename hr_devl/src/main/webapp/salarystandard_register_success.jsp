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
<script type="text/javascript" src="winopen/jquery-1.6.1.min.jsp"></script>
<script type="text/javascript" src="javascript/comm/comm.js"></script>
</head>
<body>
		<table width="100%">
			<tr>
				<td colspan="2"><font color="#0000CC">您正在做的业务是：人力资源--薪酬标准管理--薪酬标准登记
				</font></td>
			</tr>
			<tr>
				<td width="49%">提交成功，需要复核！</td>
				<td width="51%" align="right"><input type="button" value="返回"
					class="BUTTON_STYLE1" onclick="javascript:toAdd();"></td>
			</tr>
		</table>
</body>
</html>
