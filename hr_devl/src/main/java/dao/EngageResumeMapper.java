package dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import pojo.EngageResume;

@Repository
public interface EngageResumeMapper {
	public void insertEngageResume(EngageResume EngageResume);
	public void deleteEngageResume(short id);
	public void updateEngageResume(EngageResume EngageResume);
	public EngageResume selectEngageResumeById(short id);
	public List<EngageResume> selectAllEngageResume();
	public List<EngageResume> selectAllEngageResumeByConditon(HashMap<String,String> hashmap);
}
