package dao;

import java.util.List;

import pojo.EngageInterview;

public interface EngageInterviewMapper {
	public void insertEngageInterview(EngageInterview EngageInterview);

	public void deleteEngageInterview(short id);

	public void updateEngageInterview(EngageInterview EngageInterview);

	public EngageInterview selectEngageInterviewById(short id);

	public List<EngageInterview> selectAllEngageInterview();
	
	public EngageInterview selectEngageInterviewByIdWithResume(short id);
}
