package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pojo.ConfigFileFirstKind;
import service.ConfigFileFirstKindService;
import service.EngageAnswerDetailsService;
import service.EngageAnswerService;
import service.EngageExamDetailsService;
import service.EngageExamService;
import service.EngageInterviewService;
import service.EngageMajorReleaseService;
import service.EngageResumeService;
import service.EngageSubjectsService;
import service.HumanFileDigService;
import service.HumanFileService;

@Controller
@RequestMapping("/ybc")
public class Test2Controller {
	

	@Autowired
	EngageSubjectsService engageSubjectsService=null;
	@Autowired
	EngageResumeService engageResumeService=null;
	@Autowired
	HumanFileDigService humanFileDigService=null;
	@Autowired
	HumanFileService humanFileService=null;
	@RequestMapping("/demo.do")
	public String test222(){
		short id=1;
		System.out.println(humanFileService.findHumanFileById(id));
		return null;
	}
}
