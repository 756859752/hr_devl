package service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.EngageExamMapper;
import pojo.EngageExam;
import service.EngageExamService;

@Service
public class EngageExamServiceImpl implements EngageExamService{

	@Autowired
	EngageExamMapper engageExamMapper=null;
	
	@Override
	public void addEngageExam(EngageExam EngageExam) {
		// TODO Auto-generated method stub
		engageExamMapper.insertEngageExam(EngageExam);
	}

	@Override
	public void removeEngageExam(short id) {
		// TODO Auto-generated method stub
		engageExamMapper.deleteEngageExam(id);
	}

	@Override
	public void alterEngageExam(EngageExam EngageExam) {
		// TODO Auto-generated method stub
		engageExamMapper.updateEngageExam(EngageExam);
	}

	@Override
	public EngageExam findEngageExamById(short id) {
		// TODO Auto-generated method stub
		return engageExamMapper.selectEngageExamById(id);
	}

	@Override
	public List<EngageExam> findAllEngageExam() {
		// TODO Auto-generated method stub
		return engageExamMapper.selectAllEngageExam();
	}

	@Override
	public List<EngageExam> findEngageGroupAndCount() {
		// TODO Auto-generated method stub
		return engageExamMapper.selectEngageGroupAndCount();
	}

	@Override
	public List<EngageExam> findEngageExamByCondition(HashMap<String, String> hashmap) {
		// TODO Auto-generated method stub
		return engageExamMapper.selectEngageExamByCondition(hashmap);
	}
	
}
