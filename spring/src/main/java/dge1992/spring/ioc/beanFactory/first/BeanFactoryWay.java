package dge1992.spring.ioc.beanFactory.first;

import dge1992.spring.ioc.beanFactory.bean.Car;
import dge1992.spring.ioc.beanFactory.bean.Dog;
import dge1992.spring.ioc.beanFactory.bean.Person;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * BeanFactory对象注册和依赖绑定方式
 */
public class BeanFactoryWay {

    public static void main(String[] args) {
        //直接编码方式
//        wayOne();

        //外部配置文件方式
//        wayTwo();

        //注解方式
        wayThree();
    }

    private static void wayThree() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc/beanFactory/first/wayThree.xml");
        BeanFactoryPerson person = (BeanFactoryPerson) context.getBean("beanFactoryPerson");
        System.out.println(person);

    }

    private static void wayTwo() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("ioc/beanFactory/first/wayTwo.xml");
        Person person = (Person) beanFactory.getBean("person");
        System.out.println(person);
    }

    private static void wayOne() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        AbstractBeanDefinition rootBeanDefinition1 = new RootBeanDefinition(new Person("金正焕", 12, true).getClass());
        AbstractBeanDefinition rootBeanDefinition2 = new RootBeanDefinition(new Car("甲壳虫", 1992, "大众").getClass());
        AbstractBeanDefinition rootBeanDefinition3 = new RootBeanDefinition(new Dog("笨笨", "金毛").getClass());
        //将Bean定义注册到容器中
        beanFactory.registerBeanDefinition("person", rootBeanDefinition1);
        beanFactory.registerBeanDefinition("car", rootBeanDefinition2);
        beanFactory.registerBeanDefinition("dog", rootBeanDefinition3);
        //指定依赖关系
        //1.可以通过构造方法注入方式
//        ConstructorArgumentValues argValues = new ConstructorArgumentValues();
//        argValues.addIndexedArgumentValue(0, rootBeanDefinition2);
//        argValues.addIndexedArgumentValue(1, rootBeanDefinition3);
//        rootBeanDefinition1.setConstructorArgumentValues(argValues);
        //2.或者通过setter方法注入方式
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("car", rootBeanDefinition2));
        propertyValues.addPropertyValue(new PropertyValue("dog", rootBeanDefinition3));
        rootBeanDefinition1.setPropertyValues(propertyValues);

        Person person = (Person) beanFactory.getBean("person");
        System.out.println(person);
    }
}
