<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
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
<script type="text/javascript" src="/hr_devl//javascript/jquery-1.7.2.js"/></script>
<script type="text/javascript">
function toCheck(id)
{
	document.forms[0].action = document.forms[0].action + "?operate=toCheck&id=" + id;
	document.forms[0].submit();
}
</script>
</head>

<body>
	<form name="humanfileForm" method="post" action="/hr/humanfile.do">
		<table width="100%">
			<tr>
				<td><font color="#0000CC">您正在做的业务是：人力资源--人力资源档案管理--人力资源档案删除
				</font></td>
			</tr>
			<tr>
				<td>当前等待变更的人力资源档案总数：${fn:length(humanFilelist)} 例</td>
			</tr>
		</table>
		<table width="100%" border="1" cellpadding=0 cellspacing=1
			bordercolorlight=#848284 bordercolordark=#eeeeee class="TABLE_STYLE1">
			<tr class="TR_STYLE1">
				<td width="13%" class="TD_STYLE1">档案编号</td>
				<td width="13%" class="TD_STYLE1">姓名</td>
				<td width="11%" class="TD_STYLE1">性别</td>
				<td width="14%" class="TD_STYLE1">I级机构</td>
				<td width="14%" class="TD_STYLE1">II级机构</td>
				<td width="14%" class="TD_STYLE1">III级机构</td>
				<td width="14%" class="TD_STYLE1">职称</td>
				<td width="7%" class="TD_STYLE1">变更</td>
			</tr>
			<c:forEach items="${humanFilelist }" var="h">
				<tr>
					<td class="TD_STYLE2">${h.hufId }</td>
					<!--  --><td class="TD_STYLE2">${h.humanName }</td>
					<td class="TD_STYLE2">${h.humanSex }</td>
					<td class="TD_STYLE2">${h.firstKindName }</td>
					<td class="TD_STYLE2">${h.secondKindName }</td>
					<td class="TD_STYLE2">${h.thirdKindName }</td>
					<td class="TD_STYLE2">${h.humanProDesignation }</td>
					<td class="TD_STYLE2"><a href="cgp/${h.hufId }/humandeleteselect.do">删除</a></td>
				</tr>
			</c:forEach>
		</table>
		<p>
			&nbsp;&nbsp;总数：${fn:length(humanFilelist)}例 &nbsp;&nbsp;&nbsp;当前第 1 页 &nbsp;&nbsp;&nbsp;共 1 页
			&nbsp;&nbsp;&nbsp;跳到第 <input name=page type=text class=input1 size=1>
			页&nbsp;&nbsp;<input type=image src="images/go.bmp" width=18 height=18
				border=0>
	</form>
</body>
</html>
