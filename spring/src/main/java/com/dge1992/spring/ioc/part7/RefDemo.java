package com.dge1992.spring.ioc.part7;

public class RefDemo {

    String name;

    public RefDemo() {
    }

    public RefDemo(String name) {
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
        return "RefDemo{" +
                "name='" + name + '\'' +
                '}';
    }
}
