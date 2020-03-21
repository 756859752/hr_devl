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
    
    <title>My JSP 'exam_answer.jsp' starting page</title>
    
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
			<script type="text/javascript">
					function queryMajor(){
					var mid = $("#majorKind").val();
					var majorSelect = $("#majorId");
					var majorkindname = $("#majorkind_"+mid).html();
					 $("#majorKindName").val(majorkindname);
					majorSelect.empty();
					majorSelect.append("<option value=''>--请选择--</option>");
					if(mid != 0){
						$.ajax({
							url:'ybcresume/engageresumefinmajorinajax.do?mid='+mid,
							type:'get',
							success:function(data){
					 			for(var i=0;i<data.length;i++){
									var eachMajor = data[i];
									majorSelect.append("<option id='major_"+eachMajor.majorId+"' value="+eachMajor.majorId+">"+eachMajor.majorName+"</option>");
									
								}
					 			}
						});
					}
		 	 	}
		
		 	 	function getMajorName(){
		 	 	 	var mid =  $("#majorId").val();
		 	 		var majorkindname = $("#major_"+mid).html();
					 $("#majorName").val(majorkindname);
		 	 	}
		 	 	function  mysubmit() {
					document.fm.submit();
				}
			</script>
  </head>
  
  <body>
   <form method="post" name="fm" action="ybcexam/examStartPeopleMassge.do">
   
   <input type="hidden" id="majorName" name="majorName" >
   <input type="hidden" id="majorKindName" name="majorKindName" >
   <table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--招聘管理--招聘考试管理--考试答题
						</font>
					</td>
				</tr>
			 <input type="button" value="开始答题" class="BUTTON_STYLE1" onclick="mysubmit()">
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td class="TD_STYLE1" width="10%">
						姓名
					</td>
					<td class="TD_STYLE2" width="20%">
						<input type="text"  name="humanName" id="name" class="INPUT_STYLE2" value="${user.user_true_name}"/>
					</td>
					<td class="TD_STYLE2" width="20%">
						
					</td>
					<td class="TD_STYLE1" width="10%">
						身份证
					</td>
					<td class="TD_STYLE2" width="20%">
						<input type="text"  name="humanIdcard" id="name" class="INPUT_STYLE2" value="${user.user_true_name}"/>
					</td>
					<td class="TD_STYLE2" width="20%">
						
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1" width="10%">
						职位分类名称
					</td>
					<td class="TD_STYLE2" width="20%">
						<select name="majorKindId" class="SELECT_STYLE1" id="majorKind" onchange="queryMajor()">
							<option value="">--请选择--</option>
							<c:forEach items="${mklist}" var="m">
								<option  id="majorkind_${m.majorKindId }" value="${m.majorKindId }">${m.majorKindName }</option>
							</c:forEach>
						</select>		
					</td>
					<td class="TD_STYLE2" width="20%">
						
					</td>
					<td class="TD_STYLE1" width="10%">
						职位名称
					</td>
					<td class="TD_STYLE2" width="20%">
						<select name="majorId" class="SELECT_STYLE1" id="majorId" onchange="getMajorName()">
							<option value="">--请选择--</option>
						</select>
					</td>
					<td class="TD_STYLE2" width="20%">
						
					</td>
				</tr>
			</table>
   </form>
  </body>
</html>
