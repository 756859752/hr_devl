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
<script type="text/javascript">
		var subcat = new Array(2);
subcat[0] = ["1", "集团/软件公司","集团","集团/软件公司"];
subcat[1] = ["2", "集团/生物科技有限公司","集团","集团/生物科技有限公司"];
var subcat1 = new Array(2);
subcat1[0] = ["1", "外包组", "集团/软件公司/外包组","集团/软件公司"];
subcat1[1] = ["2", "药店", "集团/生物科技有限公司/药店","集团/生物科技有限公司"];
var subcat2 = new Array(8);
subcat2[0] = ["1", "区域经理", "销售/区域经理", "销售"];
subcat2[1] = ["2", "总经理", "销售/总经理", "销售"];
subcat2[2] = ["3", "项目经理", "软件开发/项目经理", "软件开发"];
subcat2[3] = ["4", "程序员", "软件开发/程序员", "软件开发"];
subcat2[4] = ["5", "人事经理", "人力资源/人事经理", "人力资源"];
subcat2[5] = ["6", "专员", "人力资源/专员", "人力资源"];
subcat2[6] = ["7", "主任", "生产部/主任", "生产部"];
subcat2[7] = ["8", "技术工人", "生产部/技术工人", "生产部"];

 		function startdelete()
		{
			//document.forms[0].action = document.forms[0].action + "?operate=list&method=delete&delete_status=1";
			document.forms[0].action ="cgp/delete.do";
			document.forms[0].submit();
		}
		function search()
		{
			//document.forms[0].action = document.forms[0].action + "?operate=toSearch&method=delete";
			document.forms[0].action ="query_keywords.html";
			document.forms[0].submit();
		}
 		</script>
</head>

<body>
	<form name="humanfileForm" method="post" action="/hr/humanfile.do">
		<table width="100%">
			<tr>
				<td><font color="#0000CC">您正在做的业务是：人力资源--人力资源档案管理--人力资源档案删除</font>
				</td>
			</tr>
			<tr>
				<td align="right"><input type="button" value="开始"
					class="BUTTON_STYLE1" onclick="javascript:startdelete();"> <input
					type="button" value="搜索" class="BUTTON_STYLE1" onclick="search();">
				</td>
			</tr>
		</table>
		<table width="100%" border="1" cellpadding=0 cellspacing=1
			bordercolorlight=#848284 bordercolordark=#eeeeee class="TABLE_STYLE1">
			<tr class="TR_STYLE1">
				<td width="16%" class="TD_STYLE1">请选择员工所在I级机构</td>
				<td width="84%" class="TD_STYLE2">
				<select name="firstKindName" size="5"
					onchange="changelocation(document.forms[0].elements['secondKindName'],document.forms[0].elements['firstKindName'].options[document.forms[0].elements['firstKindName'].selectedIndex].value)"
					class="SELECT_STYLE2">
					<option value="">&nbsp;</option>
					<!-- <option value="01/集团">集团</option>
					<option value="03/02">02</option></select></td> -->
					<c:forEach items="${list1 }" var="l1">
						<option value="${l1.firstKindName }">${l1.firstKindName }</option>
					</c:forEach>
			</tr>
			<tr>
				<td class="TD_STYLE1">请选择员工所在II级机构</td>
				<td width="84%" class="TD_STYLE2">
					<select name="secondKindName" size="5"
						onchange="changelocation1(document.forms[0].elements['thirdKindName'],document.forms[0].elements['secondKindName'].options[document.forms[0].elements['secondKindName'].selectedIndex].value)"
						class="SELECT_STYLE2">
						<script language="javascript"> changelocation(document.forms[0].elements["secondKindName"],document.forms[0].elements["firstKindName"].value)
	    				</script>
	    			</select>
	    		</td>
			</tr>
			<tr class="TR_STYLE1">
				<td width="16%" class="TD_STYLE1">请选择员工所在III级机构</td>
				<td width="84%" class="TD_STYLE2">
					<select name="thirdKindName" size="5" class="SELECT_STYLE2">
						<script language="javascript">
							changelocation1(document.forms[0].elements["thirdKindName"],document.forms[0].elements["secondKindName"].value)
						</script>
					</select>
				</td>
			</tr>
			<tr>
				<td class="TD_STYLE1">请选择职位分类</td>
				<td width="84%" class="TD_STYLE2">
					<select name="humanMajorKindName" size="5"
						onchange="changelocation2(document.forms[0].elements['hunmaMajorName'],document.forms[0].elements['humanMajorKindName'].options[document.forms[0].elements['humanMajorKindName'].selectedIndex].value)"
						class="SELECT_STYLE2">
						<option value="">&nbsp;</option>
						<!-- <option value="销售">销售</option>
						<option value="软件开发">软件开发</option>
						<option value="人力资源">人力资源</option>
						<option value="生产部">生产部</option> -->
						<c:forEach items="${listmk }" var="l1">
							<option value="${l1.majorKindName }">${l1.majorKindName }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr class="TR_STYLE1">
				<td width="16%" class="TD_STYLE1">请选择职位名称</td>
				<td width="84%" class="TD_STYLE2">
					<select name="hunmaMajorName" size="5" class="SELECT_STYLE2">
						<script language="javascript">
							changelocation2(document.forms[0].elements["hunmaMajorName"],document.forms[0].elements["humanMajorKindName"].value)
						</script>
					</select>
				</td>
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

