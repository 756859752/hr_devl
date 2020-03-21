<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="/hr_devl/css/table.css"
			type="text/css"></link>
	</head>

	<body>
		 
			<table width="100%">
				<tr>
					<td>
						<font color="black">您正在做的业务是:人力资源--培训管理--调动登记查看</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" class="BUTTON_STYLE1" onclick="javascript:window.history.back();" value="返回">
					</td>
				</tr>
			</table>
		<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr height="21">
					<td class="TD_STYLE1" width="8%">
						档案编号
					</td>
					<td class="TD_STYLE2" width="10%">
						${onechang.humanId}
					</td>					
					<td class="TD_STYLE1" width="8%">
						姓名
					</td>					
					<td class="TD_STYLE2" width="10%">
					${onechang.humanName}
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
					<td class="TD_STYLE2" >
						${onechang.firstKindName}	
					</td>
					<td class="TD_STYLE1" width="8%">
						原二级机构
					</td>
					<td class="TD_STYLE2" width="10%">
						${onechang.secondKindName}
					</td>
					<td class="TD_STYLE1" width="8%">
						原三级机构
					</td>
					<td class="TD_STYLE2" width="10%">
						${onechang.thirdKindName}
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
						${onechang.majorKindName}
					</td>
					<td class="TD_STYLE1" width="12%">
						原职位名称
					</td>
					<td class="TD_STYLE2">
						${onechang.majorName}
					</td>
					<td class="TD_STYLE1">
						原薪酬标准
					</td>
					<td class="TD_STYLE2">
						${onechang.salaryStandardName}
						</td>
					<td class="TD_STYLE1">
						原薪酬总额
					</td>
					<td class="TD_STYLE2" >
						${onechang.salarySum}
					</td>
				</tr>				
				<tr>
					<td class="TD_STYLE1">
						新一级机构名称
					</td>
					<td class="TD_STYLE2">
						<select name="mc.newFirstKindId" class="INPUT_STYLE2">
							<option value="${onechang.newFirstKindId}">${onechang.newFirstKindName}</option>
						</select>
						
					</td>
					<td class="TD_STYLE1" width="12%">
						新二级机构名称
					</td>
					<td class="TD_STYLE2">
						<select name="mc.newSecondKindId" class="INPUT_STYLE2">
							<option value="${onechang.newSecondKindId}">${onechang.newSecondKindName}</option>
						</select>
					</td>
					<td class="TD_STYLE1" width="12%">
						新三级机构名称
					</td>
					<td class="TD_STYLE2">
						<select name="mc.newThirdKindId" class="INPUT_STYLE2">
							<option value="${onechang.newThirdKindId}">${onechang.newThirdKindName}</option>
						</select>
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
						<select name="mc.newMajorKindId" class="INPUT_STYLE2">
							<option value="${onechang.newMajorKindId}">${onechang.newMajorKindName}</option>
						</select>
					</td>
					<td class="TD_STYLE1" width="12%">
						新职位名称
					</td>
					<td class="TD_STYLE2">
						<select name="mc.newMajorId" class="INPUT_STYLE2">
							<option value="${onechang.newMajorId}">${onechang.newMajorName}</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						新薪酬标准
					</td>
					<td class="TD_STYLE2">
						<select name="mc.newSalaryStandardId" class="INPUT_STYLE2">
							<option value="${onechang.newSalaryStandardId}">${onechang.newSalaryStandardName}</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						新薪酬总额
					</td>
					<td class="TD_STYLE2">
						${onechang.newSalarySum}
					</td>
				</tr>
								
				<tr>
					<td class="TD_STYLE1">
						登记人
					</td>
					<td class="TD_STYLE2">
						${onechang.register}
					</td>
					<td class="TD_STYLE1">
						登记时间
					</td>
					<td class="TD_STYLE2">
							${onechang.registTime}
					</td>
					<td class="TD_STYLE1">
						复核人
					</td>
					<td class="TD_STYLE2">
						${onechang.checker}
					</td>
					<td class="TD_STYLE1">
						复核时间
					</td>
					<td class="TD_STYLE2">
						${onechang.checkTime}
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						调动原因
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="majorChange.changeReason" rows="6" readonly="readonly" class="TEXTAREA_STYLE1">						
						${onechang.changeReason}
						</textarea>
					</td>
				</tr>
			</table>
	 
	</body>
</html>


