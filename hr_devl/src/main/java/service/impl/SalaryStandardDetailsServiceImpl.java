package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.SalaryStandardDetailsMapper;
import pojo.SalaryStandardDetails;
import service.SalaryStandardDetailsService;

@Service
public class SalaryStandardDetailsServiceImpl implements SalaryStandardDetailsService{
	
	@Autowired
	SalaryStandardDetailsMapper SalaryStandardDetailsMapper=null;
	
	@Override
	public void addSalaryStandardDetails(SalaryStandardDetails SalaryStandardDetails) {
		// TODO Auto-generated method stub
		SalaryStandardDetailsMapper.insertSalaryStandardDetails(SalaryStandardDetails);
	}

	@Override
	public void removeSalaryStandardDetails(short id) {
		// TODO Auto-generated method stub
		SalaryStandardDetailsMapper.deleteSalaryStandardDetails(id);
	}

	@Override
	public void alterSalaryStandardDetails(SalaryStandardDetails SalaryStandardDetails) {
		// TODO Auto-generated method stub
		SalaryStandardDetailsMapper.updateSalaryStandardDetails(SalaryStandardDetails);
	}

	@Override
	public SalaryStandardDetails findSalaryStandardDetailsById(short id) {
		// TODO Auto-generated method stub
		return SalaryStandardDetailsMapper.selectSalaryStandardDetailsById(id);
	}

	@Override
	public List<SalaryStandardDetails> findAllSalaryStandardDetails() {
		// TODO Auto-generated method stub
		return SalaryStandardDetailsMapper.selectAllSalaryStandardDetails();
	}
//	根据薪酬标准编号查询
	@Override
	public ArrayList<SalaryStandardDetails> findManySalaryStandardDetails(String sid) {
		
		return SalaryStandardDetailsMapper.selectSalaryStandardDetailsBySsid(sid);
	}
	
}
