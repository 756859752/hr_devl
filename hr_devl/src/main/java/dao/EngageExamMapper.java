package dao;

import java.util.List;

import pojo.EngageExam;

public interface EngageExamMapper {
	public void insertEngageExam(EngageExam EngageExam);
	public void deleteEngageExam(short id);
	public void updateEngageExam(EngageExam EngageExam);
	public EngageExam selectEngageExamById(short id);
	public List<EngageExam> selectAllEngageExam();
}
