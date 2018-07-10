package com.dge1992.spring.ioc.part8;

public class Eye {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Eye{" +
                "name='" + name + '\'' +
                '}';
    }
}
