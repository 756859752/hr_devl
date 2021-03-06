package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import pojo.ConfigPublicChar;

@Repository
public interface ConfigPublicCharMapper {
	public void insertConfigPublicChar(ConfigPublicChar ConfigPublicChar);

	public void deleteConfigPublicChar(int id);

	public void updateConfigPublicChar(ConfigPublicChar ConfigPublicChar);

	public ConfigPublicChar selectConfigPublicCharById(int id);
     
	public List<ConfigPublicChar> selectConfigPublicCharByattributeKind(String attributeKind);	
	public List<ConfigPublicChar> selectAllConfigPublicChar();
	
	public List<ConfigPublicChar> selecAllConfigPublicCharByCondition(ConfigPublicChar ConfigPublicChar);
}
