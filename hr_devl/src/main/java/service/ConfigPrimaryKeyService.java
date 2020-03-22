package service;

import java.util.List;

import pojo.ConfigPrimaryKey;

public interface ConfigPrimaryKeyService {
	public void addConfigPrimaryKey(ConfigPrimaryKey ConfigPrimaryKey);

	public void removeConfigPrimaryKey(short id);

	public void alterConfigPrimaryKey(ConfigPrimaryKey ConfigPrimaryKey);
	
	public void alterConfigPrimaryKeyprimaryKeyStatus(ConfigPrimaryKey ConfigPrimaryKey);

	public ConfigPrimaryKey ConfigPrimaryKeyById(short id);

	public List<ConfigPrimaryKey> findAllConfigPrimaryKey();
	
	public List<ConfigPrimaryKey> findAllConfigPrimaryKeyByprimaryKeyTable(String primaryKeyTable);
}
