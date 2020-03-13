package service;

import java.util.List;

import pojo.SalaryStandard;

public interface SalaryStandardService{
	public void addSalaryStandard(SalaryStandard SalaryStandardDetail);
	public void removeSalaryStandard(short id);
	public void alterSalaryStandard(SalaryStandard SalaryStandardDetail);
	public SalaryStandard findSalaryStandardById(short id);
	public List<SalaryStandard> findAllSalaryStandard();
}
