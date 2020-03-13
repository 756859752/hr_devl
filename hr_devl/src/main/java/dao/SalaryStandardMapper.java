package dao;

import java.util.List;

import pojo.SalaryStandard;

public interface SalaryStandardMapper {
	public void insertSalaryStandard(SalaryStandard SalaryGrantDetail);

	public void deleteSalaryStandard(short id);

	public void updateSalaryStandard(SalaryStandard SalaryGrantDetail);

	public SalaryStandard selectSalaryStandardById(short id);

	public List<SalaryStandard> selectAllSalaryStandard();
}
