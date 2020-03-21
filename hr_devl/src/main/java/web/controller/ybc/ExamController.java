package web.controller.ybc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.ConfigFileFirstKind;
import pojo.ConfigMajor;
import pojo.ConfigMajorKind;
import pojo.ConfigQuestionFirstKind;
import pojo.ConfigQuestionSecondKind;
import pojo.EngageAnswer;
import pojo.EngageExam;
import pojo.EngageExamDetails;
import pojo.EngageInterview;
import pojo.EngageResume;
import pojo.EngageSubjects;
import service.ConfigMajorKindService;
import service.ConfigMajorService;
import service.ConfigQuestionFirstKindService;
import service.ConfigQuestionSecondKindService;
import service.EngageExamDetailsService;
import service.EngageExamService;
import service.EngageInterviewService;
import service.EngageResumeService;
import service.EngageSubjectsService;
import web.controller.ybc.dto.ExamsModel;
import web.controller.ybc.dto.Helper;
import web.controller.ybc.dto.Massage;

@Service
@RequestMapping("/ybcexam")
public class ExamController {
	@Autowired
	ConfigQuestionFirstKindService configQuestionFirstKind=null;
	@Autowired
	ConfigQuestionSecondKindService configQuestionSecondKind=null;
	@Autowired
	EngageSubjectsService engageSubjectsService=null;
	@Autowired
	ConfigMajorKindService configMajorKindService=null;
	@Autowired
	ConfigMajorService configMajorService=null;
	@Autowired
	EngageExamService engageExamService=null;
	@Autowired
	EngageExamDetailsService  engageExamDetailsService=null;
	@Autowired
	EngageResumeService engageResumeService=null;
	@Autowired
	EngageInterviewService engageInterviewService =null;
	//考试试题登记 
	@RequestMapping("gototheSubjectRegister.do")
	public String gototheSubjectRegister(Model model,String operate){
		List<ConfigQuestionFirstKind> cqlist=configQuestionFirstKind.findAllConfigQuestionFirstKind();
		model.addAttribute("cqlist", cqlist);
		if("toAdd".equals(operate)){
			return "forward:/ybc_EngageMajorRelease/subject/subject_register.jsp";
		}else if("locate".equals(operate)){
			return "forward:/ybc_EngageMajorRelease/subject/subject_search.jsp";
		}
		return null;
	}
	
	//查询二级
	@RequestMapping("selectConfigQuestionSecondKindinAjax.do")
	@ResponseBody
	public List<ConfigQuestionSecondKind> selectConfigQuestionSecondKindinAjax(String mid){
		List<ConfigQuestionSecondKind>  list=	configQuestionSecondKind.findAllConfigQuestionSecondKind();
		List<ConfigQuestionSecondKind> slist=new ArrayList<>();
		for (ConfigQuestionSecondKind configQuestionSecondKind : list) {
			if(configQuestionSecondKind.getFirstKindId().equals(mid))
			{
				slist.add(configQuestionSecondKind);
			}
		}
		return slist;
	}
	
	//试题登记提交
	@RequestMapping("subjectRegisterSubmit.do")
	public String subjectRegisterSubmit(EngageSubjects es,Model model){
		engageSubjectsService.addEngageSubjects(es);
		model.addAttribute("msg", new Massage("试题登记成功！", "main.jsp"));
		return Massage.MSG_PAGE;
	}
	
	//开始查询
	@RequestMapping("subjectRegisterSearchStart.do")
	public String subjectRegisterSearchStart(String firstKindId,String secondKindId
			,String startDate,String endDate,String primarKey ,Model model){
		HashMap< String, String> map=new HashMap<>();
		map.put("firstKindId", firstKindId);
		map.put("secondKindId", secondKindId);
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		List<EngageSubjects> slist=	engageSubjectsService.findEngageSubjectsByCondition(map);
		model.addAttribute("slist", slist);
		return "forward:/ybc_EngageMajorRelease/subject/subject_list.jsp";
	}
	
	//查询套卷
		@RequestMapping("examRegisterSelects.do")
		public String examRegisterSelects(Model model){
			List<EngageExam> resultlist=engageExamService.findEngageGroupAndCount();
			System.out.println(resultlist);
			model.addAttribute("resultlist", resultlist);
			return "forward:/ybc_EngageMajorRelease/exam/exam_list.jsp";
		}
	
	//进入生成套卷
	@RequestMapping("examRegisterSelect.do")
	public String examRegisterSelect( Model model,EngageExam e){
		//加载职位登记页面的数据
				List <ConfigMajorKind> mlist =configMajorKindService.findAllConfigMajorKind();
				model.addAttribute("mlist",mlist);
				Helper h=new Helper();
				model.addAttribute("h", h);
		List<ConfigQuestionFirstKind> flist=	configQuestionFirstKind.findAllConfigQuestionFirstKind();
		List<ConfigQuestionSecondKind> list =configQuestionSecondKind.findAllConfigQuestionSecondKind();
		List<EngageSubjects>  elist=engageSubjectsService.findAllEngageSubjects();
		for (ConfigQuestionFirstKind configQuestionFirstKind : flist) {
			for (ConfigQuestionSecondKind configQuestionSecondKind : list) {
				if(configQuestionSecondKind.getFirstKindId().equals(configQuestionFirstKind.getFirstKindId())){
					configQuestionFirstKind.getSeconds().add(configQuestionSecondKind);
					for (EngageSubjects engageSubjects : elist) {
						if(configQuestionFirstKind.getFirstKindId().equals(engageSubjects.getFirstKindId())&&configQuestionSecondKind.getSecondKindId().equals(engageSubjects.getSecondKindId()))
						{
							configQuestionSecondKind.getList().add(engageSubjects);
						}
					}
				}
			}
		}
		model.addAttribute("flist", flist);
		if(e!=null){
			System.out.println(e);
		}
		return "forward:/ybc_EngageMajorRelease/exam/exam_register.jsp";
	}
	//ajavx
	@RequestMapping("examRegisterMajorInAjax.do")
	@ResponseBody
	public List<ConfigMajor> examRegisterMajorInAjax(String mid){
		List<ConfigMajor> list=configMajorService.findAllConfigMajor();
		List<ConfigMajor> configMajorlist=new ArrayList<ConfigMajor>();
		for (ConfigMajor configMajor : list) {
			if(configMajor.getMajorKindId().equals(mid)){
				configMajorlist.add(configMajor);
			}
		}
		return configMajorlist;
	}
	
	
	
	
	//创建套卷提交
	@RequestMapping("examRegisterSubmit.do")
	public String examRegisterSubmit(ExamsModel examdetails,EngageExam ee,Model model){
		
		System.out.println(examdetails.getExamdetails());
		List<EngageExamDetails> list=examdetails.getExamdetails();
			String examNumber =	Helper.getExamid();
			ee.setExamNumber(examNumber);
			engageExamService.addEngageExam(ee);
		for (EngageExamDetails engageExamDetails : list) {
			engageExamDetails.setExamNumber(examNumber);
			engageExamDetailsService.addEngageExamDetails(engageExamDetails);
		}
		model.addAttribute("msg", new Massage("出题成功","main.jsp"));
		
		return Massage.MSG_PAGE;
	}
	
	//开始考试
	
	@RequestMapping("examstarttoAnswer.do")
	public String examstarttoAnswer(Model model){
		List <ConfigMajorKind> mklist=configMajorKindService.findAllConfigMajorKind();
		model.addAttribute("mklist", mklist);
		
		return "forward:/ybc_EngageMajorRelease/exam/exam_answer.jsp";
	}
	
	//提交考试人信息
	@RequestMapping("examStartPeopleMassge.do")
	public String examStartPeopleMassge(EngageAnswer ea,Model model){
		//先通过身份证查出简历
		HashMap<String, String> hashmap=new HashMap<>();
		hashmap.put("humanIdcard", ea.getHumanIdcard());
		List<EngageResume> erlist=engageResumeService.findAllEngageResumeByConditon(hashmap);
		if(erlist.size()<1){
			model.addAttribute("msg", new Massage("您还没有提交简历！", "main.jsp"));
			return Massage.MSG_PAGE;
		}
		EngageResume er=erlist.get(1);
		if(er.getCheckStatus()!=1){
			model.addAttribute("msg", new Massage("您的简历还没有通过审核!", "main.jsp"));
			return Massage.MSG_PAGE;
		}
		
		
		//再通过简历的id查出面试登记表
		List<EngageInterview>  eilist=	engageInterviewService.findAllEngageInterview();
		EngageInterview ei=null;
		for (EngageInterview engageInterview : eilist) {
			if(engageInterview.getResumeId()==er.getResId()){
				ei=engageInterview;
			}
		}
		if(ei==null){
			model.addAttribute("msg", new Massage("您还没有通过面试!", "main.jsp"));
			return Massage.MSG_PAGE;
		}
		if(ei.getCheckStatus()!=1){
			model.addAttribute("msg", new Massage("您的面试还没有审核!", "main.jsp"));
			return Massage.MSG_PAGE;
		}
		if(!"建议笔试".equals(ei.getResult())){
			model.addAttribute("msg", new Massage("您的面试解结果是"+ei.getResult()+"!", "main.jsp"));
			return Massage.MSG_PAGE;
		}
		System.out.println(ea);
		return null;
	}
	
}
