package web.controller.ybc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
	public String interviewResultRegisterSelectStart(
			@RequestParam String humanMajorKindId,
			@RequestParam String humanMajorId,
			@RequestParam String primarKey,@RequestParam String startDate,
			@RequestParam String endDate,Model model){
		HashMap<String, String> hashmap=new HashMap<String, String> ();
		hashmap.put("humanMajorKindId", humanMajorKindId);
		hashmap.put("humanMajorId", humanMajorId);
		hashmap.put("startDate", startDate);
		hashmap.put("endDate", endDate);
		List<EngageResume> resultList=engageResumeService.findAllEngageResumeByConditon(hashmap);
		 Iterator<EngageResume> it =resultList.iterator();
		while(it.hasNext()){
			EngageResume e=it.next();
			if(e.getCheckStatus()==4){//如果是
				it.remove();
			}
		}
		model.addAttribute("resultList", resultList);
		return "forward:/ybc_EngageMajorRelease/interview/interview-list.jsp";
	}
	
	//面试结果登记(登记细节)
	@RequestMapping("interviewResultRegister.do")
	public String interviewResultRegister(Short resid,Model model){
		EngageResume re= engageResumeService.findEngageResumeById(resid);
		
		model.addAttribute("re",re);
		EngageInterview in=null;
	List<EngageInterview> elist=	engageInterviewService.findAllEngageInterview();
		for (EngageInterview engageInterview : elist) {
			if(engageInterview.getResumeId()==resid){
				in=engageInterview;
			}
		}
		model.addAttribute("in", in);
		return "forward:/ybc_EngageMajorRelease/interview/interview-register.jsp";
	}
	
	//面试结果提交
	@RequestMapping("interviewResultSubmit.do")
	public String interviewResultSubmit(EngageResume resume,EngageInterview interview,Model model){
		System.out.println(resume.getInterviewStatus());
		System.out.println(interview);
		List<EngageInterview> list=engageInterviewService.findAllEngageInterview();
		for (EngageInterview engageInterview : list) {
			if(engageInterview.getResumeId()==interview.getResumeId()){//如果已经面试过一次了
				interview.setInterviewAmount((short)(engageInterview.getInterviewAmount()+1));
				interview.setEinId(engageInterview.getEinId());
				engageInterviewService.alterEngageInterview(interview);
				engageResumeService.alterEngageResume(resume);//同步简历的面试状态
				model.addAttribute("msg", new Massage("面试结果登记成功","main.jsp"));
				return Massage.MSG_PAGE;
			}
		}
		engageInterviewService.addEngageInterview(interview);//如果是第一次面试
		engageResumeService.alterEngageResume(resume);//同步简历的面试状态
		model.addAttribute("msg", new Massage("面试结果登记成功","main.jsp"));
		return Massage.MSG_PAGE;
	}
	
	//面试筛选
	@RequestMapping("interviewResultShaixuan.do")
	public String interviewResultShaixuan(Model model){
		List<EngageInterview> vlist=engageInterviewService.findAllEngageInterview();
		
		 Iterator<EngageInterview> it =vlist.iterator();
			while(it.hasNext()){
				EngageInterview e=it.next();
				EngageResume er=engageResumeService.findEngageResumeById(e.getResumeId());
				if(er.getCheckStatus()==4){//如果是已经删除的简历
					it.remove();
				}
			}
		model.addAttribute("vlist", vlist);
		return "forward:/ybc_EngageMajorRelease/interview/sift-list.jsp";
	}
	
	//进入筛选
	@RequestMapping("interviewResultShaixuanStart.do")
	public String interviewResultShaixuanStart(Short einId,Model model){
		EngageInterview vi=	engageInterviewService.findEngageInterviewByIdWithResume(einId);
		EngageResume er=engageResumeService.findEngageResumeById(vi.getResumeId());
		vi.setResumeid(er);
		model.addAttribute("vi", vi);
		return "forward:/ybc_EngageMajorRelease/interview/interview-sift.jsp";
	}
	
	//提交面试筛选
	@RequestMapping("interviewResultShaixuanSubmit.do")
	public String interviewResultShaixuanSubmit(EngageInterview interview,Model model){
		EngageResume er=	engageResumeService.findEngageResumeById(interview.getResumeId());
		short a=1;
			if("建议面试".equals(interview.getResult())){
				a=1;
				short b=2;
				er.setTestStatus(b);
				b=1;
				interview.setInterviewStatus(b);
			}
			if("建议笔试".equals(interview.getResult())){
				a=2;
				short b=1;
				er.setTestStatus(b);
				b=2;
				interview.setInterviewStatus(b);
			}
			if("建议录用".equals(interview.getResult())){
				a=3;
				short b=2;
				er.setTestStatus(b);
				interview.setInterviewStatus(b);
			}
			if("删除简历".equals(interview.getResult())){
				a=4;
				short b=2;
				er.setTestStatus(b);
				interview.setInterviewStatus(b);
			}
			interview.setCheckStatus(a);
			er.setCheckStatus(a);
			//同步面表的审核状态
		
			er.setInterviewStatus(interview.getInterviewStatus());
			engageResumeService.alterEngageResume(er);
			
		engageInterviewService.alterEngageInterview(interview);
		model.addAttribute("msg", new Massage("筛选成功","main.jsp"));
		return Massage.MSG_PAGE;
	}
}
