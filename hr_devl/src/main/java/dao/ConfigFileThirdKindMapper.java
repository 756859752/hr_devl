package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import pojo.ConfigFileThirdKind;

@Repository
public interface ConfigFileThirdKindMapper {
	public void insertConfigFileThirdKind(ConfigFileThirdKind ConfigFileThirdKind);
	public void deleteConfigFileThirdKind(short id);
	public void updateConfigFileFirstKind(ConfigFileThirdKind ConfigFileThirdKind);
	public ConfigFileThirdKind selectConfigFileThirdKindKindById(short id);
	public List<ConfigFileThirdKind> selectAllConfigFileSecondKind();
}
