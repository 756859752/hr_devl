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

	public List<ConfigPublicChar> selectAllConfigPublicChar();
}
