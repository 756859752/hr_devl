<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'exam_answer_start.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
  <form method="post" name="fm" action="ybcexam/examStartPeopleMassge.do">
   <table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--招聘管理--招聘考试管理--考试答题
						</font>
					</td>
				</tr>
			 <input type="button" value="提交试卷" class="BUTTON_STYLE1" onclick="mysubmit()">
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td class="TD_STYLE1" width="20%">
						考试编号
					</td>
					<td class="TD_STYLE2" width="30%">
						${ex.examNumber }
					</td>
					<td class="TD_STYLE1" width="20%">
						试题数量
					</td>
					<td class="TD_STYLE2" width="30%">
						${ex.amout }
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1" width="20%">
						姓名
					</td>
					<td class="TD_STYLE2" width="30%">
						${re.humanName }
					</td>
					<td class="TD_STYLE1" width="20%">
						试题数量
					</td>
					<td class="TD_STYLE2" width="30%">
						${re.humanIdcard }
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1" width="20%">
						考试限时
					</td>
					<td class="TD_STYLE2" width="30%">
						${ex.limiteTime }
					</td>
					<td class="TD_STYLE1" width="20%">
						当前用时
					</td>
					<td class="TD_STYLE2" width="30%">
						${ex.humanIdcard }
					</td>
				</tr>
			
			</table>
  </form>
  </body>
</html>
