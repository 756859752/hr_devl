package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ConfigFileSecondKindMapper;
import pojo.ConfigFileFirstKind;
import pojo.ConfigFileSecondKind;

import service.ConfigFileSecondKindService;

@Service
public class ConfigFileSecondKindServiceImpl implements ConfigFileSecondKindService {

	@Autowired
	ConfigFileSecondKindMapper configFileSecondKindMapper = null;

	@Override
	public void addConfigFileSecondKind(ConfigFileSecondKind ConfigFileSecondKind) {
		// TODO Auto-generated method stub
		configFileSecondKindMapper.insertConfigFileSecondKind(ConfigFileSecondKind);
	}

	@Override
	public void removeConfigFileSecondKind(short id) {
		// TODO Auto-generated method stub
		configFileSecondKindMapper.deleteConfigFileSecondKind(id);
	}

	@Override
	public void alterConfigFileSecondKind(ConfigFileSecondKind ConfigFileSecondKind) {
		// TODO Auto-generated method stub
		configFileSecondKindMapper.updateConfigFileSecondKind(ConfigFileSecondKind);
	}

	@Override
	public ConfigFileSecondKind findConfigFileSecondKindById(short id) {
		// TODO Auto-generated method stub
		return configFileSecondKindMapper.selectConfigFileSecondKindById(id);
	}

	@Override
	public List<ConfigFileSecondKind> findAllConfigFileSecondKind() {
		// TODO Auto-generated method stub
		return configFileSecondKindMapper.selectAllConfigFileSecondKind();
	}

	@Override
	public void removeConfigFileSecondKindByfirstkindid(String firstkinfid) {
		// TODO Auto-generated method stub
		configFileSecondKindMapper.deleteConfigFileSecondKindByfirstkindid(firstkinfid);
	}

	@Override
	public void alterConfigFileSecondKindBycffk(ConfigFileFirstKind ff) {
		// TODO Auto-generated method stub
		configFileSecondKindMapper.updateConfigFileSecondKindBycffk(ff);
	}

	@Override
	public List<ConfigFileSecondKind> findAllConfigFileSecondKindByfisrtKindId(String firstKindId) {
		// TODO Auto-generated method stub
		return configFileSecondKindMapper.selectAllConfigFileSecondKindByfisrtKindId(firstKindId);
	}
	
}
