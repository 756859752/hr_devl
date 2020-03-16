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
				<c:forEach items="${sglist}" var="s">
					<tr class="TD_STYLE2">
						<td name="sgid">
							${s.salary_grant_id }
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
						<td>
						<c:if test="${s.check_status == 1}"><span><a href="queryBysgidr?sid=${s.check_status }" ">复核</a></span></c:if> 
					    <c:if test="${s.check_status == 2}"><span><a href="queryBysgidr?sid=${s.check_status }" ">已复核</a></span></c:if> 
						</td>
					</tr>
				  </c:forEach>
			</table>	
		</form>
	</body>
</html>
