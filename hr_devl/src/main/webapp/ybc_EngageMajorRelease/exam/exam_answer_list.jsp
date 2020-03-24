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
    
    <title>My JSP 'exam_answer_list.jsp' starting page</title>
    
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
			<script type="text/javascript"
			src="${pageContext.request.contextPath}/javascript/jquery-1.7.2.js">
		</script>
  </head>
  
  <body>
    <form id="recruitAction!findEngageResume?a=list" name="resumeChooseForm" action="ybcexam/checkTheAnswerDetailselect.do" method="post">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--招聘管理--招聘考试管理--成绩查询筛选--考试结果 </font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="submit" value="返回" class="BUTTON_STYLE1"
							onclick= "history.back();">
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="20%" class="TD_STYLE1">
						考试编号
					</td>
					<td width="10%" class="TD_STYLE1">
						姓名
					</td>
					<td width="20%" class="TD_STYLE1">
						职位分类
					</td>
					<td width="10%" class="TD_STYLE1">
						职位名称
					</td>
					<td width="10%" class="TD_STYLE1">
						考试用时
					</td>
					<td width="10%" class="TD_STYLE1">
						考试分数
					</td>
					<td width="10%" class="TD_STYLE1">
						阅卷
					</td>
					<td width="10%" class="TD_STYLE1">
						筛选状态
					</td>
				</tr>
				<c:forEach items="${resultList}" var="re">
					<tr>
						<td class="TD_STYLE2">
								${re.answerNumber}
						</td>
						<td class="TD_STYLE2">
							${re.humanName}
						</td>
						<td class="TD_STYLE2">
							${re.majorKindName}
						</td>
						<td class="TD_STYLE2">
						${re.majorName}
						</td>
						<td class="TD_STYLE2">
						${re.useTime}
						</td>
						<td class="TD_STYLE2">
						${re.totalPoint}
						</td>
						<td class="TD_STYLE2">
							<a href="ybcexam/checkTheAnswerDetails.do?ansId=${re.ansId}">阅卷</a>
						</td>
						<td class="TD_STYLE2">
						<c:if test="${re.testStatus==2 }">
							<a href="ybcexam/AnswerDetailstoShaixuan.do?ansId=${re.ansId}">筛选</a>
						</c:if>
						<c:if test="${re.testStatus==1 }">
							等待考试
						</c:if>
						</td>
					</tr>
				</c:forEach>
			</table>
		</form>
  </body>
</html>
