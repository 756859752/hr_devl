package service.imp;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo.ConfigQuestionSecondKind;
import service.ConfigQuestionSecondKindService;

public class ConfigQuestionSecondKindServiceImpl {

	ConfigQuestionSecondKindService cs=null;
	@Before
     public void start() {
		   ApplicationContext   context= new  ClassPathXmlApplicationContext("applicationContext.xml");
			  cs  =(ConfigQuestionSecondKindService)context.getBean("configQuestionSecondKindServiceImpl") ;          
	   }		
	@Test
	public void testAddConfigQuestionSecondKind() {
	
	}

	@Test
	public void testRemoveConfigQuestionSecondKind() {
	
	}

	@Test
	public void testAlterConfigQuestionSecondKind() {
		
	}

	@Test
	public void testConfigQuestionSecondKindById() {
		  System.out.println("ok");
	}

	@Test
	public void testFindAllConfigQuestionSecondKind() {
		List<ConfigQuestionSecondKind> list =cs.findAllConfigQuestionSecondKind();
	    System.out.println(list.size());
	    System.out.println("ok");
	}

}
