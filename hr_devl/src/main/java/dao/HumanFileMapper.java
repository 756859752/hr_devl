package dao;

import java.util.List;

import pojo.HumanFile;

public interface HumanFileMapper {
	public void insertHumanFile(HumanFile HumanFile);
	public void deleteHumanFile(short id);
	public void updateHumanFile(HumanFile HumanFile);
	public HumanFile selectHumanFileById(short id);
	public List<HumanFile> selectAllHumanFile();
}
