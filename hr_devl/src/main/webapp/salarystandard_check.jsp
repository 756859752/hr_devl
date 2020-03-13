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
<link rel="stylesheet" href="table.css" type="text/css" />
<title>无标题文档</title>
<script type="text/javascript">
		function doEdit(id)
		{
			//document.forms[0].action = document.forms[0].action + "?operate=doEdit&method=check&id=" + id;
			document.forms[0].action ="salarystandard_check_success.html";
			document.forms[0].submit();
		}
		</script>
</head>

<body>
	<form action="salarystandard.do" method="post">
		<table width="100%">
			<tr>
				<td><font color="#0000CC">您正在做的业务是:人力资源管理--薪酬标准管理--薪酬标准登记复核</font>
				</td>
			</tr>
			<tr>
				<td>
					<div align="right">
						<input type="button" value="复核通过" class="BUTTON_STYLE1"
							onclick="doEdit(1);"> <input type="button" value="返回"
							onclick="history.back();" class="BUTTON_STYLE1">
					</div>
				</td>
			</tr>
		</table>
		<table width="100%" border="1" cellpadding=0 cellspacing=1
			bordercolorlight=#848284 bordercolordark=#eeeeee class="TABLE_STYLE1">
			<tr>
				<td width="12%" class="TD_STYLE1">薪酬编号</td>
				<td width="15%" class="TD_STYLE2">1000001</td>
				<td width="12%" class="TD_STYLE1">薪酬标准名称</td>
				<td width="11%" class="TD_STYLE2"><input type="text"
					name="item.standardName" value="" class="INPUT_STYLE2"></td>
				<td width="11%" class="TD_STYLE1">薪酬总额</td>
				<td width="17%" class="TD_STYLE2">0.0</td>
				<td width="12%" class="TD_STYLE1">&nbsp;</td>
				<td width="10%" class="TD_STYLE2">&nbsp;</td>
			</tr>
			<tr>
				<td class="TD_STYLE1">制定人</td>
				<td class="TD_STYLE2"><input type="text" name="item.designer"
					value="" class="INPUT_STYLE2"></td>
				<td class="TD_STYLE1">复核人</td>
				<td class="TD_STYLE2"><input type="text" name="item.checker"
					value="better_wanghao" readonly="readonly" class="INPUT_STYLE2">
				</td>
				<td class="TD_STYLE1">复核时间</td>
				<td class="TD_STYLE2"><input type="text"
					name="item.str_checkTime" value="2010-05-29 03:27:14"
					readonly="readonly" class="INPUT_STYLE2"></td>
				<td class="TD_STYLE1">&nbsp;</td>
				<td class="TD_STYLE2">&nbsp;</td>
			</tr>
			<tr>
				<td class="TD_STYLE1">复核意见</td>
				<td colspan="7" class="TD_STYLE2"><textarea
						name="item.checkComment" rows="4" class="TEXTAREA_STYLE1"></textarea>
				</td>
			</tr>
			<tr>
				<td class="TD_STYLE1">序号</td>
				<td colspan="3" class="TD_STYLE1">薪酬项目名称</td>
				<td colspan="4" class="TD_STYLE1">金额</td>
			</tr>

			<tr class="TD_STYLE2">
				<input type="hidden" name="list[0].sdtId" value="1"
					class="INPUT_STYLE2">
				<td align="center">1 <input type="hidden" name="list[0].itemId"
					value="1" class="INPUT_STYLE2">
				</td>
				<td colspan="3">出差补助 <input type="hidden"
					name="list[0].itemName" value="出差补助" class="INPUT_STYLE2">
				</td>
				<td><input type="text" name="list[0].salary" value="0.0"
					class="INPUT_STYLE2"></td>
				<td colspan="3">&nbsp;</td>
			</tr>

			<tr class="TD_STYLE2">
				<input type="hidden" name="list[1].sdtId" value="2"
					class="INPUT_STYLE2">
				<td align="center">2 <input type="hidden" name="list[1].itemId"
					value="2" class="INPUT_STYLE2">
				</td>
				<td colspan="3">交通补贴 <input type="hidden"
					name="list[1].itemName" value="交通补贴" class="INPUT_STYLE2">
				</td>
				<td><input type="text" name="list[1].salary" value="0.0"
					class="INPUT_STYLE2"></td>
				<td colspan="3">&nbsp;</td>
			</tr>

			<tr class="TD_STYLE2">
				<input type="hidden" name="list[2].sdtId" value="3"
					class="INPUT_STYLE2">
				<td align="center">3 <input type="hidden" name="list[2].itemId"
					value="3" class="INPUT_STYLE2">
				</td>
				<td colspan="3">住房补贴 <input type="hidden"
					name="list[2].itemName" value="住房补贴" class="INPUT_STYLE2">
				</td>
				<td><input type="text" name="list[2].salary" value="0.0"
					class="INPUT_STYLE2"></td>
				<td colspan="3">&nbsp;</td>
			</tr>

			<tr class="TD_STYLE2">
				<input type="hidden" name="list[3].sdtId" value="4"
					class="INPUT_STYLE2">
				<td align="center">4 <input type="hidden" name="list[3].itemId"
					value="4" class="INPUT_STYLE2">
				</td>
				<td colspan="3">基本工资 <input type="hidden"
					name="list[3].itemName" value="基本工资" class="INPUT_STYLE2">
				</td>
				<td><input type="text" name="list[3].salary" value="0.0"
					class="INPUT_STYLE2"></td>
				<td colspan="3">&nbsp;</td>
			</tr>

			<tr class="TD_STYLE2">
				<input type="hidden" name="list[4].sdtId" value="5"
					class="INPUT_STYLE2">
				<td align="center">5 <input type="hidden" name="list[4].itemId"
					value="5" class="INPUT_STYLE2">
				</td>
				<td colspan="3">年终奖 <input type="hidden"
					name="list[4].itemName" value="年终奖" class="INPUT_STYLE2">
				</td>
				<td><input type="text" name="list[4].salary" value="0.0"
					class="INPUT_STYLE2"></td>
				<td colspan="3">&nbsp;</td>
			</tr>

			<tr class="TD_STYLE2">
				<input type="hidden" name="list[5].sdtId" value="6"
					class="INPUT_STYLE2">
				<td align="center">6 <input type="hidden" name="list[5].itemId"
					value="6" class="INPUT_STYLE2">
				</td>
				<td colspan="3">误餐补助 <input type="hidden"
					name="list[5].itemName" value="误餐补助" class="INPUT_STYLE2">
				</td>
				<td><input type="text" name="list[5].salary" value="0.0"
					class="INPUT_STYLE2"></td>
				<td colspan="3">&nbsp;</td>
			</tr>

			<tr class="TD_STYLE2">
				<input type="hidden" name="list[6].sdtId" value="7"
					class="INPUT_STYLE2">
				<td align="center">1 <input type="hidden" name="list[6].itemId"
					value="1" class="INPUT_STYLE2">
				</td>
				<td colspan="3">出差补助 <input type="hidden"
					name="list[6].itemName" value="出差补助" class="INPUT_STYLE2">
				</td>
				<td><input type="text" name="list[6].salary" value="0.0"
					class="INPUT_STYLE2"></td>
				<td colspan="3">&nbsp;</td>
			</tr>

			<tr class="TD_STYLE2">
				<input type="hidden" name="list[7].sdtId" value="8"
					class="INPUT_STYLE2">
				<td align="center">2 <input type="hidden" name="list[7].itemId"
					value="2" class="INPUT_STYLE2">
				</td>
				<td colspan="3">交通补贴 <input type="hidden"
					name="list[7].itemName" value="交通补贴" class="INPUT_STYLE2">
				</td>
				<td><input type="text" name="list[7].salary" value="0.0"
					class="INPUT_STYLE2"></td>
				<td colspan="3">&nbsp;</td>
			</tr>

			<tr class="TD_STYLE2">
				<input type="hidden" name="list[8].sdtId" value="9"
					class="INPUT_STYLE2">
				<td align="center">3 <input type="hidden" name="list[8].itemId"
					value="3" class="INPUT_STYLE2">
				</td>
				<td colspan="3">住房补贴 <input type="hidden"
					name="list[8].itemName" value="住房补贴" class="INPUT_STYLE2">
				</td>
				<td><input type="text" name="list[8].salary" value="0.0"
					class="INPUT_STYLE2"></td>
				<td colspan="3">&nbsp;</td>
			</tr>

			<tr class="TD_STYLE2">
				<input type="hidden" name="list[9].sdtId" value="10"
					class="INPUT_STYLE2">
				<td align="center">4 <input type="hidden" name="list[9].itemId"
					value="4" class="INPUT_STYLE2">
				</td>
				<td colspan="3">基本工资 <input type="hidden"
					name="list[9].itemName" value="基本工资" class="INPUT_STYLE2">
				</td>
				<td><input type="text" name="list[9].salary" value="0.0"
					class="INPUT_STYLE2"></td>
				<td colspan="3">&nbsp;</td>
			</tr>

			<tr class="TD_STYLE2">
				<input type="hidden" name="list[10].sdtId" value="11"
					class="INPUT_STYLE2">
				<td align="center">5 <input type="hidden"
					name="list[10].itemId" value="5" class="INPUT_STYLE2">
				</td>
				<td colspan="3">年终奖 <input type="hidden"
					name="list[10].itemName" value="年终奖" class="INPUT_STYLE2">
				</td>
				<td><input type="text" name="list[10].salary" value="0.0"
					class="INPUT_STYLE2"></td>
				<td colspan="3">&nbsp;</td>
			</tr>

			<tr class="TD_STYLE2">
				<input type="hidden" name="list[11].sdtId" value="12"
					class="INPUT_STYLE2">
				<td align="center">6 <input type="hidden"
					name="list[11].itemId" value="6" class="INPUT_STYLE2">
				</td>
				<td colspan="3">误餐补助 <input type="hidden"
					name="list[11].itemName" value="误餐补助" class="INPUT_STYLE2">
				</td>
				<td><input type="text" name="list[11].salary" value="0.0"
					class="INPUT_STYLE2"></td>
				<td colspan="3">&nbsp;</td>
			</tr>

			<tr class="TD_STYLE2">
				<input type="hidden" name="list[12].sdtId" value="13"
					class="INPUT_STYLE2">
				<td align="center">1 <input type="hidden"
					name="list[12].itemId" value="1" class="INPUT_STYLE2">
				</td>
				<td colspan="3">出差补助 <input type="hidden"
					name="list[12].itemName" value="出差补助" class="INPUT_STYLE2">
				</td>
				<td><input type="text" name="list[12].salary" value="0.0"
					class="INPUT_STYLE2"></td>
				<td colspan="3">&nbsp;</td>
			</tr>

			<tr class="TD_STYLE2">
				<input type="hidden" name="list[13].sdtId" value="14"
					class="INPUT_STYLE2">
				<td align="center">2 <input type="hidden"
					name="list[13].itemId" value="2" class="INPUT_STYLE2">
				</td>
				<td colspan="3">交通补贴 <input type="hidden"
					name="list[13].itemName" value="交通补贴" class="INPUT_STYLE2">
				</td>
				<td><input type="text" name="list[13].salary" value="0.0"
					class="INPUT_STYLE2"></td>
				<td colspan="3">&nbsp;</td>
			</tr>

			<tr class="TD_STYLE2">
				<input type="hidden" name="list[14].sdtId" value="15"
					class="INPUT_STYLE2">
				<td align="center">3 <input type="hidden"
					name="list[14].itemId" value="3" class="INPUT_STYLE2">
				</td>
				<td colspan="3">住房补贴 <input type="hidden"
					name="list[14].itemName" value="住房补贴" class="INPUT_STYLE2">
				</td>
				<td><input type="text" name="list[14].salary" value="0.0"
					class="INPUT_STYLE2"></td>
				<td colspan="3">&nbsp;</td>
			</tr>

			<tr class="TD_STYLE2">
				<input type="hidden" name="list[15].sdtId" value="16"
					class="INPUT_STYLE2">
				<td align="center">4 <input type="hidden"
					name="list[15].itemId" value="4" class="INPUT_STYLE2">
				</td>
				<td colspan="3">基本工资 <input type="hidden"
					name="list[15].itemName" value="基本工资" class="INPUT_STYLE2">
				</td>
				<td><input type="text" name="list[15].salary" value="0.0"
					class="INPUT_STYLE2"></td>
				<td colspan="3">&nbsp;</td>
			</tr>

			<tr class="TD_STYLE2">
				<input type="hidden" name="list[16].sdtId" value="17"
					class="INPUT_STYLE2">
				<td align="center">5 <input type="hidden"
					name="list[16].itemId" value="5" class="INPUT_STYLE2">
				</td>
				<td colspan="3">年终奖 <input type="hidden"
					name="list[16].itemName" value="年终奖" class="INPUT_STYLE2">
				</td>
				<td><input type="text" name="list[16].salary" value="0.0"
					class="INPUT_STYLE2"></td>
				<td colspan="3">&nbsp;</td>
			</tr>

			<tr class="TD_STYLE2">
				<input type="hidden" name="list[17].sdtId" value="18"
					class="INPUT_STYLE2">
				<td align="center">6 <input type="hidden"
					name="list[17].itemId" value="6" class="INPUT_STYLE2">
				</td>
				<td colspan="3">误餐补助 <input type="hidden"
					name="list[17].itemName" value="误餐补助" class="INPUT_STYLE2">
				</td>
				<td><input type="text" name="list[17].salary" value="0.0"
					class="INPUT_STYLE2"></td>
				<td colspan="3">&nbsp;</td>
			</tr>

		</table>
	</form>
</body>
</html>
