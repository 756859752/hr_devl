<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="../javascript/jquery-1.6.1.min.js"></script>
	<link rel="stylesheet" href="../css/table.css" type="text/css" />
	<script type="text/javascript" src="../javascript/comm/comm.js"></script>
	<title>无标题文档</title>
	<STYLE type="text/css">
	      td{text-align: center}
	</STYLE>
</head>
<body>
<table width="100%">
	<tr>
		<td colspan="2" style="text-align: left">
			<font color="black">您正在做的业务是：人力资源--薪酬标准管理--薪酬发放登记(负责人控制)
			</font>	 
		</td>
	</tr>
	</table>
	<br/> 
			薪酬总数:${count}
			总人数:<span id="sumpeo"></span>，基本薪酬总数:${summap.salaryall }，实发总额:${summap.salarypall }	
	<table width="100%" border="1" cellpadding=0 cellspacing=1
		bordercolorlight=#848284 bordercolordark=#eeeeee
		class="TABLE_STYLE1" id="showtable">
		<tr>
			<td width="10%" class="TD_STYLE1">
				<span>序号</span>
			</td>			
			<td width="20%"  class="TD_STYLE1">
			<span>Ⅰ级机构名称</span>	
			</td>
			<td width="20" class="TD_STYLE1"><span>II级机构名称</span></td>
			  <td width="20" class="TD_STYLE1"><span>III级机构名称</span></td>
			<td width="10%" class="TD_STYLE1">
				<span>人数</span>
			</td>
			<td width="10%" class="TD_STYLE1">
				基本薪酬总额(元)
			</td>					
			<td width="10%" class="TD_STYLE1">
				登记
			</td>
		</tr>	
	</table>
</body>
</html>

<script type="text/javascript">
  (function(){
		$.ajax({
			url:'/hr_devl/dcf/salarygrant/querysalarygrantpeoples.do',	
			type:"POST",
			contentType:"application/json;charset=utf-8",
		    success:function(result){
	          var str ='';
	          var sum=0;
	          for(var i=0;i<result.length;i++){
	        	  sum++;
	        	  str += '<tr class="TD_STYLE2"><td>'+(i+1)+'</td><td>'+result[i].firstKindName+'</td><td>'+result[i].secondKindName+'</td><td>'+result[i].thirdKindName+'</td><td>'+result[i].humanAmount+'</td><td>'+result[i].salaryStandardSum+'</td><td><a href="/hr_devl/dcf/salarygrant/querysalarygrant/'+result[i].salaryGrantId+'.do">登记</a></td></tr>';
	          }
	          $("#showtable").append(str);
			  $("#sumpeo").html(sum);
		  }
		});
  })();

</script>