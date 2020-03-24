<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
   String path = request.getContextPath();
   String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
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
        $("#configMajor").submit();   
  }
  
  function change(){
       
       var c = $("#majorKindId").val();
       var b = $("#f"+c).html();                  
       $("#majorKindName").val(b);                
  }
 </script>
 </head>
<body>
   
<form   id="configMajor"  name="configMajor" method="post" action="xxk/addconfigMajor.do">
<table width="100%" >
  <tr>
    <td> 
    <font color="#0000CC">您正在做的业务是：人力资源--客户化设置--人力资源档案管理设置--职称设置 </font></td>
  </tr>
  <tr>
    <td align="right"><input type="button" value="提交" class="BUTTON_STYLE1" onclick="save()">
      <input type="button" value="返回" class="BUTTON_STYLE1" onclick="history.back();">
    </td>
  </tr>
  </table>
  
<table width="100%"  border="1" cellpadding=0 cellspacing=1 bordercolorlight=#848284 bordercolordark=#eeeeee class="TABLE_STYLE1">
     
     <!-- private Short makId;
	 private String majorKindId;
	 private String majorKindName;
	 private String majorId;
	 private String majorName;
	 private Short testAmount; -->
	 
          <input type="hidden"  id="majorKindName" name="majorKindName"  ></td>
        
     <!--     private Short mfkId;
	 private String majorKindId;
	 private String majorKindName;
         --> 
          <tr>
          <td width="19%" class="TD_STYLE1">职位分类名称</td>
          <td width="81%" class="TD_STYLE2">
          
          <select class="INPUT_STYLE1"  id="majorKindId" name="majorKindId" onchange="change()">
           <option>--请选择职位--</option>
          <c:forEach items="${configMajorKind}" var="i">
          <option value="${i.majorKindId}"  id="f${i.majorKindId}"  >${i.majorKindName}</option>
         </c:forEach>
          </select>
          </td>
          </tr>
          
          <tr>
          <td width="19%" class="TD_STYLE1">职位编号</td>
          <td width="81%" class="TD_STYLE2"><input type="text"  name="majorId"   class="INPUT_STYLE1"></td>
          </tr>
          
          <tr>
          <td width="19%" class="TD_STYLE1">职位名称</td>
          <td width="81%" class="TD_STYLE2"><input type="text" name="majorName"   class="INPUT_STYLE1"></td>
          </tr>
  
    </table>
   </form>
 </body>
</html>
