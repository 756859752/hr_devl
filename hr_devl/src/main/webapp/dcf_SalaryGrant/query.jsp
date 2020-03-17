<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="css/table.css" type="text/css" />
		<title>无标题文档</title>
		<style type="text/css">
		<!--
		.style3 {color: #0000CC}
		td{text-align: center;}
		-->
		</style>
	</head>

	<body>
		<form method="post" action="salaryGrantAction.do?methodName=doSeatchSalaryGrant">
			<table width="100%">
				<tr>
					<td style="text-align: left">
						<font color="black">您正在做的业务是:人力资源管理--薪酬发放管理--薪酬发放复核</font>
						<br><br><br>
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
					 	，基本薪酬总数:${summap.salaryall } 
					，实发总额:<span id="salarySum_sum">${summap.salarypall }</span>
					 
					</td>
					<td   style="text-align: right">
					 
						登记人:${userlogin.user_true_name } 　
						登记时间： 2012年11月24日
						 
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
						
					<td class="TD_STYLE1">
						奖励金额
					</td>
					<td class="TD_STYLE1">
						销售绩效总额
					</td>
					<td class="TD_STYLE1">
						应扣金额
					</td>
					<td class="TD_STYLE1">
						实发金额
					</td>
					
				</tr>
				<input type="hidden" name="grantDetails[0].salaryGrantId" value="HS1353753198460">
				 	<input type="hidden" id="salaryStandardSum1" name="grantDetails[0].salaryStandardSum" value="1332.0"/>
					<c:forEach items="${sgdlist}" var="s" varStatus="vs">
					
					<tr class="TD_STYLE2">
					
						<td>
							${s.s_m_id }
						</td>
						<td>
							${s.human_id }
							 	</td>
						<td>
							${s.human_name }	
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
						 0.0 
						</td>
						<td>
						 0.0 
						</td>
						<td>
							 0.0  
						</td>
						<td>
						 ${s.salary_paid_sum } 
						</td>
						
					</tr>	
					</c:forEach>
					
					 
				
			</table>
			<br>
			<center>
			<input type="button" style="width: 200;height: 50;font-size: 20px;font-weight: bold;border-bottom-style: ridge;cursor: pointer" onclick="javascript:window.history.back();" value="返 回">
		
			</center>
				
		</form>
	</body>
</html>
