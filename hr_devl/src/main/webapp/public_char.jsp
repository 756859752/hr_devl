<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
</head>

<body>
	<form method="post" action="configpublicchar.do">
		<table width="100%">
			<tr>
				<td><font color="#0000CC">您正在做的业务是：人力资源--客户化设置--人力资源档案管理设置--公共属性设置
				</font></td>
			</tr>
			<tr>
				<td align="right"><input type="button" value="添加"
					class="BUTTON_STYLE1" onclick="javascript:toAdd();"></td>
			</tr>
		</table>
		<table width="100%" border="1" cellpadding=0 cellspacing=1
			bordercolorlight=#848284 bordercolordark=#eeeeee class="TABLE_STYLE1">
			<tr>
				<td width="49%" class="TD_STYLE1">属性种类</td>
				<td width="44%" class="TD_STYLE1">属性名称</td>
				<td width="7%" class="TD_STYLE1" align="center">删除</td>
			</tr>

			<tr>
				<td class="TD_STYLE2">爱好</td>
				<td class="TD_STYLE2">篮球</td>
				<td class="TD_STYLE2" align="center"><a
					href="javascript:toDel('17')">删除</a></td>
			</tr>

			<tr>
				<td class="TD_STYLE2">爱好</td>
				<td class="TD_STYLE2">舞蹈</td>
				<td class="TD_STYLE2" align="center"><a
					href="javascript:toDel('18')">删除</a></td>
			</tr>

			<tr>
				<td class="TD_STYLE2">国籍</td>
				<td class="TD_STYLE2">中国</td>
				<td class="TD_STYLE2" align="center"><a
					href="javascript:toDel('1')">删除</a></td>
			</tr>

			<tr>
				<td class="TD_STYLE2">国籍</td>
				<td class="TD_STYLE2">美国</td>
				<td class="TD_STYLE2" align="center"><a
					href="javascript:toDel('2')">删除</a></td>
			</tr>

			<tr>
				<td class="TD_STYLE2">奖励等级</td>
				<td class="TD_STYLE2">A</td>
				<td class="TD_STYLE2" align="center"><a
					href="javascript:toDel('25')">删除</a></td>
			</tr>

			<tr>
				<td class="TD_STYLE2">奖励等级</td>
				<td class="TD_STYLE2">B</td>
				<td class="TD_STYLE2" align="center"><a
					href="javascript:toDel('26')">删除</a></td>
			</tr>

			<tr>
				<td class="TD_STYLE2">奖励项目</td>
				<td class="TD_STYLE2">技术攻关</td>
				<td class="TD_STYLE2" align="center"><a
					href="javascript:toDel('23')">删除</a></td>
			</tr>

			<tr>
				<td class="TD_STYLE2">奖励项目</td>
				<td class="TD_STYLE2">销售绩效</td>
				<td class="TD_STYLE2" align="center"><a
					href="javascript:toDel('24')">删除</a></td>
			</tr>

			<tr>
				<td class="TD_STYLE2">教育年限</td>
				<td class="TD_STYLE2">12</td>
				<td class="TD_STYLE2" align="center"><a
					href="javascript:toDel('9')">删除</a></td>
			</tr>

			<tr>
				<td class="TD_STYLE2">教育年限</td>
				<td class="TD_STYLE2">16</td>
				<td class="TD_STYLE2" align="center"><a
					href="javascript:toDel('10')">删除</a></td>
			</tr>

			<tr>
				<td class="TD_STYLE2">民族</td>
				<td class="TD_STYLE2">汉族</td>
				<td class="TD_STYLE2" align="center"><a
					href="javascript:toDel('3')">删除</a></td>
			</tr>

			<tr>
				<td class="TD_STYLE2">民族</td>
				<td class="TD_STYLE2">回族</td>
				<td class="TD_STYLE2" align="center"><a
					href="javascript:toDel('4')">删除</a></td>
			</tr>

			<tr>
				<td class="TD_STYLE2">培训成绩</td>
				<td class="TD_STYLE2">A</td>
				<td class="TD_STYLE2" align="center"><a
					href="javascript:toDel('21')">删除</a></td>
			</tr>

			<tr>
				<td class="TD_STYLE2">培训成绩</td>
				<td class="TD_STYLE2">B</td>
				<td class="TD_STYLE2" align="center"><a
					href="javascript:toDel('22')">删除</a></td>
			</tr>

			<tr>
				<td class="TD_STYLE2">培训项目</td>
				<td class="TD_STYLE2">英语</td>
				<td class="TD_STYLE2" align="center"><a
					href="javascript:toDel('19')">删除</a></td>
			</tr>

			<tr>
				<td class="TD_STYLE2">培训项目</td>
				<td class="TD_STYLE2">管理</td>
				<td class="TD_STYLE2" align="center"><a
					href="javascript:toDel('20')">删除</a></td>
			</tr>

			<tr>
				<td class="TD_STYLE2">特长</td>
				<td class="TD_STYLE2">数据库</td>
				<td class="TD_STYLE2" align="center"><a
					href="javascript:toDel('15')">删除</a></td>
			</tr>

			<tr>
				<td class="TD_STYLE2">特长</td>
				<td class="TD_STYLE2">java</td>
				<td class="TD_STYLE2" align="center"><a
					href="javascript:toDel('16')">删除</a></td>
			</tr>

			<tr>
				<td class="TD_STYLE2">学历</td>
				<td class="TD_STYLE2">本科</td>
				<td class="TD_STYLE2" align="center"><a
					href="javascript:toDel('11')">删除</a></td>
			</tr>

			<tr>
				<td class="TD_STYLE2">学历</td>
				<td class="TD_STYLE2">大专</td>
				<td class="TD_STYLE2" align="center"><a
					href="javascript:toDel('12')">删除</a></td>
			</tr>

			<tr>
				<td class="TD_STYLE2">政治面貌</td>
				<td class="TD_STYLE2">党员</td>
				<td class="TD_STYLE2" align="center"><a
					href="javascript:toDel('7')">删除</a></td>
			</tr>

			<tr>
				<td class="TD_STYLE2">政治面貌</td>
				<td class="TD_STYLE2">群众</td>
				<td class="TD_STYLE2" align="center"><a
					href="javascript:toDel('8')">删除</a></td>
			</tr>

			<tr>
				<td class="TD_STYLE2">专业</td>
				<td class="TD_STYLE2">生物工程</td>
				<td class="TD_STYLE2" align="center"><a
					href="javascript:toDel('13')">删除</a></td>
			</tr>

			<tr>
				<td class="TD_STYLE2">专业</td>
				<td class="TD_STYLE2">计算机</td>
				<td class="TD_STYLE2" align="center"><a
					href="javascript:toDel('14')">删除</a></td>
			</tr>

			<tr>
				<td class="TD_STYLE2">宗教信仰</td>
				<td class="TD_STYLE2">无</td>
				<td class="TD_STYLE2" align="center"><a
					href="javascript:toDel('5')">删除</a></td>
			</tr>

			<tr>
				<td class="TD_STYLE2">宗教信仰</td>
				<td class="TD_STYLE2">佛教</td>
				<td class="TD_STYLE2" align="center"><a
					href="javascript:toDel('6')">删除</a></td>
			</tr>

		</table>
		<p>
			&nbsp;&nbsp;总数：26例 &nbsp;&nbsp;&nbsp;当前第 1 页 &nbsp;&nbsp;&nbsp;共 1 页
			&nbsp;&nbsp;&nbsp;跳到第 <input name=page type=text class=input1 size=1>
			页&nbsp;&nbsp;<input type=image src="images/go.bmp" width=18 height=18
				border=0>
	</form>
</body>
</html>
