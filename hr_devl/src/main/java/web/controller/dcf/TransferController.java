package web.controller.dcf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.MajorChange;
import service.ConfigFileFirstKindService;
import service.ConfigFileSecondKindService;
import service.ConfigFileThirdKindService;
import service.ConfigMajorKindService;
import service.ConfigMajorService;
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
	
//	插入人员调动信息
	@RequestMapping("/addtransferinfo.do")
	public String addTransferInfo(@ModelAttribute MajorChange mc){
		
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

}
