<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>		
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="/hr_devl/css/table.css" type="text/css"></link>	 
	<script type="text/javascript" src="/hr_devl/javascript/jquery-1.7.2.js"></script>
	</head>
<body>
<form method="post" action="/hr_devl/dcf/transfer/passonemajorchange.do">
	<table width="100%">
		<tr>
			<td>
				<font color="black">您正在做的业务是:人力资源--调动管理--调动审核</font>
			</td>
		</tr>
		<tr>
			<td align="right">
				<input type="radio" name="checkStatus" value="1">通过
				<input type="radio" name="checkStatus" value="0">不通过
				<input type="button" value="确认" class="BUTTON_STYLE1" onclick="check()">
				<input type="button" class="BUTTON_STYLE1" onclick="javascript:window.history.back();" value="返回">
			<SCRIPT type="text/javascript">
			function check(){
				var rs=document.getElementsByName("checkStatus");
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
		<input type="hidden" name="mchId" value="${onechang.mchId}"/>
		<tr height="21">
			<td class="TD_STYLE1" width="8%">
				档案编号
			</td>
			<td class="TD_STYLE2" width="10%">
				<input type="text" name="humanId" readonly="readonly"
					value="${onechang.humanId}" class="INPUT_STYLE2">
					
			</td>
			<td class="TD_STYLE1" width="8%">
				姓名
			</td>
			<td class="TD_STYLE2" width="10%">
				<input type="text" name="humanName"
					value="${onechang.humanName}" readonly="readonly"
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
					value="${onechang.firstKindName}" readonly="readonly" value=""
					class="INPUT_STYLE2">
			<input type="hidden" name="firstKindId" value="${onechang.firstKindId}">
			</td>
			<td class="TD_STYLE1" width="8%">
				原二级机构
			</td>
			<td class="TD_STYLE2" width="10%">
				<input type="text" name="secondKindName"
					value="${onechang.secondKindName}" readonly="readonly" value=""
					class="INPUT_STYLE2">
					<input type="hidden" name="secondKindId" value="${onechang.secondKindId}">
			</td>
			<td class="TD_STYLE1" width="8%">
				原三级机构
			</td>
			<td class="TD_STYLE2" width="10%">
				<input type="text" name="thirdKindName"
					value="${onechang.thirdKindName}" readonly="readonly" value=""
					class="INPUT_STYLE2">
					<input type="hidden" name="thirdKindId" value="${onechang.thirdKindId}">
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
					value="${onechang.majorKindName}" readonly="readonly"
			         class="INPUT_STYLE2">
				<input type="hidden" name="majorKindId" value="${onechang.majorKindId}">
			</td>
			<td class="TD_STYLE1" width="12%">
				原职位名称
			</td>
			<td class="TD_STYLE2">
				<input type="text" name="majorName"
					value="${onechang.majorName}" readonly="readonly" 
					class="INPUT_STYLE2">
				<input type="hidden" name="majorId" value="${onechang.majorId}">
			</td>
			<td class="TD_STYLE1">
				原薪酬标准
			</td>
			<td class="TD_STYLE2">
				<input type="text" name="salaryStandardName"
					value="${onechang.salaryStandardName}"
					readonly="readonly"   class="INPUT_STYLE2">
					<input type="hidden" name="majorChange.salaryStandardId" value="${onechang.salaryStandardId}">
			</td>
			<td class="TD_STYLE1">
				原薪酬总额
			</td>
			<td class="TD_STYLE2">
				<input type="text" name="salarySum"
					value="${onechang.salarySum}" readonly="readonly"
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
   
   <select style="width:160px" name="newFirstKindId" id="firstKindId" size="1" class="SELECT_STYLE2" >						
								<option  value="${onechang.newFirstKindId}" >${onechang.newFirstKindName}</option>	
								<c:forEach items="${configefirstkind}" var="f">
								   <option value="${f.firstKindId}">${f.firstKindName}</option>	
								</c:forEach>				
									  
	</select>
		<input type="hidden" name="newFirstKindName" id="newFirstKindName" value="${onechang.newFirstKindName}">
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
								<option value="${onechang.newSecondKindId}">${onechang.newSecondKindName}</option>						
					 		
					  </select>
					  <input type="hidden" name="newSecondKindName" id="newSecondKindName" value="${onechang.newSecondKindName}">
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
								<option value="${onechang.newThirdKindId}" >${onechang.newThirdKindName}</option>						
					   </select>
					   <input type="hidden" name="newThirdKindName" id="newThirdKindName" value="${onechang.newThirdKindName}">
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
								<option value="${onechang.newMajorKindId}">${onechang.newMajorKindName}</option>					
					  			   <c:forEach items="${majorkinds}" var="m">
					  			      <option  value="${m.majorKindId}">${m.majorKindName}</option>	
					  			   </c:forEach>
					  </select>
					  <input type="hidden" name="newMajorKindName" id="newMajorKindName" value="${onechang.newMajorKindName}">
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
						<select style="width:160px" name="newMajorId" id="newMajorId" class="INPUT_STYLE2">
							<option value="${onechang.newMajorId}">${onechang.newMajorName}</option>	
						</select>
						 <input type="hidden" name="newMajorName" id="newMajorName" value="${onechang.newMajorName}">
					</td>
					<td class="TD_STYLE1">
						新薪酬标准
					</td>
					<td class="TD_STYLE2">
						 <select style="width:160px" name="newSalaryStandardId" id="newSalaryStandardId" size="1" class="SELECT_STYLE2">						
								<option value="${onechang.newSalaryStandardId}" selected>${onechang.newSalaryStandardName}</option>					
					  			    <c:forEach items="${salarystandard}" var="s">
					  			        <option  value="${s.standardId}">${s.standardName }</option>
					  			    </c:forEach>			  			
					  </select>
					  <input type="hidden" name="newSalaryStandardName" id="newSalaryStandardName" value="${onechang.newSalaryStandardName}">
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
							value="${onechang.newSalarySum}" class="INPUT_STYLE2">
					</td>
				</tr>

		<tr>
			<td class="TD_STYLE1">
				登记人
			</td>
			<td class="TD_STYLE2">
				<input type="text" name="register" readonly="readonly" value="${onechang.register}" class="INPUT_STYLE2">
			</td>
			<td class="TD_STYLE1">
				登记时间
			</td>
			<td class="TD_STYLE2">
				<input type="text" name="registTime" readonly="readonly" value="${onechang.registTime}" class="INPUT_STYLE2">
			</td>
			<td class="TD_STYLE1">
				复核人
			</td>
			<td class="TD_STYLE2">
				<input type="text" name="checker" readonly="readonly" value="${onechang.checker}" class="INPUT_STYLE2">
			</td>
			<td class="TD_STYLE1">
				复核时间
			</td>
			<td class="TD_STYLE2">	
				<input type="text" name="checkTime" id="Tdate" class="INPUT_STYLE2">
			</td>
		</tr>
		<tr>
			<td class="TD_STYLE1">
				调动原因
			</td>
			<td colspan="7" class="TD_STYLE2">
				<textarea name="changeReason" rows="6" readonly="readonly" class="TEXTAREA_STYLE1">
				${onechang.changeReason}
				</textarea>
			</td>
		</tr>
		<tr>
			<td class="TD_STYLE1">
				复合通过意见
			</td>
			<td colspan="7" class="TD_STYLE2">
				<textarea name="checkReason" rows="6" class="TEXTAREA_STYLE1"></textarea>
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
