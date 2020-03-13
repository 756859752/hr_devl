package service;

import java.util.List;

import pojo.ConfigMajorKind;






public interface ConfigMajorKindService {
	public void addConfigMajorKind(ConfigMajorKind ConfigMajorKind);

	public void removeConfigMajorKindKind(short id);

	public void alterConfigMajorKindKind(ConfigMajorKind ConfigMajorKind);

	public ConfigMajorKind findConfigMajorKindById(short id);

	public List<ConfigMajorKind> findAllConfigMajorKind();
}
