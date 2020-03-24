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
public class LoginController {

	@Autowired
	UsersService usersService=null;
	
	//登录
	@RequestMapping("/login.do")
	public String login(@RequestParam String UName,@RequestParam String UPassword ,HttpSession session,Model model){
		
	List<Users>	list =usersService.findAllUsers();
		for (Users users : list) {
			if(users.getuName().equals(UName)){
				if(users.getuPassword().equals(UPassword)){
					UserLogin userlogin=new UserLogin();
					userlogin.setUser_true_name(users.getuTrueName());
					userlogin.setUser_role(users.getuMajorName());
					System.out.println("登录人："+userlogin);
					session.setAttribute("userlogin", userlogin);
					return "redirect:/index.jsp";
				}
			}
		}
		//要将当前的登陆人cunzaisession
		
		
		model.addAttribute("msg", new Massage("账号密码错误","login.jsp"));
		
		return "forward:/ybc_EngageMajorRelease/massage.jsp";
	}
}
