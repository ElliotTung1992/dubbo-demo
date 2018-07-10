package com.dge1992.spring.ioc.part6;

/**
 * 梨
 */
public class Pear {
    private String name;

    public Pear() {
    }

    public Pear(String name) {
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
        return "Pear{" +
                "name='" + name + '\'' +
                '}';
    }
}
