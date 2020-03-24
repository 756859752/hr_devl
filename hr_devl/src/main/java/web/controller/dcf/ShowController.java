package web.controller.dcf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("dcf/show")
public class ShowController {
//	判断薪酬标准登记
	 @RequestMapping("/showSalaryStandard.do")
     public String showSalaryStandard() {
    	 return "redirect:/salarystandard_register.jsp";
     }
	 @RequestMapping("/showSalaryStandardCheckList.do")
     public String showSalaryStandardCheckList() {
    	 return "redirect:/salarystandard_check_list.jsp";
     }
	 @RequestMapping("/showSalaryStandardQuerylocate.do")
     public String showSalaryStandardQuerylocate() {
    	 return "redirect:/salarystandard_query_locate.jsp";
     }
	 @RequestMapping("/showSalaryStandardChangeLocate.do")
     public String showSalaryStandardChangeLocate() {
    	 return "redirect:/salarystandard_change_locate.jsp";
     }
	 
//		判断薪酬发放登记	 
	 @RequestMapping("/showSalaryGrantRegisteList.do")
     public String showSalaryGrantRegisteList() {
    	 return "redirect:/dcf_SalaryGrant/register_list.jsp";
     }
	 @RequestMapping("/showSalaryGrantCheckList.do")
     public String showSalaryGrantCheckList() {
    	 return "redirect:/dcf_SalaryGrant/check_list.jsp";
     }
	 @RequestMapping("/showSalaryGrantQueryLocate.do")
     public String showSalaryGrantQueryLocate() {
    	 return "redirect:/dcf_SalaryGrant/query_locate.jsp";
     }
//	 调动管理
	 @RequestMapping("/showTransferRegisterLocate.do")
     public String showTransferRegisterLocate() {
    	 return "redirect:/dcf_Transfer/register_locate.jsp";
     }
	 @RequestMapping("/showTransferCheckList.do")
     public String showTransferCheckList() {
    	 return "redirect:/dcf_Transfer/check_list.jsp";
     }
	 
	 @RequestMapping("/showTransferQuery.do")
     public String showTransferQuery() {
    	 return "redirect:/dcf_Transfer/query.jsp";
     }
}
