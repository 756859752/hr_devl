<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>My JSP 'sift-list.jsp' starting page</title>
    
	<link rel="stylesheet"
			href="${pageContext.request.contextPath}/css/table.css" type="text/css">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/css/cwcalendar.css"
			type="text/css">
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
		<form method="post" name="fm" action="/HR_Fist/recruit/recruitAction!toSiftList?str=sift">
				<input type="hidden" name="utilBean.currPage" id="page"/>
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--招聘管理--面试管理--面试筛选--面试结果列表 
						</font>
					</td>
				</tr>
			  <tr>
					<td align="right"> 
						<input type="button" value="返回" class="BUTTON_STYLE1" onclick="history.back();">
					</td>
				</tr>
			</table> 
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="10%" class="TD_STYLE1">
						档案编号
					</td>
					<td width="10%" class="TD_STYLE1">
						姓名
					</td>
					<td width="15%" class="TD_STYLE1">
						职位分类
					</td>
					<td width="15%" class="TD_STYLE1">
						职位名称
					</td>
					<td width="10%" class="TD_STYLE1">
						面试次数
					</td>
					<td width="10%" class="TD_STYLE1">
						面试时间
					</td>
					<td width="10%" class="TD_STYLE1">
						综合素质
					</td>
					<td width="10%" class="TD_STYLE1">
						筛选
					</td>
				</tr>
				<c:forEach items="${vlist}" var="v">
					<tr>
						<td class="TD_STYLE2">
							${v.einId }
						</td>
						<td class="TD_STYLE2">
							${v.humanName }
						</td>
						<td class="TD_STYLE2">
							${v.humanMajorKindName }
						</td>
						<td class="TD_STYLE2">
						    ${v.humanMajorName }
						</td>
						<td class="TD_STYLE2">
							${v.interviewAmount }
						</td>
						<td class="TD_STYLE2">
							${v.registeTime }
						</td>
						<td class="TD_STYLE2">
							${v.multiQualityDegree }
						</td>
						<td class="TD_STYLE2">
						<c:if test="${v.interviewStatus==3 }">
							待笔试
						</c:if>
						<c:if test="${v.interviewStatus!=3 }">
							<a href="interviewResultShaixuanStart.do?einId=${v.einId }">筛选</a>
						</c:if>
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
  