package service.imp;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo.ConfigPublicChar;
import service.ConfigPublicCharService;


public class ConfigPublicCharServicelmpl {

	ConfigPublicCharService cs=null;
	@Before
     public void start() {
		   ApplicationContext   context= new  ClassPathXmlApplicationContext("applicationContext.xml");
			  cs  =(ConfigPublicCharService)context.getBean("configPublicCharServiceImpl") ;          
	   }	
	
	@Test
	public void testAddConfigPublicChar() {
	
	}

	@Test
	public void testRemoveConfigPublicChar() {
	
	}

	@Test
	public void testAlterConfigPublicChar() {
		
	}

//	@Test
//	public void testFindConfigPublicCharById() {
//		ConfigPublicChar c = cs.findConfigPublicCharById( 1);
//	    System.out.println(c);
//	}

	@Test
	public void testFindAllConfigPublicChar() {
		List<ConfigPublicChar> c = cs.findAllConfigPublicChar();
	    System.out.println(c);
	}

}
