package web.controller.xxk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pojo.ConfigMajor;
import pojo.ConfigMajorKind;
import service.ConfigMajorKindService;
import service.ConfigMajorService;

@Controller
@RequestMapping("/xxk")
public class ConfigMajorController {
	@Autowired
	ConfigMajorService  configMajorService=null;
	
	@Autowired
	ConfigMajorKindService configMajorKindService=null;
	
	@RequestMapping("/selectallconfigMajor.do")
	public String selectallconfigMajor(Model m) {
	List<ConfigMajor> list	=configMajorService.findAllConfigMajor();
	m.addAttribute("configMajor", list);
	return "/major";
	}
	
	
	@RequestMapping("/{id}/deleteconfigMajor.do")
	public  String  deleteconfigMajor(@PathVariable("id")  short id) {
	configMajorService.removeConfigMajor(id);	
	return "redirect:/xxk/selectallconfigMajor.do";	
	} 
	
	@RequestMapping("/addconfigMajorprocess.do")
	public String addconfigMajorprocess(Model m) {
	List<ConfigMajorKind> list=configMajorKindService.findAllConfigMajorKind();
	m.addAttribute("configMajorKind",list);
	return "/xxkpage/major_add";
	}
	
	
	
	@RequestMapping("/addconfigMajor.do")
	public String addconfigMajor(ConfigMajor c) {
	
	configMajorService.addConfigMajor(c);	
	return "redirect:/xxk/selectallconfigMajor.do";
	}
	
}
