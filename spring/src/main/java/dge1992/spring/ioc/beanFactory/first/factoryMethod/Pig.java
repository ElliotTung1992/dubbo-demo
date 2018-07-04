package dge1992.spring.ioc.beanFactory.first.factoryMethod;

public class Pig {

    String name;

    public Pig() {
    }

    public Pig(String name) {
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
        return "Pig{" +
                "name='" + name + '\'' +
                '}';
    }
}
