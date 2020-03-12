package service;

import java.util.List;

import pojo.EngageAnswer;

public interface EngageAnswerService {
	public void addEngageAnswer(EngageAnswer EngageAnswer);
	public void removeEngageAnswer(short id);
	public void alterEngageAnswer(EngageAnswer EngageAnswer);
	public EngageAnswer findEngageAnswerById(short id);
	public List<EngageAnswer> findAllEngageAnswer();
}
