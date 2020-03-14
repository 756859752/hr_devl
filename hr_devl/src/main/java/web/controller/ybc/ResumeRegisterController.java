package web.controller.ybc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import service.EngageMajorReleaseService;

@Service
@RequestMapping("/ybcresume")
public class ResumeRegisterController {
	@Autowired
	EngageMajorReleaseService engageMajorReleaseService=null;
	
	//金图腾
	@RequestMapping("resumeregisterselect.do")
	public String resumeRegisterselect(){
		
		return null;
	}
}
