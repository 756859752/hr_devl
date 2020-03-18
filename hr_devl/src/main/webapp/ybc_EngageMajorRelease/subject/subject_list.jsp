<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>My JSP 'resume-list.jsp' starting page</title>
	 <link rel="stylesheet"
			href="${pageContext.request.contextPath}/css/table.css" type="text/css">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/css/cwcalendar.css" type="text/css">
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/javascript/comm/comm.js">
		</script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/javascript/comm/list.js">
		</script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/javascript/calendar-ch.js">
		</script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/javascript/jquery-1.7.2.js">
		</script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/javascript/locate.js">
		</script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/javascript/select.js">
		</script>
	  </head>
	<body>
		<form method="post" name="fm" action="/HR_Fist/recruit/recruitAction!toResumeList?a=list">
		<input type="hidden" name="utilBean.currPage" id="page"/>
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--招聘管理--招聘考试题库管理--试题查询-试题查询结果
						</font>
					</td>
				</tr>
			  <tr>
					<td align="right"> 
						<input type="button" value="返回" class="BUTTON_STYLE1" onclick="history.back()">
					</td>
				</tr>
			</table> 
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="40%" class="TD_STYLE1" >
						题干
					</td>
					<td width="10%" class="TD_STYLE1">
						试题I级分类
					</td>
					<td width="10%" class="TD_STYLE1">
						试题II级分类
					</td>
					<td width="5%" class="TD_STYLE1">
						登记人
					</td>
					<td width="20%" class="TD_STYLE1">
						登记日期
					</td>
					<td width="10%" class="TD_STYLE1">
						出处
					</td>
					<td width="5%" class="TD_STYLE1">
						正确答案
					</td>
				</tr>
				<c:forEach items="${slist}" var="sl">
					<tr>
						<td class="TD_STYLE2" style="color:blue">
							${sl.content}
						</td>
						<td class="TD_STYLE2">
							${sl.firstKindName}
						</td>
						<td class="TD_STYLE2">
							${sl.secondKindName}
						</td>
						<td class="TD_STYLE2">
						${sl.register}
						</td>
						<td class="TD_STYLE2">
						${sl.registTime}
						</td>
						<td class="TD_STYLE2">
						${sl.derivation}
						</td>
						<td class="TD_STYLE2">
						${sl.correctKey}
						</td>
					</tr>
				</c:forEach>
				
			</table>
		</form>
		<script type="text/javascript">
		function up(currPage,row){  
		if(currPage<=0){
		document.getElementById("page").value = row;
		}else{
		document.getElementById("page").value =currPage; 
		}
		 document.fm.submit();
		}
		function down(currPage,row){ 
		if(currPage>=row){
		document.getElementById("page").value = row;
		}else{
		document.getElementById("page").value =currPage; 
		}
		 document.fm.submit();
		}
		function tj(row){
	     document.getElementById("page").value = document.getElementById("currPage").value;
	     if(document.getElementById("currPage").value>row){
	     alert("最大页数为"+row+",当前为第"+row+"页 ");
	     return false;
	     }
	     document.fm.submit();
	 	}
		</script>
	</body>
</html>