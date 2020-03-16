<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript"
			src="${pageContext.request.contextPath}/javascript/jquery-1.7.2.js">
		</script>
<script type="text/javascript">
	window.onload=check;
	function back(){
		var urls=$('#backurl').val();
		location.href=urls;
	}
</script>
</head>
<body>
	<center>
		<h3>${msg.massagetext} </h3>
		<input id="backurl" type="hidden" value="${pageContext.request.contextPath}/${msg.backurl}">
			<button onclick="back()">返回</button>
		
	</center>
</body>
</html>