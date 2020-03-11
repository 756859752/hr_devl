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
		<form method="post" action="configmajor.do">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：人力资源--客户化设置--人力资源档案管理设置--职位设置
						</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="添加" class="BUTTON_STYLE1"
							onclick="toAdd();">
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="22%" class="TD_STYLE1">
						职位分类编号
					</td>
					<td width="23%" class="TD_STYLE1">
						职位分类名称
					</td>
					<td width="26%" class="TD_STYLE1">
						职位编号
					</td>
					<td width="24%" class="TD_STYLE1">
						职位名称
					</td>
					<td width="5%" class="TD_STYLE1">
						删除
					</td>
				</tr>
				
					<tr>
						<td class="TD_STYLE2">
							01
						</td>
						<td class="TD_STYLE2">
							销售
						</td>
						<td class="TD_STYLE2">
							01
						</td>
						<td class="TD_STYLE2">
							区域经理
						</td>
						<td class="TD_STYLE2">
							<a href="configmajor.do?operate=toDel(1)">删除</a>
						</td>
					</tr>
				
					<tr>
						<td class="TD_STYLE2">
							01
						</td>
						<td class="TD_STYLE2">
							销售
						</td>
						<td class="TD_STYLE2">
							02
						</td>
						<td class="TD_STYLE2">
							总经理
						</td>
						<td class="TD_STYLE2">
							<a href="configmajor.do?operate=toDel(2)">删除</a>
						</td>
					</tr>
				
					<tr>
						<td class="TD_STYLE2">
							02
						</td>
						<td class="TD_STYLE2">
							软件开发
						</td>
						<td class="TD_STYLE2">
							01
						</td>
						<td class="TD_STYLE2">
							项目经理
						</td>
						<td class="TD_STYLE2">
							<a href="configmajor.do?operate=toDel(3)">删除</a>
						</td>
					</tr>
				
					<tr>
						<td class="TD_STYLE2">
							02
						</td>
						<td class="TD_STYLE2">
							软件开发
						</td>
						<td class="TD_STYLE2">
							02
						</td>
						<td class="TD_STYLE2">
							程序员
						</td>
						<td class="TD_STYLE2">
							<a href="configmajor.do?operate=toDel(4)">删除</a>
						</td>
					</tr>
				
					<tr>
						<td class="TD_STYLE2">
							03
						</td>
						<td class="TD_STYLE2">
							人力资源
						</td>
						<td class="TD_STYLE2">
							01
						</td>
						<td class="TD_STYLE2">
							人事经理
						</td>
						<td class="TD_STYLE2">
							<a href="configmajor.do?operate=toDel(5)">删除</a>
						</td>
					</tr>
				
					<tr>
						<td class="TD_STYLE2">
							03
						</td>
						<td class="TD_STYLE2">
							人力资源
						</td>
						<td class="TD_STYLE2">
							02
						</td>
						<td class="TD_STYLE2">
							专员
						</td>
						<td class="TD_STYLE2">
							<a href="configmajor.do?operate=toDel(6)">删除</a>
						</td>
					</tr>
				
					<tr>
						<td class="TD_STYLE2">
							04
						</td>
						<td class="TD_STYLE2">
							生产部
						</td>
						<td class="TD_STYLE2">
							01
						</td>
						<td class="TD_STYLE2">
							主任
						</td>
						<td class="TD_STYLE2">
							<a href="configmajor.do?operate=toDel(7)">删除</a>
						</td>
					</tr>
				
					<tr>
						<td class="TD_STYLE2">
							04
						</td>
						<td class="TD_STYLE2">
							生产部
						</td>
						<td class="TD_STYLE2">
							02
						</td>
						<td class="TD_STYLE2">
							技术工人
						</td>
						<td class="TD_STYLE2">
							<a href="configmajor.do?operate=toDel(8)">删除</a>
						</td>
					</tr>
				
			</table>
			<p>&nbsp;&nbsp;总数：8例 &nbsp;&nbsp;&nbsp;当前第 1 页  &nbsp;&nbsp;&nbsp;共 1 页  &nbsp;&nbsp;&nbsp;跳到第 <input name=page type=text class=input1 size=1> 页&nbsp;&nbsp;<input type=image src="images/go.bmp" width=18 height=18 border=0>
		</form>
	</body>
</html>
