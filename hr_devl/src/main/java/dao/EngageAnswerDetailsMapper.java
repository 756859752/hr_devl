package dao;

import java.util.List;

import pojo.EngageAnswerDetails;

public interface EngageAnswerDetailsMapper {
	public void insertEngageAnswerDetails(EngageAnswerDetails EngageAnswerDetails);

	public void deleteEngageAnswerDetails(short id);

	public void updateEngageAnswerDetails(EngageAnswerDetails EngageAnswerDetails);

	public EngageAnswerDetails selectEngageAnswerDetailsById(short id);

	public List<EngageAnswerDetails> selectAllEngageAnswerDetails();
	
	public List<EngageAnswerDetails> selectEngageAnswerByCondition(String answerNumber);
	
	public List<EngageAnswerDetails>  selectEngageAnswerDetailsWithSubject(String answerNumber);
}
