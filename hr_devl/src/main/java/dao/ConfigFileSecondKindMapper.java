package dao;

import java.util.List;

import pojo.ConfigFileFirstKind;
import pojo.ConfigFileSecondKind;



public interface ConfigFileSecondKindMapper {
	public void insertConfigFileSecondKind(ConfigFileSecondKind ConfigFileSecondKind);

	public void deleteConfigFileSecondKind(short id);

	public void updateConfigFileSecondKind(ConfigFileSecondKind ConfigFileSecondKind);

	public ConfigFileSecondKind selectConfigFileSecondKindById(short id);
	
	public List<ConfigFileSecondKind> selectAllConfigFileSecondKindByfisrtKindId(String firstSecondid);
	
	public List<ConfigFileSecondKind> selectAllConfigFileSecondKind();

    public void deleteConfigFileSecondKindByfirstkindid(String firstKindId );
    
    public void updateConfigFileSecondKindBycffk(ConfigFileFirstKind ff);    
}
