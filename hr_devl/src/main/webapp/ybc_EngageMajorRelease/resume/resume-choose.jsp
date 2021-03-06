<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>My JSP 'resume-choose.jsp' starting page</title>

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
	   <script type="text/javascript"
			src="${pageContext.request.contextPath}/javascript/comm/time.js">
			</script>
		<script type="text/javascript">
	function search() {
	 
				if(document.getElementById("majorKindId").value=="0"){
				document.getElementById("majorKindId").value=null;
				}
		document.resumeChooseForm.submit();
	}
		function queryMajor(){
			var mid = $("#humanMajorKind").val();
			var humanmajorkindname = $("#humanMajorKind"+mid).html();
			$("#humanMajorKindId").val(humanmajorkindname);
			var majorSelect = $("#humanMajorId");
			majorSelect.empty();
			majorSelect.append("<option value=''>--请选择--</option>");
			if(mid != 0){
				$.ajax({
					url:'findconfigmajorbyconfigmajorkind.do?mid='+mid,
					type:'get',
					success:function(data){
			 			for(var i=0;i<data.length;i++){
							var eachMajor = data[i];
							majorSelect.append("<option value='"+eachMajor.majorId+"'>"+eachMajor.majorName+"</option>");
						}
			 			}
				});
			}
 	 	}
</script>
	</head>

	<body>
		<form id="recruitAction!findEngageResume?a=list" name="resumeChooseForm" action="starttoshaixuan.do" method="post">
			<input type="hidden" name="engageResume.checkStatus" value="false" /> 
			<input type="hidden"  id="humanMajorKindId" name="humanmajorkindname" />
			<input type="hidden"  name="checkstatus" value="0" />
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--招聘管理--简历管理--简历筛选 </font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="submit" value="开始" class="BUTTON_STYLE1"
							onclick= search(); >
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1 bordercolorlight=#848284 bordercolordark=#eeeeee class="TABLE_STYLE1">
				<tr>
					<td class="TD_STYLE1" width="30%">
						请选择职位分类
					</td>
					<td class="TD_STYLE2" width="30%">
					<select onchange="queryMajor()" multiple="multiple" id="humanMajorKind" name="humanMajorKindId"
					 style="width: 290;height: 100" class="SELECT_STYLE2"> 
						<option value="0">--请选择--</option>
					<c:forEach items="${mklist}" var="m">
						<option  value="${m.majorKindId }" id="humanMajorKind${m.majorKindId }">${m.majorKindName }</option>
					</c:forEach>
					 </select>
						<select name="humanMajorId" multiple="multiple" id="humanMajorId"
						 style="width: 290;height: 100" size="5" class="SELECT_STYLE2">
							<option>--请选择--</option>
						</select>
 
					</td>
				</tr>

				<tr>
					<td class="TD_STYLE1" width="30%">
						请输入关键字
					</td>
					<td width="84%">
						<input type="text" name="primarKey" class="INPUT_STYLE2" />
					</td>
				</tr>

				<tr>
					<td class="TD_STYLE1" width="30%">
						请输入登记时间
					</td>
					<td width="84%" class="TD_STYLE2">
						<input type="text" name="startDate"   onclick="aa('startdate')" 
							style="width: 14%" class="INPUT_STYLE2">
						至
						<input type="text" name="endDate" 
							style="width: 14%" class="INPUT_STYLE2" onclick="aa('enddate')">
						（YYYY-MM-DD）
					</td>
				</tr>
			</table>
		</form>




	</body>
	
</html>