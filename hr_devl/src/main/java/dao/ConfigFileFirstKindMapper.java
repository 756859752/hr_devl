package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import pojo.ConfigFileFirstKind;

@Repository
public interface ConfigFileFirstKindMapper {
	public void insertConfigFileFirstKind(ConfigFileFirstKind configFileFirstKind);

	public void deleteConfigFileFirstKind(short id);

	public void updateConfigFileFirstKind(ConfigFileFirstKind configFileFirstKind);

	public ConfigFileFirstKind selectConfigFileFirstKindById(short id);

	public List<ConfigFileFirstKind> selectAllConfigFileFirstKind();
}
