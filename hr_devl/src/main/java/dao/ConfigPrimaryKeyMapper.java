package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import pojo.ConfigPrimaryKey;

@Repository
public interface ConfigPrimaryKeyMapper {
	public void insertConfigPrimaryKey(ConfigPrimaryKey ConfigPrimaryKey);
	public void deleteConfigPrimaryKey(short id);
	public void updateConfigPrimaryKey(ConfigPrimaryKey ConfigPrimaryKey);
	public ConfigPrimaryKey selectConfigPrimaryKeyById(short id);
	public List<ConfigPrimaryKey> selectAllConfigPrimaryKey();
}
