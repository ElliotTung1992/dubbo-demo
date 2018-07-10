package com.dge1992.spring.ioc.part3;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * 管理对象间的依赖关系的三种方式
 */
public class IoCServiceProviderTest {

    public static void main(String[] args) {
        //直接编码方式
        //test1();
        //配置文件方式(已实现)
        //test2();
        //元数据方式(已实现)
        test3();

        //容器的两种实现方式 BeanFactory和ApplicationContext
        //test4();
    }

    private static void test4() {
        //BeanFactory
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(""));

        //ApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext("");
    }

    private static void test3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc/part3/test3.xml");
        Person person = (Person) context.getBean("person");
        System.out.println(person);
    }

    private static void test2() {
        //创建容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("ioc/part3/test2.xml");
        Person person = (Person) beanFactory.getBean("person");
        System.out.println(person);
    }

    private static void test1() {
        //创建容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //创建bean定义
        AbstractBeanDefinition beanDefinition = new RootBeanDefinition(Person.class);
        AbstractBeanDefinition beanDefinition1 = new RootBeanDefinition(Dog.class);
        //将bean定义注册到容器中
        beanFactory.registerBeanDefinition("person", beanDefinition);
        beanFactory.registerBeanDefinition("dog", beanDefinition1);
        //指定依赖关系
        //1.通过构造方法
        /*ConstructorArgumentValues values = new ConstructorArgumentValues();
        values.addIndexedArgumentValue(0, beanDefinition1);
        beanDefinition.setConstructorArgumentValues(values);*/
        //2.通过set方法注入方式
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("name", "范冰冰"));
        propertyValues.addPropertyValue(new PropertyValue("dog", beanDefinition1));
        beanDefinition.setPropertyValues(propertyValues);
        Person person = (Person) beanFactory.getBean("person");
        System.out.println(person);
    }
}
