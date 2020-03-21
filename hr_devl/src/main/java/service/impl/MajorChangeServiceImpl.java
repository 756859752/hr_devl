package service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MajorChangeMapper;
import pojo.MajorChange;
import service.MajorChangeService;

@Service
public class MajorChangeServiceImpl implements MajorChangeService{
	
	@Autowired
	MajorChangeMapper MajorChangeMapper=null;
	
	@Override
	public void addMajorChange(MajorChange MajorChange) {
		// TODO Auto-generated method stub
		MajorChangeMapper.insertMajorChange(MajorChange);
	}

	@Override
	public void removeMajorChange(short id) {
		// TODO Auto-generated method stub
		MajorChangeMapper.deleteMajorChange(id);
	}

	@Override
	public void alterMajorChange(MajorChange MajorChange) {
		// TODO Auto-generated method stub
		MajorChangeMapper.updateMajorChange(MajorChange);
	}

	@Override
	public MajorChange findMajorChangeById(short id) {
		// TODO Auto-generated method stub
		return MajorChangeMapper.selectMajorChangeById(id);
	}

	@Override
	public List<MajorChange> findAllMajorChange() {
		// TODO Auto-generated method stub
		return MajorChangeMapper.selectAllMajorChange();
	}

	@Override
	public List<MajorChange> findAllMajorChangeByCheckStatus() {
		// TODO Auto-generated method stub
		return MajorChangeMapper.selectAllMajorChangeByCheckStatus();
	}

	@Override
	public List<MajorChange> findMajorChangeByConditions(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return MajorChangeMapper.selectMajorChangeCoditions(map);
	}
	
}
