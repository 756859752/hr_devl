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
		<script type="text/javascript" src="/hr_devl//javascript/jquery-1.7.2.js"/></script>
		<script type="text/javascript">
		//页面加载给时间设值
		//window.onload =function()
		//{
		    //your code  
		//}
		
		
		//下拉框联动
		function findscondkind(){//当第一个选择框改变
			var firstkindid = $("#firstKind").val();//拿到选择的id
			var secondKind = $("#secondKind");//拿到第二个选择框
			//var arr = $("#firstKindId"+firstkindid).html().split("/");
			var firstKindname = $("#firstKindId"+firstkindid).html();//拿到一级分类名
			$("#firstKindName").val(firstKindname);//改变隐藏域里的一级分类名值
			secondKind.empty();
			secondKind.append("<option value='0'>--请选择--</option>");
			console.log("当前拿到的firstkindid"+firstkindid+firstKindname);
			var thirdKind = $("#thirdKind");//拿到第3个选择框
			thirdKind.empty();
			thirdKind.append("<option value='0'>--请选择--</option>");
			if(firstkindid != 0){
				$.ajax({
					url:'cgp/queryConditions.do?firstkindid='+firstkindid+'&secondkindid=2',//ajax地址
					type:'post',
					success:function(data){
			 			for(var i=0;i<data.length;i++){
							var eachMajor = data[i];
							secondKind.append("<option id='secondkindid"+eachMajor.secondKindId+"' value='"+eachMajor.secondKindId+"'>"+eachMajor.secondKindId+"/"+eachMajor.secondKindName+"</option>");
							}
			 			}
				});
			}
		}
		function findthirdkind(){//当第2个选择框改变
			var secondkindid = $("#secondKind").val();//拿到选择的id
			var thirdKind = $("#thirdKind");//拿到第3个选择框
			//var arr = $("#secondkindid"+secondkindid).html().split('/');
			var secondkindname = $("#secondkindid"+secondkindid).html();//拿到一级分类名
			$("#secondKindName").val(secondkindname);//改变隐藏域里的一级分类名值
			thirdKind.empty();
			thirdKind.append("<option value='0'>--请选择--</option>");
			console.log("当前拿到的secondkindid"+secondkindid+secondkindname);
			if(secondkindid != 0){
				$.ajax({
					url:'cgp/queryConditionstwo.do?secondkindid='+secondkindid,//ajax地址
					type:'post',
					success:function(data){
			 			for(var i=0;i<data.length;i++){
							var eachMajor = data[i];
								thirdKind.append("<option id='thirdkindid"+eachMajor.thirdKindId+"' value='"+eachMajor.thirdKindId+"'>"+eachMajor.thirdKindId+"/"+eachMajor.thirdKindName+"</option>");
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
		
		//职位分类联动
		function findhumanmajor(){
			var humanmajorkindid = $("#humanMajorKindNameo").val();//拿到选择的id
			var hunmamajorname = $("#hunmaMajorNameo");//拿到下一个选择框
			var humanMajorKindName = $("#majorKindId"+humanmajorkindid).html();//拿到一级分类名
			$("#humanMajorKindName").val(humanMajorKindName);//改变隐藏域里的一级分类名值
			hunmamajorname.empty();
			hunmamajorname.append("<option value='0'>--请选择--</option>");
			if(humanmajorkindid != 0){
				$.ajax({
					url:'cgp/queryConditionsthree.do?humanmajorkindid='+humanmajorkindid,//ajax地址
					type:'post',
					success:function(data){
			 			for(var i=0;i<data.length;i++){
							var eachMajor = data[i];
								hunmamajorname.append("<option id='hunmamajorid"+eachMajor.majorId+"' value='"+eachMajor.majorId+"'>"+eachMajor.majorId+"/"+eachMajor.majorName+"</option>");
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
						<input id="tijiao" type="button" value="提交" class="BUTTON_STYLE1"
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
						<select id="firstKind" class="SELECT_STYLE1" onchange="findscondkind();">
						<option value="0">&nbsp;</option>
						<c:forEach items="${list1 }" var="l">
						 	 <option id="firstKindId${l.firstKindId }" value="${l.firstKindId }">${l.firstKindId }/${l.firstKindName }</option>
						 </c:forEach>
						</select>
					</td>
						<input type="hidden" id="firstKindName" name="firstKindName" value="" />
					<td width="11%" class="TD_STYLE1">
						II级机构
					</td>
					<td width="14%" class="TD_STYLE2">
						<select id="secondKind" class="SELECT_STYLE1" onchange="findthirdkind();">
   						</select>
   						<input type="hidden" id="secondKindName" name="secondKindName" value="" />
					</td>
					<td width="11%" class="TD_STYLE1">
						III级机构
					</td>
					<td class="TD_STYLE2" colspan="2">
						<select id="thirdKind" class="SELECT_STYLE1" onchange="setthird();">
						</select>
						<input type="hidden" id="thirdKindName" name="thirdKindName" value="" />
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
						<select id="humanMajorKindNameo" 
						onchange="findhumanmajor();" class="SELECT_STYLE1">
							<option value="">&nbsp;</option>
							<c:forEach items="${listmk }" var="lmk">
							 	<option id="majorKindId${lmk.majorKindId }" value="${lmk.majorKindId }">${lmk.majorKindId }/${lmk.majorKindName }</option>
							</c:forEach>
						</select>
						<input type="hidden" id="humanMajorKindName" name="humanMajorKindName" value="" />
					</td>
					<td class="TD_STYLE1">
						职位名称
					</td>
					<td class="TD_STYLE2">
						<select id="hunmaMajorNameo" onchange="setmajorname();" class="SELECT_STYLE1">
						</select>
						<input type="hidden" id="hunmaMajorName" name="hunmaMajorName" value="" />
					</td>
					<td class="TD_STYLE1">
						职称
					</td>
					<td colspan="2" class="TD_STYLE2">
						<select name="humanProDesignation" class="SELECT_STYLE1">
							<c:forEach items="${listc }" var="c">
							 	<option id="pbcid${c.attributekind }" value="${c.attributename }">${c.attributename }</option>
							</c:forEach>
						</select>
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
						<select name="salaryStandardName" class="SELECT_STYLE1">
							<c:forEach items="${lists }" var="s">
							 	<option id="standardId${s.standardId }" value="${s.standardId }/${s.standardName }">${s.standardId }/${s.standardName }</option>
							</c:forEach>
						</select>
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
						<input type="hidden" name="register" value="better_wanghao" readonly="readonly" class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						建档时间
					</td>
					<td class="TD_STYLE2">
						<!-- 2010-05-29 01:51:55 -->
						<input type="text" disable="true" value="无需输入" readonly="readonly" class="INPUT_STYLE2">
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
