package com.dge1992.spring.ioc.part7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 字面值测试
 */
public class ValueTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc/part7/value.xml");
        ValueDemo valueDemo = (ValueDemo) context.getBean("valueDemo");
        System.out.println(valueDemo);
    }
}
