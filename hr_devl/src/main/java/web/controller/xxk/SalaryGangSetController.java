package web.controller.xxk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pojo.ConfigPublicChar;
import service.ConfigPublicCharService;

@Controller
@RequestMapping("/xxk")
public class SalaryGangSetController {
	
	@Autowired   
   ConfigPublicCharService     ConfigPublicCharService=null;  
   
	@RequestMapping("/selectallsalaryGangSet.do")
   public String  selectallsalaryGangSet() {
   List<ConfigPublicChar>    c  =ConfigPublicCharService.findselectConfigPublicCharByattributeKind("薪酬发放方式设置");
   
   return null; 
   }
}
