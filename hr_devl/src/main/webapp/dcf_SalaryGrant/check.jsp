<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="../css/table.css" type="text/css" />
		<title>无标题文档</title>
		<style type="text/css">
		<!--
		.style3 {color: #0000CC}
		td{text-align: center;}
		-->
		</style>
 <script type="text/javascript" src="javascript/jquery-1.7.2.js">	
</script>
			<script type="text/javascript" src="javascript/jquery.messager.js"></script>
	</head>

	<body>
		<form method="post" action="tocheck">
			<table width="100%">
				<tr>
					<td style="text-align:left;">
						<font color="black">您正在做的业务是:人力资源管理--薪酬发放管理--薪酬发放复核</font>
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: right"  >
						<input type="submit" value="复核通过"   class="BUTTON_STYLE1">	　					
						<input type="button" value="返 回" onclick="location.href='check_list'" class="BUTTON_STYLE1">
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: left" >
					薪酬单编号：${sid}
					<input type="hidden" name="salaryGrant.salaryGrantId" value="HS1353753198460">
					</td>					
				</tr>
				<tr>
					<td colspan="2" style="text-align: left">
					机构：
				     <c:if test="${sid == 1}"><span>Ⅰ级机构名称</span></c:if> 
					<c:if test="${sid == 2}"><span>II级机构名称</span></c:if> 
					<c:if test="${sid == 3}"><span>III级机构名称</span></c:if> 
					
					</td>					
				</tr>
				<tr>
					<td style="text-align: left">
					本机构总人数:${count }
					<input type="hidden" name="salaryGrant.humanAmount" value="5">
					基本薪酬总数:${summap.salaryall }<input type="hidden" name="salaryGrant.salaryStandardSum" value="${summap.salaryall }"/>
					实发总额:<span id="salarySum_sum">${summap.salarypall }</span>
					<input type="hidden" id="salaryPaidSum" name="salaryGrant.salaryPaidSum" value="${summap.salarypall }"/>
					<input type="hidden"  name="salaryGrant.register" value="better_admin"/>
					<input type="hidden"  name="salaryGrant.registTime" value="2012-11-24 18:33:46.0"/>
					</td>
					<td   style="text-align: right">
					 
						复核人:<input type="text" name="salaryGrant.checker" value="${userlogin.user_true_name }" size="8" readonly="readonly">
						复核时间：<span id="Tdate"></span>
						<input type="hidden" name="salaryGrant.checkTime" id="Tdate2" >
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td class="TD_STYLE1">
						<span>序号</span>
					</td>
					<td class="TD_STYLE1">
						<span>档案编号</span>
					</td>
					<td class="TD_STYLE1">
						<span>姓名</span>
					</td>
					
						<td class="TD_STYLE1">
							出差补助
						</td>		
						
						<td class="TD_STYLE1">
							交通补贴
						</td>		
						
						<td class="TD_STYLE1">
							住房补贴
						</td>		
						
						<td class="TD_STYLE1">
							基本工资
						</td>		
						
						<td class="TD_STYLE1">
							年终奖
						</td>		
						
						<td class="TD_STYLE1">
							误餐补助
						</td>		
							
					<td class="TD_STYLE1" width="7%">
						奖励金额
					</td>
					<td class="TD_STYLE1" width="7%">
						销售绩效总额
					</td>
					<td class="TD_STYLE1" width="7%">
						应扣金额
					</td>
					<td class="TD_STYLE1" width="7%">
						实发金额
					</td>
					
				</tr>	
				   <c:forEach items="${sgdlist}" var="s" varStatus="vs">
					<input type="hidden" name="grantDetails[${vs.index }].salaryGrantId" value="${s.salary_grant_id }">
				 	<input type="hidden" id="salaryStandardSum${vs.count }" name="grantDetails[${vs.index }].salaryStandardSum" value="${s.salary_paid_sum }"/>
					
					<tr class="TD_STYLE2">
					
						<td>
							${s.s_m_id }
						</td>
						<td>
							${s.human_id }
								<input type="hidden" name="grantDetails[${vs.index }].humanId"  value="${s.human_id }"/>							
						</td>
						<td>
							${s.human_name }	
							<input type="hidden" name="grantDetails[${vs.index }].humanName"  value="${s.human_name }"/>
						</td>
							 
							 
											
						<td> 							
							${s.mission }
						</td>
						
						<td> 							
							${s.travel }
						</td>
										
						<td> 							
							${s.housing }
						</td>
											
						<td> 							
							${s.base }
						</td>
											
						<td> 							
							${s.bonus }
						</td>
						 <td> 							
							${s.meal }
						</td>
						 		
						
										
						<td>
							<input type="text" name="grantDetails[${vs.index }].bounsSum" id="bounsSum${vs.count}" value=""  onkeyup="onKeyPress('${vs.count}')"  class="INPUT_STYLE2" />
						</td>
						<td>
							<input type="text" name="grantDetails[${vs.index }].saleSum" id="saleSum${vs.count}"  value=""  onkeyup="onKeyPress('${vs.count}')" class="INPUT_STYLE2"/>
						</td>
						<td>
							<input type="text" name="grantDetails[${vs.index }].deductSum" id="deductSum${vs.count}" value=""  onkeyup="onKeyPress('${vs.count}')" class="INPUT_STYLE2"/>
						</td>
						<td>
							<input type="text" name="grantDetails[${vs.index }].salaryPaidSum" readonly="readonly" value="${s.salary_paid_sum }"   id="salaryPaidSum${vs.count}"   class="INPUT_STYLE2"/>
						</td>
						
					</tr>	
					</c:forEach>
			</table>							
		</form>
		<SCRIPT type="text/javascript">
		 
		function onKeyPress(i){
		
		var size=4;
		var bounsSum=document.getElementById("bounsSum"+i);
		var saleSum =document.getElementById("saleSum"+i);
		var deductSum=document.getElementById("deductSum"+i);
		var salaryPaidSum=document.getElementById("salaryPaidSum"+i);
		if (isNaN(bounsSum.value) || bounsSum.value < 0) {
			$.messager.show("消息提示","金额填写错误!",2000);
		bounsSum.value="0.00";
		return;
	} 
		if (isNaN(saleSum.value) || saleSum.value < 0) {
			$.messager.show("消息提示","金额填写错误!",2000);
		saleSum.value="0.00";
		return;
	} 
		if (isNaN(deductSum.value) || deductSum.value < 0) {
			$.messager.show("消息提示","金额填写错误!",2000);
		deductSum.value="0.00";
		return;
	} 
		salaryPaidSum.value=Number(bounsSum.value)+Number(saleSum.value)-Number(deductSum.value)+Number(document.getElementById("salaryStandardSum"+i).value);
		
		var sum=0;
		for(var j=1;j<=size;j++){
			sum=Number(sum)+Number(document.getElementById("salaryPaidSum"+j).value);
		}
	 		 document.getElementById("salarySum_sum").innerHTML=sum;
	 		  document.getElementById("salaryPaidSum").value=sum;	 
		
		}



		function time(){
 					var tdate=document.getElementById("Tdate");					 
 					var d=new Date();
 					var y=d.getFullYear();
 					var moth=d.getMonth()+1;
 					var date=d.getDate();
 					var h=d.getHours();
 					var m=d.getMinutes();
 					var s=d.getSeconds();
					var hh=20-1-h;
					var mm=60-1-m;
					var ss=60-s;
					if(hh>0){
							mm=mm+60*hh;
					}
 					if(moth<10){
 							moth="0"+moth;
 					}
 					if(date<10){
 							date="0"+date;
 					}
 					if(h<10){
 							h="0"+h;
 					}
 					if(m<10){
 							m="0"+m;
 					}
 					if(s<10){
 							s="0"+s;
 					}
 					if(mm<10){
 							mm="0"+mm;
 					}
 					if(ss<10){
 							ss="0"+ss;
 					}	
 					 
 					tdate.innerHTML=y+"-"+moth+"-"+date+" "+h+":"+m+":"+s;
					 document.getElementById("Tdate2").value=tdate.innerHTML;
 				}
 				window.onload=time;
 				var out=window.setInterval(time, 1000);
		</SCRIPT>
	</body>
</html>


