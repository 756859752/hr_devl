package service;

import java.util.HashMap;
import java.util.List;

import pojo.HumanFile;

public interface HumanFileService {
	public void addHumanFile(HumanFile HumanFile);
	public void removeHumanFile(short id);
	public void alterHumanFile(HumanFile HumanFile);
	public HumanFile findHumanFileById(short id);
	public List<HumanFile> findAllHumanFile();
	public List<HumanFile> findHumanFileByCheckStatus(short s);
	public List<HumanFile> findByCondition(HumanFile HumanFile);
}
