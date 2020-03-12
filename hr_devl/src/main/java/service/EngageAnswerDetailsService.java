package service;

import java.util.List;

import pojo.EngageAnswerDetails;

public interface EngageAnswerDetailsService {
	public void addEngageAnswerDetails(EngageAnswerDetails EngageAnswerDetails);
	public void removeEngageAnswerDetails(short id);
	public void alterEngageAnswerDetails(EngageAnswerDetails EngageAnswerDetails);
	public EngageAnswerDetails findEngageAnswerDetailsById(short id);
	public List<EngageAnswerDetails> findAllEngageAnswerDetails();
}
