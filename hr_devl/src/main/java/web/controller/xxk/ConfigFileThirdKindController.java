package web.controller.xxk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pojo.ConfigFileThirdKind;
import service.ConfigFileThirdKindService;


@Controller
@RequestMapping("/xxk")
public class ConfigFileThirdKindController {
   
	@Autowired
   ConfigFileThirdKindService configFileThirdKindService=null;
	
	
   @RequestMapping("/configFileThirdKindselectall.do")
   public String selectall(Model m) {
	List<ConfigFileThirdKind>    list=configFileThirdKindService.findAllConfigFileThirdKind();
	 m.addAttribute("configFileThirdKind", list);  
	return "/xxkpage/third_kind";  
   }
    
}
