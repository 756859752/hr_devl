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
<style type="text/css">
<!--
.style3 {
	color: #0000CC
}
-->
</style>
</head>

<body>
	<form method="post" action="salarystandard.do">
		<table width="100%">
			<tr>
				<td><font color="#0000CC">您正在做的业务是:人力资源管理--薪酬标准管理--薪酬标准登记复核</font>
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>当前等待复核的薪酬标准总数:<span id="sum"></span> 例</td>
			</tr>
		</table>
		<table width="100%" border="1" cellpadding=0 cellspacing=1
			bordercolorlight=#848284 bordercolordark=#eeeeee class="TABLE_STYLE1">
			<tr>
				<td width="18%" class="TD_STYLE1"><span>薪酬标准编号</span></td>
				<td width="19%" class="TD_STYLE1"><span>薪酬标准名称</span></td>
				<td width="16%" class="TD_STYLE1"><span>制定人</span></td>
				<td width="30%" class="TD_STYLE1"><span>登记时间</span></td>
				<td width="13%" class="TD_STYLE1">薪酬总额</td>
				<td width="4%" class="TD_STYLE1">复核</td>
			</tr>
		</table>
		<p>
			&nbsp;&nbsp;总数：3例 &nbsp;&nbsp;&nbsp;当前第 1 页 &nbsp;&nbsp;&nbsp;共 1 页
			&nbsp;&nbsp;&nbsp;跳到第 <input name=page type=text class=input1 size=1>
			页&nbsp;&nbsp;<input type=image src="images/go.bmp" width=18 height=18
				border=0>
	</form>
</body>
</html>
<script type="text/javascript" src="javascript/jquery-1.7.2.js"></script>
<script type="text/javascript">
(function(){
	$.ajax({
		url:'dcf/salarystandard/checkSalaryStandard.do',	
		type:"POST",
		contentType:"application/json;charset=utf-8",
	    success:function(result){
          var str ='';
          var sum=0;
          for(var i=0;i<result.length;i++){
        	  sum++;
        	  var uu=new Date(result[i].registTime);
        	  var salsum=result[i].salarySum;
        	  str += '<tr class="TD_STYLE2"><td>'+result[i].standardId+'</td><td>'+result[i].standardName+'</td><td>'+result[i].designer+'</td><td>'+uu.toLocaleString()+'</td><td>'+salsum.toFixed(2)+'</td><td><a href="dcf/salarystandard/checkSalaryStandardOne/'+result[i].standardId+'.do">复核</a></td></tr>';
          }
          $(".TABLE_STYLE1").append(str);
		  $("#sum").html(sum);
	  }
	});
})();


</script>
