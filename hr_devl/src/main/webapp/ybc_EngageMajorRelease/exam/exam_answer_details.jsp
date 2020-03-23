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
		<script type="text/javascript">
			function  mysubmit() {
				document.fm.submit();
			}
		</script>
  </head>
  
  <body>
  <form method="post" name="fm" action="ybcexam/answersSubmit.do">
   <table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--招聘管理--招聘考试管理--考试答题
						</font>
					</td>
				</tr>
			 <input type="button" value="返回" class="BUTTON_STYLE1" onclick="history.back();">
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td class="TD_STYLE1" width="20%">
						考试编号
					</td>
					<td class="TD_STYLE2" width="30%">
					<input type="hidden" name="examNumber" value="${ex.examNumber}">
						${ex.examNumber }
					</td>
					<td class="TD_STYLE1" width="20%">
						答题用时
					</td>
					<td class="TD_STYLE2" width="30%">
						${ex.useTime}
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1" width="20%">
						姓名
					</td>
					<td class="TD_STYLE2" width="30%">
						${ex.humanName }
					</td>
					<td class="TD_STYLE1" width="20%">
						身份证号码
					</td>
					<td class="TD_STYLE2" width="30%">
						${ex.humanIdcard }
					</td>
				</tr>
				<c:forEach items="${slist }" var="s" varStatus="it">
					<tr>
						<td class="TD_STYLE1" width="100%" colspan="4">
							${s.engageSubjects.firstKindName }
						</td>
					</tr>
						<tr>
							<td class="TD_STYLE2" width="100%" colspan="4">
								<div >
									${it.index+1 }.${s.engageSubjects.content }<br/>
									a.${s.engageSubjects.keyA }
									b.${s.engageSubjects.keyB }
									c.${s.engageSubjects.keyC }
									d.${s.engageSubjects.keyD }
									e.${s.engageSubjects.keyE }<br/>
									正确答案${s.engageSubjects.correctKey } 
									<p style="color:red;margin:0px;">
										应试者答案：
										<c:if test="${s.answer==null }"> 
											没有选择
										</c:if>
										${s.answer }
									</p>
								</div>
							</td>
						</tr>
				</c:forEach>
				
			</table>
  </form>
  </body>
</html>
