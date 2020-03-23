<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>My JSP 'interview-sift.jsp' starting page</title>
    	<link rel="stylesheet"
			href="${pageContext.request.contextPath}/css/table.css" type="text/css">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/css/cwcalendar.css"
			type="text/css">
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
 

	function toPhoto(data){
		var a = data.substring(data.indexOf(".")+1)
		if(a!="jpg" && a!="gif" && a!="bmp"){
			alert("您上传的不是图片路径");
		}
	}
	
	function toPhotofile(da){
		var a = da.substring(da.indexOf(".")+1)
		if(a!="doc"){
			alert("您上传的不是文件路径");
		}
	}

		var validateMsg = "";
	function checkNotEmpty(ctlName,label)
	{
		var oCtl = document.forms[0].elements[ctlName];
		if (oCtl.value=="")
		{
			if (label)
			{
				validateMsg += label;
			}
			validateMsg += "不能为空！\n";
			oCtl.focus();
		}
	}
	
	function checkValidateMsg()
	{
		if (validateMsg!="")
		{
			alert(validateMsg);
			return false;
		}
		return true;
	}
			
		function tosubmit(){
			validateMsg = "";
			checkNotEmpty("ei.checker","筛选人");
			checkNotEmpty("ei.checkComment","录用申请审核意见");
			if (!checkValidateMsg())
			{
				return;
			}
			document.forms[0].elements["operate"].value = "doAdopt"; 
			document.forms[0].submit();
		}
		
		
		function tozwfenlei(id){
			$("er.humanMajorKindName").value=$("er.humanMajorKindId").options[$("er.humanMajorKindId").selectedIndex].outerText;
			engageResume.SelectConfig_major(id,callbackkind)
		}
		
		function callbackkind(data){
			$("er.humanMajorId").options.length=0;
			var o = new Option("--请选择--",0);
			$("er.humanMajorId").add(o);
			DWRUtil.addOptions("er.humanMajorId",data,"majorId","majorName");
		}
		function zwmingchen(){
			$("er.humanMajorName").value=$("er.humanMajorId").options[$("er.humanMajorId").selectedIndex].outerText;
		}
		
		
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
			
		  	document.getElementById("nowTime").value = now.getFullYear()+"-"+(now.getMonth()+1)+"-"+now.getDate()+" "+timeString;
			window.setTimeout("tick();", 100);
		}
		
		//load事件
		function check(){
			//获得系统当前时间的方法
		  	tick();					
		}
		
		function mians(){
			document.getElementById("passCheckcomment").value="建议面试";
			
		}
		function bis(){
			document.getElementById("passCheckcomment").value="建议笔试";
		}
		function luy(){
			document.getElementById("passCheckcomment").value="建议录用";
			
		}
		function del(){
			document.getElementById("passCheckcomment").value="删除简历";
			
		}
		
 		</script>
 		<script type="text/javascript">
 		function search(id){   
	 		if(document.getElementById("passCheckcomment").value=="删除简历"){
			window.location.href="/HR_Fist/recruit/recruitAction!deleteResumeById?id="+id;
			 document.fm.submit();
			}else if(document.getElementById("passCheckcomment").value=="建议录用"){
					document.getElementById("ly").value = true;
				document.fm.submit();
			}else if(document.getElementById("passCheckcomment").value=="建议面试"){
					document.getElementById("mianshi").value = false;
				 document.fm.submit();
			}
		}
 		</script>
	</head>

	<body onload="check(),luy()">
		<form id="recruitAction!returnSiftList" name="fm" action="AnswerDetailstoShaixuanSubmit.do" method="post" enctype="multipart/form-data">
			<input type="hidden" name="interviewStatus" value="${re.interviewStatus }" />
			<input type="hidden" name="resId" value="${ea.resumeId }" />
			<input type="hidden" name="ansId" value="${ansId }" />
			<input type="hidden" name="checkStatus" value="${re.checkStatus }" />
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--招聘管理--面试管理--面试筛选  </font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="radio" name="result"  value="建议面试" onclick="mians()">建议面试
						<input type="radio" name="result"   value="建议笔试" onclick="bis()">建议笔试
						<input type="radio" name="result"   value="建议录用"  checked="true" onclick="luy()">建议录用
						<input type="radio" name="result"  value="删除简历" onclick="del()">删除简历
						<input type="submit" value="确认" class="BUTTON_STYLE1"
							onclick="search('542')">
						<input type="button" value="返回" class="BUTTON_STYLE1" 
							onclick="history.back();">
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td class="TD_STYLE1" width="11%">
						职位分类
					</td>
					<td width="14%" class="TD_STYLE2"> 
						<input type="hidden" name="humanMajorKindId" value="${re.humanMajorKindId }"/>
					   <input type="text" name="humanMajorKindName"
						   value="${re.humanMajorKindName }" readonly="readonly" class="INPUT_STYLE2">
					
					</td>
					<td width="11%" class="TD_STYLE1">
						职位名称
					</td>
					<td width="14%" class="TD_STYLE2">
					<input type="hidden" name="humanMajorId" value="${re.humanMajorId}"/>
					 <input type="text" name="humanMajorName" value="${re.humanMajorName }" readonly="readonly" class="INPUT_STYLE2">
				    </td>
					<td width="11%" class="TD_STYLE1">
						招聘类型
					</td>
					<td class="TD_STYLE2" >
						<input type="text" name="engageType" value="${re.engageType }" readonly="readonly" class="INPUT_STYLE2">
					
					</td>
					
					<td width="10%" rowspan="6" colspan="2"  align="center">
						 
					</td>
					
				</tr>
				<tr>
				<td class="TD_STYLE1">
						姓名
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="humanName" value="${re.humanName }" readonly="readonly" class="INPUT_STYLE2">
						
					</td>
					<td class="TD_STYLE1">
						性别
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="humanSex" value="${re.humanSex }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						EMAIL
					</td>
					<td   class="TD_STYLE2">
						<input type="text" name="humanEmail" value="${re.humanEmail }"  readonly="readonly" class="INPUT_STYLE2">
					</td>
				</tr>

				<tr>
					<td class="TD_STYLE1">
						电话号码
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="humanTelephone" value="${re.humanTelephone }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						家庭电话
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="humanHomephone" value="${re.humanHomephone }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1" >
						手机
					</td>
					<td  class="TD_STYLE2" >
						<input type="text" name="humanMobilephone" value="${re.humanMobilephone }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					
				</tr>
				<tr>
					<td class="TD_STYLE1">
						住址
					</td>
					<td colspan="3" class="TD_STYLE2">
						<input type="text" name="humanAddress" value="${re.humanAddress }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						邮编
					</td>
					<td   class="TD_STYLE2">
						<input type="text" name="humanPostcode" value="${re.humanPostcode }" readonly="readonly" class="INPUT_STYLE2">
					</td>
				</tr>

				<tr>
					<td class="TD_STYLE1">
						国籍
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="humanNationality" value="${re.humanNationality }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						出生地
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="humanBirthplace" value="${re.humanBirthplace }"  readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						生日
					</td>
					<td class="TD_STYLE2"  > 
						<input type="text" name="humanBirthday" value="${re.humanBirthday }" readonly="readonly" class="INPUT_STYLE2">
					</td>
				</tr>
				
				<tr>
					<td width="11%" class="TD_STYLE1">
						民族
					</td>
					<td class="TD_STYLE2" width="14%">
						<input type="text" name="humanRace" value="${re.humanRace }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						宗教信仰
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="humanReligion" value="${re.humanReligion }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						政治面貌
					</td>
					<td class="TD_STYLE2" >
						<input type="text" name="humanParty" value="${re.humanParty }" readonly="readonly" class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>

					<td class="TD_STYLE1">
						身份证号码
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="humanIdcard" value="${re.humanIdcard }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						年龄
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="humanAge" value="${re.humanAge }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						毕业学校
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="humanCollege" value="${re.humanCollege }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1" width="10%">
						学历
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="humanEducatedDegree" value="${re.humanEducatedDegree }" readonly="readonly" class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						教育年限
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="humanEducatedYears"  value="${re.humanEducatedYears }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						学历专业
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="humanEducatedMajor" value="${re.humanEducatedMajor }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						薪酬要求
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="demandSalaryStandard" value="${re.demandSalaryStandard }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						注册时间
					</td>
					<td class="TD_STYLE2"> 
						<input type="text" name="registTime" value="${re.registTime }" readonly="readonly" class="INPUT_STYLE2">
						
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						特长
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="humanSpecility" value="${re.humanSpecility }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						爱好
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="humanHobby" value="${re.humanHobby }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1"><span style="font-size: 10.5pt; font-family: 宋体;"></span> 
						推荐人
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="checker" value="${re.checker }" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1"><span style="font-size: 10.5pt; font-family: 宋体;"></span> 
						推荐时间
					</td>
					<td class="TD_STYLE2"> 
						<input type="text" name="checkTime" value="${re.checkTime }" readonly="readonly" class="INPUT_STYLE2">	 
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						档案附件
					</td>
					<td colspan="7" class="TD_STYLE2">
						<input type="text" name="checker" readonly="readonly" class="INPUT_STYLE2">
					</td>
				</tr>
			<tr>
					<td class="TD_STYLE1">
						个人履历
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="humanHistoryRecords" rows="4"  
						class="TEXTAREA_STYLE1" readonly="readonly"> ${re.humanHistoryRecords }
						</textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						备注
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="remark" rows="4"   class="TEXTAREA_STYLE1"  readonly="readonly"> ${re.remark }
						</textarea>
					</td>
				</tr>
				
				<tr>
					<td class="TD_STYLE1">
						筛选推荐意见
					</td>
					<td class="TD_STYLE2" colspan="7">
						<textarea name="recomandation" rows="4"   class="TEXTAREA_STYLE1" readonly="readonly">${re.recomandation }</textarea>
					</td>
				</tr>
				
				
				
				<tr>
					<td class="TD_STYLE1">
						考试次数
					</td>
					<td class="TD_STYLE2">
					 	<input type="text"   name="interviewAmount" value="${re.testAmount }" class="INPUT_STYLE2" readonly="readonly"/>
					</td>
					<td class="TD_STYLE1">
						成绩平均分
					</td>
					<td class="TD_STYLE2">
						 
				 <input type="text"  name="total_point" value="${re.totalPoints }" class="INPUT_STYLE2" readonly="readonly"/>
				
					</td>
					<td class="TD_STYLE1">
						筛选人
					</td>
					<td class="TD_STYLE2">
						 <input type="text"  name="testChecker" value="${userLogin.user_true_name }" class="INPUT_STYLE2" readonly="readonly"/>
					</td>
					<td class="TD_STYLE1">
						筛选时间
					</td>
					<td class="TD_STYLE1">
						<input type="text" name="checkTime"
							  id="nowTime" readonly="readonly"
							class="INPUT_STYLE2">
					</td>
				</tr>
				
				<tr>
					<td class="TD_STYLE1">
						录用申请审核意见
					</td>
					<td class="TD_STYLE2" colspan="7">
						<textarea name="checkComment" class="TEXTAREA_STYLE1"
							rows="4" readonly="readonly" id="passCheckcomment">建议录用</textarea>
					</td>
				</tr>
			</table>
		</form>




	</body>
 
</html>
