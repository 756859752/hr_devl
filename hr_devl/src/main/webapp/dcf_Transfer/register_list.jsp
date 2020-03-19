<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>		
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="/hr_devl/css/table.css"
			type="text/css"></link>
			<STYLE type="text/css">
			</STYLE>
	</head>
	<body onload="">
		<form action="/HR_Fist/transfer/transferAction!findPage" method="post" >
			<font color="black"> 您在做的业务是-人力资源-调动管理-调动登记列表 </font>
			<br/><br/><br/>			
		
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr height="21">
					<td width="19%" class="TD_STYLE1">
						I级机构
					</td>
					<td width="19%" class="TD_STYLE1">
						II级机构
					</td>
					<td width="19%" class="TD_STYLE1">
						Ⅲ级机构
					</td>
					<td width="19%" class="TD_STYLE1">
						薪酬标准
					</td>
					<td width="19%" class="TD_STYLE1">
						名字
					</td>
					<td width="5%" class="TD_STYLE1">
						调动

					</td>
				</tr>
				<c:forEach items="${list}" var="i">
				<tr height="21">
						<td class="TD_STYLE2">
						${i.firstKindName}
						</td>
						<td class="TD_STYLE2">
						${i.secondKindName}
						</td>
						<td class="TD_STYLE2">
						${i.thirdKindName}
						</td>
						<td class="TD_STYLE2">
						${i.salaryStandardName}
						</td>
						<td class="TD_STYLE2">
						 ${i.humanName }
						</td>
						<td class="TD_STYLE2">
							<a href="/hr_devl/dcf/transfer/querytransferonepeople/${i.hufId}.do">
							调动</a>
						</td>
					</tr>
				</c:forEach>	
			</table>	
<html>
  <head>  
  </head>  
  <body>
   <p>
   <div align="center" style="font-size: 18px;color: gray">
				&nbsp;&nbsp;总数：
				<font style="color: maroon;font-weight: bold;">14</font>
				例 
				&nbsp;&nbsp;&nbsp;
				每页显示 <font style="color: maroon;font-weight: bold;">10</font> 
				条
				&nbsp;&nbsp;&nbsp; 
				当前第 <font style="color: maroon;font-weight: bold;">1</font>
				 页 
				&nbsp;&nbsp;&nbsp;共 
				<font style="color: maroon;font-weight: bold;">2</font>
				 页
				<a style="color: navy;font-weight: bold" href="javascript:doPage(1)">首页</a>
				
				<a style="color: navy;font-weight: bold"
				 href="javascript:doPage(0)">上一页</a>
				 
				<a style="color: navy;font-weight: bold" 
				href="javascript:doPage(2)">下一页</a>
				
				<a style="color: navy;font-weight: bold"
				 href="javascript:doPage(2)">末页</a>
				&nbsp;&nbsp;&nbsp;跳到第
				<input id=page type=text  value="1" class=input1 size=1>
				页&nbsp;&nbsp;
				<input type="image" onclick="dopagebybutton()" src="/hr_devl/images/go.bmp" width=18 height=18 border=0>
				<input type="hidden" name="page.startPage" id="startpage" value="1">
			</div>
			<script type="text/javascript">
function dopagebybutton() {
	var reg = /^[0-9]*[1-9][0-9]*$/;
	if (reg.test(document.getElementById("page").value)) {
		document.getElementById("startpage").value= document.getElementById("page").value;
	} else {
		alert("您的输入有误");
		document.getElementById("page").value = document.getElementById("startpage").value;
	}
	document.forms[0].submit();
	
}
function doPage(startsize) {
	document.getElementById("startpage").value =startsize;
	document.forms[0].submit();
	 
}
</script>
   
   
  </body>
</html>

			
		</form>
	</body>
</html>