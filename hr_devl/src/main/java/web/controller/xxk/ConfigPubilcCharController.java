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
public class ConfigPubilcCharController {
    
	@Autowired
	ConfigPublicCharService ConfigPublicCharService=null;
	
	@RequestMapping("/selectallconfigPublicChar.do")
	public String  selectallconfigPublicChar(Model m){
	List<ConfigPublicChar>	list=ConfigPublicCharService.findAllConfigPublicChar();
	m.addAttribute("configPubliChar", list);
	return "/public_char";
	}

	
	@RequestMapping("/{id}/deleteconfigPublicChar.do")
	public String deleteconfigPublicChar(@PathVariable("id") short id) {
	ConfigPublicCharService.removeConfigPublicChar(id);
	return "redirect:/xxk/selectallconfigPublicChar.do";
	}
	
	@RequestMapping("/addconfigPublicChar.do")
	public String addconfigPubliChar(ConfigPublicChar c){
	ConfigPublicCharService.addConfigPublicChar(c);
	return "redirect:/xxk/selectallconfigPublicChar.do";	
	}
}
