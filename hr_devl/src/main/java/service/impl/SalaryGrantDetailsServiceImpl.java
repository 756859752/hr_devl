package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.SalaryGrantDetailsMapper;
import pojo.SalaryGrantDetails;
import service.SalaryGrantDetailsService;

@Service
public class SalaryGrantDetailsServiceImpl implements SalaryGrantDetailsService{
	
	@Autowired
	SalaryGrantDetailsMapper SalaryGrantDetailsMapper=null;
	
	@Override
	public void addSalaryGrantDetails(SalaryGrantDetails SalaryGrantDetails) {
		// TODO Auto-generated method stub
		SalaryGrantDetailsMapper.insertSalaryGrantDetails(SalaryGrantDetails);
	}

	@Override
	public void removeSalaryGrantDetails(short id) {
		// TODO Auto-generated method stub
		SalaryGrantDetailsMapper.deleteSalaryGrantDetails(id);
	}

	@Override
	public void alterSalaryGrantDetails(SalaryGrantDetails SalaryGrantDetails) {
		// TODO Auto-generated method stub
		SalaryGrantDetailsMapper.updateSalaryGrantDetails(SalaryGrantDetails);
	}

	@Override
	public SalaryGrantDetails findSalaryGrantDetailsById(short id) {
		// TODO Auto-generated method stub
		return SalaryGrantDetailsMapper.selectSalaryGrantDetailsById(id);
	}

	@Override
	public List<SalaryGrantDetails> findAllSalaryGrantDetails() {
		// TODO Auto-generated method stub
		return SalaryGrantDetailsMapper.selectAllSalaryGrantDetails();
	}
//	根据薪酬发放编号查询
	@Override
	public List<SalaryGrantDetails> findSalaryGrandDetailsBySsid(String ssid) {
		return SalaryGrantDetailsMapper.selectSalaryGrandDetailsBySsid(ssid);
	}
	
}
