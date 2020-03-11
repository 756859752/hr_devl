package service;

import java.util.List;

import pojo.ConfigPublicChar;

public interface ConfigPublicCharService {
	public void addConfigPublicChar(ConfigPublicChar ConfigPublicChar);
	public void removeConfigPublicChar(short id);
	public void alterConfigPublicChar(ConfigPublicChar ConfigPublicChar);
	public ConfigPublicChar findConfigPublicCharById(short id);
	public List<ConfigPublicChar> findAllConfigPublicChar();
}
