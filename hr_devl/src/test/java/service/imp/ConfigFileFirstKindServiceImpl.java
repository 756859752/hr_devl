package service.imp;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo.ConfigFileFirstKind;
import service.BonusService;
import service.ConfigFileFirstKindService;

public class ConfigFileFirstKindServiceImpl {
	ConfigFileFirstKindService cs=null;
	
   public void start() {
	   ApplicationContext   context= new  ClassPathXmlApplicationContext("applicationContext.xml");
		  cs  =(ConfigFileFirstKindService)context.getBean("configFileFirstKindServiceImpl") ;          
   }	
	@Test
	public void testRemoveConfigFileFirstKind() {
	
	}
	@Test
	public void alterConfigFileFirstKind() {
		System.out.println("ok");
	}

	@Test
	public void testFindConfigFileFirstKindById() {
		ConfigFileFirstKind c=cs.findConfigFileFirstKindById((short) 1);
		System.out.println(c);
	}

//	@Test
//	public void testFindAllConfigFileFirstKind() {
//		List<ConfigFileFirstKind>  list  = cs.findAllConfigFileFirstKind();                  
//	       System.out.println(list);
//	}

	@Test
	public void testAddConfigFileFirstKind() {
		
	}

}
