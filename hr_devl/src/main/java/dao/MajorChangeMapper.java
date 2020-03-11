package dao;

import java.util.List;

import pojo.MajorChange;

public interface MajorChangeMapper {
	public void insertMajorChange(MajorChange MajorChange);
	public void deleteMajorChange(short id);
	public void updateMajorChange(MajorChange MajorChange);
	public MajorChange selectMajorChangeById(short id);
	public List<MajorChange> selectAllMajorChange();
}
