package dao;

import java.util.List;

import java.util.HashMap;
import pojo.SalaryStandard;

public interface SalaryStandardMapper {
	public void insertSalaryStandard(SalaryStandard SalaryGrantDetail);

	public void deleteSalaryStandard(short id);

	public void updateSalaryStandard(SalaryStandard SalaryGrantDetail);

	public SalaryStandard selectSalaryStandardById(short id);

	public List<SalaryStandard> selectAllSalaryStandard();
//	通过多条件查询出薪酬标准
	public List<SalaryStandard> seletCoditionsSalaryStandard(HashMap<String, Object> map);
//	通过状态位查询出未通过审核的薪酬标准
	public List<SalaryStandard> seletStateSalaryStandard();
	
//	根据薪酬编号查询一个薪酬标准
	public SalaryStandard selectSalaryStandardBySid(String sid);

}
