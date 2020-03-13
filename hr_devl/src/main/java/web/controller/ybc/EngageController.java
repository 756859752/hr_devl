package web.controller.ybc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.ConfigFileFirstKind;
import pojo.ConfigFileSecondKind;
import pojo.ConfigFileThirdKind;
import pojo.ConfigMajorKind;
import service.ConfigFileFirstKindService;
import service.ConfigFileSecondKindService;
import service.ConfigFileThirdKindService;
import service.ConfigMajorKindService;
import service.ConfigMajorService;

@Controller
@RequestMapping("/ybc")
public class EngageController {

	@Autowired
	ConfigFileFirstKindService configFileFirstKindService=null;
	@Autowired
	ConfigFileSecondKindService configFileSecondKindService=null;
	@Autowired
	ConfigFileThirdKindService configFileThirdKindService=null;
	@Autowired
	ConfigMajorKindService configMajorKindService=null;
	@Autowired
	ConfigMajorService configMajorService=null;
	
	@RequestMapping("/engagemajorrelease.do")
	public String loadEngageNajorReleasePage(Model model){
		//加载职位登记页面的数据
		List <ConfigFileFirstKind> fileFirstKindlist= configFileFirstKindService.findAllConfigFileFirstKind();
		List <ConfigMajorKind> majorKindlist =configMajorKindService.findAllConfigMajorKind();
		model.addAttribute("fileFirstKindlist",fileFirstKindlist);
		model.addAttribute("majorKindlist",majorKindlist);
		
		
		return "forward:/ybc_EngageMajorRelease/position_register.jsp";
	}
	
	//查询二级机构
	@RequestMapping("/selectscondkind.do")
	@ResponseBody
	public List<ConfigFileSecondKind> loadSecondKindinAjax(Integer fid){
		List<ConfigFileSecondKind> list= configFileSecondKindService.findAllConfigFileSecondKind();
		List<ConfigFileSecondKind> fileSecondKindlist=new ArrayList<ConfigFileSecondKind>();
		
		for (ConfigFileSecondKind configFileSecondKind : list) {
			if(Integer.parseInt(configFileSecondKind.getFirstKindId())==fid){
				fileSecondKindlist.add(configFileSecondKind);
			}
		}
		return fileSecondKindlist;
	}
	
	//查询三级机构
	@RequestMapping("/selectthirdkind.do")
	@ResponseBody
	public List<ConfigFileThirdKind> loadThirdKindinAjax(Integer tid){
		List<ConfigFileThirdKind> list=configFileThirdKindService.findAllConfigFileThirdKind();
		List<ConfigFileThirdKind> fileThirdKindlist=new ArrayList<ConfigFileThirdKind>();
		
		for (ConfigFileThirdKind configFileThirdKind : list) {
			if(Integer.parseInt(configFileThirdKind.getSecondKindId())==tid){
				fileThirdKindlist.add(configFileThirdKind);
			}
		}
		return fileThirdKindlist;
	}
	
	//查询职位
	
}
