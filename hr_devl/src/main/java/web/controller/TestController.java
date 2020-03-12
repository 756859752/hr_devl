package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pojo.Bonus;
import service.BonusService;

@Controller
public class TestController {
	
	@Autowired
	BonusService bonusService=null;
	
	@RequestMapping("mytest1.do")
	public String test1(){
		
		bonusService.findAllBonus();
		return null;
	}
}
