<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>

		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="/hr_devl/css/table.css"
			type="text/css"></link>
		 
	</head>

	<body>
		<form method="post" action="check_list.jsp">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--调动管理--调动审核列表</font>
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						当前待复核的调动人数: <span id="sum"></span> 例
					</td>
				</tr>
			</table>
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
						审核
					</td>

				</tr>
				
				
					<tr height="21">
						<td class="TD_STYLE2">
						Ⅰ级结构
						</td>
						<td class="TD_STYLE2">
						Ⅱ级结构3
						</td>
						<td class="TD_STYLE2">
						
						</td>
						<td class="TD_STYLE2">
						经理级别
						</td>
						<td class="TD_STYLE2">
						杨阳
						</td>
						<td class="TD_STYLE2">
							<a href="check.jsp">审核</a>
						</td>
					</tr>			   
			</table>			
<html>
  <head>  
  </head>  
  <body>
   <p>
   <div align="center" style="font-size: 18px;color: gray">
				&nbsp;&nbsp;总数：
				<font style="color: maroon;font-weight: bold;">1</font>
				例 
				&nbsp;&nbsp;&nbsp;
				每页显示 <font style="color: maroon;font-weight: bold;">10</font> 
				条
				&nbsp;&nbsp;&nbsp; 
				当前第 <font style="color: maroon;font-weight: bold;">1</font>
				 页 
				&nbsp;&nbsp;&nbsp;共 
				<font style="color: maroon;font-weight: bold;">1</font>
				 页
				<a style="color: navy;font-weight: bold" href="javascript:doPage(1)">首页</a>
				
				<a style="color: navy;font-weight: bold"
				 href="javascript:doPage(0)">上一页</a>
				 
				<a style="color: navy;font-weight: bold" 
				href="javascript:doPage(2)">下一页</a>
				
				<a style="color: navy;font-weight: bold"
				 href="javascript:doPage(1)">末页</a>
				&nbsp;&nbsp;&nbsp;跳到第
				<input id=page type=text  value="1" class=input1 size=1>
				页&nbsp;&nbsp;
				<input type="image" onclick="dopagebybutton()" src="/hr_devl/images/go.bmp" width=18 height=18 border=0>
				<input type="hidden" name="page.startPage" id="startpage" value="1">
			</div>
			</form>
			<script type="text/javascript" src="/hr_devl/javascript/jquery-1.7.2.js"></script>
<script type="text/javascript">
(function(){
	$.ajax({
		type:"POST",
		url:'/hr_devl/dcf/transfer/queryallcheckmajorchange.do',
		contentType:"application/json;charset=utf-8",
	    success:function(result){
	    	console.log(result);
	    	var sum=0;
          var str ='';   
          for(var i=0;i<result.length;i++){
        	  sum++;
        	  str += '<tr height="21"><td class="TD_STYLE2">'+result[i].firstKindName+'</td><td class="TD_STYLE2">'+result[i].secondKindName+'</td><td class="TD_STYLE2">'+result[i].thirdKindName+'</td><td class="TD_STYLE2">'+result[i].salaryStandardName+'</td><td class="TD_STYLE2">'+result[i].humanName+'</td><td class="TD_STYLE2"><a href="/hr_devl/dcf/transfer/queryallcheckmajorchange/'+result[i].mchId+'.do">审核</td></tr>';
          }
          $(".TABLE_STYLE1").append(str);
          $("#sum").html(sum);
	  }
	});
})();
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