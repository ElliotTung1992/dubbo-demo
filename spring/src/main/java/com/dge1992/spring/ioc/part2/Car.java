package com.dge1992.spring.ioc.part2;

import org.springframework.stereotype.Component;

/**
 * car类
 */
@Component
public class Car {

    private String name;

    public Car() {

    }

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void drive(){
        System.out.println("开车");
    }
}
