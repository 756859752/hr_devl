package web.controller.dcf;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.ConfigMajorKind;
import pojo.HumanFile;
import pojo.MajorChange;
import service.ConfigFileFirstKindService;
import service.ConfigFileSecondKindService;
import service.ConfigFileThirdKindService;
import service.ConfigMajorKindService;
import service.ConfigMajorService;
import service.HumanFileService;
import web.controller.dcf.dto.ChooseConditionsDto;

@Controller
@RequestMapping("dcf/transfer")
public class TransferController {
	@Autowired
	private ConfigFileFirstKindService  firstkind=null;
	@Autowired
	private ConfigFileSecondKindService  secondkind=null;
	@Autowired
	private ConfigFileThirdKindService  thirdkind=null;
	@Autowired
	private ConfigMajorKindService  majorkind=null;
	@Autowired
	private ConfigMajorService  major=null;
	@Autowired
	private HumanFileService humanfile=null;
	
//	插入人员调动信息
	@RequestMapping("/addtransferinfo.do")
	public String addTransferInfo(@ModelAttribute MajorChange second){
		
		return null;
	}
	
		
//	展示查询条件
	@RequestMapping("/choseConditions.do")
	@ResponseBody
	public ChooseConditionsDto queryChoseConditions(){
		ChooseConditionsDto ccd=new ChooseConditionsDto();
		ccd.setFirst(firstkind.findAllConfigFileFirstKind());
		ccd.setSecond(secondkind.findAllConfigFileSecondKind());
		ccd.setThird(thirdkind.findAllConfigFileThirdKind());
		ccd.setMajorkind(majorkind.findAllConfigMajorKind());
		ccd.setMajor(major.findAllConfigMajor());
		System.out.println("得到所有要展示的信息");
		return ccd;
	}
//	机构联动查询
	@RequestMapping("/queryConditions.do")
	@ResponseBody
	public ChooseConditionsDto queryConditions(@RequestParam String firstkindid,@RequestParam String secondkindid){
		ChooseConditionsDto ccd=new ChooseConditionsDto();
//		根据不同条件查询不同集合
//		第一个参数有值三级分类
		if(firstkindid!=""&&!firstkindid.equals(0)) {
			ccd.setSecond(secondkind.findAllConfigFileSecondKindByfisrtKindId(firstkindid));
//			第二个参数有值三级分类
		}else if(secondkindid!=""&&!secondkindid.equals(0)) {
			ccd.setThird(thirdkind.findConfigFileThirdKindBySecondKindId(secondkindid));
		}else {
//			参数没值查一级分类
			ccd.setFirst(firstkind.findAllConfigFileFirstKind());
		}
		return ccd;
	}
	
//	查询所有要调动的人员信息,多条件查询
	@RequestMapping("/querytransferpeoples.do")
	public String queryTransferPeoples(@RequestParam String firstkindid,@RequestParam String secondkindid,
			@RequestParam String thirdkindid,@RequestParam String starttime,@RequestParam String endtime,HttpSession session){
		HashMap<String, Object> map=new HashMap<String, Object>();
		if(!firstkindid.equals("0")) {
			map.put("firstkindid", firstkindid);
		}
		if(!secondkindid.equals("0")) {
			map.put("secondkindid", secondkindid);
		}
		if(!thirdkindid.equals("0")) {
			map.put("thirdkindid", thirdkindid);
		}	
		if(starttime!=""&&endtime!="") {
			System.out.println("查询时间");
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
		System.out.println("查询集合");
		List<HumanFile> humanlits=humanfile.findHumanFileByConditions(map);
//		model.addAttribute("list", humanlits);
		session.setAttribute("list", humanlits);
		return "forward:/dcf_Transfer/register_list.jsp";
	}
//	查询所有的职位跟职位分类
	
//	得到要调动的人员资料
	@RequestMapping("/querytransferonepeople/{pid}.do")
	public String queryOnePeopleInfo(@PathVariable String pid,Model model) {
//		查询原来机构
		HumanFile hf=humanfile.findHumanFileById(Short.decode(pid));
//查询所有职位分类
		List<ConfigMajorKind> majorkinds=majorkind.findAllConfigMajorKind();
		model.addAttribute("humanfile", hf);
		model.addAttribute("majorkinds", majorkinds);
		 System.out.println("把id传出"+Short.decode(pid)+"=="+hf.getHumanName());
		return "forward:/dcf_Transfer/register.jsp";
	}

	
	

}
