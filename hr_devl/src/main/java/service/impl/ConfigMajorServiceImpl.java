package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import dao.ConfigMajorMapper;
import pojo.ConfigMajor;
import service.ConfigMajorService;



@Service
public class ConfigMajorServiceImpl implements ConfigMajorService {

	@Autowired
	ConfigMajorMapper configMajorMapper = null;

	@Override
	public void addConfigMajor(ConfigMajor ConfigMajor) {
		// TODO Auto-generated method stub
		configMajorMapper.insertConfigMajor(ConfigMajor);
	}

	@Override
	public void removeConfigMajor(short id) {
		// TODO Auto-generated method stub
		configMajorMapper.deleteConfigMajor(id);
	}

	@Override
	public void alterConfigMajor(ConfigMajor ConfigMajor) {
		// TODO Auto-generated method stub
		configMajorMapper.updateConfigMajor(ConfigMajor);
	}

	@Override
	public ConfigMajor findConfigMajorById(short id) {
		// TODO Auto-generated method stub
		return configMajorMapper.selectConfigMajorById(id);
	}

	@Override
	public List<ConfigMajor> findAllConfigMajor() {
		// TODO Auto-generated method stub
		return configMajorMapper.selectAllConfigMajor();
	}

	@Override
	public List<ConfigMajor> findConfigMajorByMajorKindId(String kid) {
		
		return configMajorMapper.selectConfigMajorsByMajorKindid(kid);
	}

	
}
