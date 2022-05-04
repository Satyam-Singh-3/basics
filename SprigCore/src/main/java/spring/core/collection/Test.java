package spring.core.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext application=new ClassPathXmlApplicationContext("spring/core/collection/collection.xml");
		collectionexample bean = application.getBean("collection1",collectionexample.class);
		System.out.println(bean);
	}
}
