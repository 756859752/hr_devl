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
	//cgp多条件查询
	public List<HumanFile> findByCondition(HumanFile HumanFile);
//	根据多条件筛选
	public List<HumanFile> findHumanFileByConditions(HashMap<String, Object> map);
//	根据humanid查询一个
	public HumanFile findHumanFileByHumanId(String hid);

}
