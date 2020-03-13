package service;

import java.util.List;

import pojo.EngageInterview;

public interface EngageInterviewService {
	public void addEngageInterview(EngageInterview EngageInterview);
	public void removeEngageInterview(short id);
	public void alterEngageInterview(EngageInterview EngageInterview);
	public EngageInterview findEngageInterviewById(short id);
	public List<EngageInterview> findAllEngageInterview();
}
