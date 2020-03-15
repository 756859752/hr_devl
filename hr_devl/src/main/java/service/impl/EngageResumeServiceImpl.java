package service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.EngageResumeMapper;
import pojo.EngageResume;
import service.EngageResumeService;

@Service
public class EngageResumeServiceImpl implements EngageResumeService{

	@Autowired
	EngageResumeMapper engageResumeMapper=null;
	
	@Override
	public void addEngageResume(EngageResume EngageResume) {
		// TODO Auto-generated method stub
		engageResumeMapper.insertEngageResume(EngageResume);
	}

	@Override
	public void removeEngageResume(short id) {
		// TODO Auto-generated method stub
		engageResumeMapper.deleteEngageResume(id);
	}

	@Override
	public void alterEngageResume(EngageResume EngageResume) {
		// TODO Auto-generated method stub
		engageResumeMapper.updateEngageResume(EngageResume);
	}

	@Override
	public EngageResume findEngageResumeById(short id) {
		// TODO Auto-generated method stub
		return engageResumeMapper.selectEngageResumeById(id);
	}

	@Override
	public List<EngageResume> findAllEngageResume() {
		// TODO Auto-generated method stub
		return engageResumeMapper.selectAllEngageResume();
	}

	@Override
	public List<EngageResume> findAllEngageResumeByConditon(
			HashMap<String, String> hashmap) {
		// TODO Auto-generated method stub
		return engageResumeMapper.selectAllEngageResumeByConditon(hashmap);
	}
	
}
