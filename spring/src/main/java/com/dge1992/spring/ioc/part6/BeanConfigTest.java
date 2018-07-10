package com.dge1992.spring.ioc.part6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean的配置方式
 */
public class BeanConfigTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc/part6/beanConfigTest.xml");
        //静态工厂方法
        FruitStore fruitStore = (FruitStore) context.getBean("fruitStore1");
        System.out.println(fruitStore);
        //静态工厂方法 带参数
        FruitStore fruitStore2 = (FruitStore) context.getBean("fruitStore2");
        System.out.println(fruitStore2);
        //非静态工厂方法
        FruitStore fruitStore3 = (FruitStore) context.getBean("fruitStore3");
        System.out.println(fruitStore3);
        //自定义factoryBean
        FruitStore fruitStore4 = (FruitStore) context.getBean("fruitStore4");
        System.out.println(fruitStore4);
    }
}
