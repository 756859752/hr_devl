package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import pojo.Bonus;

@Repository
public interface BonusMapper {
	public void insertBonus(Bonus bonus);
	
	public void deleteBonus(short id);

	public void updateBonus(Bonus bonus);

	public Bonus selectBonusById(short id);

	public List<Bonus> selectAllBonus();
}
