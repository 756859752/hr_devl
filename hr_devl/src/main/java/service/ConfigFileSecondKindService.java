package service;

import java.util.List;

import pojo.ConfigFileSecondKind;


public interface ConfigFileSecondKindService {
	public void addConfigFileSecondKind(ConfigFileSecondKind ConfigFileSecondKind);

	public void removeConfigFileSecondKind(short id);

	public void alterConfigFileSecondKind(ConfigFileSecondKind ConfigFileSecondKind);

	public ConfigFileSecondKind findConfigFileSecondKindById(short id);

	public List<ConfigFileSecondKind> findAllConfigFileSecondKind();
}
