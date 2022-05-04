
package com.tectoro.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("com/tectoro/example/applicationContext.xml");
        Employee em = applicationContext.getBean("emp",Employee.class);
        System.out.println(em);
    }
}
