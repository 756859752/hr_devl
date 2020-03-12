package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pojo.ConfigFileFirstKind;
import dao.ConfigFileFirstKindMapper;
import service.ConfigFileFirstKindService;

@Service
public class ConfigFileFirstKindServiceImpl implements ConfigFileFirstKindService{

	@Autowired
	ConfigFileFirstKindMapper configFileFirstKindMapper=null;
	
	

	@Override
	public void removeConfigFileFirstKind(short id) {
		// TODO Auto-generated method stub
		configFileFirstKindMapper.deleteConfigFileFirstKind(id);
	}

	@Override
	public void alterConfigPublicChar(
			pojo.ConfigFileFirstKind ConfigFileFirstKind) {
		// TODO Auto-generated method stub
		configFileFirstKindMapper.updateConfigFileFirstKind(ConfigFileFirstKind);
	}

	@Override
	public pojo.ConfigFileFirstKind findConfigFileFirstKindById(short id) {
		// TODO Auto-generated method stub
		return configFileFirstKindMapper.selectConfigFileFirstKindById(id);
	}

	@Override
	public List<pojo.ConfigFileFirstKind> findAllConfigFileFirstKind() {
		// TODO Auto-generated method stub
		return configFileFirstKindMapper.selectAllConfigFileFirstKind();
	}

	@Override
	public void addConfigFileFirstKind(ConfigFileFirstKind ConfigFileFirstKind) {
		// TODO Auto-generated method stub
		configFileFirstKindMapper.insertConfigFileFirstKind(ConfigFileFirstKind);
	}
	
}
