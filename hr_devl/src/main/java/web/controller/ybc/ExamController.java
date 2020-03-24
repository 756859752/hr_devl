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
import pojo.EngageAnswerDetails;
import pojo.EngageExam;
import pojo.EngageExamDetails;
import pojo.EngageInterview;
import pojo.EngageResume;
import pojo.EngageSubjects;
import service.ConfigMajorKindService;
import service.ConfigMajorService;
import service.ConfigQuestionFirstKindService;
import service.ConfigQuestionSecondKindService;
import service.EngageAnswerDetailsService;
import service.EngageAnswerService;
import service.EngageExamDetailsService;
import service.EngageExamService;
import service.EngageInterviewService;
import service.EngageResumeService;
import service.EngageSubjectsService;
import web.controller.ybc.dto.AnswerModel;
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
	@Autowired
	EngageAnswerService engageAnswerService=null;
	@Autowired
	EngageAnswerDetailsService engageAnswerDetailsService=null;
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
		System.out.println(es);
		//engageSubjectsService.addEngageSubjects(es);
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
		model.addAttribute("e", e);
		
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
			if(engageExamDetails.getQuestionAmount()==null||engageExamDetails.getQuestionAmount().equals("")||engageExamDetails.getQuestionAmount()==0){
				continue;
			}
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
		hashmap.put("humanMajorKindId", "");
		hashmap.put("humanMajorId", "");
		hashmap.put("startDate", "");
		hashmap.put("endDate", "");
		List<EngageResume> erlist=engageResumeService.findAllEngageResumeByConditon(hashmap);
		if(erlist.size()<1){
			model.addAttribute("msg", new Massage("该身份证还没有提交简历！", "main.jsp"));
			return Massage.MSG_PAGE;
		}
		EngageResume re=erlist.get(0);
		if(re.getCheckStatus()==0){
			model.addAttribute("msg", new Massage("您的简历还没有通过审核!", "main.jsp"));
			return Massage.MSG_PAGE;
		}
		if(!(re.getHumanMajorKindId().equals(ea.getMajorKindId())&&re.getHumanMajorId().equals(ea.getMajorId()))){
			model.addAttribute("msg", new Massage("你填写的职位信息与简历不符，请重新填写", "ybcexam/examstarttoAnswer.do"));
			return Massage.MSG_PAGE;
		}
		
		//再通过简历的id查出面试登记表
		List<EngageInterview>  eilist=	engageInterviewService.findAllEngageInterview();
		EngageInterview in=null;
		for (EngageInterview engageInterview : eilist) {
			if(engageInterview.getResumeId()==re.getResId()){
				in=engageInterview;
			}
		}
		if(in==null){
			model.addAttribute("msg", new Massage("您还没有通过面试!", "main.jsp"));
			return Massage.MSG_PAGE;
		}
		if(in.getCheckStatus()!=2){
			model.addAttribute("msg", new Massage("您的面试解结果是"+in.getResult()+"!", "main.jsp"));
			return Massage.MSG_PAGE;
		}
		if(re.getTestStatus()==2){
			model.addAttribute("msg", new Massage("您的考试还没有经过审核!", "main.jsp"));
			return Massage.MSG_PAGE;
		}
		
		//通过选择的应聘类型挑选出题目
		HashMap<String, String> hashmap2=new HashMap<>();
		hashmap2.put("majorKindId",ea.getMajorKindId());
		hashmap2.put("majorId", ea.getMajorId());
		List<EngageExam> eelist=engageExamService.findEngageExamByCondition(hashmap2);
		int[] arr=	Helper.randomArray(1, eelist.size(), 1);
		EngageExam ex=eelist.get(arr[0]-1);//随机拿到一套题
		
		//
		
		
		HashMap<String, String> hashmap3=new HashMap<>();
		hashmap3.put("examNumber",ex.getExamNumber());//拿到套题的题号 找到对应的题目数量
		List<EngageExamDetails> eedlist=engageExamDetailsService.findEngageExamDetailsByCondition(hashmap3);
		
		List<List<EngageSubjects>> slist=new ArrayList<>();//总的试题
		int subamount=0;//总试题数量
		
		for (EngageExamDetails engageExamDetails : eedlist) {
			hashmap3.put("firstKindId", engageExamDetails.getFirstKindId());
			hashmap3.put("secondKindId", engageExamDetails.getSecondKindId());
			List<EngageSubjects> eslist=engageSubjectsService.findEngageSubjectsByCondition(hashmap3);//得到套题对应的所有试题
			//开始随机选择
			
			int [] arr1=Helper.randomArray(1, eslist.size(), engageExamDetails.getQuestionAmount());
			List<EngageSubjects> eslistr=new ArrayList<>();//一个类型的题目放进这个集合
			for (int rand : arr1) {
				eslistr.add(eslist.get(rand-1))	;
			}
			System.out.println(eslistr);
			subamount+=eslistr.size();//计算总题目数
			slist.add(eslistr);//将随机提取的题目存起来发到页面上
		}
		//开始出题
		System.out.println("拿到的简历吧"+re);
		
		model.addAttribute("re", re);//将简历
		model.addAttribute("in", in);//面试登记
		model.addAttribute("ex", ex);//套题
		model.addAttribute("subamount", subamount);
		model.addAttribute("ind", new Helper());//为了做接受的索引
		model.addAttribute("slist", slist);//得出的题目
		
		return "forward:/ybc_EngageMajorRelease/exam/exam_answer_start.jsp";
	}
	
	//提交交卷
	@RequestMapping("answersSubmit.do")
	public String answersSubmit(AnswerModel answers,EngageAnswer ea,Model model){
		System.out.println(ea);
		System.out.println(answers.getAnswers());
	//先把答案和答案细节表连接起来
		String asn=Helper.getExamid();//拿一个answer_nuber
		ea.setAnswerNumber(asn);
		
		short total=0;
		for (EngageAnswerDetails ead : answers.getAnswers()) {
			EngageSubjects 	subject=engageSubjectsService.findEngageSubjectsById(ead.getSubjectId());
			if(subject.getCorrectKey().equals(ead.getAnswer())){
				total+=4;//算分
			}
			ead.setAnswerNumber(asn);//关联
			engageAnswerDetailsService.addEngageAnswerDetails(ead);//考试细节表存库
		}
		ea.setTotalPoint(Double.valueOf(total));//考试表改分数
		engageAnswerService.addEngageAnswer(ea);//考试表存库
		
		EngageResume  er=engageResumeService.findEngageResumeById(ea.getResumeId());
		
		//计算平均分数
		HashMap<String, String> hashmap=new HashMap<>();
		hashmap.put("humanIdcard", ea.getHumanIdcard());
		List<EngageAnswer> listfortotal=engageAnswerService.findEngageAnswerByCondition(hashmap);
		double db=0;
		for (EngageAnswer engageAnswer : listfortotal) {
			db+=engageAnswer.getTotalPoint();
		}
		db/=listfortotal.size();
		er.setTotalPoints(db);//简历改分数
		short a2;
		if(er.getTestAmount()==null){//有可能是第一次考试   数据库的值为null
			a2=1;
		}else{
		a2=er.getTestAmount();
		a2+=1;
		}
		er.setTestAmount(a2);//考试次数加1
		short b=2;
		er.setTestStatus(b);//考试转台变为不可考试
		engageResumeService.alterEngageResume(er);//update简历表
		model.addAttribute("msg", new Massage("考试交卷成功！", "main.jsp"));
		
		return Massage.MSG_PAGE;
	}
	
	//到考试筛选结果去
	@RequestMapping("gotoThecheckTheAnswerDetailselect.do")
	public String gotoThecheckTheAnswerDetailselect(){
		return "forward:/ybc_EngageMajorRelease/exam/exam_answer_search.jsp";
	}
	
	//考试筛选结果
	@RequestMapping("checkTheAnswerDetailselect.do")
	public String checkTheAnswerDetailselect(String humanIdcard,String primarKey,
			String startDate,String endDate,Model model){
		HashMap<String, String> hashmap=new HashMap<>();
		hashmap.put("humanIdcard", humanIdcard);
		hashmap.put("primarKey", primarKey);
		hashmap.put("startDate", startDate);
		hashmap.put("endDate", endDate);
		List<EngageAnswer> resultList=	engageAnswerService.findEngageAnswerByCondition(hashmap);
		for (EngageAnswer engageAnswer : resultList) {
			EngageResume re=engageResumeService.findEngageResumeById(engageAnswer.getResumeId());
			engageAnswer.setTestStatus(re.getTestStatus());
		}
		
		model.addAttribute("resultList", resultList);
		
		return "forward:/ybc_EngageMajorRelease/exam/exam_answer_list.jsp";
	}
	
	//阅卷 查看应试人的答题状况
	@RequestMapping("checkTheAnswerDetails.do")
	public String checkTheAnswerDetails(Short ansId,Model model){
		EngageAnswer ex=	engageAnswerService.findEngageAnswerById(ansId);
		List<EngageAnswerDetails> slist=engageAnswerDetailsService.findEngageAnswerDetailsWithSubject(ex.getAnswerNumber());
		model.addAttribute("ex", ex);
		model.addAttribute("slist", slist);
		
		return "forward:/ybc_EngageMajorRelease/exam/exam_answer_details.jsp";
	}
	
	
	//考试筛选查询结果
	@RequestMapping("AnswerDetailstoShaixuan.do")
	public String AnswerDetailstoShaixuan(Short ansId,Model model){
		EngageAnswer ea=	engageAnswerService.findEngageAnswerById(ansId);
		Short reid=ea.getResumeId();
		 EngageResume re=engageResumeService.findEngageResumeById(reid);
		model.addAttribute("ea", ea);
		model.addAttribute("re", re);
		model.addAttribute("ansId", ansId);
		return "forward:/ybc_EngageMajorRelease/exam/exam_answer_sift.jsp";
	}
	
	//筛选结果接收
	@RequestMapping("AnswerDetailstoShaixuanSubmit.do")
	public String AnswerDetailstoShaixuanSubmit(Short ansId,Short resId,String result,Model model){
		EngageResume re=engageResumeService.findEngageResumeById(resId);
		if("建议面试".equals(result)){
			model.addAttribute("msg", new Massage("考试阶段不能回到面试阶段！","ybcexam/AnswerDetailstoShaixuan.do?ansId="+ansId));
			return Massage.MSG_PAGE;
		}
		if("建议笔试".equals(result)){
			short b=1;
			re.setTestStatus(b);
		}
		if("建议录用".equals(result)){
			short b=2;
			re.setTestStatus(b);
			b=3;
			re.setCheckStatus(b);
		}
		if("删除简历".equals(result)){
			short b=2;
			re.setTestStatus(b);
			b=4;
			re.setCheckStatus(b);
		}
		
		engageResumeService.alterEngageResume(re);//update
		
		model.addAttribute("msg", new Massage("筛选成功！","main.jsp"));
		return Massage.MSG_PAGE;
	}
}


