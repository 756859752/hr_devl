package web.controller.xxk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pojo.ConfigPrimaryKey;
import service.ConfigPrimaryKeyService;

@Controller
@RequestMapping("/xxk")
public class ConfigPrimaryKindController {
	
   @Autowired
   ConfigPrimaryKeyService ConfigPrimaryKeyService=null;
   @RequestMapping("/{table}/selectByPrimaryKeyTable.do")
   public String  selectByPrimaryKeyTable(@PathVariable("table")  String  table,Model m ){
   List<ConfigPrimaryKey>   list  =ConfigPrimaryKeyService.findAllConfigPrimaryKeyByprimaryKeyTable(table);
   m.addAttribute("ConfigPrimaryKey", list);                     
   return "/xxk/primarykey/primary_key_register";   
   }  
  	
    
}
