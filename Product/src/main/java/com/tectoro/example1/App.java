package com.tectoro.example1;

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
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("com/tectoro/example1/applicationContext.xml");
        Object product = applicationContext.getBean("pro");
        System.out.println(product);
    }
}
