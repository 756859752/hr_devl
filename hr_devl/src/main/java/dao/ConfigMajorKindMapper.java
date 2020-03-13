package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import pojo.ConfigMajorKind;

@Repository
public interface ConfigMajorKindMapper {
	public void insertConfigMajorKind(ConfigMajorKind ConfigMajorKind);

	public void deleteConfigMajorKind(short id);

	public void updateConfigMajorKind(ConfigMajorKind ConfigMajorKind);

	public ConfigMajorKind selectConfigMajorKindById(short id);

	public List<ConfigMajorKind> selectAllConfigMajorKind();
}
