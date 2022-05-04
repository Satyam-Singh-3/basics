package spring.core;

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
        
        ApplicationContext context =new ClassPathXmlApplicationContext("spring/core/NewFile.xml");
        Student student = context.getBean("student1",Student.class);
        System.out.println(student);
        
        
    }
}
