package com.dge1992.spring.ioc.part14;

public class BeanPostProcesserDemo {
    private String name;
    private int age;

    public void sayHello(){
        System.out.println("hello world");
    }

    public void sayBye(){
        System.out.println("see you next");
    }

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
        return "BeanPostProcesserDemo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
