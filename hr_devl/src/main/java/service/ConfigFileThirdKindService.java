package service;

import java.util.List;

import pojo.ConfigFileThirdKind;




public interface ConfigFileThirdKindService {
	public void addConfigFileThirdKind(ConfigFileThirdKind ConfigFileThirdKind);

	public void removeConfigFileThirdKind(short id);

	public void alterConfigFileThirdKind(ConfigFileThirdKind ConfigFileThirdKind);

	public ConfigFileThirdKind findConfigFileThirdKindById(short id);

	public List<ConfigFileThirdKind> findAllConfigFileThirdKind();
}
