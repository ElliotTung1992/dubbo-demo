package com.dge1992.spring.ioc.part14;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 自定义BeanPostProcessor
 */
public class TestBeanPostProcesser implements BeanPostProcessor{

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        BeanPostProcesserDemo beanPostProcesserDemo = (BeanPostProcesserDemo) o;
        beanPostProcesserDemo.setName("哈哈");
        System.out.println(o);
        System.out.println(s);
        System.out.println("后置处理器前置方法执行");

        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        BeanPostProcesserDemo beanPostProcesserDemo = (BeanPostProcesserDemo) o;
        beanPostProcesserDemo.setAge(11);
        System.out.println(o);
        System.out.println(s);
        System.out.println("后置处理器后置方法执行");

        return o;
    }
}
