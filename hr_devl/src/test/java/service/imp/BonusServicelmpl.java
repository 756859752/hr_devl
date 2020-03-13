package service.imp;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo.Bonus;
import service.BonusService;


public class BonusServicelmpl {
	BonusService bonusServiceImpl = null;
	
	 @Before 
	 public void start(){
		 ApplicationContext   context= new  ClassPathXmlApplicationContext("applicationContext.xml");
		 bonusServiceImpl     =(BonusService)context.getBean("bonusServiceImpl") ;          
	 
	 }
	 
//	@Test
//	public void testAddBonus() {
//	     Bonus Bonus = new Bonus();
//	         Bonus.setBonId((short) 2);
//	         Bonus.setBonusDegree("ok");
//		bonusServiceImpl.addBonus(Bonus);
//		System.out.println("ok");
//	}

//	@Test
//	public void testRemoveBonus() {
//		Bonus Bonus = new Bonus();
//        Bonus.setBonId((short) 2);
//        Bonus.setBonusDegree("ok");
//		bonusServiceImpl.removeBonus((short) 2);
//	}

//	@Test
//	public void testAlterBonus() {
//		Bonus Bonus = new Bonus();
//		 Bonus.setBonId((short) 1);
//         Bonus.setBonusDegree("ok");
//		bonusServiceImpl.alterBonus(Bonus);
//	}

//	@Test
//	public void testFindBonusById() {
//		Bonus b	=bonusServiceImpl.findBonusById((short) 1);
//		System.out.println(b);
//		System.out.println("ok");
//	}

	@Test
	public void testFindAllBonus() {
	List<Bonus> li =bonusServiceImpl.findAllBonus();
	
		  System.out.println(li);
	}

}
