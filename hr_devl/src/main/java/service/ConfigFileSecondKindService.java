package service;

import java.util.List;

import pojo.ConfigFileFirstKind;
import pojo.ConfigFileSecondKind;


public interface ConfigFileSecondKindService {
	public void addConfigFileSecondKind(ConfigFileSecondKind ConfigFileSecondKind);

	public void removeConfigFileSecondKind(short id);
	public void removeConfigFileSecondKindByfirstkindid(String firstkinfid);

	public void alterConfigFileSecondKind(ConfigFileSecondKind ConfigFileSecondKind);
	
	public void alterConfigFileSecondKindBycffk(ConfigFileFirstKind ff);
	
	public ConfigFileSecondKind findConfigFileSecondKindById(short id);

	public List<ConfigFileSecondKind> findAllConfigFileSecondKind();
	
	public List<ConfigFileSecondKind> findAllConfigFileSecondKindByfisrtKindId(String firstKindId);
	
}
