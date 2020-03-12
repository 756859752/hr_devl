package dao;

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
}
