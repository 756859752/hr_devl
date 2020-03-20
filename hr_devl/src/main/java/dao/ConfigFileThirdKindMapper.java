package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import pojo.ConfigFileFirstKind;
import pojo.ConfigFileThirdKind;

@Repository
public interface ConfigFileThirdKindMapper {
	public void insertConfigFileThirdKind(ConfigFileThirdKind ConfigFileThirdKind);
	
	public void deleteConfigFileThirdKind(short id);
	
	public void updateConfigFileThirdKind(ConfigFileThirdKind ConfigFileThirdKind);
	public void updateConfigFileFirstKindBycffk(ConfigFileFirstKind ff);
	public ConfigFileThirdKind selectConfigFileThirdKindKindById(short id);

	public List<ConfigFileThirdKind> selectAllConfigFileThirdKind();
	
	public void deleteConfigFileThirdKindByfirstkindid(String firstKindId);
	
//	根据二级的id展示所有三级分类下选项
	public List<ConfigFileThirdKind> selectConfigFileThirdKindBySecondKindId(String secondkindid);
}
