package service;

import java.util.List;

import pojo.Bonus;

public interface BonusService {
	public void addBonus(Bonus Bonus);
	public void removeBonus(short id);
	public void alterBonus(Bonus Bonus);
	public Bonus findBonusById(short id);
	public List<Bonus> findAllBonus();
}
