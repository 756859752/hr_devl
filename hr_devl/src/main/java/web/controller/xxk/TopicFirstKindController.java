package web.controller.xxk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pojo.ConfigQuestionFirstKind;
import service.ConfigQuestionFirstKindService;
import service.ConfigQuestionSecondKindService;

@Controller
@RequestMapping("/xxk")
public class TopicFirstKindController {
	 @Autowired  
     ConfigQuestionFirstKindService   ConfigQuestionFirstKindService =null; 
	
	 @Autowired
	 ConfigQuestionSecondKindService   configQuestionSecondKindService=null ; 
	
	 @RequestMapping("/selectalltopicFirstKind.do")
	 public String selectalltopicFirstKind(Model m){ 
	 List<ConfigQuestionFirstKind>	list =ConfigQuestionFirstKindService.findAllConfigQuestionFirstKind();	 
	 m.addAttribute("topicFirstKind",list);
	 return "/xxkpage/topic/topic_first_kind"; 
	 }
	 
	 @RequestMapping("/addtopicFirstKindProcess.do")
	 public String  addtopicFirstKindProcess(Model m){
	 String   time   = String.valueOf(System.currentTimeMillis());  	 
	 m.addAttribute("time", time); 

	 return "/xxkpage/topic/topic_first_kind_add";
	 }
	 
	 @RequestMapping("/addtopicFirstKind.do")
	 public String  addtopicFirstKind(ConfigQuestionFirstKind c){
	 ConfigQuestionFirstKindService.addConfigQuestionFirstKind(c);
	 return "redirect:/xxk/selectalltopicFirstKind.do";
	 }
	 
	 
	 @RequestMapping("/{id}/deletetopicFirstKind.do")
	 public String deletetopicFirstKind(@PathVariable("id") short id) {
	 ConfigQuestionFirstKind   c =ConfigQuestionFirstKindService.ConfigQuestionFirstKindById(id);  	    
     configQuestionSecondKindService.removeConfigQuestionSecondKindByfirstKindId(c.getFirstKindId());    
     ConfigQuestionFirstKindService.removeConfigQuestionFirstKind(id);
     return "redirect:/xxk/selectalltopicFirstKind.do";
	 }
	 
}
