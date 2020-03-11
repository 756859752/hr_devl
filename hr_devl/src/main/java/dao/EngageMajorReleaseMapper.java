package dao;

import java.util.List;

import pojo.EngageMajorRelease;

public interface EngageMajorReleaseMapper {
	public void insertEngageMajorRelease(EngageMajorRelease EngageMajorRelease);
	public void deleteEngageMajorRelease(short id);
	public void updateEngageMajorRelease(EngageMajorRelease EngageMajorRelease);
	public EngageMajorRelease selectEngageMajorReleaseById(short id);
	public List<EngageMajorRelease> selectAllEngageMajorRelease();
}
