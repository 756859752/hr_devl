<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="/hr_devl/css/table.css" type="text/css" />
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
						<font color="black">您正在做的业务是:人力资源管理--薪酬发放管理--薪酬发放详情</font>
						<br><br><br>
					</td>
				</tr>
				 
				 <tr>
					<td colspan="2" style="text-align: left" >
					薪酬单编号：${salarygrant.salaryGrantId}
					<input type="hidden" name="salarygrant.salaryGrantId" value="${salarygrant.salaryGrantId}">
					</td>	
					</tr>
				<tr>
					<td colspan="2" style="text-align: left">
					机构：
					</td>					
				</tr>
				<tr>
					<td style="text-align: left">
					本机构总人数:${salarygrant.humanAmount }
					 	，基本薪酬总数:${salarygrant.salaryStandardSum } 
					，实发总额:<span id="salarySum_sum">${salarygrant.salaryPaidSum }</span>
					 
					</td>
					<td   style="text-align: right">				 
						登记人:${salarygrant.register } 　
						登记时间：${salarygrant.registTime} 　	 
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
				    <input type="hidden" name="salaryGrant.salaryGrantId" value="${salarygrant.salaryGrantId}">
				 	<input type="hidden" id="salaryStandardSum1" name="salarygrant[0].salaryStandardSum" value="${salarygrant.salaryStandardSum }"/>
					<c:forEach items="${show}" var="s" varStatus="vs">
				     <input type="hidden" name="grantDetails[${vs.index }].grdId" value="${s.sgd.grdId}">
					<input type="hidden" name="grantDetails[${vs.index }].salaryGrantId" value="${salarygrant.salaryGrantId}">
				 	<input type="hidden" id="salaryStandardSum${vs.count }" name="grantDetails[${vs.index }].salaryStandardSum" value=""/>
				 	<tr class="TD_STYLE2">	
						<td class="TD_STYLE1">
							${vs.count}
						</td>
						<td class="TD_STYLE1">${s.sgd.humanId }<input type="hidden" name="grantDetails[${vs.index}].humanId" value="${s.sgd.humanId }"></td>
						<td class="TD_STYLE1">${s.sgd.humanName}<input type="hidden" name="grantDetails[${vs.index}].humanName" value="${s.sgd.humanName}"></td>
						<c:forEach items="${s.list}" var="i">
						   <td class="TD_STYLE1" width="7%">${i.salary}</td>
						</c:forEach>
						<c:forEach items="${salmoney}" var="m">
						<td class="TD_STYLE1">
							<input type="text" name="grantDetails[${vs.index}].bounsSum"  id="bounsSum${vs.count }" readonly="readonly" onkeyup="onKeyPress('${vs.count }')"  class="INPUT_STYLE2" value="${m.bounsSum}" />
						</td>
						<td class="TD_STYLE1">
							<input type="text" name="grantDetails[${vs.index}].saleSum"   id="saleSum${vs.count }" readonly="readonly" onkeyup="onKeyPress('${vs.count }')" class="INPUT_STYLE2" value="${m.saleSum}"/>
						</td>
						<td class="TD_STYLE1">
							<input type="text" name="grantDetails[${vs.index}].deductSum"   id="deductSum${vs.count }" readonly="readonly" onkeyup="onKeyPress('${vs.count }')" class="INPUT_STYLE2" value="${m.deductSum}"/>
						</td>
						<td class="TD_STYLE1">
							<input type="text" name="grantDetails[${vs.index}].salaryPaidSum" readonly="readonly"  id="salaryPaidSum${vs.count }" value="${m.salaryPaidSum}"  class="INPUT_STYLE2" />
						</td>	
						</c:forEach>
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
