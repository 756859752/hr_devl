package web.controller.dcf;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import pojo.SalaryStandard;
import pojo.SalaryStandardDetails;
import service.SalaryStandardDetailsService;
import service.SalaryStandardService;
import web.controller.dcf.dto.Salary;


@Controller
@RequestMapping("dcf/salarystandard")
public class SalaryStandardCotroller {
    @Autowired
    private SalaryStandardService sss=null;
    @Autowired
    private SalaryStandardDetailsService ssds=null;
//    保存一个薪酬标准
    @RequestMapping("/saveSalStan.do")
    public String saveSalaryStandard(@ModelAttribute Salary s) {
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
    
//查询现有通过审核的薪酬标准
    @RequestMapping("/querySalStan.do")
    public String querySalaryStandards(@RequestParam String salid,@RequestParam String salinfo,
    		@RequestParam String starttime,@RequestParam String endtime,Model model) {
    	HashMap<String, Object> map=new HashMap<String, Object>();
    	map.put("salid", salid);
    	map.put("salnam", salinfo);
//   添加通过审核的薪酬标准状态 	
    	map.put("pass", (short)1);
    	if(starttime!=""&&endtime!="") {
    		if(Timestamp.valueOf((starttime+" 00:00:00")).after(Timestamp.valueOf((endtime+" 00:00:00")))) {
        		map.put("mintime",Timestamp.valueOf((endtime+" 00:00:00")));
            	map.put("maxtime", Timestamp.valueOf((starttime+" 00:00:00")));
        	}else {
        		map.put("mintime",Timestamp.valueOf((starttime+" 00:00:00")));
            	map.put("maxtime", Timestamp.valueOf((endtime+" 00:00:00")));
        	}	
    	}else if(starttime==""&&endtime!="") {
    		map.put("maxtime",Timestamp.valueOf((endtime+" 00:00:00")));
    	}else if(starttime!=""&&endtime=="") {
    		map.put("mintime",Timestamp.valueOf((starttime+" 00:00:00")));
    	}
    	List<SalaryStandard> list=sss.findCoditionsSalaryStandard(map);
    	model.addAttribute("list", list);
    	return "forward:/salarystandard_query_list.jsp";
    }
// 展示一个薪酬标准   
    @RequestMapping("/queryone/{sid}.do")
    public String queryOneSalaryStandard(@PathVariable int sid,HttpSession session) {
    	SalaryStandard salaryStandard=sss.findSalaryStandardById((short)sid);
    	ArrayList<SalaryStandardDetails> list=ssds.findManySalaryStandardDetails(String.valueOf(sid));
    	Salary s=new Salary();
    	s.setSs(salaryStandard);
    	s.setList(list);
    	session.setAttribute("salinfo",s);
    	return "redirect:/salarystandard_query.jsp";
    }
// 展示所有待审核的薪酬标准
    @RequestMapping("/checkSalaryStandard.do")
    @ResponseBody
    public List<SalaryStandard> queryCheck(HttpSession session) {
    	List<SalaryStandard> list=sss.findStateSalaryStandards();
    	session.setAttribute("moreSalaryStandard", list);
    	return list;
    }
 // 展示一个待审核的薪酬标准
    @RequestMapping("/checkSalaryStandardOne/{sid}.do")
    public String queryCheckOne(@PathVariable String sid,HttpSession session) {
    	Salary s=new Salary();
    	ArrayList<SalaryStandard> list1=(ArrayList)session.getAttribute("moreSalaryStandard");
    	for (SalaryStandard ss : list1) {
			if(ss.getStandardId().equals(sid)) {
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String nowtime=sdf.format(new Date());
				ss.setChangeTime(Timestamp.valueOf(nowtime));
				s.setSs(ss);
			}
		}
    	ArrayList<SalaryStandardDetails> list2=ssds.findManySalaryStandardDetails(sid);
    	s.setList(list2);
    	session.setAttribute("moreSalary", s);
    	return "redirect:/salarystandard_check.jsp";
    }
//    通过复核一个薪酬标准
    @RequestMapping("/checkone.do")
    public String checkOneSalaryStandard(@ModelAttribute Salary s) {
    	SalaryStandard ss=s.getSs();
    	ss.setCheckStatus((short)1);
    	sss.alterSalaryStandard(ss);
    	ArrayList<SalaryStandardDetails> list=s.getList();
    	for (SalaryStandardDetails sd : list) {
			ssds.alterSalaryStandardDetails(sd);
		}
    	return "redirect:/salarystandard_check_success.jsp";
    }
//    查询所有可以变更的薪酬标准
    @RequestMapping("/updateSalStan.do")
    public String uodateSalaryStandards(@RequestParam String salid,@RequestParam String salinfo,
    		@RequestParam String starttime,@RequestParam String endtime,Model model) {
    	HashMap<String, Object> map=new HashMap<String, Object>();
    	map.put("salid", salid);
    	map.put("salnam", salinfo);
       //   添加通过审核的薪酬标准状态 	
    	map.put("pass", (short)1);
    	if(starttime!=""&&endtime!="") {
    		if(Timestamp.valueOf((starttime+" 00:00:00")).after(Timestamp.valueOf((endtime+" 00:00:00")))) {
        		map.put("mintime",Timestamp.valueOf((endtime+" 00:00:00")));
            	map.put("maxtime", Timestamp.valueOf((starttime+" 00:00:00")));
        	}else {
        		map.put("mintime",Timestamp.valueOf((starttime+" 00:00:00")));
            	map.put("maxtime", Timestamp.valueOf((endtime+" 00:00:00")));
        	}	
    	}else if(starttime==""&&endtime!="") {
    		map.put("maxtime",Timestamp.valueOf((endtime+" 00:00:00")));
    	}else if(starttime!=""&&endtime=="") {
    		map.put("mintime",Timestamp.valueOf((starttime+" 00:00:00")));
    	}
    	List<SalaryStandard> list=sss.findCoditionsSalaryStandard(map);
    	model.addAttribute("list", list);
    	return "forward:/salarystandard_change_list.jsp";
    }
    
//    展示一个要修改薪酬标准
    @RequestMapping("/showupdateone/{sid}.do")
    public String showUpdateOneSalaryStandard(@PathVariable int sid,HttpSession session) {
    	SalaryStandard salaryStandard=sss.findSalaryStandardById((short)sid);
    	ArrayList<SalaryStandardDetails> list=ssds.findManySalaryStandardDetails(String.valueOf(sid));
    	Salary s=new Salary();
    	s.setSs(salaryStandard);
    	s.setList(list);
    	session.setAttribute("salinfo",s);
    	return "redirect:/salarystandard_change.jsp";
    }
//    修改一个薪酬标准
    @RequestMapping("/updateone.do")
    public String updateOneSalaryStandard(@ModelAttribute Salary s) {
    	SalaryStandard ss=s.getSs();
    	ss.setCheckStatus((short)0);
    	sss.alterSalaryStandard(ss);
    	ArrayList<SalaryStandardDetails> list=s.getList();
    	for (SalaryStandardDetails sd : list) {
			ssds.alterSalaryStandardDetails(sd);
		}
    	return "redirect:/salarystandard_change_success.jsp";
    }
}