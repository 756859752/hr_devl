
package web.controller.dcf;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.ConfigMajor;
import pojo.ConfigMajorKind;
import pojo.HumanFile;
import pojo.MajorChange;
import pojo.SalaryStandard;
import service.ConfigFileFirstKindService;
import service.ConfigFileSecondKindService;
import service.ConfigFileThirdKindService;
import service.ConfigMajorKindService;
import service.ConfigMajorService;
import service.HumanFileService;
import service.MajorChangeService;
import service.SalaryStandardService;
import web.controller.dcf.dto.ChooseConditionsDto;

@Controller
@RequestMapping("dcf/transfer")
public class TransferController {
	@Autowired
	private ConfigFileFirstKindService  firstkind=null;
	@Autowired
	private ConfigFileSecondKindService  secondkind=null;
	@Autowired
	private ConfigFileThirdKindService  thirdkind=null;
	@Autowired
	private ConfigMajorKindService  majorkind=null;
	@Autowired
	private ConfigMajorService  major=null;
	@Autowired
	private HumanFileService humanfile=null;
	
	@Autowired
	private SalaryStandardService sss=null;
	
	@Autowired
	private MajorChangeService mcs=null;

	
//	插入人员调动信息,等待审核
	@RequestMapping("/addtransferinfo.do")
	public String addTransferInfo(@ModelAttribute MajorChange majorchange){
	  System.out.println("收集到所有数据"+majorchange.getNewSalaryStandardName());
	  System.out.println("收集到所有数据"+majorchange.getNewThirdKindName());
	  majorchange.setCheckStatus((short)0);
	  mcs.addMajorChange(majorchange);
		return "redirect:/dcf_Transfer/register_success.jsp";
	}
	
		
//	展示查询条件
	@RequestMapping("/choseConditions.do")
	@ResponseBody
	public ChooseConditionsDto queryChoseConditions(){
		ChooseConditionsDto ccd=new ChooseConditionsDto();
//		ccd.setFirst(firstkind.findAllConfigFileFirstKind());
//		ccd.setSecond(secondkind.findAllConfigFileSecondKind());
//		ccd.setThird(thirdkind.findAllConfigFileThirdKind());
//		ccd.setMajorkind(majorkind.findAllConfigMajorKind());
//		ccd.setMajor(major.findAllConfigMajor());
//		System.out.println("得到所有要展示的信息");
		return ccd;
	}
//	机构联动查询
	@RequestMapping("/queryConditions.do")
	@ResponseBody
	public ChooseConditionsDto queryConditions(@RequestParam String firstkindid,@RequestParam String secondkindid){
		ChooseConditionsDto ccd=new ChooseConditionsDto();
//		根据不同条件查询不同集合
//		第一个参数有值三级分类
		if(firstkindid!=""&&!firstkindid.equals(0)) {
			ccd.setSecond(secondkind.findAllConfigFileSecondKindByfisrtKindId(firstkindid));
//			第二个参数有值三级分类
		}else if(secondkindid!=""&&!secondkindid.equals(0)) {
			ccd.setThird(thirdkind.findConfigFileThirdKindBySecondKindId(secondkindid));
		}else {
//			参数没值查一级分类
			ccd.setFirst(firstkind.findAllConfigFileFirstKind());
//			查询职位
			ccd.setMajorkind(majorkind.findAllConfigMajorKind());
		}
		return ccd;
	}
//	职位跟职位分类联动
	@RequestMapping("/querymajors/{majorkindid}.do")
	@ResponseBody
	public List<ConfigMajor> queryMajors(@PathVariable String majorkindid){
		List<ConfigMajor> majors=major.findConfigMajorByMajorKindId(majorkindid);
		return majors;
	}
//	薪酬标准跟薪酬总额联动
	@RequestMapping("/querysumsalar/{sid}.do")
	@ResponseBody
	public String querySumSalar(@PathVariable String sid){
		SalaryStandard salarystandard=sss.findSalaryStandardBySid(sid);
		return salarystandard.getSalarySum().toString();
	}
	
	
//	查询所有要调动的人员信息,多条件查询
	@RequestMapping("/querytransferpeoples.do")
	public String queryTransferPeoples(@RequestParam String firstkindid,@RequestParam String secondkindid,
			@RequestParam String thirdkindid,@RequestParam String starttime,@RequestParam String endtime,HttpSession session){
		HashMap<String, Object> map=new HashMap<String, Object>();
		if(!firstkindid.equals("0")) {
			map.put("firstkindid", firstkindid);
		}
		if(!secondkindid.equals("0")) {
			map.put("secondkindid", secondkindid);
		}
		if(!thirdkindid.equals("0")) {
			map.put("thirdkindid", thirdkindid);
		}	
		if(starttime!=""&&endtime!="") {
    		if(Timestamp.valueOf((starttime+" 00:00:00")).after(Timestamp.valueOf((endtime+" 00:00:00")))) {
        		map.put("mintime",Timestamp.valueOf((endtime+" 00:00:00")));
            	map.put("maxtime", Timestamp.valueOf((starttime+" 00:00:00")));
        	}else {
        		map.put("mintime",Timestamp.valueOf((starttime+" 00:00:00")));
            	map.put("maxtime", Timestamp.valueOf((endtime+" 00:00:00")));
        	}	
    	}else if(starttime==""&&endtime!="") {
    		map.put("maxtime",Timestamp.valueOf((endtime+" 00:00:00")));
    	}else if(starttime!=""&&endtime=="") {
    		map.put("mintime",Timestamp.valueOf((starttime+" 00:00:00")));
    	}
		List<HumanFile> humanlits=humanfile.findHumanFileByConditions(map);
		session.setAttribute("list", humanlits);
		return "forward:/dcf_Transfer/register_list.jsp";
	}
//	查询所有的职位跟职位分类
	
//	得到要调动的人员资料
	@RequestMapping("/querytransferonepeople/{pid}.do")
	public String queryOnePeopleInfo(@PathVariable String pid,Model model) {
//		查询原来机构
		HumanFile hf=humanfile.findHumanFileById(Short.decode(pid));
//查询所有职位分类
		List<ConfigMajorKind> majorkinds=majorkind.findAllConfigMajorKind();
//		查询所有的薪酬标准
		List<SalaryStandard> salarystandard=sss.findAllSalaryStandard();
		model.addAttribute("humanfile", hf);
		model.addAttribute("majorkinds", majorkinds);
		model.addAttribute("salarystandard", salarystandard);
		return "forward:/dcf_Transfer/register.jsp";
	}
	
//查询所有要审核的信息
	@RequestMapping("/queryallcheckmajorchange.do")
	@ResponseBody
	public List<MajorChange> queryAllCheckMajorChange() {
		List<MajorChange> list=mcs.findAllMajorChangeByCheckStatus();
		return list;
	}
//	展示一个要审核的信息
	@RequestMapping("/queryallcheckmajorchange/{mid}.do")
	public String queryAllCheckMajorChange(@PathVariable String mid,Model model) {
		MajorChange majorchange=mcs.findMajorChangeById(Short.parseShort(mid));
		List<ConfigMajorKind> majorkinds=majorkind.findAllConfigMajorKind();
		List<SalaryStandard> salarystandard=sss.findAllSalaryStandard();
		model.addAttribute("onechang", majorchange);
		model.addAttribute("majorkinds",majorkinds);
		model.addAttribute("salarystandard",salarystandard);
		return "forward:/dcf_Transfer/check.jsp";
	}
//	调动审核通过
	@RequestMapping("/passonemajorchange.do")
	public String passOneMajorChange(@ModelAttribute MajorChange majorchange) {
		
		return "forward:/dcf_Transfer/check_success.jsp";
	}
	
//	多条件查询通过审核的信息
	@RequestMapping("/showpassmajorchange.do")
	public String showPassMajorChange(@RequestParam String firstkindid,@RequestParam String secondkindid,
			@RequestParam String thirdkindid,@RequestParam String starttime,
			@RequestParam String endtime,@RequestParam String majorKindId,
			@RequestParam String majorId,HttpSession session){
		System.out.println("得到一级机构id"+firstkindid);
		System.out.println("得到二级机构id"+secondkindid);
		System.out.println("得到三级机构id"+thirdkindid);
		System.out.println("得到职位分类id"+majorKindId);
		System.out.println("得到职位id"+majorId);
		System.out.println("得到建档开始时间"+starttime);
		System.out.println("得到职档结束时间"+endtime);
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("pass", 1);
		if(!firstkindid.equals("0")) {
			map.put("firstkindid", firstkindid);
		}
		if(!secondkindid.equals("0")) {
			map.put("secondkindid", secondkindid);
		}
		if(!thirdkindid.equals("0")) {
			map.put("thirdkindid", thirdkindid);
		}
		if(!majorKindId.equals("0")) {
			map.put("majorkindid", majorKindId);
		}
		if(!majorId.equals("0")) {
			map.put("majorid", majorId);
		}
		if(starttime!=""&&endtime!="") {
    		if(Timestamp.valueOf((starttime+" 00:00:00")).after(Timestamp.valueOf((endtime+" 00:00:00")))) {
        		map.put("mintime",Timestamp.valueOf((endtime+" 00:00:00")));
            	map.put("maxtime", Timestamp.valueOf((starttime+" 00:00:00")));
        	}else {
        		map.put("mintime",Timestamp.valueOf((starttime+" 00:00:00")));
            	map.put("maxtime", Timestamp.valueOf((endtime+" 00:00:00")));
        	}	
    	}else if(starttime==""&&endtime!="") {
    		map.put("maxtime",Timestamp.valueOf((endtime+" 00:00:00")));
    	}else if(starttime!=""&&endtime=="") {
    		map.put("mintime",Timestamp.valueOf((starttime+" 00:00:00")));
    	}
		
//		session.setAttribute("list", humanlits);
		
		return "forward:/dcf_Transfer/list.jsp";
	}

}