package service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.EngageAnswerDetailsMapper;
import pojo.EngageAnswerDetails;
import pojo.EngageExamDetails;
import service.EngageAnswerDetailsService;

@Service
public class EngageAnswerDetailsServiceImpl implements EngageAnswerDetailsService{

	@Autowired
	EngageAnswerDetailsMapper engageAnswerDetailsMapper=null;
	
	@Override
	public void addEngageAnswerDetails(EngageAnswerDetails EngageAnswerDetails) {
		// TODO Auto-generated method stub
		engageAnswerDetailsMapper.insertEngageAnswerDetails(EngageAnswerDetails);
	}

	@Override
	public void removeEngageAnswerDetails(short id) {
		// TODO Auto-generated method stub
		engageAnswerDetailsMapper.deleteEngageAnswerDetails(id);
	}

	@Override
	public void alterEngageAnswerDetails(EngageAnswerDetails EngageAnswerDetails) {
		// TODO Auto-generated method stub
		engageAnswerDetailsMapper.updateEngageAnswerDetails(EngageAnswerDetails);
	}

	@Override
	public EngageAnswerDetails findEngageAnswerDetailsById(short id) {
		// TODO Auto-generated method stub
		return engageAnswerDetailsMapper.selectEngageAnswerDetailsById(id);
	}

	@Override
	public List<EngageAnswerDetails> findAllEngageAnswerDetails() {
		// TODO Auto-generated method stub
		return engageAnswerDetailsMapper.selectAllEngageAnswerDetails();
	}

	@Override
	public List<EngageAnswerDetails> findEngageAnswerByCondition(
			String answerNumber) {
		// TODO Auto-generated method stub
		return engageAnswerDetailsMapper.selectEngageAnswerByCondition(answerNumber);
	}

	
	
}
