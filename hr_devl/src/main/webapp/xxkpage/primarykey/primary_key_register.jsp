<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib    prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="table.css" type="text/css">
<script type="text/javascript" src="js/jquery-1.6.1.min.js"></script>
<script type="text/javascript">


 	function selAll(obj){
 		var cho = document.all.choice.value;
 		if(cho == "全选")
 			document.all.choice.value = "取消";
 		else
 			document.all.choice.value = "全选";
 			
 		 for(var i=0;i<obj.elements.length;i++){
 			if(obj.elements[i].tagName.toLowerCase()=="input" &&　obj.elements[i].type=="checkbox"){
 				if(cho == "全选"){
 				 	 obj.elements[i].checked=true;
 					 var t =obj.elements[i].getAttribute("tge");
 					 
 				     document.getElementById(t).value="2";  
 					}
 				else{
 			    	 obj.elements[i].checked=false;
 				     var t =obj.elements[i].getAttribute("tge");
 					 document.getElementById(t).value="1";  
 				   }
 					
 			}
 		}
 	}
 	
 	function change(obj){
 	   var t=obj.getAttribute("tge"); 
 	              
 	  if(obj.checked==true){
 	  document.getElementById(t).value="2";  
 	  }else{
 	  document.getElementById(t).value="1";  
 	  }    
 	   
 	}
 	
 	function doRegister(obj){
 		//document.forms[0].action = document.forms[0].action + "?operate=doRegister";
		  
		   for(var i=0;i<obj.elements.length;i++){
 			if(obj.elements[i].tagName.toLowerCase()=="input" &&　obj.elements[i].type=="checkbox"){	  
 					 var t = obj.elements[i].getAttribute("ttge"); 
 					  
 					 var pks= $("#primaryKeyStatus"+t).val(); 
 					
 					 $.ajax({
 					   type: "post",
 					   url:"xxk/updatePrimaryKeyTable.do",
 					   contextType:"application/json,charset=utf-8",
 					   data:{"prkId":t,"primaryKeyStatus":pks},
 					   success: function(ret){
 					   
 					   }
 					 });
 				   
 			   }
 		} 
 		
		window.location.href="xxkpage/primary_key.jsp";     
 	}
 	
 	
  function myfunction(obj){

         
         for(var i=0;i<obj.elements.length;i++){
 			if(obj.elements[i].tagName.toLowerCase()=="input" &&　obj.elements[i].type=="checkbox"){
 				var t =obj.elements[i].getAttribute("status");
 				
 				if(t=="2"){
 				 	 obj.elements[i].checked=true;
 				    }
 				    
 				else{
 			    	 obj.elements[i].checked=false;  
 				    }
 					
 			 }
 		 }	
      }
 
    setTimeout("myfunction(document.forms[0])", 500);
         
</script>
</head>

<body   >
	<form  method="post" >
		<table width="100%">
			<tr>
				<td><font color="#0000CC">您正在做的业务是：人力资源--客户化设置--其他设置--关键字查询设置</font>
				</td>
			</tr>
			<tr>
				<td align="right"><input type="button" value="提交"
					class="BUTTON_STYLE1" onclick="doRegister(this.form)"> <input
					type="button" value="返回" class="BUTTON_STYLE1"
					onclick="history.back();"></td>
			</tr>
		</table>
		 
		<table width="100%" border="1" cellpadding=0 cellspacing=1
			bordercolorlight=#848284 bordercolordark=#eeeeee class="TABLE_STYLE1" >
			<tr class="TR_STYLE1">
				<td class="TD_STYLE1" colspan="4">请选择用于关键字查询的字段&nbsp; <input
					type="button" name="choice" value="全选" class="BUTTON_STYLE1"
					onclick="selAll(this.form)">
				</td>
			</tr>
			
		     <!-- private Short prkId;
        	      private String primaryKeyTable;
	              private String primaryKey;
	              private String keyName;
             	  private Short primaryKeyStatus; -->
			 <c:forEach items="${ConfigPrimaryKey}"  var="i"   varStatus="c"  >
			  
			   <c:if test="${c.count%4==1 ||  c.count==1 }">
			      <tr>
			   </c:if> 
			    <!--    
		     	<input type="hidden"  id="primaryKeyTable${i.prkId}"     name="primaryKeyTable"  value="${i.primaryKeyTable }">
	        	<input type="hidden"  id="prkId${i.prkId}"               name="prkId"            value="${i.prkId }">
			    <input type="hidden"  id="primaryKey${i.prkId}"          name="primaryKey"       value="${i.primaryKey }">
		    	<input type="hidden"  id="keyName${i.prkId}"             name="keyName"          value="${i.keyName }">
		    	-->
		    	
		    	<input type="hidden"  id="primaryKeyStatus${i.prkId}"    name="primaryKeyStatus" value="${i.primaryKeyStatus }">
				<td class="TD_STYLE2">
				<input type="checkbox"   id="checked${i.prkId}"  value="on"  status="${i.primaryKeyStatus }"  ttge="${i.prkId}"  tge="primaryKeyStatus${i.prkId}"  onclick="change(this)" >${i.keyName }
				</td>
				
			   <c:if test="${c.count%4==0 }">
			      </tr>
			   </c:if>   
			               
		    </c:forEach>
           
		</table>
	</form>
</body>
</html>
