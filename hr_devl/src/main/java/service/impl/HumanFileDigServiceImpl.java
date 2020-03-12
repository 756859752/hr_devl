package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.HumanFileDigMapper;
import pojo.HumanFileDig;
import service.HumanFileDigService;

@Service
public class HumanFileDigServiceImpl implements  HumanFileDigService{
	@Autowired 
	HumanFileDigMapper humanFileDigMapper=null;
	 
	
	@Override
	public void addHumanFileDig(HumanFileDig HumanFileDig) {
		// TODO Auto-generated method stub
		humanFileDigMapper.insertHumanFileDig(HumanFileDig);
	}

	@Override
	public void removeHumanFileDig(short id) {
		// TODO Auto-generated method stub
		humanFileDigMapper.deleteHumanFileDig(id);
	}

	@Override
	public void alterHumanFileDig(HumanFileDig HumanFileDig) {
		// TODO Auto-generated method stub
		humanFileDigMapper.updateHumanFileDig(HumanFileDig);
	}

	@Override
	public HumanFileDig findHumanFileDigById(short id) {
		// TODO Auto-generated method stub
		return humanFileDigMapper.selectHumanFileDigById(id);
	}

	@Override
	public List<HumanFileDig> findAllHumanFileDig() {
		// TODO Auto-generated method stub
		return humanFileDigMapper.selectAllHumanFileDig();
	}

}
