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
<link rel="stylesheet" href="table.css" type="text/css" />
<title>无标题文档</title>
</head>
<body>
	<form action="dcf/salarystandard/checkone.do" method="post" class="salarystandardForm">
		<table width="100%">
			<tr>
				<td><font color="#0000CC">您正在做的业务是:人力资源管理--薪酬标准管理--薪酬标准登记复核</font>
				</td>
			</tr>
			<tr>
				<td>
					<div align="right">
						<input type="button" value="复核通过" class="BUTTON_STYLE1"
							onclick="doEdit();"> <input type="button" value="返回"
							onclick="history.back();" class="BUTTON_STYLE1">
					</div>
				</td>
			</tr>
		</table>
		<input name="Ss.ssdId" type="hidden" value="${moreSalary.ss.ssdId}"/>
		<table width="100%" border="1" cellpadding=0 cellspacing=1
			bordercolorlight=#848284 bordercolordark=#eeeeee class="TABLE_STYLE1">
			<tr>
				<td width="12%" class="TD_STYLE1">薪酬编号</td>
				<td width="15%" class="TD_STYLE2" >${moreSalary.ss.standardId}</td>
				      <input name="Ss.standardId" type="hidden" value="${moreSalary.ss.standardId}"/>
				<td width="12%" class="TD_STYLE1">薪酬标准名称</td>
				<td width="11%" class="TD_STYLE2"><input type="text"
					name="Ss.standardName" readonly="readonly" value="${moreSalary.ss.standardName}" class="INPUT_STYLE2"></td>
				<td width="11%" class="TD_STYLE1">薪酬总额</td>
				<td width="17%" id="salesum" class="TD_STYLE2" name="Ss.salarySum">${moreSalary.ss.salarySum}0</td>    
				     <input id="updatesum" name="Ss.salarySum" type="hidden" value="${moreSalary.ss.salarySum}"/>  
				<td width="12%" class="TD_STYLE1">&nbsp;</td>
				<td width="10%" class="TD_STYLE2">&nbsp;</td>
			</tr>
			<tr>
				<td class="TD_STYLE1">制定人</td>
				<td class="TD_STYLE2"><input type="text" name="Ss.designer"
					value="${moreSalary.ss.designer}" readonly="readonly" class="INPUT_STYLE2"></td>
				<td class="TD_STYLE1">复核人</td>
				<td class="TD_STYLE2"><input type="text" name="Ss.checker"
					value="${moreSalary.ss.checker}" readonly="readonly" class="INPUT_STYLE2">
				</td>
				<td class="TD_STYLE1">复核时间</td>
				<td class="TD_STYLE2"><input type="text" id="timenow"
					name="Ss.checkTime" value="${moreSalary.ss.checkTime}"
					readonly="readonly" class="INPUT_STYLE2"></td>
				<td class="TD_STYLE1">&nbsp;</td>
				<td class="TD_STYLE2">&nbsp;</td>
			</tr>
			<tr>
				<td class="TD_STYLE1">复核意见</td>
				   <input name="Ss.remark" type="hidden" value="${moreSalary.ss.remark}"/>
				<td colspan="7" class="TD_STYLE2"><textarea
						name="Ss.checkComment" rows="4" class="TEXTAREA_STYLE1"></textarea>
				</td>
			</tr>
			<tr>
				<td class="TD_STYLE1">序号</td>
				<td colspan="3" class="TD_STYLE1">薪酬项目名称</td>
				<td colspan="4" class="TD_STYLE1">金额</td>
			</tr>
            <c:forEach items="${moreSalary.list}" var="s" varStatus="i">
            	<tr class="TD_STYLE2">
            	 <input type="hidden" name="list[${i.index}].sdtId" value="${s.sdtId}"/>
            	  <input type="hidden" name="list[${i.index}].standardId" value="${s.standardId}"/>
            	  <input type="hidden" name="list[${i.index}].standardName" value="${s.standardName}"/>
				<td align="center">${i.count}<input type="hidden" name="list[${i.index}].itemId"
					value="${i.count}" class="INPUT_STYLE2">
				</td>
				<td colspan="3">${s.itemName} <input type="hidden"
					name="list[${i.index}].itemName" value="${s.itemName}" class="INPUT_STYLE2">
				</td>
				<td><input type="text" name="list[${i.index}].salary" value="${s.salary}0"
					class="INPUT_STYLE2 money"></td>
				<td colspan="3">&nbsp;</td>
			   </tr>
            </c:forEach>
		</table>
	</form>
</body>
</html>
<script type="text/javascript" src="js/jquery-1.6.1.min.js"></script>
<script type="text/javascript">
	function getTime(){
		var tim=new Date();
		var year=tim.getFullYear();
		var month=(tim.getMonth()+1)<10 ? '0'+(tim.getMonth()+1):(tim.getMonth()+1);
		var da=tim.getDate()<10 ? '0'+tim.getDate() : tim.getDate();
		var hour=tim.getHours()<10 ? '0'+tim.getHours() : tim.getHours();
		var min=tim.getMinutes()<10 ? '0'+tim.getMinutes() : tim.getMinutes();
		var tt=tim.getSeconds()<10 ? '0'+tim.getSeconds() : tim.getSeconds();
		return year+'-'+month+'-'+da+' '+hour+':'+min+':'+tt;
	}
   function doEdit(){
	   var sal=$(".TABLE_STYLE1>tbody>.TD_STYLE2>td .money");
	   for (var i=0;i<sal.length;i++) {
			if (sal[i].value==null||sal[i].value=="") {
				alert("请检查，薪酬项目金额不能为空");
				return;
		}
	   }
	   $("#timenow").val(getTime());
	   $(".salarystandardForm").submit();
   }
   $(".TABLE_STYLE1>tbody>.TD_STYLE2>td .money").blur(function(){
	   var ff=$(".TABLE_STYLE1>tbody>.TD_STYLE2>td .money");
	   var sum=0;
	   for (var i=0;i<ff.length;i++) {
			if (ff[i].value!=null) {
				sum=sum+ff[i].value*1;
		}
	   }
	   $("#salesum").html(sum.toFixed(2));
	   $("#updatesum").val(sum.toFixed(2));
   });

</script>
