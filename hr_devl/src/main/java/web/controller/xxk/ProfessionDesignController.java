package web.controller.xxk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pojo.ConfigPublicChar;
import service.ConfigPublicCharService;

@Controller
@RequestMapping("/xxk")
public class ProfessionDesignController {
    @Autowired
	ConfigPublicCharService configPublicCharService=null;
    
    
    @RequestMapping("/selecctallprofession.do")
    public String  selectallProfession(Model m) {
     List<ConfigPublicChar>	 list =configPublicCharService.findselectConfigPublicCharByattributeKind("职称");
      m.addAttribute("profession", list);
     return "/xxkpage/profession_design";
    } 
    
    
   @RequestMapping("/addProession.do")
   public String addProfession(ConfigPublicChar  c) {
   configPublicCharService.addConfigPublicChar(c);
   return "redirect:/xxk/selecctallprofession.do";   
   } 
   
   
   @RequestMapping("/{id}/deleteProfession.do")
   public String deleteProfession(@PathVariable("id") int id){
	   configPublicCharService.removeConfigPublicChar(id);
	   
   return "redirect:/xxk/selecctallprofession.do";  
   } 
   
}
