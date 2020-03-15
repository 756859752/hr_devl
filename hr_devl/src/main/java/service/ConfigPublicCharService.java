package service;

import java.util.List;

import pojo.ConfigPublicChar;


public interface ConfigPublicCharService {
	public void addConfigPublicChar(ConfigPublicChar ConfigPublicChar);

	public void removeConfigPublicChar(int id);

	public void alterConfigPublicChar(ConfigPublicChar ConfigPublicChar);

	public ConfigPublicChar findConfigPublicCharById(int id);

	public List<ConfigPublicChar> findAllConfigPublicChar();
	
	public List<ConfigPublicChar> findAllConfigPublicCharByCondition(ConfigPublicChar ConfigPublicChar);
} 
