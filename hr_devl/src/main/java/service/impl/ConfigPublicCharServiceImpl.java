package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import dao.ConfigPublicCharMapper;

import pojo.ConfigPublicChar;

import service.ConfigPublicCharService;

@Service
public class ConfigPublicCharServiceImpl implements ConfigPublicCharService {

	@Autowired
	ConfigPublicCharMapper configPublicCharMapper = null;

	@Override
	public void addConfigPublicChar(ConfigPublicChar ConfigPublicChar) {
		// TODO Auto-generated method stub
		configPublicCharMapper.insertConfigPublicChar(ConfigPublicChar);
	}

	@Override
	public void removeConfigPublicChar(int id) {
		// TODO Auto-generated method stub
		configPublicCharMapper.deleteConfigPublicChar(id);
	}

	@Override
	public void alterConfigPublicChar(ConfigPublicChar ConfigPublicChar) {
		// TODO Auto-generated method stub
		configPublicCharMapper.updateConfigPublicChar(ConfigPublicChar);
	}

	@Override
	public ConfigPublicChar findConfigPublicCharById(int id) {
		// TODO Auto-generated method stub
		return configPublicCharMapper.selectConfigPublicCharById(id);
	}

	@Override
	public List<ConfigPublicChar> findAllConfigPublicChar() {
		// TODO Auto-generated method stub
		return configPublicCharMapper.selectAllConfigPublicChar();
	}

	@Override
	public List<ConfigPublicChar> findAllConfigPublicCharByCondition(
			ConfigPublicChar ConfigPublicChar) {
		// TODO Auto-generated method stub
		return configPublicCharMapper.selecAllConfigPublicCharByCondition(ConfigPublicChar);
	}

	@Override
	public List<ConfigPublicChar> findselectConfigPublicCharByattributeKind(String attributeKind) {
		// TODO Auto-generated method stub
		return configPublicCharMapper.selectConfigPublicCharByattributeKind(attributeKind);
	}

	
}
