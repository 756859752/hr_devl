package web.controller.cgp;

import java.util.ArrayList;
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
import service.ConfigPublicCharService;
import service.EngageMajorReleaseService;
import service.HumanFileService;
import util.CheckStatus;
import util.GenericPrimaryKey;

@Controller
@RequestMapping("/cgp")
public class HumanFileCheckController implements CheckStatus{

	@Autowired
	HumanFileService humanFileService=null;
	@Autowired
	ConfigPublicCharService configPublicCharService = null;
	
	//查询所有未审核的人资
	@RequestMapping("/humancheck.do")
	public String humanRegisterCheck(Model model){
		List<HumanFile> list = humanFileService.findHumanFileByCheckStatus((short)0);
		model.addAttribute("humanFilelist",list);
		return "forward:/check_list.jsp";
	}
	
	
	//获取要复核的人资信息
	@RequestMapping("/{hufId}/humancheckselect.do")
	public String humanRegisterCheckSelect(Model model,@PathVariable("hufId") Short hid){
		//个人信息
		HumanFile h = humanFileService.findHumanFileById(hid);
		model.addAttribute("human",h);
		//职称
		List<ConfigPublicChar> list = configPublicCharService.findAllConfigPublicChar();
		model.addAttribute("listc",list);
		return "forward:/human_check.jsp";
	}
	
	//复核人资
	@RequestMapping("/humanCheckPass.do")
	public String humanCheck(HumanFile nhf,HumanFile hf){
//		HumanFile hf = humanFileService.findHumanFileById(hid);
		hf.setCheckStatus(CheckStatus.YISHENHEORYIHUIFU);
		hf.setHumanFileStatus(CheckStatus.YISHENHEORYIHUIFU);
		
		humanFileService.alterHumanFile(hf);
		return "redirect:/cgp/humancheck.do";
	}
	
}
