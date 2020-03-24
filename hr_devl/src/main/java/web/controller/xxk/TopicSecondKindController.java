package web.controller.xxk;

import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pojo.ConfigQuestionFirstKind;
import pojo.ConfigQuestionSecondKind;
import service.ConfigQuestionFirstKindService;
import service.ConfigQuestionSecondKindService;
import util.Myxxkutil;

@Controller
@RequestMapping("/xxk")
public class TopicSecondKindController {
   
   @Autowired
   ConfigQuestionSecondKindService configQuestionSecondKindService=null;
   @Autowired
   ConfigQuestionFirstKindService ConfigQuestionFirstKindService=null;
	
   @RequestMapping("/selectalltopicSecondKind.do")  	
   public String selectalltopicSecondKind(Model m){
    List<ConfigQuestionSecondKind> 	 list=configQuestionSecondKindService.findAllConfigQuestionSecondKind();
    m.addAttribute("topicSecondKind", list);	
    return "/xxkpage/topic/topic_second_kind";
   }
	
   
    @RequestMapping("/addtopicSecondKindProcess.do")
	public String addtopicSecondKindProcess(Model m){
    List<ConfigQuestionSecondKind>	list=configQuestionSecondKindService.findAllConfigQuestionSecondKind();
    String   time   = Myxxkutil.GrenericId(list, "secondKindId");  	 
	m.addAttribute("time", time); 
	List<ConfigQuestionFirstKind> c =ConfigQuestionFirstKindService.findAllConfigQuestionFirstKind();   
	m.addAttribute("configQuestionFirstKind", c) ;
    return "/xxkpage/topic/topic_second_kind_add"; 	
	} 	
    
    
    @RequestMapping("/addtopicSecondKind.do")
    public String  addtopicSecondKind(ConfigQuestionSecondKind c) {
   
    	
    configQuestionSecondKindService.addConfigQuestionSecondKind(c);
    return "redirect:/xxk/selectalltopicSecondKind.do";	
    }
    
    
    @RequestMapping("/{id}/deletetopicSecondKind.do")
    public String  deletetopicSecondKind(@PathVariable("id") short id) {
     configQuestionSecondKindService.removeConfigQuestionSecondKind(id); 
    return "redirect:/xxk/selectalltopicSecondKind.do";
    }
    
}
