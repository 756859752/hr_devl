package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.SalaryStandardMapper;
import pojo.SalaryStandard;
import service.SalaryStandardService;

@Service
public class SalaryStandardServiceImpl implements SalaryStandardService{
	
	@Autowired
	SalaryStandardMapper SalaryStandardMapper=null;
	
	@Override
	public void addSalaryStandard(SalaryStandard SalaryStandard) {
		// TODO Auto-generated method stub
		SalaryStandardMapper.insertSalaryStandard(SalaryStandard);
	}

	@Override
	public void removeSalaryStandard(short id) {
		// TODO Auto-generated method stub
		SalaryStandardMapper.deleteSalaryStandard(id);
	}

	@Override
	public void alterSalaryStandard(SalaryStandard SalaryStandard) {
		// TODO Auto-generated method stub
		SalaryStandardMapper.updateSalaryStandard(SalaryStandard);
	}

	@Override
	public SalaryStandard findSalaryStandardById(short id) {
		// TODO Auto-generated method stub
		return SalaryStandardMapper.selectSalaryStandardById(id);
	}

	@Override
	public List<SalaryStandard> findAllSalaryStandard() {
		// TODO Auto-generated method stub
		return SalaryStandardMapper.selectAllSalaryStandard();
	}
	
}
