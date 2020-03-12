package service;

import java.util.List;

import pojo.EngageSubjects;

public interface EngageSubjectsService {
	public void addEngageSubjects(EngageSubjects EngageSubjects);
	public void removeEngageSubjects(short id);
	public void alterEngageSubjects(EngageSubjects EngageSubjects);
	public EngageSubjects findEngageSubjectsById(short id);
	public List<EngageSubjects> findAllEngageSubjects();
}
