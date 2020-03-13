package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.EngageExamDetailsMapper;
import pojo.EngageExamDetails;
import service.EngageExamDetailsService;

@Service
public class EngageExamDetailsServiceImpl implements EngageExamDetailsService{

	@Autowired
	EngageExamDetailsMapper engageExamDetailsMapper=null;
	
	
	@Override
	public void addEngageExamDetails(EngageExamDetails EngageExamDetails) {
		// TODO Auto-generated method stub
		engageExamDetailsMapper.insertEngageExamDetails(EngageExamDetails);
	}

	@Override
	public void removeEngageExamDetails(short id) {
		// TODO Auto-generated method stub
		engageExamDetailsMapper.deleteEngageExamDetails(id);
	}

	@Override
	public void alterEngageExamDetails(EngageExamDetails EngageExamDetails) {
		// TODO Auto-generated method stub
		engageExamDetailsMapper.updateEngageExamDetails(EngageExamDetails);
	}

	@Override
	public EngageExamDetails findEngageExamDetailsById(short id) {
		// TODO Auto-generated method stub
		return engageExamDetailsMapper.selectEngageExamDetailsById(id);
	}

	@Override
	public List<EngageExamDetails> findAllEngageExamDetails() {
		// TODO Auto-generated method stub
		return engageExamDetailsMapper.selectAllEngageExamDetails();
	}
	
}
