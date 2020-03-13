package service.imp;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo.ConfigFileThirdKind;
import service.ConfigFileThirdKindService;



public class ConfingFileThirdKindServiceImpl {

	ConfigFileThirdKindService cs=null;
	@Before
     public void start() {
		   ApplicationContext   context= new  ClassPathXmlApplicationContext("applicationContext.xml");
			  cs  =(ConfigFileThirdKindService)context.getBean("configFileThirdKindServiceImpl") ;          
	   }	
	@Test
	public void testAddConfigFileThirdKind() {

	}

	@Test
	public void testRemoveConfigFileThirdKind() {

	}

	@Test
	public void testAlterConfigFileThirdKind() {

	}

	@Test
	public void testFindConfigFileThirdKindById() {
	
	}

	@Test
	public void testFindAllConfigFileThirdKind() {
		List<ConfigFileThirdKind>    list =cs.findAllConfigFileThirdKind();
		  System.out.println(list.size());
	}

}
