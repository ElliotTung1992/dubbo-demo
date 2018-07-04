package dge1992.spring.ioc.beanFactory.first;

import dge1992.spring.bean.Person;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * 获取Spring容器的三种方式
 */
public class BeanFactoryTest {

    public static void main(String[] args) {
        //获取容器方式一
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("ioc/DI/ConstructionTest.xml"));
        Person person = (Person) beanFactory.getBean("person1");
        System.out.println(person);

        //获取容器方式二
        ApplicationContext appletContext = new ClassPathXmlApplicationContext("ioc/DI/ConstructionTest.xml");

        //获取容器方式二
        ApplicationContext appletContext2 =
                new FileSystemXmlApplicationContext("file:E:\\gitHub\\framework\\spring\\web\\WEB-INF\\classes\\src\\main\\resources\\ioc\\DI\\ConstructionTest.xml");

        Person person2 = (Person) beanFactory.getBean("person2");
        System.out.println(person2);
    }
}
