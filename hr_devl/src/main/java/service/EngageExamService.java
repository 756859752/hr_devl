package service;

import java.util.List;

import pojo.EngageExam;

public interface EngageExamService {
	public void addEngageExam(EngageExam EngageExam);
	public void removeEngageExam(short id);
	public void alterEngageExam(EngageExam EngageExam);
	public EngageExam findEngageExamById(short id);
	public List<EngageExam> findAllEngageExam();
	public  List<EngageExam> findEngageGroupAndCount();
}
