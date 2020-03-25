package web.controller.dcf.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

import pojo.SalaryGrantDetails;

public class Info implements Serializable{
	private String checker;
	private Timestamp checkTime;
	
	private ArrayList<SalaryGrantDetails> grantDetails;
	
	public String getChecker() {
		return checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
	}

	public Timestamp getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Timestamp checkTime) {
		this.checkTime = checkTime;
	}


	public ArrayList<SalaryGrantDetails> getGrantDetails() {
		return grantDetails;
	}

	public void setGrantDetails(ArrayList<SalaryGrantDetails> grantDetails) {
		this.grantDetails = grantDetails;
	}
}
