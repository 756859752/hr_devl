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

<title>My JSP 'show.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/jquery-1.6.1.min.js">
		
	</script>
<script type="text/javascript">
		function check(sid){
		var ur="demo/"+sid+"/check.do?";
			$.ajax({
  				type:"POST",
  				url:ur,
  				dataType:"json",
  				//contentType:"applicationjson;charset=utf-8",
  				success:function(result){
  					alert("ajaxJson==="+JSON.stringify(result));
  					//console.log(111);
  					//alert(result);
  				}
  			});
		} 
		
	</script>
</head>

<body>
	<center>
		<table>
			<thead>
				<tr>
					<td colspan="4">
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>姓名</th>
					<th>成绩</th>
					<th>性别</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${list}" var="student">
					<tr>
						<th>${student.sname }</th>
						<th>${student.score }</th>
						<th>${student.sex }</th>
						<th><a href="javascript:check(${student.sid})">查看</a><a
							href="">删除</a></th>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</center>
</body>
</html>
