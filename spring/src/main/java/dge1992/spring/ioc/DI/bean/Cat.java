package dge1992.spring.ioc.DI.bean;

import org.springframework.stereotype.Component;

@Component
public class Cat extends Animal{

    private String name = "cat";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
