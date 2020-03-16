package web.controller.ybc;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping("/ybcexam")
public class ExamController {

	//考试试题登记
	@RequestMapping("gototheSubjectRegister.do")
	public String gototheSubjectRegister(){
		
		return "forward:/ybc_EngageMajorRelease/exam/subject_register.jsp";
	}
}
