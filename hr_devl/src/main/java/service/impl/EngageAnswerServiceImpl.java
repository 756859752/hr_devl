package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.EngageAnswerMapper;
import pojo.EngageAnswer;
import service.EngageAnswerService;

@Service
public class EngageAnswerServiceImpl implements EngageAnswerService{

	@Autowired
	EngageAnswerMapper engageAnswerMapper =null;
	
	@Override
	public void addEngageAnswer(EngageAnswer EngageAnswer) {
		// TODO Auto-generated method stub
		engageAnswerMapper.insertEngageAnswer(EngageAnswer);
	}

	@Override
	public void removeEngageAnswer(short id) {
		// TODO Auto-generated method stub
		engageAnswerMapper.deleteEngageAnswer(id);
	}

	@Override
	public void alterEngageAnswer(EngageAnswer EngageAnswer) {
		// TODO Auto-generated method stub
		engageAnswerMapper.updateEngageAnswer(EngageAnswer);
	}

	@Override
	public EngageAnswer findEngageAnswerById(short id) {
		// TODO Auto-generated method stub
		return engageAnswerMapper.selectEngageAnswerById(id);
	}

	@Override
	public List<EngageAnswer> findAllEngageAnswer() {
		// TODO Auto-generated method stub
		return engageAnswerMapper.selectAllEngageAnswer();
	}
	
}
