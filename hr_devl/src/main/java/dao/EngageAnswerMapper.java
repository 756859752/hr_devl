package dao;

import java.util.List;

import pojo.EngageAnswer;

public interface EngageAnswerMapper {
	public void insertEngageAnswer(EngageAnswer EngageAnswer);

	public void deleteEngageAnswer(short id);

	public void updateEngageAnswer(EngageAnswer EngageAnswer);

	public EngageAnswer selectEngageAnswerById(short id);

	public List<EngageAnswer> selectAllEngageAnswer();
}
