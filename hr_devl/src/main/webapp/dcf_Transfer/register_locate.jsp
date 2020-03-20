<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="/hr_devl/css/table.css" type="text/css">
		<link rel="stylesheet" type="text/css" media="all"
			href="/hr_devl/javascript/calendar/calendar-win2k-cold-1.css">
		<script type="text/javascript" src="/hr_devl/javascript/calendar/cal.js"></script>
		<script type="text/javascript" src="/hr_devl/javascript/comm/comm.js"></script>
		<script type="text/javascript" src="/hr_devl/javascript/comm/list.js"></script>
		<script type="text/javascript" src="/hr_devl/javascript/jquery-1.7.2.js"></script>	
		<script type="text/javascript" src="/hr_devl/javascript/calendar-ch.js"></script>
		<script type="text/javascript" src="/hr_devl/javascript/comm/time.js"></script>
		<link rel="stylesheet" href="/hr_devl/css/cwcalendar.css" type="text/css"></link> 
	 
	</head>

	<body>
		<form name="humanfileForm" method="post" action="/hr_devl/dcf/transfer/querytransferpeoples.do">
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是：人力资源--调动管理--调动登记查询 </font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="submit" value="查询"
							class="BUTTON_STYLE1" >
					</td>
				</tr>
			</table>
			<input type="hidden" name="page.startPage" value="0">
			<table width="101%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr class="TR_STYLE1">
					<td width="13%" class="TD_STYLE1">
						请选择员工所在I级机构					</td>
				  <td width="29%" class="TD_STYLE2">
						<script type="text/javascript"> 
			$(function() {
			var first=$("#firstKindId");
			var second= $("#secondKindId");
			var third=$("#thirdKindId");			
	 		 first.change(function(){
	 			var firstval=$('#firstKindId option:selected').val();
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
  
   <select style="width:160px" name="firstkindid" id="firstKindId" size="1" class="SELECT_STYLE2">						
								<option value="0">-----请选择-----</option>					
					  			
					  </select>
				  </td>
					<td width="13%" class="TD_STYLE1">
						请选择员工所在II级机构					</td>
				  <td width="45%" class="TD_STYLE2">
						 <script type="text/javascript"> 
			$(function() {
			 
			var first=$("#firstKindId");
			var second= $("#secondKindId");
			var third=$("#thirdKindId");
	 		 second.change(function(){
				var secondval=$('#secondKindId option:selected').val();
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
   <select style="width:160px" name="secondkindid" id="secondKindId" size="1" class="SELECT_STYLE2">						
								<option value="0">-----请选择-----</option>						
					 		
					  </select>
				  </td>
					<td width="0%"></td>
				</tr>
				<tr class="TR_STYLE1">
					<td width="13%" class="TD_STYLE1">
						请选择员工所在III级机构					</td>
					<td width="29%" class="TD_STYLE2">
					 <select style="width:160px" name="thirdkindid" id="thirdKindId" size="1" class="SELECT_STYLE2">		
								<option value="0">-----请选择-----</option>						
					   </select>
				  </td>
					<td height="18" class="TD_STYLE1">
						请输入建档时间					</td>
					<td width="45%" class="TD_STYLE2">
						<input name="starttime" onclick="aa('utilbean.startDate')" type="text" class="INPUT_STYLE2" id="date_start" style="width:24% " value="" size="30">
						至<input type="text" name="endtime" onclick="aa('utilbean.endDate')" value="" style="width:24% " class="INPUT_STYLE2" id="date_end">
						（YYYY-MM-DD）
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

		
