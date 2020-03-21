
package web.controller.xxk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pojo.ConfigPublicChar;
import service.ConfigPublicCharService;

@Controller
@RequestMapping("/xxk")
public class SalaryGangSetController {
	
   @Autowired   
   ConfigPublicCharService     configPublicCharService=null;  
   
   @RequestMapping("/selectallsalaryGrantSet.do")
   public String  selectallsalaryGrantSet(Model m) {
   List<ConfigPublicChar>    c  =configPublicCharService.findselectConfigPublicCharByattributeKind("薪酬发放方式设置");
   m.addAttribute("salaryGangSet", c);
   return "/xxkpage/salary/salary_grant_set"; 
   }
   
   
  @RequestMapping("/addsalaryGrangSet.do")
   public String  addsalaryGrantSet(ConfigPublicChar c) {
	
   configPublicCharService.addConfigPublicChar(c);
   return "redirect:/xxk/selectallsalaryGrantSet.do";
  }
   
  @RequestMapping("/{id}/deletesalaryGrantSet.do")
  public String deletesalaryGrantSet(@PathVariable("id") int id) {
	    System.out.println(id);
	configPublicCharService.removeConfigPublicChar(id);
  return "redirect:/xxk/selectallsalaryGrantSet.do";
  }
  
}

