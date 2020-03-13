package service.imp;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo.ConfigQuestionFirstKind;
import service.ConfigQuestionFirstKindService;


public class ConfigQuestionFirstkindServiceImpl {

	ConfigQuestionFirstKindService cs=null;
	@Before
     public void start() {
		   ApplicationContext   context= new  ClassPathXmlApplicationContext("applicationContext.xml");
			  cs  =(ConfigQuestionFirstKindService)context.getBean("configQuestionFirstKindServiceImpl") ;          
	   }	                                                                     
	                                                                                   
	@Test
	public void testAddConfigQuestionFirstKind() {
	
	}

	@Test
	public void testRemoveConfigQuestionFirstKind() {
	
	}

	@Test
	public void testAlterConfigQuestionFirstKind() {

	}

	@Test
	public void testConfigQuestionFirstKindById() {
		
	}

	@Test
	public void testFindAllConfigQuestionFirstKind() {
		List<ConfigQuestionFirstKind> list= cs.findAllConfigQuestionFirstKind();
		System.out.println(list.size());
	}

}
