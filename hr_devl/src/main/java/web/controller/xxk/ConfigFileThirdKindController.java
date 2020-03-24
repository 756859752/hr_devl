package web.controller.xxk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.ConfigFileFirstKind;
import pojo.ConfigFileSecondKind;
import pojo.ConfigFileThirdKind;
import service.ConfigFileFirstKindService;
import service.ConfigFileSecondKindService;
import service.ConfigFileThirdKindService;
import util.Myxxkutil;


@Controller
@RequestMapping("/xxk")
public class ConfigFileThirdKindController {
   
	@Autowired
   ConfigFileThirdKindService configFileThirdKindService=null;
	@Autowired
   ConfigFileSecondKindService configFileSecondKindService=null;
	@Autowired
   ConfigFileFirstKindService  	configFileFirstKindService =null;
    
	//查
   @RequestMapping("/configFileThirdKindselectall.do")
   public String selectall(Model m) {
	List<ConfigFileThirdKind>    list=configFileThirdKindService.findAllConfigFileThirdKind();
    m.addAttribute("configFileThirdKind", list); 
	return "/xxkpage/third_kind";  
   }
   
   
   @ResponseBody   
   @RequestMapping("/{fkd}/selectbyfisrtKindId.do")
   public List<ConfigFileSecondKind> selectbyfisrtKindId(@PathVariable("fkd") String firstKindId ){
   List<ConfigFileSecondKind> list=configFileSecondKindService.findAllConfigFileSecondKindByfisrtKindId(firstKindId);    
   return list;   
   }
   
   @RequestMapping("/addconfigThirdKindProcess.do")
   public String  addconfigThirdKindProcess(Model m){
       
   List<ConfigFileFirstKind> list =configFileFirstKindService.findAllConfigFileFirstKind(); 
	 m.addAttribute("configFileFirstKind", list);
	 List<ConfigFileFirstKind> listval =configFileFirstKindService.findAllConfigFileFirstKind();
	 String time=Myxxkutil.GrenericId(listval,"thirdKindId");  
	 m.addAttribute("time",time);
   return "/xxkpage/third_kind_register"; 
   } 
   
   @RequestMapping("/{id}/deleteconfigThirdKindProcess.do")
   public  String  deleteconfigThirdKindProcess(@PathVariable("id") short id,Model m) {
   ConfigFileThirdKind c=configFileThirdKindService.findConfigFileThirdKindById(id);   
   m.addAttribute("configFileThirdKind",c);
   return "/xxkpage/third_kind_delete";   
   }
    @RequestMapping("/{id}/deleteconfigThirdKind.do")
   public String  deleteconfigThirdKind(@PathVariable("id") short id){
    	configFileThirdKindService.removeConfigFileThirdKind(id);
   return "redirect:/xxk/configFileThirdKindselectall.do";   
   }
    
   @RequestMapping("/addconfigThirdkind.do")
   public String addconfigThirdkind(ConfigFileThirdKind c) {
	   System.out.println(c);
   configFileThirdKindService.addConfigFileThirdKind(c);
   return "redirect:/xxk/configFileThirdKindselectall.do"; 
   }
  
   @RequestMapping("/{id}/updateconfigFileThirdKindProcess.do")
   public String updateconfigFileThirdKindProcess(@PathVariable("id") short id ,Model m ) {
   ConfigFileThirdKind     c   = configFileThirdKindService.findConfigFileThirdKindById(id);
   m.addAttribute("configFileThirdKind", c);        
   return "/xxkpage/third_kind_change";  
   }
   
   @RequestMapping("/updateconfigFileThird.do")
   public  String  updateconfigFileThird(ConfigFileThirdKind c) {
   configFileThirdKindService.alterConfigFileThirdKind(c);
	return "redirect:/xxk/configFileThirdKindselectall.do";  
   }
}
