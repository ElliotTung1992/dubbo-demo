package com.dge1992.spring.ioc.part14;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean的一生
 */
public class BeanLifeTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc/part14/BeanLifeTest.xml");
        BeanPostProcesserDemo beanPostProcesserDemo = (BeanPostProcesserDemo) context.getBean("beanPostProcesserDemo");
        System.out.println(beanPostProcesserDemo);
    }
}
