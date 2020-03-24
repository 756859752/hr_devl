<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet"
			href="/hr_devl/css/table.css" type="text/css"></link>
		<script type="text/javascript" src="/hr_devl/javascript/jquery-1.7.2.js"></script>
	</head>

	<body>
		<form action="/hr_devl/dcf/transfer/addtransferinfo.do" method="post">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是:人力资源--调动管理--调动登记</font>
					</td>
				</tr>
				
				<tr>
					<td align="right">
						<input type="button" value="提交" class="BUTTON_STYLE1"
							onclick="mySubmit()">
						<input type="button" class="BUTTON_STYLE1"
							onclick="javascript:window.history.back();" value="返回">
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
						<input type="text" name="humanId" readonly="readonly"
							value="${humanfile.humanId}" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1" width="8%">
						姓名	
					</td>
					
					<td class="TD_STYLE2" width="10%">
						<input type="text" name="humanName"
							value="${humanfile.humanName}" readonly="readonly"
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
						<input type="text" name="firstKindName"
							value="${humanfile.firstKindName}" readonly="readonly" value=""
							class="INPUT_STYLE2">
					<input type="hidden" name="firstKindId" value="${humanfile.firstKindId}">
					</td>
					<td class="TD_STYLE1" width="8%">
						原二级机构
					</td>
					<td class="TD_STYLE2" width="10%">
						<input type="text" name="secondKindName"
							value="${humanfile.secondKindName}" readonly="readonly" value=""
							class="INPUT_STYLE2">
							<input type="hidden" name="secondKindId" value="${humanfile.secondKindId}">
					</td>
					<td class="TD_STYLE1" width="8%">
						原三级机构
					</td>
					<td class="TD_STYLE2" width="10%">
						<input type="text" name="thirdKindName"
							value="" readonly="readonly" value="${humanfile.thirdKindName}"
							class="INPUT_STYLE2">
							<input type="hidden" name="thirdKindId" value="${humanfile.thirdKindId}">
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
						<input type="text" name="majorKindName"
							value="${humanfile.humanMajorKindName}" readonly="readonly"
				              class="INPUT_STYLE2">
						<input type="hidden" name="majorKindId" value="${humanfile.humanMajorKindId}">
					</td>
					<td class="TD_STYLE1" width="12%">
						原职位名称
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="majorName"
							value="${humanfile.hunmaMajorName}" readonly="readonly" 
							class="INPUT_STYLE2">
						<input type="hidden" name="majorId" value="${humanfile.humanMajorId}">
					</td>
					<td class="TD_STYLE1">
						原薪酬标准
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="salaryStandardName"
							value="${humanfile.salaryStandardName}"
							readonly="readonly"   class="INPUT_STYLE2">
							<input type="hidden" name="salaryStandardId" value="${humanfile.salaryStandardId}">
					</td>
					<td class="TD_STYLE1">
						原薪酬总额
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="salarySum"
							value="${humanfile.salarySum}" readonly="readonly"
							  class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						新一级机构名称
					</td>
					<td class="TD_STYLE2">
						<script type="text/javascript"> 
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
			$(function() {
				var first=$("#firstKindId");
				var second= $("#secondKindId");
				var third=$("#thirdKindId");			
		 		 first.change(function(){
		 			var firstval=$('#firstKindId option:selected').val();
		 			$("#newFirstKindName").val($('#firstKindId option:selected').html());
		 		 	$.post('/hr_devl/dcf/transfer/queryConditions.do?firstkindid='+firstval+'&secondkindid',
			  			function(data){
			  			 second.css("width",first.width());
			  			second.empty();
			  			second.append("<option value='0' >-----请选择-----</option>");
			  			third.empty();
			  			third.append("<option value='0' >-----请选择-----</option>");
			  		      var str =''; 
			  		      <!--拿到二级集合-->
				  		  var li=data.second;
				          for(var i=0;i<li.length;i++){
				        	  str += '<option name="secondkindid" value='+li[i].secondKindId+'>'+li[i].secondKindName+'</option>';
				          }
				          $("#secondKindId").append(str);
					  },);
		 		 	third.val('0');
		 		 }); });
</script>
    
   <select style="width:160px" name="newFirstKindId" id="firstKindId" size="1" class="SELECT_STYLE2">						
								<option value="0">-----请选择-----</option>									  
	</select>
		<input type="hidden" name="newFirstKindName" id="newFirstKindName">
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
		 		 second.change(function(){
					var secondval=$('#secondKindId option:selected').val();
					$("#newSecondKindName").val($('#secondKindId option:selected').html());
		 		 	$.post('/hr_devl/dcf/transfer/queryConditions.do?firstkindid&secondkindid='+secondval+'',
			  			function(data){
			  			third.css("width",second.width());
			  			third.empty();
			  			third.append("<option value='0' >-----请选择-----</option>");
			  		   var str ='';
			  		 <!--拿到三级集合-->
			  		  var li=data.third;
			          for(var i=0;i<li.length;i++){
			        	  str += '<option name="thirdkindid" value='+li[i].thirdKindId+'>'+li[i].thirdKindName+'</option>';
			          }
			          $("#thirdKindId").append(str);
						},);
		 			third.val('0');
		 		 });	
				  });
</script>
   <select style="width:160px" name="newSecondKindId" id="secondKindId" size="1" class="SELECT_STYLE2">						
								<option value="0">-----请选择-----</option>						
					 		
					  </select>
					  <input type="hidden" name="newSecondKindName" id="newSecondKindName">
					</td>
					<td class="TD_STYLE1" width="12%">
						新三级机构名称
					</td>
					 <script type="text/javascript"> 
			$(function() {
				var third=$("#thirdKindId");
				third.change(function(){
					var secondval=$('#thirdKindId option:selected').html();
					$("#newThirdKindName").val(secondval);
		 		 });	
				  });
            </script>
					<td class="TD_STYLE2">
						 <select style="width:160px" name="newThirdKindId" id="thirdKindId" size="1" class="SELECT_STYLE2">		
								<option value="0">-----请选择-----</option>						
					   </select>
					   <input type="hidden" name="newThirdKindName" id="newThirdKindName">
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
						 <select style="width:160px" name="newMajorKindId" id="newMajorKindId" size="1" class="SELECT_STYLE2">						
								<option value="0">-----请选择-----</option>					
					  			   <c:forEach items="${majorkinds}" var="m">
					  			      <option  value="${m.majorKindId}">${m.majorKindName}</option>	
					  			   </c:forEach>
					  </select>
					  <input type="hidden" name="newMajorKindName" id="newMajorKindName">
					   <script type="text/javascript"> 
			$(function() {
	 		$('#newMajorId').change(function(){
	 			$("#newMajorName").val($('#newMajorId option:selected').html());
	 			});
	 		});
			           
	 		var second=$('#newMajorKindId');;
	 		 second.change(function(){
	 		 $("#newMajorKindName").val($('#newMajorKindId option:selected').html()); 
	 		 	$.post('/hr_devl/dcf/transfer/querymajors/'+$('#newMajorKindId option:selected').val()+'.do',
		  			function(data){
	 		 		$('#newMajorId').css("width",second.width());
		  			$('#newMajorId').empty();
		  			$('#newMajorId').append("<option value='0' >-----请选择-----</option>");
		  		    var	str ='';
		          for(var i=0;i<data.length;i++){ 
		        	  str += '<option name="newMajorId" value='+data[i].majorId+'>'+data[i].majorName+'</option>';
		          }
		          $("#newMajorId").append(str);
	 		 	},);
	 		 	 $("#newMajorId").val('0');
	 		 });	
</script>
					</td>
					<td class="TD_STYLE1" width="12%">
						新职位名称
					</td>
					<td class="TD_STYLE2">
						<select name="newMajorId" id="newMajorId" class="INPUT_STYLE2">
							<option value="0">-----请选择-----</option>	
						</select>
						 <input type="hidden" name="newMajorName" id="newMajorName">
					</td>
					<td class="TD_STYLE1">
						新薪酬标准
					</td>
					<td class="TD_STYLE2">
						 <select style="width:160px" name="newSalaryStandardId" id="newSalaryStandardId" size="1" class="SELECT_STYLE2">						
								<option value="0">-----请选择-----</option>					
					  			    <c:forEach items="${salarystandard}" var="s">
					  			        <option  value="${s.standardId}">${s.standardName }</option>
					  			    </c:forEach>			  			
					  </select>
					  <input type="hidden" name="newSalaryStandardName" id="newSalaryStandardName">
					  <SCRIPT type="text/javascript">
					  $(function() {
					  	var standardid=$('#newSalaryStandardId');
					  	var standardname=$('#newSalaryStandardName');
					  	var newSalarySum=$('#newSalarySum');
					  	standardid.change(function(){
					  	 standardname.val($('#newSalaryStandardId option:selected').html());
					  	$.post('/hr_devl/dcf/transfer/querysumsalar/'+$('#newSalaryStandardId option:selected').val()+'.do',
					  		function(data){
					  		newSalarySum.val(data);     
				 		 	},); 			     
		  		         });
					  	});
					  </SCRIPT>
					</td>
					<td class="TD_STYLE1">
						新薪酬总额
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="newSalarySum" id="newSalarySum" readonly="readonly"
							value="0.00" class="INPUT_STYLE2">
					</td>
				</tr>

				<tr>
					<td class="TD_STYLE1">
						登记人
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="register" readonly="readonly" value="${userlogin.user_true_name}"
							class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						登记时间
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="registTime" readonly="readonly"
							id="Tdate" class="INPUT_STYLE2">
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
				window.onload=time;
 				var out=window.setInterval(time, 1000);
					</SCRIPT>
					</td>
					<td class="TD_STYLE1">

					</td>
					<td class="TD_STYLE2">

					</td>
					<td class="TD_STYLE1">

					</td>
					<td class="TD_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						调动原因
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="changeReason" rows="6" class="TEXTAREA_STYLE1"></textarea>
					</td>
				</tr>
			</table>
		</form>
	</body>
	<script type="text/javascript">
(function(){
	$.ajax({
		type:"POST",
		url:'/hr_devl/dcf/transfer/queryConditions.do?firstkindid&secondkindid',
		contentType:"application/json;charset=utf-8",
	    success:function(result){
          var str ='';   
          var li=result.first;
          for(var i=0;i<li.length;i++){
        	  str += '<option name="firstkindid" value='+li[i].firstKindId+'>'+li[i].firstKindName+'</option>';
          }
          $("#firstKindId").append(str);
	  }
	});
})();
</script>
</html>

		
