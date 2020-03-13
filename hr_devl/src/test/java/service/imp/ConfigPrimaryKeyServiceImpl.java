package service.imp;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo.ConfigPrimaryKey;
import service.ConfigPrimaryKeyService;

public class ConfigPrimaryKeyServiceImpl {

	ConfigPrimaryKeyService cs=null;
	@Before
   public void start() {
    ApplicationContext   context= new  ClassPathXmlApplicationContext("applicationContext.xml");
			  cs  =(ConfigPrimaryKeyService)context.getBean("configPrimaryKeyServiceImpl") ;          
	   }	
	
	@Test
	public void testAddConfigPrimaryKey() {
	
	}

	@Test
	public void testRemoveConfigPrimaryKey() {
		
	}

	@Test
	public void testAlterConfigPrimaryKey() {
		
	}

	@Test
	public void testConfigPrimaryKeyById() {
		
	}

	@Test
	public void testFindAllConfigPrimaryKey() {
		List<ConfigPrimaryKey>   list =cs.findAllConfigPrimaryKey();
		    System.out.println(list.size());
	}

}
