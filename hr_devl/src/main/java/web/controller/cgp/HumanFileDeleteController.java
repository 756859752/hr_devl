package web.controller.cgp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
import service.ConfigFileFirstKindService;
import service.ConfigFileSecondKindService;
import service.ConfigFileThirdKindService;
import service.ConfigMajorKindService;
import service.ConfigMajorService;
import service.EngageMajorReleaseService;
import service.HumanFileService;
import util.CheckStatus;
import util.GenericPrimaryKey;

@Controller
@RequestMapping("/cgp")
public class HumanFileDeleteController implements CheckStatus{

	@Autowired
	HumanFileService humanFileService=null;
	
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
	
	@RequestMapping("/deletehuman.do")
	public String deletequery(Model model,HumanFile HumanFile){
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
		return "forward:/delete_locate.jsp";
	}
	//得到查询的要删除的人资信息
	@RequestMapping("/delete.do")
	public String humandeletequery(Model model,HumanFile HumanFile){
		List<HumanFile> list = humanFileService.findByCondition(HumanFile);
		List<HumanFile> list2 = new ArrayList<HumanFile>();
		for (HumanFile l : list) {
			if(l.getHumanFileStatus()==(short)2){
				list2.add(l);
			}
		}
		list.removeAll(list2);
		model.addAttribute("humanFilelist",list);
		return "forward:/delete_list.jsp";
	}
	
	//修改人资删除状态
	@RequestMapping("/{hufId}/humandeleteselect.do")
	public String humanChangeSelect(Model model,@PathVariable("hufId") Short hid){
		//个人信息
		HumanFile h = humanFileService.findHumanFileById(hid);
		h.setHumanFileStatus(CheckStatus.YISHANCHU);
		humanFileService.alterHumanFile(h);
		return "redirect:/cgp/delete.do";
	}
	
	@RequestMapping("/huifuhuman.do")
	public String huifuquery(Model model,HumanFile HumanFile){
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
		return "forward:/huifu_locate.jsp";
	}
	
	@RequestMapping("/huifu.do")
	public String humanhuifu(Model model,HumanFile HumanFile){
		List<HumanFile> list = humanFileService.findByCondition(HumanFile);
		List<HumanFile> list2 = new ArrayList<HumanFile>();
		for (HumanFile l : list) {
			if(l.getHumanFileStatus()==CheckStatus.YISHANCHU){
				list2.add(l);
			}
		}
		model.addAttribute("humanFilelist",list2);
		return "forward:/huifu_list.jsp";
	}
	
	//修改人资删除状态
		@RequestMapping("/{hufId}/humanhuifuselect.do")
		public String humanHuifuSelect(Model model,@PathVariable("hufId") Short hid){
			//个人信息
			HumanFile h = humanFileService.findHumanFileById(hid);
			h.setHumanFileStatus(CheckStatus.YISHENHEORYIHUIFU);
			humanFileService.alterHumanFile(h);
			return "redirect:/cgp/huifu.do";
		}
		//将要永久删除的集合
		@RequestMapping("/foreverdelete.do")
		public String humanHuifuSelect(Model model){
			List<HumanFile> list = humanFileService.findAllHumanFile();
			List<HumanFile> list2 = new ArrayList<HumanFile>();
			for (HumanFile l : list) {
				if(l.getHumanFileStatus()==CheckStatus.YISHANCHU){
					list2.add(l);
				}
			}
			model.addAttribute("humanFilelist",list2);
			return "forward:/delete_forever_list.jsp";
		}
		//永久删除
		@RequestMapping("/{hufId}/humandeleteforever.do")
		public String humandeleteforever(Model model,@PathVariable("hufId") Short hid){
			//个人信息
			humanFileService.removeHumanFile(hid);
			return "redirect:/cgp/foreverdelete.do";
		}
}
