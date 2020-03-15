package service;

import java.util.HashMap;
import java.util.List;

import pojo.SalaryStandard;

public interface SalaryStandardService{
	public void addSalaryStandard(SalaryStandard SalaryStandardDetail);
	public void removeSalaryStandard(short id);
	public void alterSalaryStandard(SalaryStandard SalaryStandardDetail);
	public SalaryStandard findSalaryStandardById(short id);
	public List<SalaryStandard> findAllSalaryStandard();
	public List<SalaryStandard> findCoditionsSalaryStandard(HashMap<String, Object> map);
//	查询问通过审核的薪酬标准
	public List<SalaryStandard> findStateSalaryStandards();
}
