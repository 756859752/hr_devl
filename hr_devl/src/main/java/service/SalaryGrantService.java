package service;

import java.util.List;

import pojo.SalaryGrant;

public interface SalaryGrantService{
	public void addSalaryGrant(SalaryGrant SalaryGrantDetail);
	public void removeSalaryGrant(short id);
	public void alterSalaryGrant(SalaryGrant SalaryGrantDetail);
	public SalaryGrant findSalaryGrantById(short id);
	public List<SalaryGrant> findAllSalaryGrant();
//	根据薪酬发放id查询一个对象
	public SalaryGrant findSalaryGrantBySid(String sid);
}
