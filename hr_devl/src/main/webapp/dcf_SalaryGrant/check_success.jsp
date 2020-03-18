<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/hr_devl/css/table.css" type="text/css">
<script type="text/javascript" src="/hr_devl/javascript/comm/comm.js"></script>

<script type="text/javascript">
	function toLoad(){
		document.location.href("salaryGrantAction.do?methodName=doCheckList");
	}
</script>

</head>
<body>
<form method="post" action="">
<table width="100%" >
  <tr>
  
    <td colspan="2"> 
    <font color="black">您正在做的业务是：人力资源--薪酬发放管理--薪酬发放复核 </font></td>
  </tr>
  <tr>
  
    <td width="49%"> 复核成功，谢谢！</td>
    <td width="51%" align="right">
			<input type="button" 
			class="BUTTON_STYLE1" 
			onclick="javascript:window.location.href='/hr_devl/dcf_SalaryGrant/check_list.jsp';" 
			value="返回" />
		</td>
		
		
     </tr>
  </table>
</form>
</body>
</html>