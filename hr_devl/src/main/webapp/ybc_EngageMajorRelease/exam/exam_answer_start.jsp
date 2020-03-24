<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'exam_answer_start.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
	<script type="text/javascript"
			src="${pageContext.request.contextPath}/javascript/comm/time.js">
			</script>
		<script type="text/javascript">
		
			function  mysubmit() {
				document.fm.submit();
			}
		$(window).load(function(){　
			
			var limiteTime=$("#limiteTime").val();
			limiteTime=limiteTime*60;
			var shi=0;
			var fen=0;
 			var miao=0;
 			var timer=null;
 			console.log(limiteTime);
 			var usertimeinput=$("#useTime");
 			 timer = setInterval(function(){
 			 	var shijian=shi+"时"+fen+"分"+miao+"秒";
 			 	usertimeinput.val(shijian);
 			 	
 			 	miao++;
 			 	limiteTime--;
 			 	if(limiteTime<0){
 			 		alert("答题时限已到，考卷自动提交!")
 			 		document.fm.submit();
 			 		window.clearInterval(timer);
 			 	}
 			 	if(miao==60){
 			 		miao=0;
 			 		fen++;
 			 	}
 			 	if(fen==60){
 			 			fen=0;
 			 			shi++;
 			 	}
 			 },1000)
 			
 			});
		</script>
  </head>
  
  <body>
  <form method="post" name="fm" action="ybcexam/answersSubmit.do">
   <table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--招聘管理--招聘考试管理--考试答题
						</font>
					</td>
				</tr>
			 <input type="button" value="提交试卷" class="BUTTON_STYLE1" onclick="mysubmit()">
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td class="TD_STYLE1" width="20%">
						考试编号
					</td>
					<td class="TD_STYLE2" width="30%">
					<input type="hidden" name="examNumber" value="${ex.examNumber}">
						${ex.examNumber }
					</td>
					<td class="TD_STYLE1" width="20%">
						试题数量
					</td>
					<td class="TD_STYLE2" width="30%">
						${subamount}
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1" width="20%">
						姓名
					</td>
					<td class="TD_STYLE2" width="30%">
						<input type="hidden" name="humanName" value="${re.humanName }">
						${re.humanName }
					</td>
					<td class="TD_STYLE1" width="20%">
						身份证号码
					</td>
					<td class="TD_STYLE2" width="30%">
					<input type="hidden" name="humanIdcard" value="${re.humanIdcard }"/>
					<input type="hidden" name="resumeId" value="${re.resId}"/>
					<input type="hidden" name="majorKindId" value="${re.humanMajorKindId}"/>
					<input type="hidden" name="majorKindName" value="${re.humanMajorKindName}"/>
					<input type="hidden" name="majorId" value="${re.humanMajorId}"/>
					<input type="hidden" name="majorName" value="${re.humanMajorName}"/>
					<input type="hidden" name="interviewId" value="${in.einId}"/>
						${re.humanIdcard }
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1" width="20%">
						考试限时
					</td>
					<td  class="TD_STYLE2" width="30%">
						<input type="hidden" id="limiteTime" value="${ex.limiteTime }"/>
						${ex.limiteTime }(分钟)
					</td>
					<td class="TD_STYLE1" width="20%">
						当前用时
					</td>
					<td class="TD_STYLE2" width="30%">
						<input type="text"  name="useTime" id="useTime" class="INPUT_STYLE2" readonly="readonly" />
					</td>
				</tr>
				<c:forEach items="${slist }" var="sl" varStatus="it">
					<tr>
						<td class="TD_STYLE1" width="100%" colspan="4">
							${sl[0].firstKindName }
						</td>
					</tr>
					<c:forEach items="${sl}" var="s" varStatus="smit">
						<tr>
							<td class="TD_STYLE2" width="100%" colspan="4">
								<div >
									<input type="hidden" name="answers[${ind.indexsub }].subjectId" value="${s.subId }">
									${it.index+1}.${smit.index+1 }.${s.content }</br>
									<input type="radio" name="answers[${ind.indexsub }].answer" value="a">a.${s.keyA }</br>
									<input type="radio" name="answers[${ind.indexsub }].answer" value="b">b.${s.keyB }</br>
									<input type="radio" name="answers[${ind.indexsub }].answer" value="c">c.${s.keyC }</br>
									<input type="radio" name="answers[${ind.indexsub }].answer" value="d">d.${s.keyD }</br>
									<input type="radio" name="answers[${ind.indexsub}].answer" value="e">e.${s.keyE }</br>
								</div>
							</td>
						</tr>
					</c:forEach>
				</c:forEach>
				
			</table>
  </form>
  </body>
</html>
