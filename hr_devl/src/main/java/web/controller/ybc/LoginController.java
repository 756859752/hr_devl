package web.controller.ybc;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pojo.Users;
import service.UsersService;
import web.controller.ybc.dto.Massage;
import web.controller.ybc.dto.UserLogin;

@Controller
@RequestMapping("/ybc")
public class LoginController {

	@Autowired
	UsersService usersService=null;
	
	//登录
	@RequestMapping("/login.do")
	public String login(@RequestParam String UName,@RequestParam String UPassword ,HttpSession session,Model model){
		
	List<Users>	list =usersService.findAllUsers();
		for (Users users : list) {
			if(users.getUName().equals(UName)){
				if(users.getUPassword().equals(UPassword)){
					UserLogin userlogin=new UserLogin();
					userlogin.setUser_true_name(users.getUTrueName());
					session.setAttribute("userlogin", userlogin);
					return "redirect:/index.jsp";
				}
			}
		}
		//要将当前的登陆人cunzaisession
		
		
		model.addAttribute("error", new Massage("账号密码错误","login.jsp"));
		
		return "redirect:/ybc_EngageMajorRelease/error.jsp";
	}
}
