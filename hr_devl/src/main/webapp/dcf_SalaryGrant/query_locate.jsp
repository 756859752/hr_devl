<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="/hr_devl/css/table.css" type="text/css">
		<script type="text/javascript" src="/hr_devl/javascript/comm/comm.js"></script>
		<script type="text/javascript" src="/hr_devl/javascript/comm/list.js"></script>
		<title>无标题文档</title>
		<script type="text/javascript" src="/hr_devl/javascript/jquery-1.7.2.js"></script>	
		<script type="text/javascript" src="/hr_devl/javascript/calendar-ch.js"></script>
		<script type="text/javascript" src="/hr_devl/javascript/comm/time.js"></script>
		<link rel="stylesheet" href="/hr_devl/css/cwcalendar.css" type="text/css"></link></head>

	<body>
	
		<form method="post" action="/hr_devl/dcf/salarygrant/querySalarGrant.do">
		<input type="hidden" name="page.startPage" value="0">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是:人力资源管理--薪酬发放管理--薪酬发放查询</font>
					</td>
				</tr>
				<tr>
					<td>
						<div align="right">
							<input type="submit" value="查询" class="BUTTON_STYLE1" >
						</div>
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="20%"  class="TD_STYLE1">
						请输入薪酬单号:
					</td>
					<td class="TD_STYLE2">
						<input type="text"  name="salid" class="INPUT_STYLE1"  value=""/>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						请输入关键字:
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="salinfo" class="INPUT_STYLE1" value="">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1" >
						请输入发放时间:
					</td>
					<td width="70%" class="TD_STYLE2">
						<input name="starttime"  type="date" class="INPUT_STYLE2" id="date_start" style="width:24% " size="30" value="">
						至 <input type="date" name="endtime"  style="width:24% " class="INPUT_STYLE2" value="">
						（YYYY-MM-DD）
					</td>	
				</tr>
			</table>
		</form>
	</body>
	 
</html>