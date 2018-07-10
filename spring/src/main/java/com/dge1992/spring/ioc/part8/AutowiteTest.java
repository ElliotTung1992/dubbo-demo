package com.dge1992.spring.ioc.part8;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 自动绑定测试
 */
public class AutowiteTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc/part8/autowiteTest.xml");
        //byType
        Pig pig1 = (Pig) context.getBean("pig1");
        System.out.println(pig1);

        //byName
        Pig pig2 = (Pig) context.getBean("pig2");
        System.out.println(pig2);

        //constructor
        Pig pig3 = (Pig) context.getBean("pig3");
        System.out.println(pig3);
    }
}
