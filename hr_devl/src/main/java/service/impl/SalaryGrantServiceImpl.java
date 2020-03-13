package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.SalaryGrantMapper;
import pojo.SalaryGrant;
import service.SalaryGrantService;

@Service
public class SalaryGrantServiceImpl implements SalaryGrantService{
	
	@Autowired
	SalaryGrantMapper SalaryGrantMapper=null;
	
	@Override
	public void addSalaryGrant(SalaryGrant SalaryGrant) {
		// TODO Auto-generated method stub
		SalaryGrantMapper.insertSalaryGrant(SalaryGrant);
	}

	@Override
	public void removeSalaryGrant(short id) {
		// TODO Auto-generated method stub
		SalaryGrantMapper.deleteSalaryGrant(id);
	}

	@Override
	public void alterSalaryGrant(SalaryGrant SalaryGrant) {
		// TODO Auto-generated method stub
		SalaryGrantMapper.updateSalaryGrant(SalaryGrant);
	}

	@Override
	public SalaryGrant findSalaryGrantById(short id) {
		// TODO Auto-generated method stub
		return SalaryGrantMapper.selectSalaryGrantById(id);
	}

	@Override
	public List<SalaryGrant> findAllSalaryGrant() {
		// TODO Auto-generated method stub
		return SalaryGrantMapper.selectAllSalaryGrant();
	}
	
}
