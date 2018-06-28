package dge1992.spring.ioc.DI;

import dge1992.spring.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * 构造方法注入的四种方式
 */
public class ConstructionTest {

    public static void main(String[] args) {
        ApplicationContext appletContext = new ClassPathXmlApplicationContext("ioc/DI/ConstructionTest.xml");

        Person person1 = (Person) appletContext.getBean("person1");
        System.out.println(person1);

        Person person2 = (Person) appletContext.getBean("person2");
        System.out.println(person2);

        Person person3 = (Person) appletContext.getBean("person3");
        System.out.println(person3);

        Person person4 = (Person) appletContext.getBean("person4");
        System.out.println(person4);
    }
}
