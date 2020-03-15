package dao;

import java.util.ArrayList;
import java.util.List;

import pojo.SalaryStandardDetails;

public interface SalaryStandardDetailsMapper {
	public void insertSalaryStandardDetails(SalaryStandardDetails SalaryGrantDetail);

	public void deleteSalaryStandardDetails(short id);

	public void updateSalaryStandardDetails(SalaryStandardDetails SalaryGrantDetail);

	public SalaryStandardDetails selectSalaryStandardDetailsById(short id);

	public List<SalaryStandardDetails> selectAllSalaryStandardDetails();
//	根据薪酬标准编号查询
	public ArrayList<SalaryStandardDetails> selectSalaryStandardDetailsBySsid(String sid);
}
