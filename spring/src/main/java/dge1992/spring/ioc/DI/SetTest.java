package dge1992.spring.ioc.DI;

import dge1992.spring.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * set方法注入
 *
 * 需要有一个空的构造函数
 *
 */
public class SetTest {

    public static void main(String[] args) {
        ApplicationContext appletContext = new ClassPathXmlApplicationContext("ioc/DI/SetTest.xml");
        Person person = (Person) appletContext.getBean("person");
        System.out.println(person);
    }
}
