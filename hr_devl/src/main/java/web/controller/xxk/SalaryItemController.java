package web.controller.xxk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pojo.ConfigPublicChar;
import service.ConfigPublicCharService;

@Controller
@RequestMapping("/xxk")
public class SalaryItemController {
     @Autowired
	ConfigPublicCharService configPublicCharService=null;
     
     @RequestMapping("/selectallsalaryItem.do")
     public String  selectallsalaryItem(Model m){
     List<ConfigPublicChar>  list=configPublicCharService.findselectConfigPublicCharByattributeKind("薪酬设置");
     m.addAttribute("salaryItem", list);
     return "/xxkpage/salary/salary_item"; 
     }
     
     @RequestMapping("/{id}/deletesalaryItem.do")
     public String deletesalaryItem(@PathVariable("id") int id ){
	 configPublicCharService.removeConfigPublicChar(id);
     return "redirect:/xxk/selectallsalaryItem.do";
     }
     
     @RequestMapping("/addsalaryItem.do")
    public String addsalaryItem(ConfigPublicChar c) {
    configPublicCharService.addConfigPublicChar(c);
    return "redirect:/xxk/selectallsalaryItem.do";	
    } 
}
