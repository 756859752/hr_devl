package web.controller.xxk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



import pojo.ConfigFileFirstKind;
import service.ConfigFileFirstKindService;
import service.ConfigFileSecondKindService;
import service.ConfigFileThirdKindService;
import util.Myxxkutil;

@Controller
@RequestMapping("/xxk")
public class ConfigFileFirstKindController {
   
	@Autowired
	ConfigFileFirstKindService    configFileFirstKindService=null;
	
	@Autowired
	ConfigFileSecondKindService    configFileSecondKindService=null;
	@Autowired
	ConfigFileThirdKindService     configFileThirdKindService=null;
	
	@RequestMapping("/cffktoadd.do")
	public String toadd(Model m){


	List<ConfigFileFirstKind>  list =configFileFirstKindService.findAllConfigFileFirstKind();
	String  time =Myxxkutil.GrenericId(list,"firstKindId");      
	
	m.addAttribute("myxxktime",time);
	return "/first_kind_register";
}

	//Ok好了 
	//增加
   @RequestMapping("/cffkadd.do")
   public String add(ConfigFileFirstKind c){
	 configFileFirstKindService.addConfigFileFirstKind(c);
	return "redirect:/xxk/cffkselectall.do";  
   }   
  
  
   @RequestMapping("/{id}/cffkselectbyid.do")
   public String  seletbyid(@PathVariable("id") short id ,Model m ) {
   ConfigFileFirstKind c =configFileFirstKindService.findConfigFileFirstKindById(id);


     m.addAttribute("xxkconfigFileFirstKind", c); 
     return "/first_kind_change";

     }
   
   //更新
   @RequestMapping("/cffkupdate.do")  
   public String update(ConfigFileFirstKind c) {
   configFileFirstKindService.alterConfigFileFirstKind(c); 
   configFileSecondKindService.alterConfigFileSecondKindBycffk(c);
   configFileThirdKindService.alterConfigFileThirdKindBycffk(c);
   return "/first_kind_change_success";   
     }
   
   
   @RequestMapping("/changesuccess.do")
   public String  updatesuccess(){
	return "redirect:/xxk/cffkselectall.do";   
   }
    
   @RequestMapping("/{id}/deleteprocess.do") 
   public String deleteprocess(@PathVariable("id") short id,Model m){
   ConfigFileFirstKind  d = configFileFirstKindService.findConfigFileFirstKindById(id);
   m.addAttribute("deleteprocess", d); 
        
   return "/first_kind_delete";   
   } 
   
   //删除 
   @RequestMapping("/{id}/cffkdelete.do")
   public String delete(@PathVariable short id){
   ConfigFileFirstKind  d = configFileFirstKindService.findConfigFileFirstKindById(id); 
   
   configFileSecondKindService.removeConfigFileSecondKindByfirstkindid(d.getFirstKindId());
   configFileThirdKindService.removeConfigFileThirdKindByfirstKindId(d.getFirstKindId());
   configFileFirstKindService.removeConfigFileFirstKind(id);
   
   return "redirect:/xxk/cffkselectall.do";
   }
   
   @RequestMapping("/cffkselectall.do")
   public  String  selectall(Model m){
	   List<ConfigFileFirstKind> list =configFileFirstKindService.findAllConfigFileFirstKind();
	   m.addAttribute("configFileFirstKind", list);           
	   return "/first_kind";   		
	}
 }



