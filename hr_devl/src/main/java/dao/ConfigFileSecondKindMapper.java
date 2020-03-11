package dao;

import java.util.List;

import pojo.ConfigFileSecondKind;


public interface ConfigFileSecondKindMapper {
	public void insertConfigFileSecondKind(ConfigFileSecondKind ConfigFileSecondKind);
	public void deleteConfigFileSecondKind(short id);
	public void updateConfigFileSecondKind(ConfigFileSecondKind ConfigFileSecondKind);
	public ConfigFileSecondKind selectConfigFileSecondKindById(short id);
	public List<ConfigFileSecondKind> selectAllConfigFileSecondKind();
}
