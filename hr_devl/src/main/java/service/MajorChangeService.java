package service;

import java.util.List;

import pojo.MajorChange;

public interface MajorChangeService{
	public void addMajorChange(MajorChange majorChange);
	public void removeMajorChange(short id);
	public void alterMajorChange(MajorChange majorChange);
	public MajorChange findMajorChangeById(short id);
	public List<MajorChange> findAllMajorChange();
//	查询所有未审核的信息
	public List<MajorChange> findAllMajorChangeByCheckStatus();
}
