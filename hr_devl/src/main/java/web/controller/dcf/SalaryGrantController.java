package web.controller.dcf;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.xml.ws.RequestWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.SalaryGrant;
import pojo.SalaryGrantDetails;
import pojo.SalaryStandardDetails;
import service.SalaryGrantDetailsService;
import service.SalaryGrantService;
import service.SalaryStandardDetailsService;
import service.SalaryStandardService;
import web.controller.dcf.dto.Info;
import web.controller.dcf.dto.SalaryGrantDto;

@Controller
@RequestMapping("dcf/salarygrant")
public class SalaryGrantController {
	@Autowired
	private SalaryGrantDetailsService sgds=null;
	@Autowired
	private SalaryGrantService sgs=null;
	@Autowired
    private SalaryStandardService sss=null;
    @Autowired
    private SalaryStandardDetailsService ssds=null;
	
//展示要登记的薪酬发放
	@RequestMapping("/querysalarygrant/{ssid}.do")
	public String querySalaryGrant(Model model,@PathVariable String ssid) {
       //  发放登记集合
		List<SalaryGrantDto> list=new ArrayList<SalaryGrantDto>();
//		发放细节集合
		 List<SalaryGrantDetails> salaryGrantDetails=sgds.findSalaryGrandDetailsBySsid(ssid);
//		 查询一个薪酬发放对象
		 SalaryGrant salaryGrant=sgs.findSalaryGrantBySid(ssid);
		 for (SalaryGrantDetails s: salaryGrantDetails) {
			SalaryGrantDto sg=new SalaryGrantDto();
			sg.setSgd(s);
//			查询薪酬标准细节
			ArrayList<SalaryStandardDetails> list2=ssds.findManySalaryStandardDetails(salaryGrant.getSalaryStandardId());
			sg.setList(list2);
			list.add(sg);
		 }	    
		 model.addAttribute("show", list);
		 model.addAttribute("salarygrant", salaryGrant);
		return "forward:/dcf_SalaryGrant/register_commit.jsp";
	}
	
	
//展示所有未登记的	
	@RequestMapping("/querysalarygrantpeoples.do")
	@ResponseBody
	public List<SalaryGrant> querySalaryGrantPeoples() {
		List<SalaryGrant> list=sgs.findAllSalaryGrant();
		return list;
	}
//	登记薪酬标准进入待复核状态
	@RequestMapping("/checksalarygrant.do")
	public String checkSalaryGrant(@ModelAttribute Info grantDetails) {
		ArrayList<SalaryGrantDetails> list=grantDetails.getGrantDetails();
		for (SalaryGrantDetails salaryGrantDetails : list) {
			SalaryGrant sg=sgs.findSalaryGrantBySid(salaryGrantDetails.getSalaryGrantId());
			sg.setCheckStatus((short)0);
			sg.setRegister(grantDetails.getChecker());
			sg.setRegistTime(grantDetails.getCheckTime());
			sgs.alterSalaryGrant(sg);
			sgds.alterSalaryGrantDetails(salaryGrantDetails);
		}
		return "redirect:/dcf_SalaryGrant/register_success.jsp";
	}
//	打开页面展示所有通过登记发放的薪酬
	@RequestMapping("/querysalarygrantcheck.do")
	@ResponseBody
	public List<SalaryGrant> querysalarygrantcheck() {
		List<SalaryGrant> list=sgs.findAllSalaryGrant();
		return list;
	}
//	复核一个薪酬标准
	@RequestMapping("/checkOnesalarygrant/{ssid}.do")
	public String checkOneSalaryGrant(@PathVariable String ssid,Model model) {
	//  发放登记集合
		List<SalaryGrantDto> list=new ArrayList<SalaryGrantDto>();
//			发放细节集合
		 List<SalaryGrantDetails> salaryGrantDetails=sgds.findSalaryGrandDetailsBySsid(ssid);	
//			 查询一个薪酬发放对象
		 SalaryGrant salaryGrant=sgs.findSalaryGrantBySid(ssid);
		 for (SalaryGrantDetails s: salaryGrantDetails) {
			SalaryGrantDto sg=new SalaryGrantDto();
			sg.setSgd(s);
//				查询薪酬标准细节
			ArrayList<SalaryStandardDetails> list2=ssds.findManySalaryStandardDetails(salaryGrant.getSalaryStandardId());
			sg.setList(list2);
			list.add(sg);
		 }	    
		 model.addAttribute("salmoney", salaryGrantDetails);
		 model.addAttribute("show", list);
		 model.addAttribute("salarygrant", salaryGrant);
		return "forward:/dcf_SalaryGrant/check.jsp";
	}
	
//	复核通过发放成功
	@RequestMapping("/passsalarygrant.do")
	public String passSalaryGrant(@ModelAttribute Info grantDetails) {
		System.out.println("进入方法");
		ArrayList<SalaryGrantDetails> list=grantDetails.getGrantDetails();
		for (SalaryGrantDetails salaryGrantDetails : list) {
			SalaryGrant sg=sgs.findSalaryGrantBySid(salaryGrantDetails.getSalaryGrantId());
			sg.setCheckStatus((short)1);
			sg.setChecker(grantDetails.getChecker());
			sg.setCheckTime(grantDetails.getCheckTime());
			sgs.alterSalaryGrant(sg);
			sgds.alterSalaryGrantDetails(salaryGrantDetails);
		}
		return "redirect:/dcf_SalaryGrant/check_success.jsp";
	}

}
