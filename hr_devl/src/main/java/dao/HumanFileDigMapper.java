package dao;

import java.util.List;

import pojo.HumanFileDig;

public interface HumanFileDigMapper {
	public void insertHumanFileDig(HumanFileDig HumanFileDig);

	public void deleteHumanFileDig(short id);

	public void updateHumanFileDig(HumanFileDig HumanFileDig);

	public HumanFileDig selectHumanFileDigById(short id);

	public List<HumanFileDig> selectAllHumanFileDig();
}
