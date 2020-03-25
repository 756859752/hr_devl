package service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.HumanFileMapper;
import pojo.HumanFile;
import service.HumanFileService;

@Service
public class HumanFileServiceImpl implements HumanFileService{

	@Autowired
	HumanFileMapper humanFileMapper=null;
	
	@Override
	public void addHumanFile(HumanFile HumanFile) {
		// TODO Auto-generated method stub
		humanFileMapper.insertHumanFile(HumanFile);
	}

	@Override
	public void removeHumanFile(short id) {
		// TODO Auto-generated method stub
		humanFileMapper.deleteHumanFile(id);
	}

	@Override
	public void alterHumanFile(HumanFile HumanFile) {
		// TODO Auto-generated method stub
		humanFileMapper.updateHumanFile(HumanFile);
	}

	@Override
	public HumanFile findHumanFileById(short id) {
		// TODO Auto-generated method stub
		return humanFileMapper.selectHumanFileById(id);
	}

	@Override
	public List<HumanFile> findAllHumanFile() {
		// TODO Auto-generated method stub
		return humanFileMapper.selectAllHumanFile();
	}

	@Override
	public List<HumanFile> findHumanFileByCheckStatus(short s) {
		// TODO Auto-generated method stub
		return humanFileMapper.selectHumanFileByCheckStatus(s);
	}

	@Override
	public List<HumanFile> findByCondition(HumanFile HumanFile) {
		// TODO Auto-generated method stub
		return humanFileMapper.selectByCondition(HumanFile);
	}

	@Override
	public List<HumanFile> findHumanFileByConditions(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return humanFileMapper.selectHumanFileByConditions(map);
	}

	@Override
	public HumanFile findHumanFileByHumanId(String hid) {
		// TODO Auto-generated method stub
		return humanFileMapper.selectHumanFileByHunamId(hid);
	}

	@Override
	public List<HumanFile> findHumanFileByMechchanism(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return humanFileMapper.selectHumanFileByMechchanism(map);
	}

}
