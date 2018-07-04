package dge1992.spring.ioc.beanFactory.first.methodInjection;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class Person implements BeanFactoryAware{

    private Cat cat;
    private BeanFactory beanFactory;

    public Cat getCat() {
        return (Cat) beanFactory.getBean("cat1");
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
