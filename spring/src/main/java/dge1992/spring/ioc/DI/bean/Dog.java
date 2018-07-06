package dge1992.spring.ioc.DI.bean;

import org.springframework.stereotype.Component;

@Component
public class Dog extends Animal{

    private String name = "dog";

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
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
