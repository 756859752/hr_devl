package web.controller.ybc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.ConfigQuestionFirstKind;
import pojo.ConfigQuestionSecondKind;
import pojo.EngageSubjects;
import service.ConfigQuestionFirstKindService;
import service.ConfigQuestionSecondKindService;
import service.EngageSubjectsService;
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
		engageSubjectsService.alterEngageSubjects(es);
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
	
}
