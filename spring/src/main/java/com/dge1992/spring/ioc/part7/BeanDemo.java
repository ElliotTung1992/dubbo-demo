package com.dge1992.spring.ioc.part7;

public class BeanDemo {
    String name;

    public BeanDemo() {
    }

    public BeanDemo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BeanDemo{" +
                "name='" + name + '\'' +
                '}';
    }
}
