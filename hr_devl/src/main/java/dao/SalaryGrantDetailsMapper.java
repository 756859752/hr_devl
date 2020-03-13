package dao;

import java.util.List;

import pojo.SalaryGrantDetails;

public interface SalaryGrantDetailsMapper {
	public void insertSalaryGrantDetails(SalaryGrantDetails SalaryGrantDetail);

	public void deleteSalaryGrantDetails(short id);

	public void updateSalaryGrantDetails(SalaryGrantDetails SalaryGrantDetail);

	public SalaryGrantDetails selectSalaryGrantDetailsById(short id);

	public List<SalaryGrantDetails> selectAllSalaryGrantDetails();
}
