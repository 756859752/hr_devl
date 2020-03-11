package test;


import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo.ConfigPublicChar;
import dao.ConfigPublicCharMapper;
import service.ConfigPublicCharService;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("/applicationContext.xml");
		ConfigPublicCharService cp=	(ConfigPublicCharService)context.getBean("configPublicCharServiceImpl");
		System.out.println(cp);
		System.out.println(cp.findAllConfigPublicChar());
//		ConfigPublicChar c=new ConfigPublicChar();
//		System.out.println(c);
	}
}
