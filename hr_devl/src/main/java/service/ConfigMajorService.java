package service;

import java.util.List;

import pojo.ConfigMajor;

public interface ConfigMajorService {
	public void addConfigMajor(ConfigMajor ConfigMajor);

	public void removeConfigMajor(short id);

	public void alterConfigMajor(ConfigMajor ConfigMajor);

	public ConfigMajor findConfigMajorById(short id);

	public List<ConfigMajor> findAllConfigMajor();
//	根据分类id查询所有的分类
	public List<ConfigMajor> findConfigMajorByMajorKindId(String kid);
}
