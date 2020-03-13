package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ConfigMajorKindMapper;
import pojo.ConfigMajorKind;
import service.ConfigMajorKindService;




@Service
public class ConfigMajorKindServiceImpl implements ConfigMajorKindService {

	@Autowired
	ConfigMajorKindMapper configMajorKindMapper = null;

	@Override
	public void addConfigMajorKind(ConfigMajorKind ConfigMajorKind) {
		// TODO Auto-generated method stub
		configMajorKindMapper.insertConfigMajorKind(ConfigMajorKind);
	}

	@Override
	public void removeConfigMajorKindKind(short id) {
		// TODO Auto-generated method stub
		configMajorKindMapper.deleteConfigMajorKind(id);
	}

	@Override
	public void alterConfigMajorKindKind(ConfigMajorKind ConfigMajorKind) {
		// TODO Auto-generated method stub
		configMajorKindMapper.updateConfigMajorKind(ConfigMajorKind);
	}

	@Override
	public ConfigMajorKind findConfigMajorKindById(short id) {
		// TODO Auto-generated method stub
		return configMajorKindMapper.selectConfigMajorKindById(id);
	}

	@Override
	public List<ConfigMajorKind> findAllConfigMajorKind() {
		// TODO Auto-generated method stub
		return configMajorKindMapper.selectAllConfigMajorKind();
	}


	
}
