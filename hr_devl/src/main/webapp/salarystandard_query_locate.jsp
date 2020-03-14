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
<link rel="stylesheet" href="table.css" type="text/css" />
<link rel="stylesheet" type="text/css" media="all"
	href="javascript/calendar/calendar-win2k-cold-1.css">
<script type="text/javascript" src="javascript/calendar/cal.js"></script>

<title>无标题文档</title>

</head>

<body>
	<form method="post" action="dcf/salarystandard/querySalStan.do">
		<table width="100%">
			<tr>
				<td><font color="#0000CC">您正在做的业务是:人力资源管理--薪酬标准管理--薪酬标准查询</font>
				</td>
			</tr>
			<tr>
				<td>
					<div align="right">
						<input type="button" value="查询" class="BUTTON_STYLE1" onclick="coditions()">
					</div>
				</td>
			</tr>
		</table>
		<table width="100%" border="1" cellpadding=0 cellspacing=1
			bordercolorlight=#848284 bordercolordark=#eeeeee class="TABLE_STYLE1">
			<tr>
				<td width="20%" class="TD_STYLE1">请输入薪酬标准编号</td>
				<td class="TD_STYLE2"><input type="text" name="salid"
					value="" class="INPUT_STYLE1"></td>
			</tr>
			<tr>
				<td class="TD_STYLE1">请输入关键字</td>
				<td class="TD_STYLE2"><input type="text" name="salinfo"
					class="INPUT_STYLE1"></td>
			</tr>
			<tr>
				<td class="TD_STYLE1">请输入登记时间</td>
				<td class="TD_STYLE2"><input type="date"
					name="starttime" value="" class="INPUT_STYLE1"
					id="date_start"> 至 <input type="date"
					name="endtime" value="" class="INPUT_STYLE1" id="date_end">
					(YYYY-MM-DD)</td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript" src="js/jquery-1.6.1.min.js"></script>
<script type="text/javascript">
			function coditions()
			{
				//document.forms[0].action = document.forms[0].action + "?operate=list&status=1&method=query";
				//document.forms[0].action ="salarystandard_query_list.html";
				document.forms[0].submit();
			}
</script>
</html>
