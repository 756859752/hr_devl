<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>		
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="/hr_devl/css/table.css"
			type="text/css"></link>
			
	</head>
	<body >
			<font color="black"> 您在做的业务是-人力资源-调动管理-调动查询列表 </font>
			<br/><br/><br/>			

			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr height="21">
					<td width="19%" class="TD_STYLE1">
						I级机构
					</td>
					<td width="19%" class="TD_STYLE1">
						II级机构
					</td>
					<td width="19%" class="TD_STYLE1">
						Ⅲ级机构
					</td>
					<td width="19%" class="TD_STYLE1">
						薪酬标准
					</td>
					<td width="19%" class="TD_STYLE1">
						名字
					</td>
					<td width="5%" class="TD_STYLE1">
						查看

					</td>
				<c:forEach items="${list}" var="i">
				<tr height="21">
						<td class="TD_STYLE2">
						${i.firstKindName}
						</td>
						<td class="TD_STYLE2">
						${i.secondKindName}
						</td>
						<td class="TD_STYLE2">
						${i.thirdKindName}
						</td>
						<td class="TD_STYLE2">
						${i.salaryStandardName}
						</td>
						<td class="TD_STYLE2">
						 ${i.humanName }
						</td>
						<td class="TD_STYLE2">
							<a href="/hr_devl/dcf/transfer/queryonechangeinfo/${i.mchId}.do">
							查看</a>
						</td>
					</tr>
				</c:forEach>	
			</table>
			<br>
			<br>
	</body>
</html>