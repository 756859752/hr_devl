package service.imp;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo.ConfigFileSecondKind;
import service.ConfigFileSecondKindService;
import service.ConfigPublicCharService;

public class ConfigFileSecondKindServicelmpl {

	ConfigFileSecondKindService cs=null;
	@Before
     public void start() {
		   ApplicationContext   context= new  ClassPathXmlApplicationContext("applicationContext.xml");
			  cs  =(ConfigFileSecondKindService)context.getBean("configFileSecondKindServiceImpl") ;          
	   }	
	@Test
	public void testAddConfigFileSecondKind() {
	
	}

	@Test
	public void testRemoveConfigFileSecondKind() {
		
	}

	@Test
	public void testAlterConfigFileSecondKind() {
		
	}

	@Test
	public void testFindConfigFileSecondKind() {
		
	}

	@Test
	public void testFindAllConfigFileFirstKind() {
		List<ConfigFileSecondKind> li=cs.findAllConfigFileSecondKind();
		System.out.println(li);
		System.out.println("ok");
	}

}
