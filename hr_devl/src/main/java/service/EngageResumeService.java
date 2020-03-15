package service;

import java.util.HashMap;
import java.util.List;

import pojo.EngageResume;

public interface EngageResumeService {
	public void addEngageResume(EngageResume EngageResume);
	public void removeEngageResume(short id);
	public void alterEngageResume(EngageResume EngageResume);
	public EngageResume findEngageResumeById(short id);
	public List<EngageResume> findAllEngageResume();
	public List<EngageResume> findAllEngageResumeByConditon(HashMap<String,String> hashmap);
}
