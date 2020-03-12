package service;

import java.util.List;
import pojo.ConfigFileFirstKind;

public interface ConfigFileFirstKindService {
	public void addConfigFileFirstKind(ConfigFileFirstKind ConfigFileFirstKind);
	public void removeConfigFileFirstKind(short id);
	public void alterConfigPublicChar(ConfigFileFirstKind ConfigFileFirstKind);
	public ConfigFileFirstKind findConfigFileFirstKindById(short id);
	public List<ConfigFileFirstKind> findAllConfigFileFirstKind();
}
