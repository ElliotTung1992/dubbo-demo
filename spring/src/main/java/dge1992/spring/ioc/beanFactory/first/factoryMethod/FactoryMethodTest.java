package dge1992.spring.ioc.beanFactory.first.factoryMethod;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * 工厂方法
 */
public class FactoryMethodTest {

    public static void main(String[] args) {
        //静态工厂方法
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("ioc/beanFactory/first/factoryMethod/factoryMethod.xml"));
        Person person = (Person) beanFactory.getBean("person");
        System.out.println(person);

        //静态工厂方法 传参数
        Person person2 = (Person) beanFactory.getBean("person2");
        System.out.println(person2);

        //非静态工厂方法
        Person person3 = (Person) beanFactory.getBean("person3");
        System.out.println(person3);

        //自定义factoryBean
        Person person4 = (Person) beanFactory.getBean("person4");
        System.out.println(person4);
    }
}
