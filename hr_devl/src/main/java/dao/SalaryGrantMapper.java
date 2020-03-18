package dao;

import java.util.HashMap;
import java.util.List;

import pojo.SalaryGrant;

public interface SalaryGrantMapper {
	public void insertSalaryGrant(SalaryGrant SalaryGrant);

	public void deleteSalaryGrant(short id);

	public void updateSalaryGrant(SalaryGrant SalaryGrant);

	public SalaryGrant selectSalaryGrantById(short id);

	public List<SalaryGrant> selectAllSalaryGrant();
//	根据薪酬发放id查询一个对象
	public SalaryGrant selectSalaryGrantBySid(String sid);
//	多条件查询薪酬发放
	public List<SalaryGrant> selectSalaryGrantsCoditions(HashMap<String, Object> map);
}
