package com.dge1992.spring.ioc.part9;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * bean之间的关系
 */
public class BeanTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc/part9/bean.xml");
        Son son = (Son) context.getBean("son");
        System.out.println(son.getMoney());
    }
}
