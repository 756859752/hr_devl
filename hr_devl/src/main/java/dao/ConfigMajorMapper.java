package dao;

import java.util.List;

import org.springframework.stereotype.Repository;


import pojo.ConfigMajor;

@Repository
public interface ConfigMajorMapper {
	public void insertConfigMajor(ConfigMajor ConfigMajor);

	public void deleteConfigMajor(short id);

	public void updateConfigMajor(ConfigMajor ConfigMajor);

	public ConfigMajor selectConfigMajorById(short id);

	public List<ConfigMajor> selectAllConfigMajor();
}
