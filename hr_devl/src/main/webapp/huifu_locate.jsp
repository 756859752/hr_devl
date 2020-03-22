<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="table.css" type="text/css">
<link rel="stylesheet" type="text/css" media="all"
	href="javascript/calendar/calendar-win2k-cold-1.css">
<script type="text/javascript" src="javascript/calendar/cal.js"></script>
<script type="text/javascript" src="javascript/comm/comm.js"></script>
<script type="text/javascript" src="javascript/comm/list.js"></script>
<script type="text/javascript" src="/hr_devl//javascript/jquery-1.7.2.js"/></script>
<script type="text/javascript">

 		function querylist()
		{
			//document.forms[0].action = document.forms[0].action + "?operate=list&method=delete&delete_status=1";
			document.forms[0].action ="cgp/huifu.do";
			document.forms[0].submit();
		}
		function search()
		{
			//document.forms[0].action = document.forms[0].action + "?operate=toSearch&method=delete";
			document.forms[0].action ="query_keywords.html";
			document.forms[0].submit();
		}
//下拉框联动
		function findscondkind(){//当第一个选择框改变
			var firstkindid = $("#firstKind").val();//拿到选择的id
			var secondKind = $("#secondKind");//拿到第二个选择框
			var firstKindname = $("#firstKindId"+firstkindid).html();//拿到一级分类名
			$("#firstKindName").val(firstKindname);//改变隐藏域里的一级分类名值
			secondKind.empty();
			secondKind.append("<option value='0'></option>");
			var thirdKind = $("#thirdKind");//拿到第3个选择框
			thirdKind.empty();
			thirdKind.append("<option value='0'></option>");
			if(firstkindid != 0){
				$.ajax({
					url:'cgp/queryConditions.do?firstkindid='+firstkindid+'&secondkindid=2',//ajax地址
					type:'post',
					success:function(data){
			 			for(var i=0;i<data.length;i++){
							var eachMajor = data[i];
							secondKind.append("<option id='secondkindid"+eachMajor.secondKindId+"' value='"+eachMajor.secondKindId+"'>"+eachMajor.secondKindName+"</option>");
							}
			 			}
				});
			}
		}
		function findthirdkind(){//当第2个选择框改变
			var secondkindid = $("#secondKind").val();//拿到选择的id
			var thirdKind = $("#thirdKind");//拿到第3个选择框
			var secondkindname = $("#secondkindid"+secondkindid).html();//拿到一级分类名
			$("#secondKindName").val(secondkindname);//改变隐藏域里的一级分类名值
			thirdKind.empty();
			thirdKind.append("<option value='0'></option>");
			console.log("当前拿到的secondkindid"+secondkindid+secondkindname);
			if(secondkindid != 0){
				$.ajax({
					url:'cgp/queryConditionstwo.do?secondkindid='+secondkindid,//ajax地址
					type:'post',
					success:function(data){
			 			for(var i=0;i<data.length;i++){
							var eachMajor = data[i];
								thirdKind.append("<option id='thirdkindid"+eachMajor.thirdKindId+"' value='"+eachMajor.thirdKindId+"'>"+eachMajor.thirdKindName+"</option>");
							}
			 			}
				});
			}
		}
		//给隐藏域三级机构设值
		function setthird(){
			var thirdkindid = $("#thirdKind").val();//拿到选择的id
			var thirdkindname = $("#thirdkindid"+thirdkindid).html();//拿到一级分类名
			$("#thirdKindName").val(thirdkindname);//改变隐藏域里的一级分类名值
			console.log("当前拿到的thirdkindid"+thirdkindid+thirdkindname);
		}
		
		function findhumanmajor(){
			
			var humanmajorkindid = $("#humanMajorKindNameo").val();//拿到选择的id
			var hunmamajorname = $("#hunmaMajorNameo");//拿到第3个选择框
			var name = $("#majorKindId"+humanmajorkindid).html();//拿到一级分类名
			$("#humanMajorKindName").val(name);//改变隐藏域里的一级分类名值
			hunmamajorname.empty();
			hunmamajorname.append("<option value='0'></option>");
			if(humanmajorkindid != 0){
				$.ajax({
					url:'cgp/queryConditionsthree.do?humanmajorkindid='+humanmajorkindid,//ajax地址
					type:'post',
					success:function(data){
			 			for(var i=0;i<data.length;i++){
							var eachMajor = data[i];
								hunmamajorname.append("<option id='hunmamajorid"+eachMajor.majorId+"' value='"+eachMajor.majorId+"'>"+eachMajor.majorName+"</option>");
							}
			 			}
				});
			}
		}
		
		function setmajorname(){
			var id = $("#hunmaMajorNameo").val();
			var name = $("#hunmamajorid"+id).html();
			$("#hunmaMajorName").val(name);
		}
 		
		function search()
		{
			//document.forms[0].action = document.forms[0].action + "?operate=toSearch&method=query";
			document.forms[0].action ="query_keywords.jsp";
			document.forms[0].submit();
		}
		function doExport(name)
		{
			//document.forms[0].action = "exportfile.do?operate=doExport&name="+name;
			document.forms[0].action ="excel_locate.jsp";
			document.forms[0].submit();
		}
 		</script>
</head>

<body>
	<!--  action="/hr/humanfile.do"-->
	<form id="myfrm"  method="post" >
		<table width="100%">
			<tr>
				<td><font color="#0000CC">您正在做的业务是：人力资源--人力资源档案管理--人力资源档案恢复
				</font></td>
			</tr>
			<tr>
				<td align="right">
					<input type="button" value="EXCEL列表" class="BUTTON_STYLE1" onclick="javascript:doExport('excel');">
					<input type="button" value="查询" class="BUTTON_STYLE1" onclick="javascript:querylist();"> 
					<input type="button" value="搜索" class="BUTTON_STYLE1" onclick="search();">
				</td>
			</tr>
		</table>
		<table width="100%" border="1" cellpadding=0 cellspacing=1
			bordercolorlight=#848284 bordercolordark=#eeeeee class="TABLE_STYLE1">
			<tr class="TR_STYLE1">
				<td width="16%" class="TD_STYLE1">请选择员工所在I级机构</td>
				<td width="84%" class="TD_STYLE2">
				<select id="firstKind" size="5"
					onchange="findscondkind();"
					class="SELECT_STYLE2">
					<option value="">&nbsp;</option>
					<c:forEach items="${list1 }" var="l">
						<option id="firstKindId${l.firstKindId }" value="${l.firstKindId }">${l.firstKindName }</option>
					</c:forEach>
				</select>
			</tr>
			<input type="hidden" id="firstKindName" name="firstKindName" value="" />
			<tr>
				<td class="TD_STYLE1">请选择员工所在II级机构</td>
				<td width="84%" class="TD_STYLE2">
					<select id="secondKind" size="5"
						onchange="findthirdkind();"
						class="SELECT_STYLE2">
	    			</select>
	    		</td>
			</tr>
			<input type="hidden" id="secondKindName" name="secondKindName" value="" />
			<tr class="TR_STYLE1">
				<td width="16%" class="TD_STYLE1">请选择员工所在III级机构</td>
				<td width="84%" class="TD_STYLE2">
					<select onchange="setthird();" id="thirdKind" size="5" class="SELECT_STYLE2">
					</select>
				</td>
			</tr>
			<input type="hidden" id="thirdKindName" name="thirdKindName" value="" />
			<tr>
				<td class="TD_STYLE1">请选择职位分类</td>
				<td width="84%" class="TD_STYLE2">
					<select id="humanMajorKindNameo" size="5"
						onchange="findhumanmajor();"
						class="SELECT_STYLE2">
						<option value="">&nbsp;</option>
						<c:forEach items="${listmk }" var="lmk">
						 	<option id="majorKindId${lmk.majorKindId }" value="${lmk.majorKindId }">${lmk.majorKindName }</option>
						</c:forEach>
					</select>
				</td>
				<input type="hidden" id="humanMajorKindName" name="humanMajorKindName" value="" />
			</tr>
			<tr class="TR_STYLE1">
				<td width="16%" class="TD_STYLE1">请选择职位名称</td>
				<td width="84%" class="TD_STYLE2">
					<select id="hunmaMajorNameo" onchange="setmajorname();" size="5" class="SELECT_STYLE2">
					</select>
				</td>
				<input type="hidden" id="hunmaMajorName" name="hunmaMajorName" value="" />
			</tr>
			<tr>
				<td class="TD_STYLE1">请输入建档时间</td>
				<td width="84%" class="TD_STYLE2">
				<input type="text" name="str_startTime" value="" style="width:14% "
					class="INPUT_STYLE2" id="date_start">至<input type="text"
					name="str_endTime" value="" style="width:14% "
					class="INPUT_STYLE2" id="date_end"> （YYYY-MM-DD）</td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript">
	Calendar.setup ({inputField : "date_start", ifFormat : "%Y-%m-%d", showsTime : false, button : "date_start", singleClick : true, step : 1});
	Calendar.setup ({inputField : "date_end", ifFormat : "%Y-%m-%d", showsTime : false, button : "date_end", singleClick : true, step : 1});
	</script>
</html>


