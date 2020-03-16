package service;

import java.util.List;

import pojo.SalaryGrantDetails;

public interface SalaryGrantDetailsService{
	public void addSalaryGrantDetails(SalaryGrantDetails SalaryGrantDetail);
	public void removeSalaryGrantDetails(short id);
	public void alterSalaryGrantDetails(SalaryGrantDetails SalaryGrantDetail);
	public SalaryGrantDetails findSalaryGrantDetailsById(short id);
	public List<SalaryGrantDetails> findAllSalaryGrantDetails();
//	根据薪酬发放编号查询
	public List<SalaryGrantDetails> findSalaryGrandDetailsBySsid(String ssid);
}
