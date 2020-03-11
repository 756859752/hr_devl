package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.ConfigPublicCharService;

@Controller
public class ConfigPublicCharcController {
	
	@Autowired
	public ConfigPublicCharService configPublicCharService=null;
	
	@RequestMapping("/contest.do")
	public void gotest(){
		System.out.println("进入了contes.do");
		System.out.println(configPublicCharService.findAllConfigPublicChar());
	}
}
