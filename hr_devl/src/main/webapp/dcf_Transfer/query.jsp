<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<form method="post" action="list.jsp">
		<input type="hidden" name="page.startPage" value="0">
		<table width="100%">
			<tr>
				<td>
					<font color="black">您正在做的业务是：人力资源--调动管理--调动查询 </font>
				</td>
			</tr>
			<tr>
				<td align="right">
					<input type="submit" value="查询"
						class="BUTTON_STYLE1" >
				</td>
			</tr>
		</table>
		<table width="100%" border="1" cellpadding=0 cellspacing=1
			bordercolorlight=#848284 bordercolordark=#eeeeee
			class="TABLE_STYLE1">
			<tr class="TR_STYLE1">
				<td width="16%" class="TD_STYLE1">
					请选择员工所在I级机构
				</td>
				<td width="84%" class="TD_STYLE2">

  <select  name="majorChange.newFirstKindId" id="firstKindId" size="5" class="SELECT_STYLE2">
  							<option value="0" selected="selected">全部</option>											
		  			
		  				<option  value="1353318953319">Ⅰ级结构</option>	
		  			
		  				<option  value="1353318929919">集团</option>	
		  			
		  				<option  value="1353318937391">总部</option>	
				  			
				  </select>
				</td>
			</tr>
			<tr>
				<td class="TD_STYLE1">
					请选择员工所在II级机构
				</td>
				<td width="84%" class="TD_STYLE2">
					
   <select  name="majorChange.newSecondKindId" id="secondKindId" size="5" class="SELECT_STYLE2">																 		
        <option value="0" selected="selected">全部</option>		

		<option  value="1353318983380">Ⅱ级结构2</option>	
	
		<option  value="1353318986625">Ⅱ级结构3</option>	
	
		<option  value="1353318990197">Ⅱ级结构4</option>	
	
		<option  value="1353318995252">Ⅱ级结构5</option>	
	
		<option  value="1353319004705">软件公司</option>	
	
		<option  value="1353319016546">科技公司</option>	
	
		<option  value="1353319033409">北京分校区</option>	
	
		<option  value="1353319038682">湖南分校区</option>	
	
		<option  value="1353319043830">湖北分校区</option>	
	
		<option  value="1353318979558">Ⅱ级结构1</option>	
			  			
	</select>
		</td>
	</tr>
	<tr class="TR_STYLE1">
		<td width="16%" class="TD_STYLE1">
			请选择员工所在III级机构
		</td>
		<td width="84%" class="TD_STYLE2">
			 <select  name="majorChange.newThirdKindId" id="thirdKindId" size="5" class="SELECT_STYLE2">		
					<option value="0" selected="selected">全部</option>		
					
		  				<option  value="1353319130551">外包公司</option>	
		  			
		  				<option  value="1353319150238">软件股份有限公司</option>	
		  			
		  				<option  value="1353319177944">中关村分校区1</option>	
		  			
		  				<option  value="1353319185073">中关村分校区2</option>	
		  			
		  				<option  value="1353319193840">中关村分校区3</option>	
		  			
		  				<option  value="1353319216320">长沙分校区1</option>	
		  			
		  				<option  value="1353319228535">长沙分校区2</option>	
		  			
		  				<option  value="1353319236725">长沙分校区3</option>	
		  			
		  				<option  value="1353319077370">Ⅲ级结构111</option>	
		  			
		  				<option  value="1353319096948">Ⅲ级结构222</option>	
		  								
		   </select>
		</td>
	</tr>
			<tr>
				<td class="TD_STYLE1">
					请选择职位分类
				</td>
				<td width="84%" class="TD_STYLE2">
					<select name="majorChange.newMajorKindId" id="newMajorKindId" size="5" class="SELECT_STYLE2">						
							 			<option value="0" selected="selected">全部</option>		
				  			
				  				<option  value="01">销售</option>	
				  			
				  				<option  value="02">软件开发</option>	
				  			
				  				<option  value="03">人力资源</option>	
				  			
				  				<option  value="04">生产部</option>	
				  			
				  </select>
				</td>
			</tr>
			<tr class="TR_STYLE1">
				<td width="16%" class="TD_STYLE1">
					请选择职位名称
				</td>
				<td width="84%" class="TD_STYLE2">
					<select name="majorChange.newMajorId"  size=5 id="newMajorId" class="SELECT_STYLE2">
						<option value="0" selected="selected">全部</option>	
						
							<option  value="01">区域经理</option>	
						
							<option  value="02">总经理</option>	
						
							<option  value="01">项目经理</option>	
						
							<option  value="02">程序员</option>	
						
							<option  value="01">人事经理</option>	
						
							<option  value="02">专员</option>	
						
							<option  value="01">主任</option>	
						
							<option  value="02">技术工人</option>	
							
					</select>
				</td>
			</tr>
			<tr>
				<td class="TD_STYLE1">
					请输入建档时间
				</td>
				<td width="84%" class="TD_STYLE2">
					<input name="utilbean.startDate" onclick="aa('utilbean.startDate')" type="text" class="INPUT_STYLE2" id="date_start" style="width:24% " value="" size="30">
	           	至<input type="text" name="utilbean.endDate" onclick="aa('utilbean.endDate')" value="" style="width:24% " class="INPUT_STYLE2" id="date_end">
					（YYYY-MM-DD）
				</td>
			</tr>
			</table>
		</form>
	</body>
	<script type="text/javascript">
	  (function(){
		  $.ajax({
				url:'/hr_devl/dcf/transfer/choseConditions.do',	
				type:"POST",
				contentType:"application/json;charset=utf-8",
			    success:function(result){
		         console.log(result);
			  }
			});
	  })();
	</script>
</html>

