<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <base href="<%=basePath%>">
    
    <title>My JSP 'exam_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/css/table.css" type="text/css">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/css/cwcalendar.css"
			type="text/css">
			<script type="text/javascript">
				function goexamregister(){
					location.href="ybcexam/examRegisterSelect.do";
				}
			
			</script>
  </head>
  
  <body>
   	<form method="post" action="/HR_Fist/recruit/recruitAction!findInterviewByUtilBean?str=list" name="fm">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--招聘管理--招聘考试管理--考试出题 </font>
					</td>
				</tr>
			  <tr>
					<td align="right"> 
						<input type="button" value="返回" class="BUTTON_STYLE1" onclick="history.back();">
						<input type="button" value="出题" class="BUTTON_STYLE1" onclick="goexamregister();">
					</td>
				</tr>
			</table> 
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="10%" class="TD_STYLE1">
						职位分类编号
					</td>
					<td width="15%" class="TD_STYLE1">
						职位分类名称
					</td>
					<td width="15%" class="TD_STYLE1">
						职位编号
					</td>
					<td width="20%" class="TD_STYLE1">
						职位名称
					</td>
					<td width="15%" class="TD_STYLE1">
						套题数量
					</td>
					<td width="10%" class="TD_STYLE1">
						出题
					</td>
				</tr>
				<c:forEach items="${resultlist}" var="re">
					<tr>
						<td class="TD_STYLE2">
								${re.majorKindId}
						</td>
						<td class="TD_STYLE2">
								${re.majorKindName}
						</td>
						<td class="TD_STYLE2">
								${re.majorId}
						</td>
						<td class="TD_STYLE2">
								${re.majorName}
						</td>
						<td class="TD_STYLE2">
								${re.amout}
						</td>
						<td class="TD_STYLE2">
								<a href="ybcexam/examRegisterSelect.do?majorKindId=${re.majorKindId}&majorKindName=${re.majorKindName}&majorId=${re.majorId}&majorname=${re.majorName}" >出题</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</form>
  </body>
</html>
