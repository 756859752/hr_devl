package service;

import java.util.List;

import pojo.EngageMajorRelease;

public interface EngageMajorReleaseService {
	public void addEngageMajorRelease(EngageMajorRelease EngageMajorRelease);
	public void removeEngageMajorRelease(short id);
	public void alterEngageMajorRelease(EngageMajorRelease EngageMajorRelease);
	public EngageMajorRelease findEngageMajorReleaseById(short id);
	public List<EngageMajorRelease> findAllEngageMajorRelease();
	public void addEngageMajorReleaseAutowrite(EngageMajorRelease EngageMajorRelease);
}
