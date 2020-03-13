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
<title>无标题文档</title>
</head>

<body>
	<form action="salarystandard.do" method="post">
		<table width="100%">
			<tr>
				<td><font color="#0000CC">您正在做的业务是:人力资源管理--薪酬标准管理--薪酬标准登记查询</font>
				</td>
			</tr>
			<tr>
				<td>
					<div align="right">
						<input type="button" value="打印" class="BUTTON_STYLE1"> <input
							type="button" value="返回" onclick="history.back();"
							class="BUTTON_STYLE1">
					</div>
				</td>
			</tr>
		</table>
		<table width="100%" border="1" cellpadding=0 cellspacing=1
			bordercolorlight=#848284 bordercolordark=#eeeeee class="TABLE_STYLE1">
			<tr>
				<td width="12%" class="TD_STYLE1">薪酬编号</td>
				<td width="15%" class="TD_STYLE2">1000001</td>
				<td width="12%" class="TD_STYLE1">薪酬标准名称</td>
				<td width="11%" class="TD_STYLE2"></td>
				<td width="11%" class="TD_STYLE1">薪酬总额</td>
				<td width="17%" class="TD_STYLE2">0.0</td>
				<td class="TD_STYLE1" width="12%">&nbsp;</td>
				<td class="TD_STYLE2" width="10%">&nbsp;</td>
			</tr>
			<tr>
				<td class="TD_STYLE1">制定人</td>
				<td class="TD_STYLE2"></td>
				<td class="TD_STYLE1">复核人</td>
				<td class="TD_STYLE2">better_wanghao</td>
				<td class="TD_STYLE1">复核时间</td>
				<td class="TD_STYLE2">2010-05-29 00:00:00.0</td>
				<td class="TD_STYLE1">&nbsp;</td>
				<td class="TD_STYLE2">&nbsp;</td>
			</tr>
			<tr>
				<td class="TD_STYLE1">备注</td>
				<td colspan="7" class="TD_STYLE2" height="68"></td>
			</tr>
			<tr>
				<td class="TD_STYLE1">序号</td>
				<td colspan="3" class="TD_STYLE1">薪酬项目名称</td>
				<td colspan="4" class="TD_STYLE1">金额</td>
			</tr>

			<tr class="TD_STYLE2">
				<td>1</td>
				<td colspan="3">出差补助</td>
				<td colspan="4">0.0</td>
			</tr>

			<tr class="TD_STYLE2">
				<td>2</td>
				<td colspan="3">交通补贴</td>
				<td colspan="4">0.0</td>
			</tr>

			<tr class="TD_STYLE2">
				<td>3</td>
				<td colspan="3">住房补贴</td>
				<td colspan="4">0.0</td>
			</tr>

			<tr class="TD_STYLE2">
				<td>4</td>
				<td colspan="3">基本工资</td>
				<td colspan="4">0.0</td>
			</tr>

			<tr class="TD_STYLE2">
				<td>5</td>
				<td colspan="3">年终奖</td>
				<td colspan="4">0.0</td>
			</tr>

			<tr class="TD_STYLE2">
				<td>6</td>
				<td colspan="3">误餐补助</td>
				<td colspan="4">0.0</td>
			</tr>

			<tr class="TD_STYLE2">
				<td>1</td>
				<td colspan="3">出差补助</td>
				<td colspan="4">0.0</td>
			</tr>

			<tr class="TD_STYLE2">
				<td>2</td>
				<td colspan="3">交通补贴</td>
				<td colspan="4">0.0</td>
			</tr>

			<tr class="TD_STYLE2">
				<td>3</td>
				<td colspan="3">住房补贴</td>
				<td colspan="4">0.0</td>
			</tr>

			<tr class="TD_STYLE2">
				<td>4</td>
				<td colspan="3">基本工资</td>
				<td colspan="4">0.0</td>
			</tr>

			<tr class="TD_STYLE2">
				<td>5</td>
				<td colspan="3">年终奖</td>
				<td colspan="4">0.0</td>
			</tr>

			<tr class="TD_STYLE2">
				<td>6</td>
				<td colspan="3">误餐补助</td>
				<td colspan="4">0.0</td>
			</tr>

			<tr class="TD_STYLE2">
				<td>1</td>
				<td colspan="3">出差补助</td>
				<td colspan="4">0.0</td>
			</tr>

			<tr class="TD_STYLE2">
				<td>2</td>
				<td colspan="3">交通补贴</td>
				<td colspan="4">0.0</td>
			</tr>

			<tr class="TD_STYLE2">
				<td>3</td>
				<td colspan="3">住房补贴</td>
				<td colspan="4">0.0</td>
			</tr>

			<tr class="TD_STYLE2">
				<td>4</td>
				<td colspan="3">基本工资</td>
				<td colspan="4">0.0</td>
			</tr>

			<tr class="TD_STYLE2">
				<td>5</td>
				<td colspan="3">年终奖</td>
				<td colspan="4">0.0</td>
			</tr>

			<tr class="TD_STYLE2">
				<td>6</td>
				<td colspan="3">误餐补助</td>
				<td colspan="4">0.0</td>
			</tr>

		</table>
	</form>
</body>
</html>
