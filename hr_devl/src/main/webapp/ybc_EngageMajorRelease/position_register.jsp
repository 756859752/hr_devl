<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>

		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>My JSP 'index.jsp' starting page</title>
	 
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
			src="${pageContext.request.contextPath}/javascript/comm/time.js">
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
		<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/jquery.messager.js"></script>
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
 		</script>
 	<script type="text/javascript">
 	   function mysubmit(){  
 	    if(document.getElementById("firstKindId").value==""){
 	       $.messager.show("消息提示","请选择一级机构",2000);
 	       return ;
 	       }
 	   if(document.getElementById("secondKindId").value==""){
 	       $.messager.show("消息提示","请选择二级机构",2000);
 	       return ;
 	       } 
	   if(document.getElementById("thirdKindId").value==""){
 	 	    $.messager.show("消息提示","请选择三级机构",2000);
 	 	    return ;
 	 	   }
 	  if(document.getElementById("engageType").value==""){
 		 $.messager.show("消息提示","请选择招聘类型",2000);
 	       return ;
 	       } 
 	  if(document.getElementById("majorKindId").value==""){
 		 $.messager.show("消息提示","请选择职位分类",2000);
 	       return ;
 	       }    
 	   if(document.getElementById("majorId").value==""){
 		  $.messager.show("消息提示","请选择职位名称",2000);
 	       return ;
 	       }    
 	  if(document.getElementById("humanAmount").value==""){
 		 $.messager.show("消息提示","请填写招聘人数",2000);
 	       return ; 
 	  }    
 	  if(document.getElementById("date_start").value==""){
 		 $.messager.show("消息提示","请选择截止日期",2000);
 	       return ; 
 	  }   
 	 if(document.getElementById("majordescribe").value==""){
 		 $.messager.show("消息提示","请填写职位描述",2000);
 	       return ; 
 	  }    
 	  if(document.getElementById("engagerequired").value==""){
 		 $.messager.show("消息提示","请填写招聘要求",2000);
 	       return ; 
 	  }   
		  	document.humanfileForm.submit();
	}
 	  function querysecondByFid(){
 			var fid = $("#firstKindId").val();
 			var secondSelect = $("#secondKindId");
 			var thirdSelect = $("#thirdKindId");
			//获取下拉框里的文本内容
			var firstName = $("#first_" + fid).html();
			$("#fisrtKindName").val(firstName);
 			
 			//清空下拉框
 			thirdSelect.empty();
 			secondSelect.empty();
 			//添加下拉框
 			thirdSelect.append("<option value=''>--请选择--</option>");
 			secondSelect.append("<option value=''>--请选择--</option>");
 			console.log(fid);
 			if(fid != 0){
 				$.ajax({
 					url:'selectscondkind.do?fid='+fid,
 					type:'get',
 					success:function(data){
 						for(var i=0;i<data.length;i++){
 							var eachsecond = data[i];
 							secondSelect.append("<option id='second_"+eachsecond.secondKindId+"' value="+eachsecond.secondKindId+">"+eachsecond.secondKindName+"</option>");
 						}
 					}
 				});
 			}
 		}
 		
 		function queryThirdyBySid(){
 			var sid = $("#secondKindId").val();
 			var thirdSelect = $("#thirdKindId");
 			var secondName = $("#second_"+sid).html();
 			$("#secondKindName").val(secondName);
 			//清空下拉框
 			thirdSelect.empty();
 			//添加下拉框
 			thirdSelect.append("<option value=''>--请选择--</option>");
 			if(sid != 0){
 				$.ajax({
 					url:'selectthirdkind.do?sid='+sid,
 					type:'get',
 					success:function(data){
 						for(var i=0;i<data.length;i++){
 							var eachThird = data[i];
 							thirdSelect.append("<option id='third_"+eachThird.thirdKindId+"' value="+eachThird.thirdKindId+">"+eachThird.thirdKindName+"</option>");
 						}
 					}
 				});
 			}
 		}

		function getThirdName(){
			var tid = $("#thirdKindId").val();
			var thirdName = $("#third_"+tid).html();
 			$("#thirdKindName").val(thirdName);
		}

		function getMajorName(){
			var mid = $("#majorId").val();
			var majorname = $("#major_"+mid).html();
		 	$("#majorName").val(majorname);
			}
 		
	 	function ByIdQueryMajor(){
			var mid = $("#majorKindId").val();
		 	var majorSelect = $("#majorId");
		 	var majorkname = $("#majork_"+mid).html();
		 	$("#majorKindName").val(majorkname);
		 	majorSelect.empty();
		 	majorSelect.append("<option value=''>--请选择--</option>");
		 	if(mid != 0){
			 	$.ajax({
					url:'selectmajor.do?mid='+mid,
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
</script> 
 	</head>
	<body>
		<form name="humanfileForm" method="post" action="submitengagemajorrelease.do" >
			<input type="hidden" id="fisrtKindName" name="firstkindname"/>
			<input type="hidden" id="secondKindName" name="secondkindname">
			<input type="hidden" id="thirdKindName" name="thirdkindname">
			<input type="hidden" id="majorKindName" name="majorkindname">
			<input type="hidden" id="majorName" name="majorname">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--招聘管理--职位发布管理--职位发布登记 </font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="提交" class="BUTTON_STYLE1" 
						  onclick="mysubmit()">
						<input type="reset" value="清除" class="BUTTON_STYLE1">
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td class="TD_STYLE1" width="11%">
						I级机构
					</td>
					<td width="14%" class="TD_STYLE2">
						
						<select name="firstKindId" id="firstKindId"  class="SELECT_STYLE1" onchange="querysecondByFid()"> 
						<option value="">--请选择--</option>
						<c:forEach items="${fileFirstKindlist}" var="f">
							<option id="first_${f.firstKindId }" value="${f.firstKindId }">${f.firstKindName }</option>
						</c:forEach>
					 </select>
					</td>
					<td width="11%" class="TD_STYLE1">
						II级机构
					</td>
					<td width="14%" class="TD_STYLE2">
						<select name="secondKindId" id="secondKindId" class="SELECT_STYLE1" onchange="queryThirdyBySid()"> 
						<option value="">--请选择--</option>
						</select>
					</td>
					<td width="11%" class="TD_STYLE1">
						III级机构
					</td>
					<td class="TD_STYLE2"  >
						<select name="thirdKindId" id="thirdKindId" class="SELECT_STYLE1" onchange="getThirdName()">
							<option value="">--请选择--</option>
						</select>
					</td>
					<td width="11%" class="TD_STYLE1">
						招聘类型
					</td>
					<td class="TD_STYLE2" colspan="2">
					<select name="engageType" id="engageType" class="SELECT_STYLE1"> 
							<option value="">--请选择--</option> 
							<option value="校园招聘">校园招聘</option> 
							<option value="社会招聘">社会招聘</option> 
					</select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						职位分类
					</td>
					<td class="TD_STYLE2">
						<select name="majorKindId" id="majorKindId" class="SELECT_STYLE1" onchange="ByIdQueryMajor()">
							<option value="">--请选择--</option> 
							<c:forEach items="${majorKindlist}" var="m">
								<option value="${m.majorKindId }" id="majork_${m.majorKindId }">${m.majorKindName }</option>
							</c:forEach>
						</select>
					</td>
					<td class="TD_STYLE1">
						职位名称
					</td>
					<td class="TD_STYLE2">
						<select name="majorId" id="majorId" class="SELECT_STYLE1" onchange="getMajorName()"> 
							<option value="0">--请选择--</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						招聘人数
					</td>
					<td   class="TD_STYLE2">
						 <input type="text" name="humanAmount" id="humanAmount"  class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						截止日期
					</td>
					<td   class="TD_STYLE2">
							  <input type="text" name="deadline" 
							  class="INPUT_STYLE2" id="date_start" onclick="aa('deadline')">
					</td>
				</tr>
				<tr>
				<td class="TD_STYLE1">
						登记人
					</td>
					<td  class="TD_STYLE2">
						 <input type="text" name="register" value="${userlogin.user_true_name }" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						登记时间
					</td>
					<td   class="TD_STYLE2">
					
							<input type="text" name="registTime"
							  id="nowTime" readonly="readonly"
							class="INPUT_STYLE2">
					</td>
					
					<td>&nbsp; </td>
					<td>&nbsp; </td>
					<td>&nbsp; </td>
					<td>&nbsp; </td>
					
				</tr>
				<tr>
					<td class="TD_STYLE1">
						职位描述
					</td>
					<td class="TD_STYLE2" colspan="8">
						<textarea name="majorDescribe" rows="4" id="majordescribe" cols="80" class="TEXTAREA_STYLE1"></textarea>
					</td>
					 
				</tr>
					<tr>
					<td class="TD_STYLE1">
						招聘要求
					</td>
					<td class="TD_STYLE2" colspan="8">
						<textarea name="engageRequired" rows="4" id="engagerequired" cols="80" class="TEXTAREA_STYLE1"></textarea>
					</td>
					 
				</tr>
			</table>
		</form>
	</body>
 
</html>
