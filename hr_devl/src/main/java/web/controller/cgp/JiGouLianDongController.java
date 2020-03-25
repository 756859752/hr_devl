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
import org.springframework.web.context.request.WebRequest;

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
public class JiGouLianDongController implements CheckStatus{

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
	
	//联动学习
	@RequestMapping("/xxx.do")
	@ResponseBody
	public List<ConfigFileSecondKind> deletequery(WebRequest request){
		String mid = request.getParameter("mid");
		List<ConfigFileSecondKind> list = configFileSecondKindService.findAllConfigFileSecondKind();
		List<ConfigFileSecondKind> list2 = new ArrayList<ConfigFileSecondKind>();
		for (ConfigFileSecondKind c : list) {
			if(c.getFirstKindId().toString().equals(mid)){
				list2.add(c);
			}
		}
		return list2;
	}
	@RequestMapping("/queryConditions.do")//查询
	@ResponseBody
	public List<ConfigFileSecondKind> findsecondkind(@RequestParam String firstkindid,@RequestParam String secondkindid){
		List<ConfigFileSecondKind> list = configFileSecondKindService.findAllConfigFileSecondKind();
		List<ConfigFileSecondKind> list2 = new ArrayList<ConfigFileSecondKind>();
		for (ConfigFileSecondKind c : list) {
			if(c.getFirstKindId().toString().equals(firstkindid)){
				list2.add(c);
			}
		}
		return list2;
	}
//	queryConditionstwo
	@RequestMapping("/queryConditionstwo.do")//查询
	@ResponseBody
	public List<ConfigFileThirdKind> findthirdkind(@RequestParam String secondkindid){
		List<ConfigFileThirdKind> list=configFileThirdKindService.findConfigFileThirdKindBySecondKindId(secondkindid);
		
		return list;
	}
//	queryConditionsthree  通过职位分类，返回职位名称
	@RequestMapping("/queryConditionsthree.do")//查询
	@ResponseBody
	public List<ConfigMajor> findmojarname(@RequestParam String humanmajorkindid){
		List<ConfigMajor> list=configMajorService.findConfigMajorByMajorKindId(humanmajorkindid);
		return list;
	}

	
	
	
}
