package web.controller.ybc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pojo.Users;
import service.UsersService;

@Controller
@RequestMapping("/ybc")
public class LoginController {

	@Autowired
	UsersService usersService=null;
	
	//登录
	@RequestMapping("/login.do")
	public String login(@RequestParam String UName,@RequestParam String UPassword ,Model model){
		
	List<Users>	list =usersService.findAllUsers();
		for (Users users : list) {
			if(users.getUName().equals(UName)){
				if(users.getUPassword().equals(UPassword)){
					return "redirect:/index.jsp";
				}
			}
		}
		model.addAttribute("error", new Massage("账号密码错误","login.jsp"));
		
		return "redirect:/ybc_EngageMajorRelease/error.jsp";
	}
}
