package dao;

import java.util.HashMap;
import java.util.List;

import pojo.MajorChange;

public interface MajorChangeMapper {
	public void insertMajorChange(MajorChange MajorChange);

	public void deleteMajorChange(short id);

	public void updateMajorChange(MajorChange MajorChange);

	public MajorChange selectMajorChangeById(short id);

	public List<MajorChange> selectAllMajorChange();
//	查询所有需要审核的信息
	public List<MajorChange> selectAllMajorChangeByCheckStatus();
//	多条件筛选通过审核后的信息
	public List<MajorChange> selectMajorChangeCoditions(HashMap<String, Object> map);
}
