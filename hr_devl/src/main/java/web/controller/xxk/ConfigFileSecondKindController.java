
package web.controller.xxk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pojo.ConfigFileFirstKind;
import pojo.ConfigFileSecondKind;
import service.ConfigFileSecondKindService;
import util.Myxxkutil;
import service.ConfigFileFirstKindService;

@Controller
@RequestMapping("/xxk")
public class ConfigFileSecondKindController {
    
	
	@Autowired
	ConfigFileSecondKindService  ConfigFileSecondService  =null;    
	@Autowired 
	ConfigFileFirstKindService    ConfigFileFirstKindService=null;
	 //
	@RequestMapping("/cfskselectall.do")
    public String  selectall(Model  m){
		List<ConfigFileSecondKind> list	=ConfigFileSecondService.findAllConfigFileSecondKind();
    	m.addAttribute("xxkConfigFileSecondKind", list);
		return "/xxkpage/second_kind";
    }  
	
	//增加
	@RequestMapping("/cfsktoadd.do")
	public String toadd(Model m){
	List<ConfigFileSecondKind> listval=ConfigFileSecondService.findAllConfigFileSecondKind();
		String  time	=Myxxkutil.GrenericId(listval, "secondKindId");  
	    m.addAttribute("myxxktime",time);
	    List<ConfigFileFirstKind>   list=ConfigFileFirstKindService.findAllConfigFileFirstKind();  
	    m.addAttribute("myconfigFileFirstKind", list);
	    return "/xxkpage/second_kind_register";
	}
	
	@RequestMapping("/cfstadd.do")
    public String add(ConfigFileSecondKind  c) {
	ConfigFileSecondService.addConfigFileSecondKind(c);
	return "redirect:/xxk/cfskselectall.do";
	
	}
	// 改
	@RequestMapping("/{id}/cfsktoupdateprocess.do")
	public String updateprocess(@PathVariable("id") short id,Model m) {
	ConfigFileSecondKind  c = ConfigFileSecondService.findConfigFileSecondKindById(id);
    m.addAttribute("myxxkConfigFileSecondKind", c) ;
    
   // List<ConfigFileFirstKind>   list=ConfigFileFirstKindService.findAllConfigFileFirstKind();  
   // m.addAttribute("myconfigFileFirstKind", list);
	return "/xxkpage/second_kind_change";
	}
	
	@RequestMapping("/cfskupdate.do")
	public String update(ConfigFileSecondKind b){
		System.out.println("ok");
		System.out.println(b);
    ConfigFileSecondService.alterConfigFileSecondKind(b); 
      return "redirect:/xxk/cfskselectall.do";
	} 
	//删
    @RequestMapping("/{id}/confingFileSecondtoupdateprocess.do")
    public String  deleteprocess(@PathVariable("id") short id ,Model m){
    ConfigFileSecondKind    list =ConfigFileSecondService.findConfigFileSecondKindById(id);
    m.addAttribute("mydelconfigFileSecond", list) ;         
    return "/xxkpage/second_kind_delete";	    	 
   } 
    
 
    @RequestMapping("/{id}/confingFileSeconddelete.do")
    public String delete(@PathVariable("id") short id){
    	
    ConfigFileSecondService.removeConfigFileSecondKind(id); 
   
    return "redirect:/xxk/cfskselectall.do";
    }
	
    
    
}