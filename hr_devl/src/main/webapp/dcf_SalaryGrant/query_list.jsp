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
		td{text-align: center}
		-->
		</style>
	</head>

	<body>
	<form action="toqueryall">
			<table width="100%">
				<tr>
					<td style="text-align:left;">
						<font color="black">您正在做的业务是:人力资源管理--薪酬发放管理--薪酬发放查询</font>
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						
					</td>
				</tr>
			</table>
			
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="20%" class="TD_STYLE1">
						<span>薪酬编号</span>
					</td>
					<td width="15%" class="TD_STYLE1">
						<span>I级机构名称</span>
					</td>
					<td width="15%" class="TD_STYLE1">
						<span>II级机构名称</span>
					</td>
					<td width="15%" class="TD_STYLE1">
						<span>III级机构名称</span>
					</td>
					<td width="10%" class="TD_STYLE1">
						<span>人数</span>
					</td>
					<td width="20%" class="TD_STYLE1">
						基本薪酬总额(元)
					</td>
				
				</tr>
				
				<c:forEach items="${slist}" var="s">
					<tr class="TD_STYLE2">
						<td>
						<a  href="toqueryall?sid=${s.check_status}">${s.salary_grant_id}</a>	
						</td>
						<td>
							${s.first_kind_name }
						</td>
						<td>
							${s.second_kind_name }
						</td>
						<td>
							${s.third_kind_name }
						</td>
						<td>
							${s.human_amount }
						</td>
						<td>
							${s.salary_standard_sum }
						</td>
						 
					</tr>
				
					</c:forEach>
					
				 			
			</table>
			
			

 
			
			
			
			</form>
				 

	</body>
</html>