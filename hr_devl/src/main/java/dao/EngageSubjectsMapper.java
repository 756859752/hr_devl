package dao;

import java.util.List;

import pojo.EngageSubjects;

public interface EngageSubjectsMapper {
	public void insertEngageSubjects(EngageSubjects EngageSubjects);
	public void deleteEngageSubjects(short id);
	public void updateEngageSubjects(EngageSubjects EngageSubjects);
	public EngageSubjects selectEngageSubjectsById(short id);
	public List<EngageSubjects> selectAllEngageSubjects();
}
