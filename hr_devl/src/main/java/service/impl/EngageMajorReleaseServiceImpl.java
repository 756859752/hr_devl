package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.EngageMajorReleaseMapper;
import pojo.EngageMajorRelease;
import service.EngageMajorReleaseService;

@Service
public class EngageMajorReleaseServiceImpl implements EngageMajorReleaseService{

	@Autowired
	EngageMajorReleaseMapper engageMajorReleaseMapper=null;
	
	@Override
	public void addEngageMajorRelease(EngageMajorRelease EngageMajorRelease) {
		// TODO Auto-generated method stub
		engageMajorReleaseMapper.insertEngageMajorRelease(EngageMajorRelease);
	}

	@Override
	public void removeEngageMajorRelease(short id) {
		// TODO Auto-generated method stub
		engageMajorReleaseMapper.deleteEngageMajorRelease(id);
	}

	@Override
	public void alterEngageMajorRelease(EngageMajorRelease EngageMajorRelease) {
		// TODO Auto-generated method stub
		engageMajorReleaseMapper.updateEngageMajorRelease(EngageMajorRelease);
	}

	@Override
	public EngageMajorRelease findEngageMajorReleaseById(short id) {
		// TODO Auto-generated method stub
		return engageMajorReleaseMapper.selectEngageMajorReleaseById(id);
	}

	@Override
	public List<EngageMajorRelease> findAllEngageMajorRelease() {
		// TODO Auto-generated method stub
		return engageMajorReleaseMapper.selectAllEngageMajorRelease();
	}
	
}
