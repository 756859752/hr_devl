<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>My JSP 'position-release_details.jsp' starting page</title>
    
	  <link rel="stylesheet"
			href="css/table.css" type="text/css">
		<link rel="stylesheet"
			href="css/cwcalendar.css" type="text/css">
		<script type="text/javascript"
			src="javascript/comm/comm.js">
		</script>
		<script type="text/javascript"
			src="javascript/comm/list.js">
		</script>
		<script type="text/javascript"
			src="javascript/calendar-ch.js">
		</script>
		<script type="text/javascript"
			src="javascript/jquery-1.7.2.js">
		</script>
		<script type="text/javascript"
			src="javascript/locate.js">
		</script>
		
		<script type="text/javascript">
		function search(id){ 
		 // document.fm.submit();		
 		window.location.href="/HR_Fist/recruit/recruitAction!register?id="+id;
		}
		</script>
   
 		
 	</head>
	<body>
		<form id="recruitAction!toRegister" name="fm" action="toRegister?mrid=${mr.mreid }" method="post" enctype="multipart/form-data">
			<input type="hidden" id="fisrtKindName" name="firstkindid" value="${mr.firstkindid }"/>
			<input type="hidden" id="secondKindName" name="secondkindid" value="${mr.secondkindid }">
			<input type="hidden" id="thirdKindName" name="thirdkindid" value="${mr.thirdkindid }">
			<input type="hidden" id="majorKindName" name="majorkindid" value="${mr.majorkindid }">
			<input type="hidden" id="majorName" name="majorid" value="${mr.majorid }">
			<input type="hidden" name ="mreid" value="${mr.mreid }"/>
			<table width="100%"> 
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--招聘管理--职位发布管理--职位发布查询--详细  </font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="submit" value="确认申请" onclick="search('531')" class="BUTTON_STYLE1" />
						<input type="button" value="返回" class="BUTTON_STYLE1" onclick="history.back();">
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
						
						<select name="firstkindname" id="firstKindId"  class="SELECT_STYLE1"> 
						<option>${mr.firstkindname }</option>
						
					 </select>
					</td>
					<td width="11%" class="TD_STYLE1">
						II级机构
					</td>
					<td width="14%" class="TD_STYLE2">
						<select name="secondkindname" id="secondKindId" class="SELECT_STYLE1" onchange="queryThirdyBySid()"> 
						<option>${mr.secondkindname }</option>
						</select>
					</td>
					<td width="11%" class="TD_STYLE1">
						III级机构
					</td>
					<td class="TD_STYLE2"  >
						<select name="thirdkindname" id="thirdKindId" class="SELECT_STYLE1" onchange="getThirdName()">
							<option>${mr.thirdkindname }</option>
						</select>
					</td>
					<td width="11%" class="TD_STYLE1">
						招聘类型
					</td>
					<td class="TD_STYLE2" colspan="2">
					<select name="engagetype" id="engageType" class="SELECT_STYLE1"> 
							<option value="${mr.engagetype }">${mr.engagetype }</option> 
					</select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						职位分类
					</td>
					<td class="TD_STYLE2">
						<select name="majorkindname" id="majorKindId" class="SELECT_STYLE1" onchange="ByIdQueryMajor()">
							<option>${mr.majorkindname }</option> 
								 </select>
					</td>
					<td class="TD_STYLE1">
						职位名称
					</td>
					<td class="TD_STYLE2">
						<select name="majorname" id="majorId" class="SELECT_STYLE1" onchange="getMajorName()"> 
							<option>${mr.majorname }</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						招聘人数
					</td>
					<td   class="TD_STYLE2">
						 <input type="text" name="humanamount" id="humanAmount"  class="INPUT_STYLE2" value="${mr.humanamount }">
					</td>
					<td class="TD_STYLE1">
						截止日期
					</td>
					<td   class="TD_STYLE2">
							  <input type="text" name="deadline" 
							  class="INPUT_STYLE2" id="date_start" onclick="aa('deadline')" value="${mr.deadline }">
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
					
							<input type="text" name="registtime"
							  id="nowTime" readonly="readonly" value="${mr.registtime }"
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
						<textarea name="majordescribe" rows="4" cols="80" class="TEXTAREA_STYLE1">${mr.majordescribe }</textarea>
					</td>
					 
				</tr>
					<tr>
					<td class="TD_STYLE1">
						招聘要求
					</td>
					<td class="TD_STYLE2" colspan="8">
						<textarea name="engagerequired" rows="4"  cols="80" class="TEXTAREA_STYLE1">${mr.engagerequired }</textarea>
					</td>
					 
				</tr>
			</table>
		</form>




	</body>
 
</html>
