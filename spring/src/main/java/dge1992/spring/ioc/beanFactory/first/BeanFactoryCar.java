package dge1992.spring.ioc.beanFactory.first;

import org.springframework.stereotype.Component;

@Component
public class BeanFactoryCar {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
