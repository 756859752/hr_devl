package web.controller.ybc;

import java.util.ArrayList;
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
import pojo.EngageInterview;
import pojo.EngageResume;
import service.ConfigMajorKindService;
import service.ConfigMajorService;
import service.EngageInterviewService;
import service.EngageResumeService;
import web.controller.ybc.dto.Massage;

@Service
@RequestMapping("/ybcinterview")
public class InterviewResultRegisterController {
	
	@Autowired
	ConfigMajorKindService configMajorKindService=null;
	@Autowired
	ConfigMajorService configMajorService=null;
	
	@Autowired
	EngageResumeService engageResumeService=null;
	@Autowired
	EngageInterviewService engageInterviewService=null;
	
	//面试结果登记(先查询)
	@RequestMapping("interviewResultRegisterSelectMajorKind.do")
	public String   interviewResultRegisterSelectMajorKind(Model model){
		List <ConfigMajorKind> mklist=configMajorKindService.findAllConfigMajorKind();
		model.addAttribute("mklist", mklist);
		return "forward:/ybc_EngageMajorRelease/interview/interview-resume.jsp";
	}
	
	//ajax返回职位列表
	@RequestMapping("selectMajorkindinAjax.do")
	@ResponseBody
	public List <ConfigMajor>  selectMajorkindinAjax(String mid){
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
	
	//面试结果登记(先查询 开始) 
	
	@RequestMapping("interviewResultRegisterSelectStart.do")
	public String interviewResultRegisterSelectStart(@RequestParam String humanMajorId,
			@RequestParam String primarKey,@RequestParam String startDate,
			@RequestParam String endDate,Model model){
		HashMap<String, String> hashmap=new HashMap<String, String> ();
		hashmap.put("humanMajorId", humanMajorId);
		hashmap.put("startDate", startDate);
		hashmap.put("endDate", endDate);
		List<EngageResume> resultList=engageResumeService.findAllEngageResumeByConditon(hashmap);
		model.addAttribute("resultList", resultList);
		return "forward:/ybc_EngageMajorRelease/interview/interview-list.jsp";
	}
	
	//面试结果登记(登记细节)
	@RequestMapping("interviewResultRegister.do")
	public String interviewResultRegister(Short resid,Model model){
		EngageResume re= engageResumeService.findEngageResumeById(resid);
		model.addAttribute("re",re);
		return "forward:/ybc_EngageMajorRelease/interview/interview-register.jsp";
	}
	
	//面试结果提交
	@RequestMapping("interviewResultSubmit.do")
	public String interviewResultSubmit(EngageResume resume,EngageInterview interview,Model model){
		System.out.println(resume);
		System.out.println(interview);
		engageInterviewService.addEngageInterview(interview);
		model.addAttribute("msg", new Massage("面试结果登记成功","index.jsp"));
		return "forward:ybc_EngageMajorRelease/massage.jsp";
	}
	
	//面试筛选
	@RequestMapping("interviewResultShaixuan.do")
	public String interviewResultShaixuan(Model model){
		List<EngageInterview> vlist=engageInterviewService.findAllEngageInterview();
		model.addAttribute("vlist", vlist);
		return "forward:/ybc_EngageMajorRelease/interview/sift-list.jsp";
	}
	
	//进入筛选
	@RequestMapping("interviewResultShaixuanStart.do")
	public String interviewResultShaixuanStart(Short einId,Model model){
		EngageInterview vi=	engageInterviewService.findEngageInterviewByIdWithResume(einId);
		System.out.println(vi);
		model.addAttribute("vi", vi);
		return "forward:/ybc_EngageMajorRelease/interview/interview-sift.jsp";
	}
	
}
