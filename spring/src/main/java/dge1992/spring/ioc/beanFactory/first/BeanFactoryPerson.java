package dge1992.spring.ioc.beanFactory.first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanFactoryPerson {

    public BeanFactoryPerson() {
    }

    @Autowired
    private BeanFactoryCar beanFactoryCar;

    public BeanFactoryPerson(BeanFactoryCar beanFactoryCar){
        this.beanFactoryCar = beanFactoryCar;
    }

    public BeanFactoryCar getBeanFactoryCar() {
        return beanFactoryCar;
    }

    public void setBeanFactoryCar(BeanFactoryCar beanFactoryCar) {
        this.beanFactoryCar = beanFactoryCar;
    }

    @Override
    public String toString() {
        return "BeanFactoryPerson{" +
                "beanFactoryCar=" + beanFactoryCar +
                '}';
    }
}
