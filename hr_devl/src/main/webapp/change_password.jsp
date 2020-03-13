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
<link href="table.css" rel="stylesheet" />
<style type="text/css">
<!--
.style1 {
	font-size: 18px;
	font-weight: bold;
	color: #660000;
}
-->
</style>
<script type="text/javascript">
function namechk()
{
	var name = document.forms[0].elements["item.UName"];
	var pwd = document.forms[0].elements["item.UPassword"];
	if(name.value == "")
	{
		alert ("请填写用户名");
		name.focus();
		return false;
	}
	else if(pwd.value == "")
	{
		alert ("请填写原始密码");
		tname.focus();
		return false;
	}
	else
		return true;
}
function pwdchk()
{
	var pwd = document.forms[0].elements["newPwd"];
	var spwd = document.all.surPwd;
	if (pwd.value == "")
	{	
		alert("请填写新密码");
		pwd.focus();
		return false;
	}
	else if(spwd.value == "")
	{
		alert("请填写确认新密码");
		spwd.focus();
		return false;
	}
	else if(pwd.value != spwd.value)
	{
		alert ("新密码和确认新密码不相同");
		pwd.value = "";
		spwd.value = "";	
		return false;
	}
	else
		return true;
}
function toEditPwd()
{
	if(namechk() && pwdchk())
	{
		document.forms[0].action = document.forms[0].action + "?operate=doEditPwd";
		document.forms[0].submit();
	}
}
</script>
</head>

<body bgcolor="#E9F8F3">
	<form method="post" action="users.do">
		<table width="100%">
			<tr>
				<td height="169" colspan="3" align="center">
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p class="style1">Better伯乐HR系统修改用户密码</p>
				</td>
			</tr>
			<tr>
				<td width="18%" height="166">&nbsp;</td>
				<td width="62%">
					<table width="95%" border="1" cellpadding=0 cellspacing=1
						bordercolorlight=#848284 bordercolordark=#eeeeee
						class="TABLE_STYLE1">
						<tr>
							<td width="20%" class="TD_STYLE1">用户名</td>
							<td width="80%" class="TD_STYLE2"><input type="text"
								name="item.UName" value="better_wanghao" class="INPUT_STYLE1"></td>
						</tr>
						<tr>
							<td class="TD_STYLE1">原始密码</td>
							<td class="TD_STYLE2"><input type="password"
								name="item.UPassword" value="" style="background-color: #DEEBF7"
								class="INPUT_STYLE1"></td>
						</tr>
						<tr>
							<td class="TD_STYLE1">新密码</td>
							<td class="TD_STYLE2"><input type="password" name="newPwd"
								value="" style="background-color: #DEEBF7" class="INPUT_STYLE1"></td>
						</tr>
						<tr>
							<td class="TD_STYLE1">确认新密码</td>
							<td class="TD_STYLE2"><input name="surPwd" type="password"
								class="INPUT_STYLE1" style="background-color: #DEEBF7"></td>
						</tr>
					</table>
				</td>
				<td width="20%">&nbsp;</td>
			</tr>
			<tr>
				<td></td>
				<td align="center"><input type="button" value="确认"
					class="BUTTON_STYLE1" onclick="javascript:toEditPwd();">
					&nbsp; <input type="button" value="返回" onclick="history.back();"
					class="BUTTON_STYLE1"></td>
				<td></td>
			</tr>
		</table>
	</form>
</body>
</html>
