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
//	多条件查询人事档案
	public List<HumanFile> findHumanFileByConditions(HashMap<String, Object> map);
}
