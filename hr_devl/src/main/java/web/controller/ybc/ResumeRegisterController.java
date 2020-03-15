package web.controller.ybc;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.ConfigMajor;
import pojo.ConfigMajorKind;
import pojo.ConfigPublicChar;
import pojo.EngageMajorRelease;
import pojo.EngageResume;
import service.ConfigMajorKindService;
import service.ConfigMajorService;
import service.ConfigPublicCharService;
import service.EngageMajorReleaseService;
import service.EngageResumeService;
import web.controller.ybc.dto.Massage;

@Service
@RequestMapping("/ybcresume")
public class ResumeRegisterController {
	@Autowired
	EngageMajorReleaseService engageMajorReleaseService=null;
	@Autowired
	ConfigPublicCharService configPublicCharService=null;
	@Autowired
	EngageResumeService engageResumeService=null;
	@Autowired
	ConfigMajorKindService configMajorKindService=null;
	@Autowired
	ConfigMajorService  configMajorService=null;
 	//职位申请
	@RequestMapping("majorreleaseshenqing.do")
	public String engageMajorReleaseShenqing(Short mid,Model model){
		EngageMajorRelease e=engageMajorReleaseService.findEngageMajorReleaseById(mid);
		model.addAttribute("mr", e);
		selectPublicCharInsertModel(model);
		return "forward:/ybc_EngageMajorRelease/resume/register.jsp";
	}
	
	//简历登记
	@RequestMapping("resumeregister.do")
	public String engageResumeRegister(Model model){
		List <ConfigMajorKind> mklist=configMajorKindService.findAllConfigMajorKind();
		model.addAttribute("mklist", mklist);
		selectPublicCharInsertModel(model);
		return "forward:/ybc_EngageMajorRelease/resume/resume-register.jsp";
	}
	
	//简历登记查询职位名AJax
	@RequestMapping("engageresumefinmajorinajax.do")
	@ResponseBody
	public List <ConfigMajor> engageResumefinMajorinAjax(String mid){
		List <ConfigMajor> list=configMajorService.findAllConfigMajor();
		List <ConfigMajor> mlist=new ArrayList<ConfigMajor>();
		System.out.println("此时拿到mid是"+mid);
		for (ConfigMajor configMajor : list) {
			if(configMajor.getMajorKindId().equals(mid)){
				mlist.add(configMajor);
			}
		}
		return mlist;
	}
	
	
	//简历登记提交
	@RequestMapping("resumeregistersubmit.do")
	public String  engageResumeRegisterSubmit(EngageResume e){
//		Timestamp t=new Timestamp(new Date().getTime());
//		e.setRegistTime(t);
		engageResumeService.addEngageResume(e);
		return null;
	}
	
	//简历筛选
	@RequestMapping("resumeshaixuan.do")
	public String engageResumeShaixuan(Model model){
		List<ConfigMajorKind> mklist=	configMajorKindService.findAllConfigMajorKind();
		model.addAttribute("mklist", mklist);
		return "forward:/ybc_EngageMajorRelease/resume/resume-choose.jsp";
	}
	
	//简历筛选的二级查询 根据
	@RequestMapping("findconfigmajorbyconfigmajorkind.do")
	@ResponseBody
	public List<ConfigMajor> findConfigMajorByConfigMajorKind(@RequestParam String mid){
		List<ConfigMajor> list=configMajorService.findAllConfigMajor();
		List<ConfigMajor> clist=new ArrayList<ConfigMajor>();
		for (ConfigMajor configMajor : list) {
			if(configMajor.getMajorKindId().equals(mid)){
				clist.add(configMajor);
			}
		}
		System.out.println(mid);
		return clist;
	}
	
	//开始筛选
	@RequestMapping("starttoshaixuan.do")
	public String startToShaixuan(@RequestParam String humanMajorId,
			@RequestParam String primarKey,@RequestParam String startDate,
			@RequestParam String endDate,Model model){
		HashMap<String, String> hashmap=new HashMap<String, String> ();
		hashmap.put("humanMajorId", humanMajorId);
		hashmap.put("startDate", startDate);
		hashmap.put("endDate", endDate);
		List<EngageResume> resultList=engageResumeService.findAllEngageResumeByConditon(hashmap);
		model.addAttribute("resultList", resultList);
		
		return "forward:/ybc_EngageMajorRelease/resume/resume-list.jsp";
	}
	
	//简历复核
	@RequestMapping("engageresumecheck.do")
	public String engageResumeCheck(Short resId,Model model){
		
		System.out.println("resid:"+resId);
		 EngageResume re= engageResumeService.findEngageResumeById(resId);
		model.addAttribute("re",re);
		return "forward:/ybc_EngageMajorRelease/resume/resume-details.jsp";
	}
	
	//推荐面试
	@RequestMapping("engageResumetuijianmianshi.do")
	public String engageResumetuijianmianshi(EngageResume e,Model model){
		engageResumeService.alterEngageResume(e);
		model.addAttribute("msg", new Massage("推荐成功","index.jsp"));
		return "forward:/ybc_EngageMajorRelease/massage.jsp";
	}
	
	//有效简历查询
	@RequestMapping("engageValidResumeSelect.do")
	public String engageValidResumeSelect(Model model){
		List<EngageResume> resultList=engageResumeService.findAllEngageResume();
		model.addAttribute("resultList",resultList);
		return "forward:/ybc_EngageMajorRelease/resume/valid-list.jsp";
	}
	
	
	//查找公共字段的方法
	public void selectPublicCharInsertModel(Model model){
		
		ConfigPublicChar cpc=new ConfigPublicChar();
		cpc.setAttributekind("国籍");
		List <ConfigPublicChar> glist=configPublicCharService.findAllConfigPublicCharByCondition(cpc);
		model.addAttribute("glist", glist);
		
		cpc.setAttributekind("民族");
		List <ConfigPublicChar> mlist=configPublicCharService.findAllConfigPublicCharByCondition(cpc);
		model.addAttribute("mlist", mlist);
		
		cpc.setAttributekind("宗教信仰");
		List <ConfigPublicChar> zlist=configPublicCharService.findAllConfigPublicCharByCondition(cpc);
		model.addAttribute("zlist", zlist);
		
		cpc.setAttributekind("政治面貌");
		List <ConfigPublicChar> zzlist=configPublicCharService.findAllConfigPublicCharByCondition(cpc);
		model.addAttribute("zzlist", zzlist);
		
		cpc.setAttributekind("学历");
		List <ConfigPublicChar> xlist=configPublicCharService.findAllConfigPublicCharByCondition(cpc);
		model.addAttribute("xlist", xlist);
		
		cpc.setAttributekind("教育年限");
		List <ConfigPublicChar> jlist=configPublicCharService.findAllConfigPublicCharByCondition(cpc);
		model.addAttribute("jlist", jlist);
		
		cpc.setAttributekind("专业");
		List <ConfigPublicChar> xlzylist=configPublicCharService.findAllConfigPublicCharByCondition(cpc);
		model.addAttribute("xlzylist", xlzylist);
		
		cpc.setAttributekind("特长");
		List <ConfigPublicChar> tlist=configPublicCharService.findAllConfigPublicCharByCondition(cpc);
		model.addAttribute("tlist", tlist);
		
		cpc.setAttributekind("爱好");
		List <ConfigPublicChar> alist=configPublicCharService.findAllConfigPublicCharByCondition(cpc);
		model.addAttribute("alist", alist);
		
		
		
		
	}
}
