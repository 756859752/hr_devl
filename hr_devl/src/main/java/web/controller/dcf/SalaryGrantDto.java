package web.controller.dcf;

import java.io.Serializable;
import java.util.List;

import pojo.SalaryGrantDetails;
import pojo.SalaryStandardDetails;

public class SalaryGrantDto implements Serializable{
     private SalaryGrantDetails sgd;
     private List<SalaryStandardDetails> list;
	public SalaryGrantDetails getSgd() {
		return sgd;
	}
	public void setSgd(SalaryGrantDetails sgd) {
		this.sgd = sgd;
	}
	public List<SalaryStandardDetails> getList() {
		return list;
	}
	public void setList(List<SalaryStandardDetails> list) {
		this.list = list;
	}
     
}
