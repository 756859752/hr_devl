package test;


import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.StudentService;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("/applicationContext.xml");
		StudentService da=	(StudentService)context.getBean("studentServiceImpl");
		System.out.println(da.findOne(2));
	}
}
