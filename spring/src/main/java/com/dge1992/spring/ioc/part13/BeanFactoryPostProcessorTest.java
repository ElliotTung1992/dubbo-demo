package com.dge1992.spring.ioc.part13;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * 插手容器的启动
 */
public class BeanFactoryPostProcessorTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc/part13/beanFactoryPostProcessorTest.xml");
        SpiderMan spiderMan = (SpiderMan) context.getBean("spiderMan");
        System.out.println(spiderMan);
    }
}
