package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import dao.ConfigQuestionSecondKindMapper;
import pojo.ConfigQuestionSecondKind;
import service.ConfigQuestionSecondKindService;





@Service
public class ConfigQuestionSecondKindServiceImpl implements ConfigQuestionSecondKindService {

	@Autowired
	ConfigQuestionSecondKindMapper configQuestionSecondKindMapper = null;

	@Override
	public void addConfigQuestionSecondKind(ConfigQuestionSecondKind ConfigQuestionSecondKind) {
		// TODO Auto-generated method stub
		configQuestionSecondKindMapper.insertConfigQuestionSecondKind(ConfigQuestionSecondKind);
	}

	@Override
	public void removeConfigQuestionSecondKind(short id) {
		// TODO Auto-generated method stub
		configQuestionSecondKindMapper.deleteConfigQuestionSecondKind(id);
	}

	@Override
	public void alterConfigQuestionSecondKind(ConfigQuestionSecondKind ConfigQuestionSecondKind) {
		// TODO Auto-generated method stub
		configQuestionSecondKindMapper.updateConfigQuestionSecondKind(ConfigQuestionSecondKind);
	}

	@Override
	public ConfigQuestionSecondKind ConfigQuestionSecondKindById(short id) {
		// TODO Auto-generated method stub
		return configQuestionSecondKindMapper.selectConfigQuestionSecondKindById(id);
	}

	@Override
	public List<ConfigQuestionSecondKind> findAllConfigQuestionSecondKind() {
		// TODO Auto-generated method stub
		return configQuestionSecondKindMapper.selectAllConfigQuestionSecondKind();
	}

	
	
}
