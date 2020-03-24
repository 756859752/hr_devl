package web.controller.ybc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pojo.EngageInterview;
import pojo.EngageResume;
import service.EngageInterviewService;
import service.EngageResumeService;
import service.EngageSubjectsService;
import web.controller.ybc.dto.Massage;

@Controller
@RequestMapping("/ybcpass")
public class PassController {

	@Autowired
	EngageResumeService engageResumeService=null;
	@Autowired
	EngageInterviewService engageInterviewService=null;
	
	@RequestMapping("selectPassresume.do")
	public String selectPassresume(Model model){
		List<EngageResume> list=engageResumeService.findAllEngageResume();
		List<EngageResume> vlist=new ArrayList<>();
		for (EngageResume engageResume : list) {
			if(engageResume.getCheckStatus()==3){
				vlist.add(engageResume);
			}
		}
		model.addAttribute("vlist", vlist);
		return "forward:/ybc_EngageMajorRelease/pass/register_list.jsp";
	}
	
	//录用申请具体情况
	@RequestMapping("passRegist.do")
	public String passRegist(Short resId,Model model){
		List<EngageInterview> einlist=	engageInterviewService.findAllEngageInterview();
		EngageInterview ein=null;
		for (EngageInterview engageInterview : einlist) {
			if(engageInterview.getResumeId()==resId){
				ein=engageInterview;
			}
		}
		EngageResume  re=engageResumeService.findEngageResumeById(resId);
		ein.setResumeid(re);
		model.addAttribute("vi", ein);
		return "forward:/ybc_EngageMajorRelease/pass/register.jsp";
	}
	
	//申请录提交
	@RequestMapping("passRegistSubmit.do")
	public String passRegistSubmit(Short resId,String check,String method,
			String passcheckcomment,String passchecker,Model model){
		EngageResume re=	engageResumeService.findEngageResumeById(resId);
			re.setPassCheckComment(check);
			if("申请录用".equals(check)){
				short a=1;
				re.setPassCheckStatus(a);
			}else{//释放简历
				short a=2;
				re.setPassCheckStatus(a);
				a=4;
				re.setCheckStatus(a);
		}
			re.setPassRegister(passchecker);//为了减少代码  就用同一个名字算了
			re.setPassCheckComment(passcheckcomment);
		
			engageResumeService.alterEngageResume(re);
			
		model.addAttribute("msg", new Massage("操作成功", "main.jsp"));
		return Massage.MSG_PAGE;
	}
	
	//录用审批查询
	@RequestMapping("selectPassCheck.do")
	public String selectPassCheck(Model model){
		List<EngageResume> list=engageResumeService.findAllEngageResume();
		List<EngageResume> vlist=new ArrayList<>();
		for (EngageResume engageResume : list) {
			if(engageResume.getCheckStatus()==3&&engageResume.getPassCheckStatus()!=2){
				vlist.add(engageResume);
			}
		}
		model.addAttribute("vlist", vlist);
		return "forward:/ybc_EngageMajorRelease/pass/check_list.jsp";
		
	}
	//录用审批细节
	@RequestMapping("passCheck.do")
	public String passCheck(Short resId,Model model){
		List<EngageInterview> einlist=	engageInterviewService.findAllEngageInterview();
		EngageInterview ein=null;
		for (EngageInterview engageInterview : einlist) {
			if(engageInterview.getResumeId()==resId){
				ein=engageInterview;
			}
		}
		EngageResume  re=engageResumeService.findEngageResumeById(resId);
		ein.setResumeid(re);
		model.addAttribute("vi", ein);
		return "forward:/ybc_EngageMajorRelease/pass/check.jsp";
	}
	
	//录用审批提交
	@RequestMapping("passCheckSubmit.do")
	public String passCheckSubmit(Short resId,String check,String method,
			String passcheckcomment,String passchecker,Model model){
		EngageResume re=	engageResumeService.findEngageResumeById(resId);
		re.setPassCheckComment(check);
		if("通过".equals(check)){
			short a=3;
			re.setPassCheckStatus(a);
		}else{//释放简历
			short a=2;
			re.setPassCheckStatus(a);
			a=4;
			re.setCheckStatus(a);
	}
		re.setPassChecker(passchecker);//为了减少代码  就用同一个名字算了
		re.setPassPassComment(passcheckcomment);
	
		engageResumeService.alterEngageResume(re);
		
	model.addAttribute("msg", new Massage("操作成功", "main.jsp"));
	return Massage.MSG_PAGE;
	}
	
	//录用查询 
	@RequestMapping("passSearch.do")
	public String passSearch(Model model){
		List<EngageResume> list=engageResumeService.findAllEngageResume();
		List<EngageResume> vlist=new ArrayList<>();
		for (EngageResume engageResume : list) {
			if(engageResume.getPassCheckStatus()!=null){
				if(engageResume.getPassCheckStatus()==3){
				vlist.add(engageResume);
				}
			}
		}
		model.addAttribute("vlist", vlist);
		return "forward:/ybc_EngageMajorRelease/pass/pass_list.jsp";
	}
	
	//录用查询详情
	@RequestMapping("passSearchDetails.do")
	public String passSearchDetails(Short resId,Model model){
		List<EngageInterview> einlist=	engageInterviewService.findAllEngageInterview();
		EngageInterview ein=null;
		for (EngageInterview engageInterview : einlist) {
			if(engageInterview.getResumeId()==resId){
				ein=engageInterview;
			}
		}
		EngageResume  re=engageResumeService.findEngageResumeById(resId);
		ein.setResumeid(re);
		model.addAttribute("vi", ein);
		return "forward:/ybc_EngageMajorRelease/pass/pass.jsp";
	}
}
