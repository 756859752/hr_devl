package web.controller.dcf.dto;

import java.io.Serializable;
import java.util.ArrayList;

import pojo.SalaryStandard;
import pojo.SalaryStandardDetails;

public class Salary implements Serializable{
   private SalaryStandard ss;
   private ArrayList<SalaryStandardDetails> list;
	public SalaryStandard getSs() {
		return ss;
	}
	public void setSs(SalaryStandard ss) {
		this.ss = ss;
	}
	public ArrayList<SalaryStandardDetails> getList() {
		return list;
	}
	public void setList(ArrayList<SalaryStandardDetails> list) {
		this.list = list;
	}
   
}
