package web.controller.ybc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.ConfigFileFirstKind;
import pojo.ConfigFileSecondKind;
import pojo.ConfigFileThirdKind;
import pojo.ConfigMajor;
import pojo.ConfigMajorKind;
import pojo.EngageMajorRelease;
import service.ConfigFileFirstKindService;
import service.ConfigFileSecondKindService;
import service.ConfigFileThirdKindService;
import service.ConfigMajorKindService;
import service.ConfigMajorService;
import service.EngageMajorReleaseService;

@Controller
@RequestMapping("/ybc")
public class EngageMajorReleaseController {

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
	
	@Autowired
	EngageMajorReleaseService engageMajorReleaseService=null;
	
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
	public List<ConfigFileSecondKind> loadSecondKindinAjax(String fid){
		List<ConfigFileSecondKind> list= configFileSecondKindService.findAllConfigFileSecondKind();
		List<ConfigFileSecondKind> fileSecondKindlist=new ArrayList<ConfigFileSecondKind>();
		
		for (ConfigFileSecondKind configFileSecondKind : list) {
			if(configFileSecondKind.getFirstKindId().equals(fid)){
				fileSecondKindlist.add(configFileSecondKind);
			}
		}
		return fileSecondKindlist;
	}
	
	//查询三级机构
	@RequestMapping("/selectthirdkind.do")
	@ResponseBody
	public List<ConfigFileThirdKind> loadThirdKindinAjax(String sid){
		List<ConfigFileThirdKind> list=configFileThirdKindService.findAllConfigFileThirdKind();
		List<ConfigFileThirdKind> fileThirdKindlist=new ArrayList<ConfigFileThirdKind>();
		System.out.println(sid);
		System.out.println(list);
		for (ConfigFileThirdKind configFileThirdKind : list) {
			if(configFileThirdKind.getSecondKindId().equals(sid)){
				fileThirdKindlist.add(configFileThirdKind);
			}
		}
		return fileThirdKindlist;
	}
	
	//查询职位
	@RequestMapping("selectmajor.do")
	@ResponseBody
	public List<ConfigMajor> loadConfigMajorinAjax(String mid){
		List<ConfigMajor> list=configMajorService.findAllConfigMajor();
		List<ConfigMajor> configMajorlist=new ArrayList<ConfigMajor>();
		for (ConfigMajor configMajor : list) {
			if(configMajor.getMajorKindId().equals(mid)){
				configMajorlist.add(configMajor);
			}
		}
		return configMajorlist;
	}
	
	//职位发布登记提交表单
	@RequestMapping(value="submitengagemajorrelease.do")
	public String submitEngageMajorRelease(EngageMajorRelease e){
		engageMajorReleaseService.addEngageMajorReleaseAutowrite(e);
		return null;
	}
	
	//职位发布变更查询数据 查询出所有的职位发布
	@RequestMapping("releasechangeselect.do")
	public String engageMajorReleaseChangeselect(@RequestParam String operate, Model model){
		List<EngageMajorRelease> mrlist=engageMajorReleaseService.findAllEngageMajorRelease();
		model.addAttribute("mrlist", mrlist);
		if("toEdit".equals(operate)){
			return "forward:/ybc_EngageMajorRelease/position_change_update.jsp";
		}else if("list".equals(operate)){
			return "forward:/ybc_EngageMajorRelease/position_release_search.jsp";
		}
		return null;
	}
	//职位发布的删除
	@RequestMapping("releasedelete.do")
	@ResponseBody
	public String engageMajorReleasedelete(@RequestParam Short mid){
		engageMajorReleaseService.removeEngageMajorRelease(mid);
		return "ok";
	}
	//职位发布变更提交
	
	@RequestMapping("releaseupdatesubmit.do")
	public String engageMajorReleaseUpdateSubmit(EngageMajorRelease e,Model model){
		engageMajorReleaseService.alterEngageMajorRelease(e);
		model.addAttribute("msg", new Massage("修改成功", "ybc/releasechangeselect.do?opreate=toEdit"));
		return "forward:/ybc_EngageMajorRelease/massage.jsp";
	}
	
	//发布变更的细节
	@RequestMapping("releasechangedetails.do")
	public String engageMajorReleaseChangeDetails(@RequestParam Short mid,Model model){
		EngageMajorRelease e=engageMajorReleaseService.findEngageMajorReleaseById(mid);
		model.addAttribute("mr", e);
		return "forward:/ybc_EngageMajorRelease/position_release_change.jsp";
	}
	
}
