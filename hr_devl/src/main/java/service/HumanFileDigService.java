package service;

import java.util.List;

import pojo.HumanFileDig;

public interface HumanFileDigService {
	public void addHumanFileDig(HumanFileDig HumanFileDig);
	public void removeHumanFileDig(short id);
	public void alterHumanFileDig(HumanFileDig HumanFileDig);
	public HumanFileDig findHumanFileDigById(short id);
	public List<HumanFileDig> findAllHumanFileDig();
}
