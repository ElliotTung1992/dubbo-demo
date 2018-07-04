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

        //测试list
        Person person2 = (Person) appletContext.getBean("person2");
        System.out.println(person2);

        //测试set
        Person person3 = (Person) appletContext.getBean("person3");
        System.out.println(person3);

        //测试map
        Person person4 = (Person) appletContext.getBean("person4");
        System.out.println(person4);

        //<null/>
        Person person5 = (Person) appletContext.getBean("person5");
        System.out.println(person5);
    }
}
