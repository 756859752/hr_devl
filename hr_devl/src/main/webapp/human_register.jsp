<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<!-- <script type="text/javascript" src="javascript/comm/select.js"></script> -->
		<script type="text/javascript">
		/*
		var subcat = new Array(2);
		subcat[0] = ["1", "01/软件公司","01/集团","01/集团/01/软件公司"];
		subcat[1] = ["2", "02/生物科技有限公司","01/集团","01/集团/02/生物科技有限公司"];
		var subcat1 = new Array(2);
		subcat1[0] = ["1", "01/外包组","01/集团/01/软件公司"];
		subcat1[1] = ["2", "01/药店","01/集团/02/生物科技有限公司"];
		var subcat2 = new Array(8);
		subcat2[0] = ["1", "01/区域经理", "01/销售"];
		subcat2[1] = ["2", "02/总经理", "01/销售"];
		subcat2[2] = ["3", "01/项目经理", "02/软件开发"];
		subcat2[3] = ["4", "02/程序员", "02/软件开发"];
		subcat2[4] = ["5", "01/人事经理", "03/人力资源"];
		subcat2[5] = ["6", "02/专员", "03/人力资源"];
		subcat2[6] = ["7", "01/主任", "04/生产部"];
		subcat2[7] = ["8", "02/技术工人", "04/生产部"];*/
		//下拉框联动
		function findscondkind(){//当第一个选择框改变
			var mid = $("#firstKindId").val();//拿到选择的id
			var majorSelect = $("#secondKindId");//拿到第二个选择框
			var majorkindname = $("#firstKindId"+mid).html();//拿到一级分类名
			 //$("#firstKindName").val(majorkindname);//改变隐藏域里的一级分类名值
			majorSelect.empty();
			majorSelect.append("<option value=''>--请选择--</option>");
			console.log("当前拿到的mid"+mid);
			if(mid != 0){
				$.ajax({
					url:'cgp/xxx.do?mid='+mid,//ajax地址
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
		
		//提交数据
		function humanregister(){
 			document.forms[0].action = "cgp/humanregister.do";
 			document.forms[0].submit();
 		}
 		
 		</script>
	</head>

	<body>
		<form name="humanfileForm" method="post">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：人力资源--人力资源档案管理--人力资源档案登记 </font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="提交" class="BUTTON_STYLE1"
							onclick="javascript:humanregister();">
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
						<select id="firstKindId" name="firstKindName" class="SELECT_STYLE1" onchange="findscondkind();"><!-- changelocation(document.forms[0].elements['secondKindName'],document.forms[0].elements['firstKindName'].options[document.forms[0].elements['firstKindName'].selectedIndex].value) -->
						<option value="">&nbsp;</option>
						<c:forEach items="${list1 }" var="l">
						 	 <option value="firstKindId${l.firstKindId }">${l.firstKindName }</option>
						 </c:forEach>
						<!-- 
						<option value="01/集团">01/集团</option>
						<option value="03/02">03/02</option>
						 -->
						 
						</select>
					</td>
					<td width="11%" class="TD_STYLE1">
						II级机构
					</td>
					<td width="14%" class="TD_STYLE2">
						<select id="secondKindId" name="secondKindName" class="SELECT_STYLE1" onchange="<!-- changelocation1(document.forms[0].elements['thirdKindName'],document.forms[0].elements['secondKindName'].options[document.forms[0].elements['secondKindName'].selectedIndex].value) -->">
							<!-- 
							<script language="javascript">
								changelocation(document.forms[0].elements["secondKindName"],document.forms[0].elements["firstKindName"].value)
	   						</script>
	   						 -->
   						</select>
					</td>
					<td width="11%" class="TD_STYLE1">
						III级机构
					</td>
					<td class="TD_STYLE2" colspan="2">
						<select name="thirdKindName" class="SELECT_STYLE1">
							<script language="javascript">
								<!-- 
								changelocation1(document.forms[0].elements["thirdKindName"],document.forms[0].elements["secondKindName"].value)
								-->
							</script>
						</select>
					</td>
					<td rowspan="5">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						职位分类
					</td>
					<td class="TD_STYLE2">
						<select name="humanMajorKindName" onchange="changelocation2(document.forms[0].elements['hunmaMajorName'],document.forms[0].elements['humanMajorKindName'].options[document.forms[0].elements['humanMajorKindName'].selectedIndex].value)" class="SELECT_STYLE1"><option value="">&nbsp;</option>
							
								<option value="01/销售">01/销售</option>
							
								<option value="02/软件开发">02/软件开发</option>
							
								<option value="03/人力资源">03/人力资源</option>
							
								<option value="04/生产部">04/生产部</option></select>
					</td>
					<td class="TD_STYLE1">
						职位名称
					</td>
					<td class="TD_STYLE2">
						<select name="hunmaMajorName" class="SELECT_STYLE1"><script language="javascript">
							changelocation2(document.forms[0].elements["hunmaMajorName"],document.forms[0].elements["humanMajorKindName"].value)
							</script></select>
					</td>
					<td class="TD_STYLE1">
						职称
					</td>
					<td colspan="2" class="TD_STYLE2">
						<select name="humanProDesignation" class="SELECT_STYLE1"><option value="工程师">工程师</option>
							
								<option value="经理">经理</option>
							
								<option value="助理">助理</option>
							
								<option value="教授">教授</option>
							
								<option value="讲师">讲师</option>
							
								<option value="技术支持">技术支持</option></select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						姓名
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="humanName" value="" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						性别
					</td>
					<td class="TD_STYLE2">
						<select name="humanSex" class="SELECT_STYLE1"><option value="男">男</option>
							<option value="女">女</option></select>
					</td>
					<td class="TD_STYLE1">
						EMAIL
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input type="text" name="humanEmail" value="" class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						电话
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="humanTelephone" value="" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						QQ
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="humanQq" value="" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						手机
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input type="text" name="humanMobilephone" value="" class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						住址
					</td>
					<td colspan="3" class="TD_STYLE2">
						<input type="text" name="humanAddress" value="" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						邮编
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input type="text" name="humanPostcode" value="" class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						国籍
					</td>
					<td class="TD_STYLE2">
						<select name="humanNationality" class="SELECT_STYLE1">
							<option value="中国">中国</option>
							<option value="非中国">非中国</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						出生地
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="humanBirthplace" value="" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						生日
					</td>
					<td width="13%" class="TD_STYLE2">
						<input type="text" name="str_humanBirthday" value="" class="INPUT_STYLE2" id="date_start">
					</td>
					<td width="11%" class="TD_STYLE1">
						民族
					</td>
					<td class="TD_STYLE2" width="14%">
						<select name="humanRace" class="SELECT_STYLE1"><option value="汉族">汉族</option>
							
								<option value="回族">回族</option></select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						宗教信仰
					</td>
					<td class="TD_STYLE2">
						<select name="humanReligion" class="SELECT_STYLE1"><option value="无">无</option>
							
								<option value="佛教">佛教</option></select>
					</td>
					<td class="TD_STYLE1">
						政治面貌
					</td>
					<td class="TD_STYLE2">
						<select name="humanParty" class="SELECT_STYLE1"><option value="党员">党员</option>
							
								<option value="群众">群众</option></select>
					</td>
					<td class="TD_STYLE1">
						身份证号码
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="humanIdCard" value="" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						社会保障号码
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="humanSocietySecurityId" value="" class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						年龄
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="humanAge" value="" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						学历
					</td>
					<td class="TD_STYLE2">
						<select name="humanEducatedDegree" class="SELECT_STYLE1"><option value="本科">本科</option>
							
								<option value="大专">大专</option></select>
					</td>
					<td class="TD_STYLE1">
						教育年限
					</td>
					<td class="TD_STYLE2">
						<select name="humanEducatedYears" class="SELECT_STYLE1"><option value="12">12</option>
							
								<option value="16">16</option></select>
					</td>
					<td class="TD_STYLE1">
						学历专业
					</td>
					<td class="TD_STYLE2">
						<select name="humanEducatedMajor" class="SELECT_STYLE1"><option value="生物工程">生物工程</option>
							
								<option value="计算机">计算机</option></select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						薪酬标准
					</td>
					<td class="TD_STYLE2">
						<select name="salaryStandardName" class="SELECT_STYLE1"><option value="0/未定义">0/未定义</option></select>
					</td>
					<td class="TD_STYLE1">
						开户行
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="humanBank" value="" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						帐号
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="humanAccount" value="" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						登记人
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="register" value="better_wanghao" readonly="readonly" class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						建档时间
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="str_registTime" value="2010-05-29 01:51:55" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						特长
					</td>
					<td class="TD_STYLE2">
						<select name="humanSpeciality" class="SELECT_STYLE1"><option value="数据库">数据库</option>
							
								<option value="java">java</option></select>
					</td>
					<td class="TD_STYLE1">
						爱好
					</td>
					<td class="TD_STYLE2">
						<select name="humanHobby" class="SELECT_STYLE1"><option value="篮球">篮球</option>
							
								<option value="舞蹈">舞蹈</option></select>
					</td>
					<td class="TD_STYLE1">
						&nbsp;
					</td>
					<td class="TD_STYLE2">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						个人履历
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="humanHistroyRecords" rows="4" class="TEXTAREA_STYLE1"></textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						家庭关系信息
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="humanFamilyMembership" rows="4" class="TEXTAREA_STYLE1"></textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						备注
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="remark" rows="4" class="TEXTAREA_STYLE1"></textarea>
					</td>
				</tr>
			</table>
		</form>
	</body>
<script type="text/javascript">
Calendar.setup ({inputField : "date_start", ifFormat : "%Y-%m-%d", showsTime : false, button : "date_start", singleClick : true, step : 1});
Calendar.setup ({inputField : "date_end", ifFormat : "%Y-%m-%d", showsTime : false, button : "date_end", singleClick : true, step : 1});
</script>
</html>
