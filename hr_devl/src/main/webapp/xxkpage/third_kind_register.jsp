<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
   String path = request.getContextPath();
   String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <base href="<%=basePath%>">
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <link rel="stylesheet" href="table.css" type="text/css">
 <script type="text/javascript" src="javascript/comm/comm.js"></script>
 <script type="text/javascript" src="js/jquery-1.6.1.min.js"></script>
 <script type="text/javascript">
  function save(){
        $("#configFileThirdKind").submit();   
  }
  
  function change(){
     var fid   =$("#firstKindId").val(); 
     var fna   =$("#f"+fid).html();
     $("#firstKindName").val(fna) ;    
     $("#secondKindId").empty() ; 
     $("#secondKindId").append("<option value=''>--请选择II级机构--</option>"); 
     $.ajax({
     type:"post",
     contextType:"application/json,charset=utf-8",
     url:"xxk/"+fid+"/selectbyfisrtKindId.do" ,
     success:function(ret){
     for(var i=0;i<ret.length;i++){
      var data=ret[i];  
     $("#secondKindId").append( 
     "<option id='second"+data.secondKindId+"'  value="+data.secondKindId+">"+data.secondKindName+"</option>");
     }
   }  
    }) ;  
   
  }
 
 
  function schange(){
    var f   = $("#secondKindId").val();
    
    var kk  = $("#second"+f).html();

    $("#secondKindName").val(kk);             
  }
 </script>
 </head>
<body>
   
   
<form   id="configFileThirdKind"  name="configFileThirdKind"  method="post"  action="xxk/addconfigThirdkind.do">
<table width="100%" >
  <tr>
    <td> 
    <font color="#0000CC">您正在做的业务是：人力资源--客户化设置--人力资源档案管理设置--III 级机构设置 </font></td>
  </tr>
  <tr>
    <td align="right"><input type="button" value="提交" class="BUTTON_STYLE1" onclick="save()">
      <input type="button" value="返回" class="BUTTON_STYLE1" onclick="history.back();">
    </td>
  </tr>
  </table>
  
<table width="100%"  border="1" cellpadding=0 cellspacing=1 bordercolorlight=#848284 bordercolordark=#eeeeee class="TABLE_STYLE1">
    
   
   <!-- 
    private Short  ftkId;
	private String firstKindId;
	private String firstKindName;
	private String secondKindId;
	private String secondKindName;
	private String thirdKindId;
	private String thirdKindName;
	private String thirdKindSaleId;
	private String thirdKindIsRetail;
    -->
   <tr>
    <!-- private Short fskId;
	private String firstKindId;
	private String firstKindName;
	private String secondKindId;
	private String secondKindName;
	private String secondSalaryId;
	private String secondSaleId; -->
					<td width="19%" class="TD_STYLE1">
						I级机构名称
					</td>
					<td width="81%" class="TD_STYLE2">
					<input  type="hidden" id="firstKindName" name="firstKindName" >
					<select name="firstKindId" id="firstKindId"  class="INPUT_STYLE1" onchange="change()"> 
						<option >--请选择I级机构--</option>
						<c:forEach items="${configFileFirstKind}"  var="i">
							<option id="f${i.firstKindId }"  value="${i.firstKindId }" > ${i.firstKindName } </option>
						</c:forEach>
					 </select>
					
					</td>
				</tr>
				<tr>
					<td width="19%" class="TD_STYLE1">
						II级机构名称	
					</td>
					<td width="81%" class="TD_STYLE2"   id="secondselect">						
					<input type="hidden"   id="secondKindName" name="secondKindName" />				
					<select class="INPUT_STYLE1"  id="secondKindId" name="secondKindId"  onchange="schange()" >
					<option>--请选择II级机构--</option>
					</select> 
					</td>
				</tr>
				
				
				<tr>
					<td width="19%" class="TD_STYLE1">
					III级机构编号
					</td>
					<td width="81%" class="TD_STYLE2">
					<input type="text" class="INPUT_STYLE1" name="thirdKindId"  readonly="readonly" value="${time }"/>
					</td>
				</tr>
				
				<tr>
					<td class="TD_STYLE1">
						III级机构名称
					</td>
					<td class="TD_STYLE2">
					<input type="text" class="INPUT_STYLE1" name="thirdKindName" id="thirdKindName"/>
					</td>
				</tr>
			
				<tr>
					<td class="TD_STYLE1">
						销售责任人编号（多个编号之间请用"半角逗号"加"一个空格"隔开，如", "）
					</td>
					<td class="TD_STYLE2">
						<textarea rows="4" cols="120" class="TEXTAREA_STYLE1" name="thirdKindSaleId" id="thirdKindSaleId"></textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						是否为零售店（是/否）
					</td>
					<td class="TD_STYLE2">
					<select name="thirdKindIsRetail" >
						<option selected="selected"  value="是">是</option>
						<option value="否">否</option>
					</select>
						 
					</td>
				</tr>
 
 
     </table>
   </form>
 </body>
</html>
