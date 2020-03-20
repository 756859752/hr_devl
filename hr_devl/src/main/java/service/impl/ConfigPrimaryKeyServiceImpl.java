package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import dao.ConfigPrimaryKeyMapper;
import pojo.ConfigPrimaryKey;
import service.ConfigPrimaryKeyService;


@Service
public class ConfigPrimaryKeyServiceImpl implements ConfigPrimaryKeyService {

	@Autowired
	ConfigPrimaryKeyMapper configPrimaryKeyMapper = null;

	@Override
	public void addConfigPrimaryKey(ConfigPrimaryKey ConfigPrimaryKey) {
		// TODO Auto-generated method stub
		configPrimaryKeyMapper.insertConfigPrimaryKey(ConfigPrimaryKey);
	}

	@Override
	public void removeConfigPrimaryKey(short id) {
		// TODO Auto-generated method stub
		configPrimaryKeyMapper.deleteConfigPrimaryKey(id);
	}

	@Override
	public void alterConfigPrimaryKey(ConfigPrimaryKey ConfigPrimaryKey) {
		// TODO Auto-generated method stub
		configPrimaryKeyMapper.updateConfigPrimaryKey(ConfigPrimaryKey);
	}

	@Override
	public ConfigPrimaryKey ConfigPrimaryKeyById(short id) {
		// TODO Auto-generated method stub
		return configPrimaryKeyMapper.selectConfigPrimaryKeyById(id);
	}

	@Override
	public List<ConfigPrimaryKey> findAllConfigPrimaryKey() {
		// TODO Auto-generated method stub
		return configPrimaryKeyMapper.selectAllConfigPrimaryKey();
	}

	@Override
	public List<ConfigPrimaryKey> findAllConfigPrimaryKeyByprimaryKeyTable(String primaryKeyTable) {
		// TODO Auto-generated method stub
		return configPrimaryKeyMapper.selectAllConfigPrimaryKeyByPrimaryKetTable(primaryKeyTable);
	}


	
}
