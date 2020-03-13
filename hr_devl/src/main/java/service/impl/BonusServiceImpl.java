package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BonusMapper;
import pojo.Bonus;
import service.BonusService;

@Service
public class BonusServiceImpl implements BonusService {

	@Autowired
	BonusMapper bonusMapper = null;

	@Override
	public void addBonus(Bonus Bonus) {
		// TODO Auto-generated method stub
		bonusMapper.insertBonus(Bonus);
	}

	@Override
	public void removeBonus(short id) {
		// TODO Auto-generated method stub
		bonusMapper.deleteBonus(id);
	}

	@Override
	public void alterBonus(Bonus Bonus) {
		// TODO Auto-generated method stub
		bonusMapper.updateBonus(Bonus);
	}

	@Override
	public Bonus findBonusById(short id) {
		// TODO Auto-generated method stub
		return bonusMapper.selectBonusById(id);
	}

	@Override
	public List<Bonus> findAllBonus() {
		// TODO Auto-generated method stub
		return bonusMapper.selectAllBonus();
	}

}
