package dao;

import java.util.HashMap;
import java.util.List;

import pojo.HumanFile;

public interface HumanFileMapper {
	public void insertHumanFile(HumanFile HumanFile);

	public void deleteHumanFile(short id);

	public void updateHumanFile(HumanFile HumanFile);

	public HumanFile selectHumanFileById(short id);

	public List<HumanFile> selectAllHumanFile();
	
	public List<HumanFile> selectHumanFileByCheckStatus(short s);
	//多条件查询
	public List<HumanFile> selectByCondition(HumanFile HumanFile);
	
	//多条件筛选
		public List<HumanFile> selectHumanFileByConditions(HashMap<String, Object> map);
		
//   根据人员编号查找人员信息
	public HumanFile selectHumanFileByHunamId(String hid);
	
//	根据机构查询
	public List<HumanFile> selectHumanFileByMechchanism(HashMap<String, Object> map);

}
