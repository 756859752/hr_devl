package web.controller.cgp;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.ConfigFileFirstKind;
import pojo.ConfigFileSecondKind;
import pojo.ConfigFileThirdKind;
import pojo.ConfigMajor;
import pojo.ConfigMajorKind;
import pojo.ConfigPublicChar;
import pojo.EngageMajorRelease;
import pojo.HumanFile;
import pojo.HumanFileDig;
import pojo.SalaryStandard;
import service.ConfigFileFirstKindService;
import service.ConfigFileSecondKindService;
import service.ConfigFileThirdKindService;
import service.ConfigMajorKindService;
import service.ConfigMajorService;
import service.ConfigPublicCharService;
import service.EngageMajorReleaseService;
import service.HumanFileDigService;
import service.HumanFileService;
import service.SalaryStandardService;
import util.CheckStatus;
import util.GenericPrimaryKey;

@Controller
@RequestMapping("/cgp")
public class HumanFileChangeController implements CheckStatus{

	@Autowired
	HumanFileService humanFileService=null;
	@Autowired
	HumanFileDigService humanFileDigService=null;
	@Autowired
	ConfigFileFirstKindService configFileFirstKindService = null;
	@Autowired
	ConfigFileSecondKindService configFileSecondKindService = null;
	@Autowired
	ConfigFileThirdKindService configFileThirdKindService = null;
	@Autowired
	ConfigMajorKindService configMajorKindService = null;
	@Autowired
	ConfigMajorService configMajorService = null;
	@Autowired
	ConfigPublicCharService configPublicCharService = null;
	@Autowired
	SalaryStandardService salaryStandardService=null;
	//注册登记的机构信息
	@RequestMapping("/queryjigou.do")
	public String liandong(Model model,HumanFile HumanFile){
		List<ConfigFileFirstKind> list1 = configFileFirstKindService.findAllConfigFileFirstKind();
		List<ConfigFileSecondKind> list2 = configFileSecondKindService.findAllConfigFileSecondKind();
		List<ConfigFileThirdKind> list3 = configFileThirdKindService.findAllConfigFileThirdKind();
		List<ConfigMajorKind> listmk = configMajorKindService.findAllConfigMajorKind();
		List<ConfigMajor> listm = configMajorService.findAllConfigMajor();
		List<SalaryStandard> lists= salaryStandardService.findAllSalaryStandard();
		List<ConfigPublicChar> list = configPublicCharService.findAllConfigPublicChar();
		List<ConfigPublicChar> listc = new ArrayList<ConfigPublicChar>();
		for (ConfigPublicChar c : list) {
			if(c.getAttributekind().equals("职称")){
				listc.add(c);
			}
		}
		model.addAttribute("list1",list1);
		model.addAttribute("list2",list2);
		model.addAttribute("list3",list3);
		model.addAttribute("listmk",listmk);
		model.addAttribute("listm",listm);
		model.addAttribute("listc",listc);
		model.addAttribute("lists",lists);
//		forward:/human_register.jsp
		return "forward:/human_register.jsp";
	}
	//档案查询
	@RequestMapping("/change.do")
	public String humanChange(Model model,HumanFile HumanFile){
		List<HumanFile> list = humanFileService.findByCondition(HumanFile);
		model.addAttribute("list",list);
//				forward:change_locate.jsp
		return "forward:/query_list.jsp";
	}
	
//	query_locate.jsp
//	人力查询条件,机构职位分类等
	@RequestMapping("/queryalljigou.do")
	public String duoquery(Model model,HumanFile HumanFile){
		List<ConfigFileFirstKind> list1 = configFileFirstKindService.findAllConfigFileFirstKind();
		List<ConfigFileSecondKind> list2 = configFileSecondKindService.findAllConfigFileSecondKind();
		List<ConfigFileThirdKind> list3 = configFileThirdKindService.findAllConfigFileThirdKind();
		List<ConfigMajorKind> listmk = configMajorKindService.findAllConfigMajorKind();
		List<ConfigMajor> listm = configMajorService.findAllConfigMajor();
		List<ConfigPublicChar> listc = configPublicCharService.findAllConfigPublicChar();
		model.addAttribute("list1",list1);
		model.addAttribute("list2",list2);
		model.addAttribute("list3",list3);
		model.addAttribute("listmk",listmk);
		model.addAttribute("listm",listm);
		model.addAttribute("listc",listc);
//		forward:/human_register.jsp
		return "forward:/human_register.jsp";
	}
	
//	//获取查询变更的条件
	@RequestMapping("/querychangelist.do")
	public String gequery(Model model){
		List<ConfigFileFirstKind> list1 = configFileFirstKindService.findAllConfigFileFirstKind();
		List<ConfigFileSecondKind> list2 = configFileSecondKindService.findAllConfigFileSecondKind();
		List<ConfigFileThirdKind> list3 = configFileThirdKindService.findAllConfigFileThirdKind();
		List<ConfigMajorKind> listmk = configMajorKindService.findAllConfigMajorKind();
		List<ConfigMajor> listm = configMajorService.findAllConfigMajor();
		model.addAttribute("list1",list1);
		model.addAttribute("list2",list2);
		model.addAttribute("list3",list3);
		model.addAttribute("listmk",listmk);
		model.addAttribute("listm",listm);
//		forward:/query_locate.jsp
		return "forward:/query_change_locate.jsp";
	}
	//得到查询的要变更的人资信息
		@RequestMapping("/humanchangelist.do")
		public String humanchange(Model model,HumanFile HumanFile){
			List<HumanFile> list = humanFileService.findByCondition(HumanFile);
			model.addAttribute("humanFilelist",list);
			return "forward:/change_list.jsp";
		}
	
	//获取要变更的人资信息
	@RequestMapping("/{hufId}/humanchangeselect.do")
	public String humanChangeSelect(Model model,@PathVariable("hufId") Short hid){
		//个人信息
		HumanFile h = humanFileService.findHumanFileById(hid);
		model.addAttribute("human",h);
		//职称
		List<ConfigPublicChar> list = configPublicCharService.findAllConfigPublicChar();
		model.addAttribute("listc",list);
		return "forward:/human_change.jsp";
	}
			
	//变更人资
		@RequestMapping("/humanChangePass.do")
		public String humanchange(HumanFile nhf,HumanFile hf,HumanFileDig hfd){
			humanFileService.alterHumanFile(hf);
			humanFileDigService.alterHumanFileDig(hfd);;
			return "redirect:/cgp/querychangelist.do";
		}
}
