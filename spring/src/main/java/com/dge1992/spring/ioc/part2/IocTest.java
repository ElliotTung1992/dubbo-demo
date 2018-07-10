package com.dge1992.spring.ioc.part2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 传统模式获取对象和springIOC获取对象比较
 */
public class IocTest {

    public static void main(String[] args) {

        //传统模式
        People people = new People("王俊凯", 11, new Car("保时捷"));
        people.driveCar();

        //springIOC获取对象
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc/part2/ioc.xml");
        Person person = (Person) context.getBean("person");
        person.driveCar();
    }
}
