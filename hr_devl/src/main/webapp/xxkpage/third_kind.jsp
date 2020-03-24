<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
     
	<form method="post" >
		<table width="100%">
			<tr>
				<td><font color="#0000CC">您正在做的业务是：人力资源--客户化设置--人力资源档案管理设置--III级机构设置
				</font></td>
			</tr>
			<tr>
				<td align="right"><input type="button" value="添加"
					class="BUTTON_STYLE1"
					onclick="window.location.href='xxk/addconfigThirdKindProcess.do'" /></td>
			</tr>
		</table>
		<table width="100%" border="1" cellpadding=0 cellspacing=1
			bordercolorlight=#848284 bordercolordark=#eeeeee class="TABLE_STYLE1">
			<tr>
					<td width="14%" class="TD_STYLE1">
						I级机构名称
					</td>
					<td width="14%" class="TD_STYLE1">
						II级机构名称
					</td>
					<td width="14%" class="TD_STYLE1">
						III级机构编号
					</td>
					<td width="14%" class="TD_STYLE1">
						III级机构名称
					</td>
					<td width="17%" class="TD_STYLE1">
						销售责任人编号
					</td>
					<td width="17%" class="TD_STYLE1">
						是否为零售店
					</td>
					<td width="5%" class="TD_STYLE1">
						变更
					</td>
					<td width="5%" class="TD_STYLE1">
						删除
					</td>
				</tr>
                   
	<!--  private Short ftkId;
	private String firstKindId;
	private String firstKindName;
	private String secondKindId;
	private String secondKindName;
	private String thirdKindId;
	private String thirdKindName;
	private String thirdKindSaleId;
	private String thirdKindIsRetail;
	-->
			<c:forEach items="${configFileThirdKind}" var="i" >
			 <tr>
			    <td class="TD_STYLE2">${i.firstKindName }</td>
				<td class="TD_STYLE2">${i.secondKindName }</td>
				<td class="TD_STYLE2">${i.thirdKindId}</td>
				<td class="TD_STYLE2">${i.thirdKindName }</td>
				<td class="TD_STYLE2">${i.thirdKindSaleId }</td>
				<td class="TD_STYLE2">${i.thirdKindIsRetail }</td>
				<td class="TD_STYLE2"><a href="xxk/${i.ftkId}/updateconfigFileThirdKindProcess.do">变更</a></td>
				<td class="TD_STYLE2"><a href="xxk/${i.ftkId}/deleteconfigThirdKind.do">删除</a></td>
			  </tr>
			</c:forEach>
			
			

		</table>
		<p>
			&nbsp;&nbsp;总数：1例 &nbsp;&nbsp;&nbsp;当前第 1 页 &nbsp;&nbsp;&nbsp;共 1 页
			&nbsp;&nbsp;&nbsp;跳到第 <input name=page type=text class=input1 size=1>
			页&nbsp;&nbsp;<input type=image src="images/go.bmp" width=18 height=18
				border=0>
	</form>
</body>
</html>
