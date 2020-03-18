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
    
    <title>My JSP 'exam_register.jsp' starting page</title>
    
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
			href="${pageContext.request.contextPath}/css/cwcalendar.css" type="text/css">
		
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/javascript/jquery-1.7.2.js">
		</script>
		<script type="text/javascript">
			window.onload=check;
		function tick() {
			var now = new Date();
			var hours, minutes, seconds, noon;
			var intHours, intMinutes, intSeconds;
			intHours = now.getHours();
			intMinutes = now.getMinutes();
			intSeconds = now.getSeconds();
			if (intHours < 24) {
				hours = intHours+":";
				noon = "A.M.";
			} else {
				intHours = intHours - 24;
				hours = intHours + ":";
				noon = "P.M.";
			}
			if (intMinutes < 10) {
				minutes = "0"+intMinutes+":";
			} else {
				minutes = intMinutes+":";
			}
			if (intSeconds < 10) {
				seconds = "0"+intSeconds+" ";
			} else {
				seconds = intSeconds+" ";
			}
			timeString = hours+minutes+seconds;
			var now = new Date();
		  	document.getElementById("nowTime").value=now.getFullYear()+"-"+(now.getMonth()+1)+"-"+now.getDate()+" "+timeString;
			window.setTimeout("tick();", 1000);
		}
		
		//load事件
		function check(){
			//获得系统当前时间的方法
		  	tick();					
		}
			function queryMajor(){
			var mid = $("#majorKindId").val();
			var majorSelect = $("#majorId");
			var majorkindname = $("#majorKind_"+mid).html();
			 $("#majorKindName").val(majorkindname);
			majorSelect.empty();
			majorSelect.append("<option value=''>--请选择--</option>");
			if(mid != 0){
				$.ajax({
					url:'ybcexam/examRegisterMajorInAjax.do?mid='+mid,
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
		
		function search(){
			document.fm.submit();
		}
		</script>
  </head>
  
  <body>
   <form name="fm" method="post" action="ybcexam/examRegisterSubmit.do" >
   <input type="hidden" name="majorKindName" id="majorKindName">
   <input type="hidden" name="majorName" id="majorName">
   		<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--招聘管理--招聘考试管理--考试出题 </font>
					</td>
				</tr>
				<tr>
					<td align="right">
						 
						<input type="submit" value="提交"
							class="BUTTON_STYLE1" onclick="search();">
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td class="TD_STYLE1" width="10%">
						职位分类
					</td>
					<td  class="TD_STYLE2" width="15%">
					<select name="majorKindId" onchange="queryMajor()" multiple="multiple" id="majorKindId" 
					style="width: 290;height: 100" class="SELECT_STYLE3"> 
						<option value="0">--请选择--</option>
						<c:forEach items="${mlist}" var="ml">
							<option  value="${ml.majorKindId }" id="majorKind_${ml.majorKindId }">${ml.majorKindName }</option>
						</c:forEach>
					 </select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1" width="10%">
						职位名称
					</td>
					<td  class="TD_STYLE2" width="15%">
					<select name="majorId" onchange="getMajorName()" multiple="multiple" id="majorId" 
					style="width: 290;height: 100" class="SELECT_STYLE2"> 
						<option value="0">--请选择--</option>
					 </select>
					</td>
					<td class="TD_STYLE1" width="10%">
						登记人
					</td>
					<td class="TD_STYLE2" width="15%">
						<input type="text"  name="register" id="name" class="INPUT_STYLE2" value="${user.user_true_name}"/>
					</td>
					<td class="TD_STYLE1" width="10%">
						登记时间
					</td>
					<td class="TD_STYLE2" width="15%">
						 <input type="text" name="registTime"
							  id="nowTime" disabled="disabled"
							class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1" width="10%">
						答题限时
					</td>
					<td class="TD_STYLE2" width="15%">
						<input type="text"  name="limiteTime" id="name" class="INPUT_STYLE2"/>
					</td>
				</tr>
				
				<c:forEach items="${flist }" var="fl">
					<tr>
						<td class="TD_STYLE1" width="10%" rowspan="3">
							${fl.firstKindName }
						</td>
						<td class="TD_STYLE2" width="15%" colspan="3">
							试题II级分类
						</td>
						<td class="TD_STYLE2" width="15%" colspan="2">
							可用试题数
						</td>
						<td class="TD_STYLE2" width="15%" colspan="2">
							出题数量
						</td>
					</tr>
						<c:forEach items="${fl.seconds }" var="se" varStatus="i">
							<input type="hidden" name="examdetails[${h.index}].firstKindId" value="${fl.firstKindId}"/>
							<input type="hidden" name="examdetails[${h.index}].firstKindName" value="${fl.firstKindName}"/>
							<input type="hidden" name="examdetails[${h.index}].secondKindName" value="${se.secondKindName}"/>
							<input type="hidden" name="examdetails[${h.index}].secondKindId" value="${se.secondKindId}"/>
							<tr>
							
								<td class="TD_STYLE2" width="15%" colspan="3">
									${se.secondKindName}
								</td>
								<td class="TD_STYLE2" width="15%" colspan="2">
									${se.subjectsize} 
								</td>
								<td class="TD_STYLE2" width="15%" colspan="2">
									<input type="text"  name="examdetails[${h.index}].questionAmount" id="name" class="INPUT_STYLE2"/>
								</td>
							</tr>
						</c:forEach>
				</c:forEach>
				</table>
   </form>
  </body>
</html>
