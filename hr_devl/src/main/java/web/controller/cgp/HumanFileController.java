package web.controller.cgp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.ConfigFileFirstKind;
import pojo.ConfigFileSecondKind;
import pojo.ConfigFileThirdKind;
import pojo.ConfigMajor;
import pojo.ConfigMajorKind;
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
public class HumanFileController implements CheckStatus{

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
	
	//登记
		@RequestMapping("/humanregister.do")
		public String registerHumanFile(@ModelAttribute HumanFile hf){
			//human-id
			hf.setHumanId(GenericPrimaryKey.getPrimaryKey());
			//一级机构
			if(hf.getFirstKindName().contains("/")){
				String[] firstKind = hf.getFirstKindName().split("/");
				hf.setFirstKindId(firstKind[0]);
//				hf.setFirstKindName(firstKind[1]);
			}
			//二级机构
			if(hf.getSecondKindName().contains("/")){
				String[] secondKind = hf.getSecondKindName().split("/");
				hf.setSecondKindId(secondKind[2]);
//				hf.setSecondKindName(secondKind[3]);
			}
			//三级机构
			if(hf.getThirdKindName().contains("/")){
				String[] thirdKind = hf.getThirdKindName().split("/");
				hf.setThirdKindId(thirdKind[0]);
//				hf.setThirdKindName(thirdKind[1]);
			}
			//职位分类
			if(hf.getHumanMajorKindName().contains("/")){
				String[] humanMajorKind = hf.getHumanMajorKindName().split("/");
				hf.setHumanMajorKindId(humanMajorKind[0]);
				hf.setHumanMajorKindName(humanMajorKind[1]);
			}
			//职位名称
			if(hf.getHunmaMajorName().contains("/")){
				String[] humanMajor = hf.getHunmaMajorName().split("/");
				hf.setHumanMajorId(humanMajor[0]);
//				hf.setHunmaMajorName(humanMajor[1]);
			}
			//薪酬标准
			if(hf.getSalaryStandardName().contains("/")){
				String[] salaryStandardName = hf.getSalaryStandardName().split("/");
				hf.setSalaryStandardId(salaryStandardName[0]);
//				hf.setSalaryStandardName(salaryStandardName[1]);
			}
			//审核状态和档案状态
			hf.setCheckStatus(CheckStatus.DAISHENHE);
			hf.setHumanFileStatus(CheckStatus.DAISHENHE);
			
			
			humanFileService.addHumanFile(hf);
			return "redirect:/register_choose_picture.jsp";
		}
		
		//上传照片，未完成
		@RequestMapping("/upload.do")
		public String humanPhotoUpload(Model model){
			List<HumanFile> list = humanFileService.findHumanFileByCheckStatus((short)0);
			model.addAttribute("humanFilelist",list);
//			forward:/check_list.jsp
			return null;
		}
		//档案查询
		@RequestMapping("/query.do")
		public String humanQuery(Model model,HumanFile HumanFile){
			List<HumanFile> list = humanFileService.findByCondition(HumanFile);
			model.addAttribute("list",list);
//			forward:/query_list.jsp
			return "forward:/query_list.jsp";
		}
		
//		query_locate.jsp
//		人力查询条件,机构职位分类等
		@RequestMapping("/queryhuman.do")
		public String duoquery(Model model,HumanFile HumanFile){
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
//			forward:/query_locate.jsp
			return "forward:/query_locate.jsp";
		}
		
	
}
