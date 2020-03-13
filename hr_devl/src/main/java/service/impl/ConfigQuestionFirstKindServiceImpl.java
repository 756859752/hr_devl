package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import dao.ConfigQuestionFirstKindMapper;
import pojo.ConfigQuestionFirstKind;
import service.ConfigQuestionFirstKindService;



@Service
public class ConfigQuestionFirstKindServiceImpl implements ConfigQuestionFirstKindService {

	@Autowired
	ConfigQuestionFirstKindMapper configQuestionFirstKindMapper = null;

	@Override
	public void addConfigQuestionFirstKind(ConfigQuestionFirstKind ConfigQuestionFirstKind) {
		// TODO Auto-generated method stub
		configQuestionFirstKindMapper.insertConfigQuestionFirstKind(ConfigQuestionFirstKind);
	}

	@Override
	public void removeConfigQuestionFirstKind(short id) {
		// TODO Auto-generated method stub
		configQuestionFirstKindMapper.deleteConfigQuestionFirstKind(id);
	}

	@Override
	public void alterConfigQuestionFirstKind(ConfigQuestionFirstKind ConfigQuestionFirstKind) {
		// TODO Auto-generated method stub
		configQuestionFirstKindMapper.updateConfigQuestionFirstKind(ConfigQuestionFirstKind);
	}

	@Override
	public ConfigQuestionFirstKind ConfigQuestionFirstKindById(short id) {
		// TODO Auto-generated method stub
		return configQuestionFirstKindMapper.selectConfigQuestionFirstKindById(id);
	}

	@Override
	public List<ConfigQuestionFirstKind> findAllConfigQuestionFirstKind() {
		// TODO Auto-generated method stub
		return configQuestionFirstKindMapper.selectAllConfigQuestionFirstKind();
	}


	
}
