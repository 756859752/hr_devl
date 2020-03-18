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
    
    <title>My JSP 'subject_register.jsp' starting page</title>
    
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
		
		function findscondkind(){//当第一个选择框改变
			var mid = $("#firstKindId").val();//n拿到选择的id
			var majorSelect = $("#secondKindId");//拿到第二个选择框
			var majorkindname = $("#firstKindId"+mid).html();//拿到一级分类名
			 $("#firstKindName").val(majorkindname);//改变隐藏域里的一级分类名值
			majorSelect.empty();
			majorSelect.append("<option value=''>--请选择--</option>");
			console.log("当前拿到的mid"+mid);
			if(mid != 0){
				$.ajax({
					url:'ybcexam/selectConfigQuestionSecondKindinAjax.do?mid='+mid,//ajax地址
					type:'get',
					success:function(data){
			 			for(var i=0;i<data.length;i++){
							var eachMajor = data[i];
							majorSelect.append("<option id='secondKindId_"+eachMajor.secondKindId+"' value='"+eachMajor.secondKindId+"'>"+eachMajor.secondKindName+"</option>");
							
						}
			 			}
				});
			}
		}
		function getsecondKindName(){//当第二个选择框改变时
 	 	 	var mid =  $("#secondKindId").val();//拿到选择的id
 	 		var majorkindname = $("#secondKindId_"+mid).html();//拿到对应的二级分类名
			 $("#secondKindName").val(majorkindname);//放进隐藏表单域中的二级分类名
 	 	}
 	 	function mysubmit(){
 	 		document.fm.submit();
 	 	}
		</script>
  </head>
  
  <body>
  <form id="myfm" name="fm" action="ybcexam/subjectRegisterSubmit.do" method="post">
   <table width="100%">
   			<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--招聘管理--招聘考试题库管理--试题登记 </font>
					 
					</td>
				</tr>
			<tr>
					<td align="right">
					 
						<input type="button" value="提交" class="BUTTON_STYLE1" onclick="mysubmit()">
						<input type="reset" value="清除" class="BUTTON_STYLE1">
					</td>
				</tr>
   </table>
   <table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td class="TD_STYLE1">
						试题一级分类
					</td>
					<td class="TD_STYLE2">  
					<input type="hidden" id="firstKindName" name="firstKindName">
					<select name="firstKindId" class="SELECT_STYLE1" id="firstKindId" onchange="findscondkind()">
						<option>--请选择--</option>
						<c:forEach items="${cqlist }" var="cq">
							<option id="firstKindId_${cq.firstKindId }" value="${cq.firstKindId}">${cq.firstKindName }</option>
						</c:forEach>
					</select>		
					</td>
					<td class="TD_STYLE1">
						试题二级级分类
					</td>
					<td class="TD_STYLE2">  
					<input type="hidden"  id ="secondKindName" name="secondKindName">
					<select name="secondKindId" class="SELECT_STYLE1" id="secondKindId" onchange="getsecondKindName()">
					<option>--请选择--</option>
					</select>
					<td class="TD_STYLE1">
						姓名
					</td>
					<td class="TD_STYLE2">
						 <input type="text"  name="humanName" id="name" class="INPUT_STYLE2"/>
					</td>
					<td class="TD_STYLE1">
						注册时间
					</td>
					<td class="TD_STYLE2">
						 <input type="text" name="registTime"
							  id="nowTime" disabled="disabled"
							class="INPUT_STYLE2">
					</td>
				</tr>
				<tr >
					<td class="TD_STYLE1" height="50px">
						题干
					</td>
					<td class="TD_STYLE2" colspan="7" >
						 <textarea name="content" rows="3" cols="3"   class="TEXTAREA_STYLE1" style="resize:none"></textarea>
					</td>
				</tr>
				<tr >
					<td class="TD_STYLE1" height="50px">
						答案a
					</td>
					<td class="TD_STYLE2" colspan="7" >
						 <textarea name="keyA" rows="3" cols="3"   class="TEXTAREA_STYLE1" style="resize:none"></textarea>
					</td>
				</tr>
				<tr >
					<td class="TD_STYLE1" height="50px">
						答案b
					</td>
					<td class="TD_STYLE2" colspan="7" >
						 <textarea name="keyB" rows="3" cols="3"   class="TEXTAREA_STYLE1" style="resize:none"></textarea>
					</td>
				</tr>
				<tr >
					<td class="TD_STYLE1" name="keyC" height="50px">
						答案c
					</td>
					<td class="TD_STYLE2" colspan="7" >
						 <textarea rows="3" name="keyc" cols="3"   class="TEXTAREA_STYLE1" style="resize:none"></textarea>
					</td>
				</tr>
				<tr >
					<td class="TD_STYLE1" height="50px">
						答案d
					</td>
					<td class="TD_STYLE2" colspan="7" >
						 <textarea name="keyD"  rows="3" cols="3"   class="TEXTAREA_STYLE1" style="resize:none"></textarea>
					</td>
				</tr>
				<tr >
					<td class="TD_STYLE1" height="50px">
						答案e
					</td>
					<td class="TD_STYLE2" colspan="7" >
						 <textarea name="keyE" rows="3" cols="3"   class="TEXTAREA_STYLE1" style="resize:none"></textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						正确答案
					</td>
					<td class="TD_STYLE2">
						 <input  type="text"  name="correctKey" id="name" class="INPUT_STYLE2"/>
					</td>
					<td class="TD_STYLE1">
						试题出处
					</td>
					<td class="TD_STYLE2">
						 <input type="text" name="derivation"   id="name" class="INPUT_STYLE2"/>
					</td>
					<td class="TD_STYLE1">
						
					</td>
					<td class="TD_STYLE2">
						 <input type="text"   id="name" class="INPUT_STYLE2"/>
					</td>
					<td class="TD_STYLE1">
					
					</td>
					<td class="TD_STYLE2">
						 <input type="text"   id="name" class="INPUT_STYLE2"/>
					</td>
				</tr>
				
	</table>
	</form>
  </body>
</html>
