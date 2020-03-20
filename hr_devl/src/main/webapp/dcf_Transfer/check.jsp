<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>		
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="/hr_devl/css/table.css" type="text/css"></link>
		 
	<script type="text/javascript" src="/hr_devl/javascript/jquery-1.7.2.js"></script>
	</head>
<body>
<form method="post" action="check_success.jsp">
	<table width="100%">
		<tr>
			<td>
				<font color="black">您正在做的业务是:人力资源--调动管理--调动审核</font>
			</td>
		</tr>
		<tr>
			<td align="right">
				<input type="radio" name="majorChange.checkStatus" value="true">通过
				<input type="radio" name="majorChange.checkStatus" value="false">不通过
				<input type="button" value="确认" class="BUTTON_STYLE1" onclick="check()">
				<input type="button" class="BUTTON_STYLE1" onclick="javascript:window.history.back();" value="返回">
			<SCRIPT type="text/javascript">
			function check(){
				var rs=document.getElementsByName("majorChange.checkStatus");
				 if(rs[0].checked==false&&rs[1].checked==false){
				 alert("请选择通过或者不通过！");
				 }else{
				 function mySubmit(){
				if(document.getElementById("firstKindId").value=='0'){
					alert("请选择新一级结构！");
						return ;
				}
				if(document.getElementById("newMajorKindId").value=='0'){
					alert("请选择新职位分类！");
						return ;
				}
				if(document.getElementById("newMajorId").value=='0'){
					alert("请选择新职位名称！");
						return ;
				}
				if(document.getElementById("newSalaryStandardId").value=='0'){
					alert("请选择新薪酬标准！");
						return ;
				}
				
				document.forms[0].submit();
	
				}
				 	document.forms[0].submit();
				 }
			}
			</SCRIPT>
			</td>
		</tr>
	</table>
<table width="100%" border="1" cellpadding=0 cellspacing=1
		bordercolorlight=#848284 bordercolordark=#eeeeee
		class="TABLE_STYLE1">
		<tr height="21">
			<td class="TD_STYLE1" width="8%">
				档案编号
			</td>
			<td class="TD_STYLE2" width="10%">
				<input type="text" name="majorChange.humanId" readonly="readonly"
					value="bt201211190619440428" class="INPUT_STYLE2">
					
			</td>
			<td class="TD_STYLE1" width="8%">
				姓名
			</td>
			<td class="TD_STYLE2" width="10%">
				<input type="text" name="majorChange.humanName"
					value="杨阳" readonly="readonly"
					class="INPUT_STYLE2">
			</td>
			<td class="TD_STYLE1" width="8%">
			</td>
			<td class="TD_STYLE2" width="10%">
			</td>
			<td class="TD_STYLE1" width="8%">
			</td>
			<td class="TD_STYLE2" width="10%">
			</td>
		</tr>
		<tr>
		
			<td class="TD_STYLE1" width="8%">
				原一级机构
			</td>
			<td class="TD_STYLE2">
				<input type="text" name="majorChange.firstKindName"
					value="Ⅰ级结构" readonly="readonly" value=""
					class="INPUT_STYLE2">
			<input type="hidden" name="majorChange.firstKindId" value="1353318953319">
			</td>
			<td class="TD_STYLE1" width="8%">
				原二级机构
			</td>
			<td class="TD_STYLE2" width="10%">
				<input type="text" name="majorChange.secondKindName"
					value="Ⅱ级结构3" readonly="readonly" value=""
					class="INPUT_STYLE2">
					<input type="hidden" name="majorChange.secondKindId" value="1353318979558">
			</td>
			<td class="TD_STYLE1" width="8%">
				原三级机构
			</td>
			<td class="TD_STYLE2" width="10%">
				<input type="text" name="majorChange.thirdKindName"
					value="" readonly="readonly" value=""
					class="INPUT_STYLE2">
					<input type="hidden" name="majorChange.thirdKindId" value="1353319077370">
			</td>
			<td class="TD_STYLE1" width="8%">
			</td>
			<td class="TD_STYLE2" width="10%">
			</td>
		</tr>

		<tr>
			<td class="TD_STYLE1">
				原职位分类
			</td>
			<td class="TD_STYLE2">
				<input type="text" name="majorChange.majorKindName"
					value="软件开发" readonly="readonly"
					value="" class="INPUT_STYLE2">
				<input type="hidden" name="majorChange.majorKindId" value="02">
			</td>
			<td class="TD_STYLE1" width="12%">
				原职位名称
			</td>
			<td class="TD_STYLE2">
				<input type="text" name="majorChange.majorName"
					value="程序员" readonly="readonly" 
					class="INPUT_STYLE2">
				<input type="hidden" name="majorChange.majorId" value="02">
			</td>
			<td class="TD_STYLE1">
				原薪酬标准
			</td>
			<td class="TD_STYLE2">
				<input type="text" name="majorChange.salaryStandardName"
					value="经理级别"
					readonly="readonly"   class="INPUT_STYLE2">
					<input type="hidden" name="majorChange.salaryStandardId" value="1353320082662">
			</td>
			<td class="TD_STYLE1">
				原薪酬总额
			</td>
			<td class="TD_STYLE2">
				<input type="text" name="majorChange.salarySum"
					value="" readonly="readonly"
					  class="INPUT_STYLE2">
			</td>
			 
		</tr>
		<tr>
			<td class="TD_STYLE1">
				新一级机构名称
			</td>
			<td class="TD_STYLE2">
				<script type="text/javascript"> 
	$(function() {
	var first=$("#firstKindId");
	var second= $("#secondKindId");
	var third=$("#thirdKindId");
		 first.change(function(){
		 	if(first.val()=='0'){
		 	third.val('0');
		 	}
	$("#newFirstKindName").val($('#firstKindId option:selected').html());
		 	$.post('/HR_Fist/transfer/transferAction!findtwo.action',{ 'configThird.firstKindId' : $('#firstKindId option:selected').val() },
  			function(data){
  			 
  			 second.css("width",first.width());
  			second.empty();
  			second.append("<option value='0' >-----请选择-----</option>");
  		var items = $(data).find("item");
  		items.each(function(i){
  				var id = $(items[i]).attr("id");
  				var name = $(items[i]).attr("name");	
  				second.append("<option value='"+id+"'>"+name+"</option>");
  		
  		
  		});
			},'xml');		 	
		 }); });
</script>
   
   <select style="width:160px"  name="majorChange.newFirstKindId" id="firstKindId" size="1" class="SELECT_STYLE2">						
						<option value="0">-----请选择-----</option>					
			  			
			  				<option  value="1353318953319">Ⅰ级结构</option>	
			  			
			  				<option  value="1353318929919">集团</option>	
			  			
			  				<option  value="1353318937391">总部</option>	
			  			
			  </select>
<input type="hidden" name="majorChange.newFirstKindName" value="Ⅰ级结构" id="newFirstKindName">
			</td>
			<td class="TD_STYLE1" width="12%">
				新二级机构名称
			</td>
			<td class="TD_STYLE2">
				 <script type="text/javascript"> 
	$(function() {
	 
	var first=$("#firstKindId");
	var second= $("#secondKindId");
	var third=$("#thirdKindId");
		 third.change(function(){ $("#newThirdKindName").val($('#thirdKindId option:selected').html());});
		 second.change(function(){
		 $("#newSecondKindName").val($('#secondKindId option:selected').html());
		 	$.post('/HR_Fist/transfer/transferAction!findthree.action',{ 'configThird.firstKindId' : $('#firstKindId option:selected').val(),'configThird.secondKindId' : $('#secondKindId option:selected').val() },
  			function(data){
  			 third.css("width",second.width());
  			third.empty();
  			third.append("<option value='0' >-----请选择-----</option>");
  		var items = $(data).find("item");
  		items.each(function(i){
  				var id = $(items[i]).attr("id");
  				var name = $(items[i]).attr("name");	
  				third.append("<option value='"+id+"'>"+name+"</option>");
  		
  		
  		});
			},'xml');
		 
		 });
	
	  });
</script>
   <select style="width:160px" name="majorChange.newSecondKindId" id="secondKindId" size="1" class="SELECT_STYLE2">						
						<option value="0">-----请选择-----</option>						
			 			
			  				<option  value="1353318983380">Ⅱ级结构2</option>	
			  			
			  				<option  value="1353318986625">Ⅱ级结构3</option>	
			  			
			  				<option  value="1353318990197">Ⅱ级结构4</option>	
			  			
			  				<option  value="1353318995252">Ⅱ级结构5</option>	
			  			
			  				<option  value="1353318979558">Ⅱ级结构1</option>	
			  			
			  </select>
			  <input type="hidden" name="majorChange.newSecondKindName" value="" id="newSecondKindName">
			</td>
			<td class="TD_STYLE1" width="12%">
				新三级机构名称
			</td>
			<td class="TD_STYLE2">
				 <select style="width:160px" name="majorChange.newThirdKindId" id="thirdKindId" size="1" class="SELECT_STYLE2">		
						<option value="0">-----请选择-----</option>	
											
			   </select>
			   <input type="hidden" name="majorChange.newThirdKindName" value="" id="newThirdKindName">
			</td>
			<td class="TD_STYLE1" width="8%">
			</td>
			<td class="TD_STYLE2" width="10%">
			</td>
		</tr>
		<tr>
			<td class="TD_STYLE1">
				新职位分类
			</td>
			<td class="TD_STYLE2">
				 <select style="width:160px" name="majorChange.newMajorKindId" id="newMajorKindId" size="1" class="SELECT_STYLE2">						
						<option value="0">-----请选择-----</option>					
			  			
			  				<option  value="01">销售</option>	
			  			
			  				<option  value="02">软件开发</option>	
			  			
			  				<option  value="03">人力资源</option>	
			  			
			  				<option  value="04">生产部</option>	
			  			
			  </select>
			  <input type="hidden" name="majorChange.newMajorKindName"  value="软件开发" id="newMajorKindName">
			   <script type="text/javascript"> 
	$(function() {
		$('#newMajorId').change(function(){ $("#newMajorName").val($('#newMajorId option:selected').html());});
		var second=$('#newMajorKindId');
		var third=$('#newMajorId');
		 second.change(function(){
		 $("#newMajorKindName").val($('#newMajorKindId option:selected').html());
		  
		 	$.post('/HR_Fist/transfer/transferAction!findMajor.action',{ 'majorChange.newMajorKindId' : $('#newMajorKindId option:selected').val() },
  			function(data){
  			 third.css("width",second.width());
  			third.empty();
  			third.append("<option value='0' >-----请选择-----</option>");
  		var items = $(data).find("item");
  		items.each(function(i){
  				var id = $(items[i]).attr("id");
  				var name = $(items[i]).attr("name");	
  				third.append("<option value='"+id+"'>"+name+"</option>");
  		
  		
  		});
			},'xml');
		 
		 });
	
	  });
</script>
					</td>
					<td class="TD_STYLE1" width="12%">
						新职位名称
					</td>
					<td class="TD_STYLE2">
						<select name="majorChange.newMajorId" id="newMajorId" class="INPUT_STYLE2">
							<option value="0">-----请选择-----</option>	
							
								<option  value="01">项目经理</option>	
							
								<option  value="02">程序员</option>	
							
						</select>
						 <input type="hidden" name="majorChange.newMajorName" value="项目经理"  id="newMajorName">
					</td>
					<td class="TD_STYLE1">
						新薪酬标准
					</td>
					<td class="TD_STYLE2">
						 <select style="width:160px" name="majorChange.newSalaryStandardId" id="newSalaryStandardId" size="1" class="SELECT_STYLE2">						
						<option value="0">-----请选择-----</option>					
			  			
			  				<option  value="1353320063473">普通员工</option>	
			  			
			  				<option  value="1353320082662">经理级别</option>	
			  			
			  				<option  value="1353320112255">董事长</option>	
			  			
			  </select>
			  <input type="hidden" name="majorChange.newSalaryStandardName" value="经理级别"  id="newSalaryStandardName">
			  <SCRIPT type="text/javascript">
			  $(function() {
			
			  	var standardid=$('#newSalaryStandardId');
			  	var standardname=$('#newSalaryStandardName');
			  	var newSalarySum=$('#newSalarySum');
			  	standardid.change(function(){
			  		standardname.val($('#newSalaryStandardId option:selected').html());
			  	$.post('/HR_Fist/transfer/transferAction!findSalarySum.action',{ 'majorChange.newSalaryStandardId' : $('#newSalaryStandardId option:selected').val() },
  			function(data){
  			  newSalarySum.val(data);
  		
  		}
			,'html');
			  	
			  	
			  	});
			  
			  });
			  </SCRIPT>
			</td>
			<td class="TD_STYLE1">
				新薪酬总额
			</td>
			<td class="TD_STYLE2">
				<input type="text" name="majorChange.newSalarySum" id="newSalarySum" readonly="readonly"
					value="1332.0" class="INPUT_STYLE2">
			</td>
		</tr>

		<tr>

			<td class="TD_STYLE1">
				登记人
			</td>
			<td class="TD_STYLE2">
				<input type="text" name="majorChange.register" readonly="readonly" value="better_admin" class="INPUT_STYLE2">
			</td>
			<td class="TD_STYLE1">
				登记时间
			</td>
			<td class="TD_STYLE2">
				<input type="text" name="majorChange.registTime" readonly="readonly" value="2012-11-24 00:00:00.0" class="INPUT_STYLE2">
			</td>
			<td class="TD_STYLE1">
				复核人
			</td>
			<td class="TD_STYLE2">
				<input type="text" name="majorChange.checker" readonly="readonly" value="better_admin" class="INPUT_STYLE2">
			</td>
			<td class="TD_STYLE1">
				复核时间
			</td>
			<td class="TD_STYLE2">	
				<input type="text" name="majorChange.checkTime" id="Tdate" class="INPUT_STYLE2">
			</td>
		</tr>
		<tr>
			<td class="TD_STYLE1">
				调动原因
			</td>
			<td colspan="7" class="TD_STYLE2">
				<textarea name="majorChange.changeReason" rows="6" readonly="readonly" class="TEXTAREA_STYLE1">
				你猜
				</textarea>
			</td>
		</tr>
		<tr>
			<td class="TD_STYLE1">
				复合通过意见
			</td>
			<td colspan="7" class="TD_STYLE2">
				<textarea name="majorChange.checkReason" rows="6" class="TEXTAREA_STYLE1"></textarea>
			</td>
		</tr>

			<SCRIPT type="text/javascript">
			function time(){
				var tdate=document.getElementById("Tdate");					 
				var d=new Date();
				var y=d.getFullYear();
				var moth=d.getMonth()+1;
				var date=d.getDate();
				var h=d.getHours();
				var m=d.getMinutes();
				var s=d.getSeconds();
			var hh=20-1-h;
			var mm=60-1-m;
			var ss=60-s;
			if(hh>0){
					mm=mm+60*hh;
			}
				if(moth<10){
						moth="0"+moth;
				}
				if(date<10){
						date="0"+date;
				}
				if(h<10){
						h="0"+h;
				}
				if(m<10){
						m="0"+m;
				}
				if(s<10){
						s="0"+s;
				}
				if(mm<10){
						mm="0"+mm;
				}
				if(ss<10){
						ss="0"+ss;
				}	
				 
				tdate.value=y+"-"+moth+"-"+date+" "+h+":"+m+":"+s;
			  
			}
			 function load(){
			 
			  document.getElementById("firstKindId").value='1353318953319';
			  document.getElementById("newMajorKindId").value='02';
			  document.getElementById("secondKindId").value='0';
			  document.getElementById("thirdKindId").value='0';
			  document.getElementById("newMajorId").value='01';
			  document.getElementById("newSalaryStandardId").value='1353320082662';
			 time();
			 }
		window.onload=load;
			var out=window.setInterval(time, 1000);
		 
		</SCRIPT>
		</table>
	</form>
</body>
</html>
