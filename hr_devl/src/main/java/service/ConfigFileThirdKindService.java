package service;

import java.util.List;

import pojo.ConfigFileFirstKind;
import pojo.ConfigFileSecondKind;
import pojo.ConfigFileThirdKind;




public interface ConfigFileThirdKindService {
	public void addConfigFileThirdKind(ConfigFileThirdKind ConfigFileThirdKind);

	public void removeConfigFileThirdKind(short id);
	
	public void removeConfigFileThirdKindByfirstKindId(String firstKindId);

	public void alterConfigFileThirdKind(ConfigFileThirdKind ConfigFileThirdKind);

	public void alterConfigFileThirdKindBycffk(ConfigFileFirstKind cffk);
	
	public ConfigFileThirdKind findConfigFileThirdKindById(short id);

	public List<ConfigFileThirdKind> findAllConfigFileThirdKind();
	
	//根据二级机构id查
    public List<ConfigFileThirdKind> findConfigFileThirdKindBySecondKindId(String kid);
}
