<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>My JSP 'filter_result.jsp' starting page</title>
 	  <link rel="stylesheet"
			href="css/table.css" type="text/css">
		<link rel="stylesheet"
			href="css/cwcalendar.css"
			type="text/css">
		<script type="text/javascript"
			src="javascript/comm/comm.js">
	
</script>
		<script type="text/javascript"
			src="javascript/comm/list.js">
	
</script>
		<script type="text/javascript"
			src="javascript/calendar-ch.js">
	
</script>
		<script type="text/javascript"
			src="javascript/jquery-1.7.2.js">
	
</script>
		<script type="text/javascript"
			src="javascript/locate.js">
	
</script>
		<script type="text/javascript"
			src="javascript/select.js">
	
</script> 
	 
     </head>

	<body>
	<form method="post" name="fm" action="/HR_Fist/recruit/recruitAction!list">
		<input type="hidden" name="utilBean.currPage" id="page"/>
		<table width="100%">
			<tr>
				<td>
					<font color="black">您正在做的业务是：人力资源--招聘管理--录用管理--录用查询  </font>
				</td>
			</tr>
		</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr class="TR_STYLE1">
					<td class="TD_STYLE1">
						姓名
					</td>
					<td class="TD_STYLE1">
						性别
					</td>
					<td class="TD_STYLE1">
						年龄
					</td>
					<td class="TD_STYLE1">
						职位类别
					</td>
					<td class="TD_STYLE1">
						职位名称
					</td>
					<td class="TD_STYLE1">
						毕业院校
					</td>
					<td class="TD_STYLE1">
						学历专业
					</td>
					<td class="TD_STYLE1">
						电子邮箱
					</td>
					<td class="TD_STYLE1">
						查询
					</td>
				</tr>
				<c:forEach items="${vlist}" var="v">
					<tr class="TR_STYLE1">
						<td class="TD_STYLE2">
							${v.humanname }
						</td>
						<td class="TD_STYLE2">
							${v.humansex }
						</td>
						<td class="TD_STYLE2">
							${v.humanage }
						</td>
						<td class="TD_STYLE2">
							${v.humanmajorkindname }
						</td>
						<td class="TD_STYLE2">
							${v.humanmajorname }
						</td>
						<td class="TD_STYLE2">
							${v.humancollege }
						</td>
						<td class="TD_STYLE2">
							${v.humaneducatedmajor }
						</td>
						<td class="TD_STYLE2">
						<c:if test="${v.viewnotice == 1}"><a href="toSendmail?resid=${v.resid}">${v.humanemail}</a></c:if>
						<c:if test="${v.viewnotice == 2}">已通知</c:if>
						</td>
						<td class="TD_STYLE2">
							<a href="toCheck?einid=${v.resId }">查询</a>
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