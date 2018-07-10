package com.dge1992.spring.ioc.part5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 依赖注入的三种方式
 */
public class DITest {

    public static void main(String[] args) {

        //构造方法注入
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc/part5/DITest.xml");
        Cat cat = (Cat) context.getBean("cat");
        System.out.println(cat);

        //set方法注入
        Dog dog = (Dog) context.getBean("dog");
        System.out.println(dog);

        //接口注入(退役)

    }
}
