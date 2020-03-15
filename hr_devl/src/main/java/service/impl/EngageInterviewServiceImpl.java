package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.EngageInterviewMapper;
import pojo.EngageInterview;
import service.EngageInterviewService;

@Service
public class EngageInterviewServiceImpl implements EngageInterviewService{

	@Autowired
	EngageInterviewMapper engageInterviewMapper=null;
	
	@Override
	public void addEngageInterview(EngageInterview EngageInterview) {
		// TODO Auto-generated method stub
		engageInterviewMapper.insertEngageInterview(EngageInterview);
	}

	@Override
	public void removeEngageInterview(short id) {
		// TODO Auto-generated method stub
		engageInterviewMapper.deleteEngageInterview(id);
	}

	@Override
	public void alterEngageInterview(EngageInterview EngageInterview) {
		// TODO Auto-generated method stub
		engageInterviewMapper.updateEngageInterview(EngageInterview);
	}

	@Override
	public EngageInterview findEngageInterviewById(short id) {
		// TODO Auto-generated method stub
		return engageInterviewMapper.selectEngageInterviewById(id);
	}

	@Override
	public List<EngageInterview> findAllEngageInterview() {
		// TODO Auto-generated method stub
		return engageInterviewMapper.selectAllEngageInterview();
	}

	@Override
	public EngageInterview findEngageInterviewByIdWithResume(short id) {
		// TODO Auto-generated method stub
		return engageInterviewMapper.selectEngageInterviewByIdWithResume(id);
	}

	

}
