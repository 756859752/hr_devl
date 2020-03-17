<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="/hr_devl/css/table.css" type="text/css" />
		<title>无标题文档</title>
		<style type="text/css">
		<!--
		.style3 {color: #0000CC}
		td{text-align: center}
		-->
		</style>
	</head>

	<body>
		<form method="post" action="SalarygrantAll">
			<table width="100%">
				<tr>
					<td style="text-align:left;">
						<font color="black">您正在做的业务是:人力资源管理--薪酬发放管理--薪酬发放登记审核</font>					
						<br/><br/><br/>
					</td>
				</tr>
			</table>
									
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="10%" class="TD_STYLE1">
						<span>薪酬发放编号</span>
					</td>
					<td width="20%" class="TD_STYLE1">
						<span>I级机构名称</span>
					</td>
					<td width="20%" class="TD_STYLE1">
						<span>II级机构名称</span>
					</td>
					<td width="20%" class="TD_STYLE1">
						<span>III级机构名称</span>
					</td>
					<td width="10%" class="TD_STYLE1">
						<span>人数</span>
					</td>
					<td width="10%" class="TD_STYLE1">
						基本薪酬总额(元)
					</td>
					<td width="10%" class="TD_STYLE1">
						复核
					</td>
				</tr>
			</table>	
		</form>
	</body>
<script type="text/javascript" src="/hr_devl/javascript/jquery-1.6.1.min.js"></script>
<script type="text/javascript">
(function(){
	$.ajax({
		url:"/hr_devl/dcf/salarygrant/querysalarygrantcheck.do",	
		type:"POST",
		contentType:"application/json;charset=utf-8",
	    success:function(result){
	    	console.log(result);
          var str ='';
          var sum=0;
          for(var i=0;i<result.length;i++){ 
        	  var uu=new Date(result[i].registTime);
        	  var salsum=result[i].salaryStandardSum;
        	  if(result[i].checkStatus==0){
        		  sum++;
        		  str += '<tr class="TD_STYLE2"><td>'+result[i].salaryGrantId+'</td><td>'+result[i].firstKindName+'</td><td>'+result[i].secondKindName+'</td><td>'+result[i].thirdKindName+'</td><td>'+salsum.toFixed(2)+'</td><td>'+result[i].humanAmount+'</td><td><a href="/hr_devl/dcf/salarygrant/checkOnesalarygrant/'+result[i].salaryGrantId+'.do">复核</a></td></tr>'; 
        	  }else{
        		  str += '<tr class="TD_STYLE2"><td>'+result[i].salaryGrantId+'</td><td>'+result[i].firstKindName+'</td><td>'+result[i].secondKindName+'</td><td>'+result[i].thirdKindName+'</td><td>'+salsum.toFixed(2)+'</td><td>'+result[i].humanAmount+'</td><td>已复核</td></tr>';  
        	  }
        	 
          }
          $(".TABLE_STYLE1").append(str);
		  $("#sum").html(sum);
	  }
	});
})();
	</script>
</html>