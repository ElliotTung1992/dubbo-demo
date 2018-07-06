package dge1992.spring.ioc.DI.bean;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class People {

    private String name;

    @Resource(name = "cat")
    private Animal animal;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
