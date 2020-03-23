package service;

import java.util.HashMap;
import java.util.List;

import pojo.EngageAnswerDetails;
import pojo.EngageExamDetails;

public interface EngageAnswerDetailsService {
	public void addEngageAnswerDetails(EngageAnswerDetails EngageAnswerDetails);
	public void removeEngageAnswerDetails(short id);
	public void alterEngageAnswerDetails(EngageAnswerDetails EngageAnswerDetails);
	public EngageAnswerDetails findEngageAnswerDetailsById(short id);
	public List<EngageAnswerDetails> findAllEngageAnswerDetails();
	public List<EngageAnswerDetails> findEngageAnswerByCondition(String answerNumber);
	public List<EngageAnswerDetails>  findEngageAnswerDetailsWithSubject(String answerNumber);
}
