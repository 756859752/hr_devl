package service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.EngageSubjectsMapper;
import pojo.EngageSubjects;
import service.EngageSubjectsService;

@Service
public class EngageSubjectsServiceImpl implements EngageSubjectsService{

	@Autowired
	EngageSubjectsMapper engageSubjectsMapper=null;
	
	@Override
	public void addEngageSubjects(EngageSubjects EngageSubjects) {
		// TODO Auto-generated method stub
		engageSubjectsMapper.insertEngageSubjects(EngageSubjects);
	}

	@Override
	public void removeEngageSubjects(short id) {
		// TODO Auto-generated method stub
		engageSubjectsMapper.deleteEngageSubjects(id);
	}

	@Override
	public void alterEngageSubjects(EngageSubjects EngageSubjects) {
		// TODO Auto-generated method stub
		engageSubjectsMapper.updateEngageSubjects(EngageSubjects);
	}

	@Override
	public EngageSubjects findEngageSubjectsById(short id) {
		// TODO Auto-generated method stub
		return engageSubjectsMapper.selectEngageSubjectsById(id);
	}

	@Override
	public List<EngageSubjects> findAllEngageSubjects() {
		// TODO Auto-generated method stub
		return engageSubjectsMapper.selectAllEngageSubjects();
	}

	@Override
	public List<EngageSubjects> findEngageSubjectsByCondition(
			HashMap<String, String> map) {
		
		return engageSubjectsMapper.selectEngageSubjectsByCondition(map);
	}
	
}
