package com.dge1992.spring.ioc.part10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 作用域测试
 */
public class ScopeTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc/part10/scopeTest.xml");
        SingletonDemo singletonDemo1 = (SingletonDemo) context.getBean("singletonDemo");
        SingletonDemo singletonDemo2 = (SingletonDemo) context.getBean("singletonDemo");

        System.out.println(singletonDemo1 == singletonDemo2);

        PrototypeDemo prototypeDemo1 = (PrototypeDemo) context.getBean("prototypeDemo");
        PrototypeDemo prototypeDemo2 = (PrototypeDemo) context.getBean("prototypeDemo");

        System.out.println(prototypeDemo1 == prototypeDemo2);
    }
}
