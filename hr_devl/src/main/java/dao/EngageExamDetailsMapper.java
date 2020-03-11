package dao;

import java.util.List;

import pojo.EngageExamDetails;

public interface EngageExamDetailsMapper {
	public void insertEngageExamDetails(EngageExamDetails EngageExamDetails);
	public void deleteEngageExamDetails(short id);
	public void updateEngageExamDetails(EngageExamDetails EngageExamDetails);
	public EngageExamDetails selectEngageExamDetailsById(short id);
	public List<EngageExamDetails> selectAllEngageExamDetails();
}
