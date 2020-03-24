<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
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
<script type="text/javascript" src="javascript/comm/comm.js"></script>
 <script type="text/javascript" src="js/jquery-1.6.1.min.js"></script>
 <script type="text/javascript">
  function save(){
      $("#configfilethirdkindForm").submit();     
  }
 </script>
 </head>
<body>
</head>
<body>
	<form id="configfilethirdkindForm"  name="configfilesecondkindForm" method="post"
		action="xxk/updateconfigFileThird.do">
		<table width="100%">
			<tr>
				<td><font color="#0000CC">您正在做的业务是：人力资源--客户化设置--人力资源档案管理设置--II级机构设置
				</font></td>
			</tr>
			<tr>
				<td align="right"> <input type="button" value="提交"
					class="BUTTON_STYLE1"
					onclick="save()">
					<input type="button" value="返回" class="BUTTON_STYLE1"
					onclick="history.back();"></td>
			</tr>
		</table>
    
   <!--   private Short ftkId;
	private String firstKindId;
	private String firstKindName;
	private String secondKindId;
	private String secondKindName;
	private String thirdKindId;
	private String thirdKindName;
	private String thirdKindSaleId;
	private String thirdKindIsRetail;
    --> 
         <input type="hidden" name="ftkId" value="${configFileThirdKind.ftkId}" />
		 	
		 
		 <table width="100%" border="1" cellpadding=0 cellspacing=1
		 	bordercolorlight=#848284 bordercolordark=#eeeeee class="TABLE_STYLE1">
		 	
		 	
			 
			<tr>
				<td width="19%" class="TD_STYLE1">I级机构名称</td>
				<td width="81%" class="TD_STYLE2">
				<input type="text" readonly="readonly"
					name="firstKindName" value="${configFileThirdKind.firstKindName}" 
					class="INPUT_STYLE1">
					
				</td>
			 </tr>
			
		
			<tr>
				<td class="TD_STYLE1">II级机构名称</td>
				<td class="TD_STYLE2"><input type="text"   readonly="readonly"
				name="secondKindName" value="${configFileThirdKind.secondKindName}" 
				class="INPUT_STYLE1"></td>
			</tr>
			
			<tr>
				<td class="TD_STYLE1">III级机构编号</td>
				<td class="TD_STYLE2"><input type="text"   readonly="readonly"
				name="thirdKindId" value="${configFileThirdKind.thirdKindId}" 
				class="INPUT_STYLE1"></td>
			</tr>
			
			<tr>
				<td class="TD_STYLE1">III级机构名称</td>
				<td class="TD_STYLE2"><input type="text"   
				name="thirdKindName" value="${configFileThirdKind.thirdKindName}" 
				class="INPUT_STYLE1"></td>
			</tr>
			
			<tr>
				<td class="TD_STYLE1">薪酬发放责任人编号（多个编号之间请用"半角逗号"加"一个空格"隔开，如", "）</td>
				<td class="TD_STYLE2"><textarea name="thirdKindSaleId"
				rows="4" class="TEXTAREA_STYLE1">${configFileThirdKind.thirdKindSaleId}</textarea></td>
			</tr>
			
		    <tr>
				<td class="TD_STYLE1">是否为零售店（是/否）</td>
				<td class="TD_STYLE2">
				<select name="thirdKindIsRetail" >
						<option selected="selected" value="是">是</option>
						<option value="否">否</option>
					</select>
				</td>
			</tr>
			
		</table>
	</form>
</body>
</html>
