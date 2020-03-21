package service;

import java.util.HashMap;
import java.util.List;

import pojo.EngageExamDetails;

public interface EngageExamDetailsService {
	public void addEngageExamDetails(EngageExamDetails EngageExamDetails);
	public void removeEngageExamDetails(short id);
	public void alterEngageExamDetails(EngageExamDetails EngageExamDetails);
	public EngageExamDetails findEngageExamDetailsById(short id);
	public List<EngageExamDetails> findAllEngageExamDetails();
	public List<EngageExamDetails> findEngageExamDetailsByCondition(HashMap<String,String> hashmap);
}
