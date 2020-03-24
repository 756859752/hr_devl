


package web.controller.xxk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pojo.ConfigMajorKind;
import service.ConfigMajorKindService;
import util.Myxxkutil;

@Controller
@RequestMapping("/xxk")
public class ConfigMajorKindController {
	
	@Autowired
	ConfigMajorKindService    ConfigMajorKindService=null;
	
	@RequestMapping("/selectallconfigMagjorKind.do")
	public String selectallconfigMagjorKind(Model m){
		List<ConfigMajorKind>	list =ConfigMajorKindService.findAllConfigMajorKind();
		m.addAttribute("configMajorKind", list);
		return "/major_kind";
	}
	
	
	@RequestMapping("/addconfigMajorKindProcess.do")
	public String addconfigMajorKindProcess(Model m) {
    List<ConfigMajorKind>	 list     =  ConfigMajorKindService.findAllConfigMajorKind();
   	String  time= Myxxkutil.GrenericId(list,"majorKindId");
   	m.addAttribute("time",time);
	return "/xxkpage/major_kind_add";	
	}
	
	@RequestMapping("/addconfigMajorKind.do")
	public String addconfigMajorKind(ConfigMajorKind c) {
    ConfigMajorKindService.addConfigMajorKind(c);	
	return "redirect:/xxk/selectallconfigMagjorKind.do";	
	}
	
	
   @RequestMapping("/{id}/deleteconfigMajorKind.do")	
   public String deleteconfigMajorKind(@PathVariable("id") short id){
	ConfigMajorKindService.removeConfigMajorKindKind(id);
   return "redirect:/xxk/selectallconfigMagjorKind.do";   
   }   
	
}