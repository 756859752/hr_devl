package service.imp;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo.ConfigMajorKind;
import service.ConfigMajorKindService;



public class ConfigMajorKindServiceImpl {

	ConfigMajorKindService cs=null;
	
	@Before
     public void start() {
		   ApplicationContext   context= new  ClassPathXmlApplicationContext("applicationContext.xml");
			  cs  =(ConfigMajorKindService)context.getBean("configMajorKindServiceImpl") ;          
	   }	
	
	@Test
	public void testAddConfigMajorKind() {
		
	}

	@Test
	public void testRemoveConfigMajorKindKind() {
		
	}

	@Test
	public void testAlterConfigMajorKindKind() {
	
	}

	@Test
	public void testFindConfigMajorKindById() {
		
	}

	@Test
	public void testFindAllConfigMajorKind() {
		List<ConfigMajorKind> list =cs.findAllConfigMajorKind();
		System.out.println(list.size());
	}

}
