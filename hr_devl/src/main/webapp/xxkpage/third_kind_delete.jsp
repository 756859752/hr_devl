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
 <script type="text/javascript" src="js/jquery-1.6.1.min.js"></script>

 <script type="text/javascript" >
   function deleteone(){
    $("#configFileThirdkind").submit();    
   }
 </script>
</head>
<body>
	<form  id="configFileThirdkind"  method="post" action="xxk/${configFileThirdKind.ftkId}/deleteconfigThirdKind.do ">
		<table width="100%">
			<tr>
				<td colspan="2"><font color="#0000CC">您正在做的业务是：人力资源--客户化设置--人力资源档案管理设置--III级机构设置
				</font></td>
			</tr>
			<tr>                         
				<td width="49%">您确认删除  <b> ${configFileThirdKind.firstKindName }/ ${configFileThirdKind.secondKindName} / ${configFileThirdKind.thirdKindName}  </b>这条记录吗?</td>
				<td width="51%" align="right"><input type="button" value="删除"
					class="BUTTON_STYLE1" onclick="deleteone()"> <input
					type="button" value="返回" class="BUTTON_STYLE1"
					onclick="history.back();"></td>
			</tr>
		</table>
	</form>
</body>
</html>
