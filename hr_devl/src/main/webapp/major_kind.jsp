<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
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
<script type="text/javascript" src="js/jquery-1.6.1.min.js"></script>
<script type="text/javascript" >
 function configMajorKindadd(){
   window.location.href="xxkpage/major_kind_add.jsp";
 }
</script>
</head>

<body>
	<form method="post" >
		<table width="100%">
			<tr>
				<td><font color="#0000CC">您正在做的业务是：人力资源--客户化设置--薪酬管理设置--薪酬项目设置
				</font></td>
			</tr>
			<tr>
				<td align="right"><input type="button" value="添加"
					class="BUTTON_STYLE1" onclick="configMajorKindadd()"></td>
			</tr>
		</table>
	  <!--  
	 private int pbcid;
	 private String attributekind;
	 private String attributename;
	   -->
	   
		<table width="100%" border="1" cellpadding=0 cellspacing=1
			bordercolorlight=#848284 bordercolordark=#eeeeee class="TABLE_STYLE1">
			<tr height="20">
			 <td width="80%" class="TD_STYLE1" align="center">薪酬项目名称</td>
			 <td width="20%" class="TD_STYLE1" align="center">删除</td>
		    </tr>
				
          <c:forEach items="${configMajorKind}" var="i">
			  <tr>
				 <td class="TD_STYLE2">${x.attributename}</td>
				 <td  align="center" class="TD_STYLE2">
				  <a href="xxk//deletesalaryItem.do">删除</a>
				 </td>
			 </tr>
          </c:forEach>

		</table>
		<p>
			&nbsp;&nbsp;总数：4例 &nbsp;&nbsp;&nbsp;当前第 1 页 &nbsp;&nbsp;&nbsp;共 1 页
			&nbsp;&nbsp;&nbsp;跳到第 <input name=page type=text class=input1 size=1>
			页&nbsp;&nbsp;<input type=image src="images/go.bmp" width=18 height=18
				border=0>
	</form>
</body>
</html>
