package dge1992.spring.ioc.beanFactory.first.autowire;

import dge1992.spring.ioc.beanFactory.first.BeanFactoryPerson;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * 自动绑定
 */
public class AutowireTest {

    public static void main(String[] args) {
        //自动绑定 byType
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("ioc/beanFactory/first/autowire/autowire.xml"));
        BeanFactoryPerson person = (BeanFactoryPerson) beanFactory.getBean("beanFactoryPerson");
        System.out.println(person);
        //自动绑定 constructor
        BeanFactoryPerson beanFactoryPerson1 = (BeanFactoryPerson) beanFactory.getBean("beanFactoryPerson1");
        System.out.println(beanFactoryPerson1);
    }
}
