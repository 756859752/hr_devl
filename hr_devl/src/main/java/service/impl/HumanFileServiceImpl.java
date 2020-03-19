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
// 多条件选择人事档案
	@Override
	public List<HumanFile> findHumanFileByConditions(HashMap<String, Object> map) {	
		return  humanFileMapper.selectHumanFileByConditions(map);
	}

}
