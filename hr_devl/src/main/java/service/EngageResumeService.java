package service;

import java.util.List;

import pojo.EngageResume;

public interface EngageResumeService {
	public void addEngageResume(EngageResume EngageResume);
	public void removeEngageResume(short id);
	public void alterEngageResume(EngageResume EngageResume);
	public EngageResume findEngageResumeById(short id);
	public List<EngageResume> findAllEngageResume();
}
