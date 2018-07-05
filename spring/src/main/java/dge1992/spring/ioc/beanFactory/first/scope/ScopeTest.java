package dge1992.spring.ioc.beanFactory.first.scope;

import dge1992.spring.ioc.beanFactory.bean.Person;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * 作用域测试
 * singleton prototype request
 */
public class ScopeTest {

    public static void main(String[] args) {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("ioc/beanFactory/first/scope/scope.xml"));
        Person person1 = (Person) beanFactory.getBean("person1");
        System.out.println(person1);
        Person person2 = (Person) beanFactory.getBean("person2");
        System.out.println(person2);

        System.out.println(person1.getCar() == person2.getCar());
        System.out.println(person1.getDog() == person2.getDog());
    }
}
