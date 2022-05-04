package com.tectoro.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("program started");
		// Spring Jdbc=> jdbcTemplate
		ApplicationContext context = new ClassPathXmlApplicationContext("com/tectoro/jdbc/Config.xml");

		JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
		String query = "insert into Student(id,name,city) values(?,?,?)";
		String Query="delete from Student where id=?";
		int temp = template.update(Query,223);
		System.out.println("executed"+temp);
		// fire the query
		//int result = template.update(query, 224, "Patel", "hyderabad");
		//System.out.println("number of record inserted" + result);
		/*int result1 = template.update(query, 102, "Arun", "patna");
		int result2 = template.update(query, 103, "Mohan", "ongol");
		System.out.println("number of record inserted" + result);
		System.out.println("number of record inserted" + result1);
		System.out.println("number of record inserted" + result2);*/

	}

}
