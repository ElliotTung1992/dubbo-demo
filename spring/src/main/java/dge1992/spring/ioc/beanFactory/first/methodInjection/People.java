package dge1992.spring.ioc.beanFactory.first.methodInjection;

import org.springframework.beans.factory.ObjectFactory;

public class People {

    private ObjectFactory<Dog> factory;

    public Dog getDog() {
        return factory.getObject();
    }

    public void setFactory(ObjectFactory<Dog> factory) {
        this.factory = factory;
    }
}
