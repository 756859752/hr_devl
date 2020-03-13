package web.controller.dcf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.SalaryStandard;
import pojo.SalaryStandardDetails;
import service.SalaryStandardDetailsService;
import service.SalaryStandardService;


@Controller

public class SalaryStandardCotroller {
    @Autowired
    private SalaryStandardService sss=null;
    @Autowired
    private SalaryStandardDetailsService ssds=null;
    @RequestMapping("dcf/salarystandard")
    public String saveSalaryStandard(@ModelAttribute Salary s) {
//    	System.out.println("保存一个标准"+s.getSs().getStandardName()+"=="+s.getSs().getRemark());
//    	System.out.println(s.getSs().getRegistTime());
//    	System.out.println(s.getSs().getSalarySum());
    	s.getSs().setCheckStatus((short)0);
    	sss.addSalaryStandard(s.getSs());
    	List<SalaryStandardDetails> ll=s.getList();
    	for (SalaryStandardDetails ss: ll) {
    		ss.setStandardId(s.getSs().getStandardId());
    		ss.setStandardName(s.getSs().getStandardName());
			ssds.addSalaryStandardDetails(ss);
		}
    	return "redirect:/salarystandard_register_success.jsp";
    }
}
