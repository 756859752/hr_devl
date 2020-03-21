package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ConfigFileThirdKindMapper;
import pojo.ConfigFileFirstKind;
import pojo.ConfigFileSecondKind;
import pojo.ConfigFileThirdKind;
import service.ConfigFileThirdKindService;


@Service
public class ConfigFileThirdKindServiceImpl implements ConfigFileThirdKindService {

	@Autowired
	ConfigFileThirdKindMapper ConfigFileThirdKindMapper = null;

	@Override
	public void addConfigFileThirdKind(ConfigFileThirdKind ConfigFileThirdKind) {
		// TODO Auto-generated method stub
		ConfigFileThirdKindMapper.insertConfigFileThirdKind(ConfigFileThirdKind);
	}

	@Override
	public void removeConfigFileThirdKind(short id) {
		// TODO Auto-generated method stub
		ConfigFileThirdKindMapper.deleteConfigFileThirdKind(id);
	}

	@Override
	public void alterConfigFileThirdKind(ConfigFileThirdKind ConfigFileThirdKind) {
		// TODO Auto-generated method stub
		ConfigFileThirdKindMapper.updateConfigFileThirdKind(ConfigFileThirdKind); 
	}

	@Override
	public ConfigFileThirdKind findConfigFileThirdKindById(short id) {
		// TODO Auto-generated method stub
		return ConfigFileThirdKindMapper.selectConfigFileThirdKindKindById(id);
	}

	@Override
	public List<ConfigFileThirdKind> findAllConfigFileThirdKind() {
		// TODO Auto-generated method stub
		return ConfigFileThirdKindMapper.selectAllConfigFileThirdKind();
	}

	@Override
	public void removeConfigFileThirdKindByfirstKindId(String firstKindId) {
		// TODO Auto-generated method stub
		ConfigFileThirdKindMapper.deleteConfigFileThirdKindByfirstkindid(firstKindId);
	}

	@Override
	public void alterConfigFileThirdKindBycffk(ConfigFileFirstKind cffk) {
		// TODO Auto-generated method stub
		ConfigFileThirdKindMapper.updateConfigFileFirstKindBycffk(cffk);
	}

	@Override
	public List<ConfigFileThirdKind> findConfigFileThirdKindBySecondKindId(String kid) {
		// TODO Auto-generated method stub
		return ConfigFileThirdKindMapper.selectConfigFileThirdKindBySecondKindId(kid);
	}


	
}
