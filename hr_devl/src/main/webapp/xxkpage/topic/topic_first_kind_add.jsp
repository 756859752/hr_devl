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
        $("#topicFirstKind").submit();   
  }
 </script>
 </head>
<body>
   
<form   id="topicFirstKind"  name="configfilefirstkindForm" method="post" action="xxk/addtopicFirstKind.do">
<table width="100%" >
  <tr>
    <td> 
    <font color="#0000CC">您正在做的业务是：人力资源--客户化设置--题库管理设置--试题I分类设置 </font></td>
  </tr>
  <tr>
    <td align="right"><input type="button" value="提交" class="BUTTON_STYLE1" onclick="save()">
      <input type="button" value="返回" class="BUTTON_STYLE1" onclick="history.back();">
    </td>
  </tr>
  </table>
  
<table width="100%"  border="1" cellpadding=0 cellspacing=1 bordercolorlight=#848284 bordercolordark=#eeeeee class="TABLE_STYLE1">
     
     <!--   	private Short qfkId;
	            private String firstKindId;
	            private String firstKindName; -->
          <tr>
          <td width="19%" class="TD_STYLE1">题目分类编号</td>
          <td width="81%" class="TD_STYLE2"><input type="text" name="firstKindId"  readonly="readonly" value="${time}"   class="INPUT_STYLE1"></td>
          </tr>
    
          <tr>
          <td width="19%" class="TD_STYLE1">题目分类名称</td>
          <td width="81%" class="TD_STYLE2"><input type="text" name="firstKindName"   class="INPUT_STYLE1"></td>
          </tr>
         
         
  
</table>
</html>
