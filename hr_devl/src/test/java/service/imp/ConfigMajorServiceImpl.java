package service.imp;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo.ConfigMajor;
import service.ConfigMajorService;

public class ConfigMajorServiceImpl {

   ConfigMajorService cs=null;
	
	@Before
     public void start() {
	  ApplicationContext   context= new  ClassPathXmlApplicationContext("applicationContext.xml");
	   cs  =(ConfigMajorService)context.getBean("configMajorServiceImpl") ;          
	   }
	
	@Test
	public void testAddConfigMajor() {
		
	}

	@Test
	public void testRemoveConfigMajor() {
	
	}

	@Test
	public void testAlterConfigMajor() {
	
	}

	@Test
	public void testFindConfigMajorById() {
	
	}

	@Test
	public void testFindAllConfigMajor() {
		List<ConfigMajor> l= cs.findAllConfigMajor();
		    System.out.println(l.size());
	}

}
