package com.dge1992.spring.ioc.part13;

/**
 * 蜘蛛侠
 */
public class SpiderMan {

    private String name = "皮特";
    private int age = 10;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "SpiderMan{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
