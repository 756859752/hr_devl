<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		<script type="text/javascript">
 	function selAll(obj)
 	{
 		var cho = document.all.choice.value;
 		if(cho == "全选")
 			document.all.choice.value = "取消";
 		else
 			document.all.choice.value = "全选";
 			
 		 for(var i=0;i<obj.elements.length;i++){
 			if(obj.elements[i].tagName.toLowerCase()=="input" &&　obj.elements[i].type=="checkbox"){
 				if(cho == "全选")
 					obj.elements[i].checked=true;
 				else
 					obj.elements[i].checked=false;
 			}
 		}
 	}
 	function doRegister()
 	{
 		//document.forms[0].action = document.forms[0].action + "?operate=doRegister";
		document.forms[0].action = "register_success.html";
		document.forms[0].submit();
 	}
</script>
	</head>

	<body>
		<form action="configprimarykey.do" method="post">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：人力资源--客户化设置--其他设置--关键字查询设置</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="提交" class="BUTTON_STYLE1" onclick="doRegister();">
						<input type="button" value="返回" class="BUTTON_STYLE1"
							onclick="history.back();">
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr class="TR_STYLE1">
					<td class="TD_STYLE1" colspan="4">
						请选择用于关键字查询的字段&nbsp;
						<input type="button" name="choice" value="全选"
							class="BUTTON_STYLE1" onclick="selAll(this.form)">
					</td>
				</tr>
				<input type="hidden" name="item.primaryKeyTable" value="HumanFile">
				
					<input type="hidden" name="list[0].prkId" value="1">
					<input type="hidden" name="list[0].primaryKey" value="firstKindName">
					<input type="hidden" name="list[0].keyName" value="I机机构名称">
					<tr>
						<td class="TD_STYLE2">
							<input type="checkbox" name="list[0].checked" value="on" checked="checked">I机机构名称
						</td>
					
				
					<input type="hidden" name="list[1].prkId" value="2">
					<input type="hidden" name="list[1].primaryKey" value="secondKindName">
					<input type="hidden" name="list[1].keyName" value="II机机构名称">
					
						<td class="TD_STYLE2">
							<input type="checkbox" name="list[1].checked" value="on" checked="checked">II机机构名称
						</td>
					
				
					<input type="hidden" name="list[2].prkId" value="3">
					<input type="hidden" name="list[2].primaryKey" value="thirdKindName">
					<input type="hidden" name="list[2].keyName" value="III机机构名称">
					
						<td class="TD_STYLE2">
							<input type="checkbox" name="list[2].checked" value="on" checked="checked">III机机构名称
						</td>
					
				
					<input type="hidden" name="list[3].prkId" value="4">
					<input type="hidden" name="list[3].primaryKey" value="humanId">
					<input type="hidden" name="list[3].keyName" value="档案编号">
					
						<td class="TD_STYLE2">
							<input type="checkbox" name="list[3].checked" value="on" checked="checked">档案编号
						</td>
					</tr>
				
					<input type="hidden" name="list[4].prkId" value="5">
					<input type="hidden" name="list[4].primaryKey" value="humanName">
					<input type="hidden" name="list[4].keyName" value="姓名">
					<tr>
						<td class="TD_STYLE2">
							<input type="checkbox" name="list[4].checked" value="on" checked="checked">姓名
						</td>
					
				
					<input type="hidden" name="list[5].prkId" value="6">
					<input type="hidden" name="list[5].primaryKey" value="humanAddress">
					<input type="hidden" name="list[5].keyName" value="住址">
					
						<td class="TD_STYLE2">
							<input type="checkbox" name="list[5].checked" value="on" checked="checked">住址
						</td>
					
				
					<input type="hidden" name="list[6].prkId" value="7">
					<input type="hidden" name="list[6].primaryKey" value="humanPostcode">
					<input type="hidden" name="list[6].keyName" value="邮编">
					
						<td class="TD_STYLE2">
							<input type="checkbox" name="list[6].checked" value="on" checked="checked">邮编
						</td>
					
				
					<input type="hidden" name="list[7].prkId" value="8">
					<input type="hidden" name="list[7].primaryKey" value="humanProDesignation">
					<input type="hidden" name="list[7].keyName" value="职称">
					
						<td class="TD_STYLE2">
							<input type="checkbox" name="list[7].checked" value="on" checked="checked">职称
						</td>
					</tr>
				
					<input type="hidden" name="list[8].prkId" value="9">
					<input type="hidden" name="list[8].primaryKey" value="humanMajorKindName">
					<input type="hidden" name="list[8].keyName" value="职位分类名称">
					<tr>
						<td class="TD_STYLE2">
							<input type="checkbox" name="list[8].checked" value="on" checked="checked">职位分类名称
						</td>
					
				
					<input type="hidden" name="list[9].prkId" value="10">
					<input type="hidden" name="list[9].primaryKey" value="hunmaMajorName">
					<input type="hidden" name="list[9].keyName" value="职位名称">
					
						<td class="TD_STYLE2">
							<input type="checkbox" name="list[9].checked" value="on" checked="checked">职位名称
						</td>
					
				
					<input type="hidden" name="list[10].prkId" value="11">
					<input type="hidden" name="list[10].primaryKey" value="humanBank">
					<input type="hidden" name="list[10].keyName" value="开户银行">
					
						<td class="TD_STYLE2">
							<input type="checkbox" name="list[10].checked" value="on" checked="checked">开户银行
						</td>
					
				
					<input type="hidden" name="list[11].prkId" value="12">
					<input type="hidden" name="list[11].primaryKey" value="humanAccount">
					<input type="hidden" name="list[11].keyName" value="银行帐号">
					
						<td class="TD_STYLE2">
							<input type="checkbox" name="list[11].checked" value="on" checked="checked">银行帐号
						</td>
					</tr>
				
					<input type="hidden" name="list[12].prkId" value="13">
					<input type="hidden" name="list[12].primaryKey" value="humanTelephone">
					<input type="hidden" name="list[12].keyName" value="电话">
					<tr>
						<td class="TD_STYLE2">
							<input type="checkbox" name="list[12].checked" value="on" checked="checked">电话
						</td>
					
				
					<input type="hidden" name="list[13].prkId" value="14">
					<input type="hidden" name="list[13].primaryKey" value="humanMobilephone">
					<input type="hidden" name="list[13].keyName" value="手机号码">
					
						<td class="TD_STYLE2">
							<input type="checkbox" name="list[13].checked" value="on" checked="checked">手机号码
						</td>
					
				
					<input type="hidden" name="list[14].prkId" value="15">
					<input type="hidden" name="list[14].primaryKey" value="humanEmail">
					<input type="hidden" name="list[14].keyName" value="E-mail">
					
						<td class="TD_STYLE2">
							<input type="checkbox" name="list[14].checked" value="on" checked="checked">E-mail
						</td>
					
				
					<input type="hidden" name="list[15].prkId" value="16">
					<input type="hidden" name="list[15].primaryKey" value="humanHobby">
					<input type="hidden" name="list[15].keyName" value="爱好">
					
						<td class="TD_STYLE2">
							<input type="checkbox" name="list[15].checked" value="on" checked="checked">爱好
						</td>
					</tr>
				
					<input type="hidden" name="list[16].prkId" value="17">
					<input type="hidden" name="list[16].primaryKey" value="humanSpeciality">
					<input type="hidden" name="list[16].keyName" value="特长">
					<tr>
						<td class="TD_STYLE2">
							<input type="checkbox" name="list[16].checked" value="on" checked="checked">特长
						</td>
					
				
					<input type="hidden" name="list[17].prkId" value="18">
					<input type="hidden" name="list[17].primaryKey" value="humanSex">
					<input type="hidden" name="list[17].keyName" value="性别">
					
						<td class="TD_STYLE2">
							<input type="checkbox" name="list[17].checked" value="on" checked="checked">性别
						</td>
					
				
					<input type="hidden" name="list[18].prkId" value="19">
					<input type="hidden" name="list[18].primaryKey" value="humanReligion">
					<input type="hidden" name="list[18].keyName" value="宗教信仰">
					
						<td class="TD_STYLE2">
							<input type="checkbox" name="list[18].checked" value="on" checked="checked">宗教信仰
						</td>
					
				
					<input type="hidden" name="list[19].prkId" value="20">
					<input type="hidden" name="list[19].primaryKey" value="humanParty">
					<input type="hidden" name="list[19].keyName" value="政治面貌">
					
						<td class="TD_STYLE2">
							<input type="checkbox" name="list[19].checked" value="on" checked="checked">政治面貌
						</td>
					</tr>
				
					<input type="hidden" name="list[20].prkId" value="21">
					<input type="hidden" name="list[20].primaryKey" value="humanNationality">
					<input type="hidden" name="list[20].keyName" value="国籍">
					<tr>
						<td class="TD_STYLE2">
							<input type="checkbox" name="list[20].checked" value="on" checked="checked">国籍
						</td>
					
				
					<input type="hidden" name="list[21].prkId" value="22">
					<input type="hidden" name="list[21].primaryKey" value="humanRace">
					<input type="hidden" name="list[21].keyName" value="民族">
					
						<td class="TD_STYLE2">
							<input type="checkbox" name="list[21].checked" value="on" checked="checked">民族
						</td>
					
				
					<input type="hidden" name="list[22].prkId" value="23">
					<input type="hidden" name="list[22].primaryKey" value="humanBirthday">
					<input type="hidden" name="list[22].keyName" value="生日">
					
						<td class="TD_STYLE2">
							<input type="checkbox" name="list[22].checked" value="on" checked="checked">生日
						</td>
					
				
					<input type="hidden" name="list[23].prkId" value="24">
					<input type="hidden" name="list[23].primaryKey" value="humanBirthplace">
					<input type="hidden" name="list[23].keyName" value="出生地">
					
						<td class="TD_STYLE2">
							<input type="checkbox" name="list[23].checked" value="on" checked="checked">出生地
						</td>
					</tr>
				
					<input type="hidden" name="list[24].prkId" value="25">
					<input type="hidden" name="list[24].primaryKey" value="humanAge">
					<input type="hidden" name="list[24].keyName" value="年龄">
					<tr>
						<td class="TD_STYLE2">
							<input type="checkbox" name="list[24].checked" value="on" checked="checked">年龄
						</td>
					
				
					<input type="hidden" name="list[25].prkId" value="26">
					<input type="hidden" name="list[25].primaryKey" value="humanEducatedDegree">
					<input type="hidden" name="list[25].keyName" value="学历">
					
						<td class="TD_STYLE2">
							<input type="checkbox" name="list[25].checked" value="on" checked="checked">学历
						</td>
					
				
					<input type="hidden" name="list[26].prkId" value="27">
					<input type="hidden" name="list[26].primaryKey" value="humanEducatedYears">
					<input type="hidden" name="list[26].keyName" value="教育年限">
					
						<td class="TD_STYLE2">
							<input type="checkbox" name="list[26].checked" value="on" checked="checked">教育年限
						</td>
					
				
					<input type="hidden" name="list[27].prkId" value="28">
					<input type="hidden" name="list[27].primaryKey" value="humanEducatedMajor">
					<input type="hidden" name="list[27].keyName" value="专业">
					
						<td class="TD_STYLE2">
							<input type="checkbox" name="list[27].checked" value="on" checked="checked">专业
						</td>
					</tr>
				
					<input type="hidden" name="list[28].prkId" value="29">
					<input type="hidden" name="list[28].primaryKey" value="humanSocietySecurityId">
					<input type="hidden" name="list[28].keyName" value="社会保障号码">
					<tr>
						<td class="TD_STYLE2">
							<input type="checkbox" name="list[28].checked" value="on" checked="checked">社会保障号码
						</td>
					
				
					<input type="hidden" name="list[29].prkId" value="30">
					<input type="hidden" name="list[29].primaryKey" value="humanIdCard">
					<input type="hidden" name="list[29].keyName" value="身份证号码">
					
						<td class="TD_STYLE2">
							<input type="checkbox" name="list[29].checked" value="on" checked="checked">身份证号码
						</td>
					
				
					<input type="hidden" name="list[30].prkId" value="31">
					<input type="hidden" name="list[30].primaryKey" value="salaryStandardId">
					<input type="hidden" name="list[30].keyName" value="薪酬标准编号">
					
						<td class="TD_STYLE2">
							<input type="checkbox" name="list[30].checked" value="on" checked="checked">薪酬标准编号
						</td>
					
				
					<input type="hidden" name="list[31].prkId" value="32">
					<input type="hidden" name="list[31].primaryKey" value="salaryStandardName">
					<input type="hidden" name="list[31].keyName" value="薪酬标准">
					
						<td class="TD_STYLE2">
							<input type="checkbox" name="list[31].checked" value="on" checked="checked">薪酬标准
						</td>
					</tr>
				
					<input type="hidden" name="list[32].prkId" value="33">
					<input type="hidden" name="list[32].primaryKey" value="majorChangeAmount">
					<input type="hidden" name="list[32].keyName" value="调动次数">
					<tr>
						<td class="TD_STYLE2">
							<input type="checkbox" name="list[32].checked" value="on" checked="checked">调动次数
						</td>
					
				
					<input type="hidden" name="list[33].prkId" value="34">
					<input type="hidden" name="list[33].primaryKey" value="bonusAmount">
					<input type="hidden" name="list[33].keyName" value="激励次数">
					
						<td class="TD_STYLE2">
							<input type="checkbox" name="list[33].checked" value="on" checked="checked">激励次数
						</td>
					
				
					<input type="hidden" name="list[34].prkId" value="35">
					<input type="hidden" name="list[34].primaryKey" value="trainingAmount">
					<input type="hidden" name="list[34].keyName" value="培训次数">
					
						<td class="TD_STYLE2">
							<input type="checkbox" name="list[34].checked" value="on" checked="checked">培训次数
						</td>
					
				
					<input type="hidden" name="list[35].prkId" value="36">
					<input type="hidden" name="list[35].primaryKey" value="fileChangAmount">
					<input type="hidden" name="list[35].keyName" value="档案变更次数">
					
						<td class="TD_STYLE2">
							<input type="checkbox" name="list[35].checked" value="on" checked="checked">档案变更次数
						</td>
					</tr>
				
					<input type="hidden" name="list[36].prkId" value="37">
					<input type="hidden" name="list[36].primaryKey" value="remark">
					<input type="hidden" name="list[36].keyName" value="备注">
					<tr>
						<td class="TD_STYLE2">
							<input type="checkbox" name="list[36].checked" value="on" checked="checked">备注
						</td>
					
				
					<input type="hidden" name="list[37].prkId" value="38">
					<input type="hidden" name="list[37].primaryKey" value="humanHistroyRecords">
					<input type="hidden" name="list[37].keyName" value="简历">
					
						<td class="TD_STYLE2">
							<input type="checkbox" name="list[37].checked" value="on" checked="checked">简历
						</td>
					
				
					<input type="hidden" name="list[38].prkId" value="39">
					<input type="hidden" name="list[38].primaryKey" value="humanFamilyMembership">
					<input type="hidden" name="list[38].keyName" value="家庭关系">
					
						<td class="TD_STYLE2">
							<input type="checkbox" name="list[38].checked" value="on" checked="checked">家庭关系
						</td>
					
				
					<input type="hidden" name="list[39].prkId" value="40">
					<input type="hidden" name="list[39].primaryKey" value="register">
					<input type="hidden" name="list[39].keyName" value="登记人">
					
						<td class="TD_STYLE2">
							<input type="checkbox" name="list[39].checked" value="on" checked="checked">登记人
						</td>
					</tr>
				
			</table>
		</form>
	</body>
</html>
