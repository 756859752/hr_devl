package web.controller.dcf;

import java.util.ArrayList;
import java.util.List;

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
	public String querySalaryGrant(@ModelAttribute SalaryGrant salaryGrant,Model model,@PathVariable String ssid) {
       //  发放登记集合
		List<SalaryGrantDto> list=new ArrayList<SalaryGrantDto>();
//		发放细节集合
		 List<SalaryGrantDetails> salaryGrantDetails=sgds.findSalaryGrandDetailsBySsid("111");
		 for (SalaryGrantDetails s: salaryGrantDetails) {
			SalaryGrantDto sg=new SalaryGrantDto();
			sg.setSgd(s);
			ArrayList<SalaryStandardDetails> list2=ssds.findManySalaryStandardDetails("1");
			sg.setList(list2);
			list.add(sg);
		 }	    
		 model.addAttribute("show", list);
		 System.out.println(list.size());
		return "forward:/dcf_SalaryGrant/register_commit.jsp";
	}
	
	
//展示所有未登记的	
	@RequestMapping("/querysalarygrantpeoples.do")
	@ResponseBody
	public List<SalaryGrant> querySalaryGrantPeoples() {
		List<SalaryGrant> list=sgs.findAllSalaryGrant();
		return list;
	}
	

}
