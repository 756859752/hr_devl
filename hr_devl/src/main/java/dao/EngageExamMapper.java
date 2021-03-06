package dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import pojo.EngageExam;

@Repository
public interface EngageExamMapper {
	public void insertEngageExam(EngageExam EngageExam);

	public void deleteEngageExam(short id);

	public void updateEngageExam(EngageExam EngageExam);

	public EngageExam selectEngageExamById(short id);

	public List<EngageExam> selectAllEngageExam();
	
	public  List<EngageExam> selectEngageGroupAndCount();
	
	public List<EngageExam> selectEngageExamByCondition(HashMap<String, String> hashmap);
}
