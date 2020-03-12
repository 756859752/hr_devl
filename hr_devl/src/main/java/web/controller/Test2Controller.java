package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.ConfigFileFirstKindService;

@Controller
@RequestMapping("/ybc")
public class Test2Controller {
	
	@Autowired
	ConfigFileFirstKindService configFileFirstKindService=null;
	
	@RequestMapping("/demo.do")
	public String test222(){
		System.out.println(configFileFirstKindService.findAllConfigFileFirstKind());
		return null;
	}
}
