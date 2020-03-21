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
<script language="javascript" src="javascript/winopen/winopenm.js"></script>
<script>
	function humanCheck(){
		humanfileForm.action = "cgp/humanChangePass.do";
		humanfileForm.submit();
	}
</script>
</head>
<body>
	<!--  action="/hr/humanfile.do" -->
	<form name="humanfileForm" method="post">
		<table width="100%">
			<tr>
				<td><font color="#0000CC">您正在做的业务是：人力资源--人力资源档案管理--人力资源档案复核
				</font></td>
			</tr>
			<tr>
				<td align="right">
					<input type="button" value="变更"
						class="BUTTON_STYLE1" onclick="javascript:humanCheck();" /> 
					<input type="reset" value="清除" class="BUTTON_STYLE1"/> 
					<input type="button" value="返回" class="BUTTON_STYLE1"
						onclick="history.back()"/>
				</td>
			</tr>
		</table>
		<table width="100%" border="1" cellpadding=0 cellspacing=1
			bordercolorlight=#848284 bordercolordark=#eeeeee class="TABLE_STYLE1">
			<tr>
				<input type="hidden" name="hufId" value="${human.hufId }">
				<td class="TD_STYLE1" width="10%">档案编号</td>
				<td colspan="6" class="TD_STYLE2" >${human.hufId }</td>
				<td rowspan="6" width="13%"><img src=""></td>
			</tr>
			<tr>
				<td class="TD_STYLE1" width="10%">I级机构</td>
				<td width="13%" class="TD_STYLE2" name ="firstKindName" value="${human.firstKindName}">${human.firstKindName }</td>
				<input type="hidden" name ="firstKindName" value="${human.firstKindName}" />
				<td width="10%" class="TD_STYLE1">II级机构</td>
				<td width="13%" class="TD_STYLE2" name ="secondKindName" value="${human.secondKindName}">${human.secondKindName }</td>
				<input type="hidden" name ="secondKindName" value="${human.secondKindName}" />
				<td width="10%" class="TD_STYLE1">III级机构</td>
				<td class="TD_STYLE2" colspan="2" width="2%" name ="thirdKindName" value="${human.thirdKindName}">${human.thirdKindName }</td>
				<input type="hidden" name ="thirdKindName" value="${human.thirdKindName}" />
			</tr>
			
			<tr>
				<td class="TD_STYLE1">职位分类</td>
				<td class="TD_STYLE2" name ="humanMajorKindName" value="${human.humanMajorKindName}">${human.humanMajorKindName}</td>
				<input type="hidden" name ="humanMajorKindName" value="${human.humanMajorKindName}" />
				<td class="TD_STYLE1">职位名称</td>
				<td class="TD_STYLE2" name ="hunmaMajorName" value="${human.hunmaMajorName}">${human.hunmaMajorName}</td>
				<input type="hidden" name ="hunmaMajorName" value="${human.hunmaMajorName}" />
				<td class="TD_STYLE1">职称</td>
				<td colspan="2" class="TD_STYLE2"><select
					name="humanProDesignation" class="SELECT_STYLE1">
					<option value="${human.humanProDesignation}" selected="selected">${human.humanProDesignation}</option>
					<c:forEach items="${listc }" var="c">
						<c:if test="${c.attributename ne 'human.humanProDesignation'}">
							<option value="${c.attributename}">${c.attributename}</option>
						</c:if>
					</c:forEach>
						<!-- 
						<option value="工程师">工程师</option>
						<option value="经理" selected="selected">经理</option>
						<option value="助理">助理</option>
						<option value="教授">教授</option>
						<option value="讲师">讲师</option>
						<option value="技术支持">技术支持</option></select></td>
						 -->
			</tr>
			<tr>
				<td class="TD_STYLE1">姓名</td>
				<td class="TD_STYLE2"><input type="text" name="humanName"
					value="${human.humanName }" class="INPUT_STYLE2"></td>
				<td class="TD_STYLE1">性别</td>
				<td class="TD_STYLE2">
					<select name="humanSex" class="SELECT_STYLE1">
						<!-- -->
						<c:if test="${human.humanSex eq '男'}">
							<option value="男" selected="selected">男</option>
							<option value="女">女</option>
						</c:if>
						<c:if test="${human.humanSex eq '女'}">
							<option value="女" selected="selected">女</option>
							<option value="男">男</option>
						</c:if>
					</select>
				</td>
				<td class="TD_STYLE1">EMAIL</td>
				<td colspan="2" class="TD_STYLE2"><input type="text"
					name="humanEmail" value="${human.humanEmail }" class="INPUT_STYLE2">
				</td>
			</tr>
			<tr>
				<td class="TD_STYLE1">电话</td>
				<td class="TD_STYLE2"><input type="text"
					name="humanTelephone" value="${human.humanTelephone}" class="INPUT_STYLE2"></td>
				<td class="TD_STYLE1">QQ</td>
				<td class="TD_STYLE2"><input type="text" name="humanQq"
					value="${human.humanQq}" class="INPUT_STYLE2"></td>
				<td class="TD_STYLE1">手机</td>
				<td colspan="2" class="TD_STYLE2"><input type="text"
					name="humanMobilephone" value="${human.humanMobilephone}"
					class="INPUT_STYLE2"></td>
			</tr>
			<tr>
				<td class="TD_STYLE1">住址</td>
				<td colspan="3" class="TD_STYLE2"><input type="text"
					name="humanAddress" value="${human.humanAddress}" class="INPUT_STYLE2">
				</td>
				<td class="TD_STYLE1">邮编</td>
				<td colspan="2" class="TD_STYLE2"><input type="text"
					name="humanPostcode" value="${human.humanPostcode}" class="INPUT_STYLE2">
				</td>
			</tr>
			<tr>
				<td class="TD_STYLE1">国籍</td>
				<td class="TD_STYLE2"><select name="humanNationality"
					class="SELECT_STYLE1">
					<c:if test="${human.humanNationality eq '中国'}">
						<option value="中国" selected="selected">中国</option>
						<option value="美国">美国</option>
					</c:if>
					<c:if test="${human.humanNationality eq '美国'}">
						<option value="中国">中国</option>
						<option value="美国" selected="selected">美国</option>
					</c:if>
					</select></td>
				<td class="TD_STYLE1">出生地</td>
				<td class="TD_STYLE2"><input type="text"
					name="humanBirthplace" value="${human.humanBirthplace}" class="INPUT_STYLE2">
				</td>
				<td class="TD_STYLE1">生日</td>
				<td width="13%" class="TD_STYLE2"><input type="text"
					name="str_humanBirthday" value="${human.humanBirthday}"
					class="INPUT_STYLE2" id="date_start"></td>
				<td width="10%" class="TD_STYLE1">民族</td>
				<td class="TD_STYLE2"><select name="humanRace"
					class="SELECT_STYLE1">
					<c:if test="${human.humanRace eq '汉族'}">
						<option value="汉族" selected="selected">汉族</option>
						<option value="回族">回族</option>
					</c:if>
					<c:if test="${human.humanRace eq '回族'}">
						<option value="汉族">汉族</option>
						<option value="回族" selected="selected">回族</option>
					</c:if>
				</select></td>
			</tr>
			<tr>
				<td class="TD_STYLE1">宗教信仰</td>
				<td class="TD_STYLE2">
					<select name="humanReligion"
					class="SELECT_STYLE1">
						<c:if test="${human.humanReligion eq '无'}">
							<option value="无" selected="selected">无</option>
							<option value="佛教">佛教</option>
						</c:if>
						<c:if test="${human.humanReligion eq '佛教'}">
							<option value="无">无</option>
							<option value="佛教" selected="selected">佛教</option>
						</c:if>
					</select></td>
				<td class="TD_STYLE1">政治面貌</td>
				<td class="TD_STYLE2">
					<select name="humanParty"
					class="SELECT_STYLE1">
						<c:if test="${human.humanParty eq '党员'}">
							<option value="党员" selected="selected">党员</option>
							<option value="群众">群众</option>
						</c:if>
						<c:if test="${human.humanParty eq '群众'}">
							<option value="党员">党员</option>
							<option value="群众" selected="selected">群众</option>
						</c:if>
					</select></td>
				<td class="TD_STYLE1">身份证号码</td>
				<td class="TD_STYLE2"><input type="text"
					name="humanIdCard" value="${human.humanIdCard}"
					class="INPUT_STYLE2"></td>
				<td class="TD_STYLE1">社会保障号码</td>
				<td class="TD_STYLE2"><input type="text"
					name="humanSocietySecurityId" value="${human.humanSocietySecurityId}" class="INPUT_STYLE2">
				</td>
			</tr>
			<tr>
				<td class="TD_STYLE1">年龄</td>
				<td class="TD_STYLE2"><input type="text" name="humanAge"
					value="${human.humanAge}" class="INPUT_STYLE2"></td>
				<td class="TD_STYLE1">学历</td>
				<td class="TD_STYLE2">
				<select name="humanEducatedDegree"
					class="SELECT_STYLE1">
					<c:if test="${human.humanEducatedDegree eq '本科'}">
						<option value="本科" selected="selected">本科</option>
						<option value="大专">大专</option>
					</c:if>
					<c:if test="${human.humanEducatedDegree eq '大专'}">
						<option value="本科">本科</option>
						<option value="大专" selected="selected">大专</option>
					</c:if>
				</select></td>
				<td class="TD_STYLE1">教育年限</td>
				<td class="TD_STYLE2">
					<select name="humanEducatedYears"
					class="SELECT_STYLE1">
						<c:if test="${human.humanEducatedYears eq '16'}">
							<option value="12">12</option>
							<option value="16" selected="selected">16</option>
						</c:if>
						<c:if test="${human.humanEducatedYears eq '12'}">
							<option value="12" selected="selected">12</option>
							<option value="16">16</option>
						</c:if>
					</select></td>
				<td class="TD_STYLE1">学历专业</td>
				<td class="TD_STYLE2"><select name="humanEducatedMajor"
					class="SELECT_STYLE1">
						<c:if test="${human.humanEducatedMajor eq '生物工程'}">
							<option value="生物工程" selected="selected">生物工程</option>
							<option value="计算机">计算机</option>
						</c:if>
						<c:if test="${human.humanEducatedMajor eq '计算机'}">
							<option value="生物工程">生物工程</option>
							<option value="计算机" selected="selected">计算机</option>
						</c:if>
					</select></td>
			</tr>
			<tr>
				<td class="TD_STYLE1">薪酬标准</td>
				<td class="TD_STYLE2"><select name="salaryStandardName"
					class="SELECT_STYLE1">
					<option value="0/未定义">0/未定义</option></select>
				</td>
				<td class="TD_STYLE1">开户行</td>
				<td class="TD_STYLE2"><input type="text" name="humanBank"
					value="${human.humanBank}" class="INPUT_STYLE2"></td>
				<td class="TD_STYLE1">帐号</td>
				<td class="TD_STYLE2"><input type="text"
					name="humanAccount" value="${human.humanAccount}"
					class="INPUT_STYLE2"></td>
				<td class="TD_STYLE1">复核人</td>
				<td class="TD_STYLE2">
				<input type="text" name="checker"
					value="${human.checker}" readonly="readonly" class="INPUT_STYLE2">
					<input type="hidden" name ="checker" value="${human.checker}" />
				
				</td>
			</tr>
			<tr>
				<td class="TD_STYLE1">复核时间</td>
				<td class="TD_STYLE2"><input type="text"
					name="str_checkTime" value="${human.checkTime}"
					readonly="readonly" class="INPUT_STYLE2"></td>
				<td class="TD_STYLE1">特长</td>
				<td class="TD_STYLE2">
				<select name="humanSpeciality"
					class="SELECT_STYLE1">
					<c:if test="${human.humanSpeciality eq 'java'}">
						<option value="数据库">数据库</option>
						<option value="java" selected="selected">java</option>
					</c:if>
					<c:if test="${human.humanSpeciality eq '数据库'}">
						<option value="数据库" selected="selected">数据库</option>
						<option value="java">java</option>
					</c:if>
				</select></td>
				<td class="TD_STYLE1">爱好</td>
				<td class="TD_STYLE2">
					<select name="humanHobby" class="SELECT_STYLE1">
						<c:if test="${human.humanHobby eq '舞蹈'}">
							<option value="篮球">篮球</option>
							<option value="舞蹈" selected="selected">舞蹈</option>
						</c:if>
						<c:if test="${human.humanHobby eq '篮球'}">
							<option value="篮球" selected="selected">篮球</option>
							<option value="舞蹈">舞蹈</option>
						</c:if>
					</select>
				</td>
				<td class="TD_STYLE1">&nbsp;</td>
				<td class="TD_STYLE2">&nbsp;</td>
			</tr>
			<tr>
				<td class="TD_STYLE1">档案附件</td>
				<td colspan="7" class="TD_STYLE2"><a
					href="javascript:winopenm('query.jsp?filename=')"></a></td>
			</tr>
			<tr>
				<td class="TD_STYLE1">个人履历</td>
				<td colspan="7" class="TD_STYLE2"><textarea
						name="humanHistroyRecords" rows="4" class="TEXTAREA_STYLE1">${human.humanHistroyRecords}</textarea>
				</td>
			</tr>
			<tr>
				<td class="TD_STYLE1">家庭关系信息</td>
				<td colspan="7" class="TD_STYLE2"><textarea
						name="humanFamilyMembership" rows="4" class="TEXTAREA_STYLE1">${human.humanFamilyMembership}</textarea>
				</td>
			</tr>
			<tr>
				<td class="TD_STYLE1">备注</td>
				<td colspan="7" class="TD_STYLE2"><textarea name="remark"
						rows="4" class="TEXTAREA_STYLE1" value="${human.remark}">${human.remark}</textarea></td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript">
Calendar.setup ({inputField : "date_start", ifFormat : "%Y-%m-%d", showsTime : false, button : "date_start", singleClick : true, step : 1});
Calendar.setup ({inputField : "date_end", ifFormat : "%Y-%m-%d", showsTime : false, button : "date_end", singleClick : true, step : 1});
</script>
</html>
