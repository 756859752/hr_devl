package web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.Student;
import service.StudentService;

@Controller
@RequestMapping("/demo")
public class StudentController {
	@Autowired
	StudentService studentService=null;
	
	@RequestMapping(value="/tianjia.do")
	public String tianjia(@ModelAttribute Student student,Model model){
		boolean flag=studentService.addStudent(student);
		if(flag){
			return "redirect:/demo/show.do";
		}else{
			return "redirect:/index.jsp";
		}
	}
	
	@RequestMapping("/show.do")
	public String showStudent(Model model){
		List<Student> list=studentService.findAllStudent();
		model.addAttribute("list", list);
		System.out.println("进入了show.do");
		return "forward:/show.jsp";
	}
	
	//ajax测试
	@RequestMapping("/{sid}/check.do")
	@ResponseBody
	//如果是3.1.2版本以上  这样既可  如果是以下  必须在springMVC配置文件中配置消息响应类型 并导入相关jar包
	public Student checkStudent(@PathVariable("sid") int sid){
		System.out.println(sid);
		Student stu=studentService.findOne(sid);
		return stu;
	}
	
}
