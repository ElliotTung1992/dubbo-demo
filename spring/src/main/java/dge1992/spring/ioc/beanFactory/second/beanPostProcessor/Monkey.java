package dge1992.spring.ioc.beanFactory.second.beanPostProcessor;

import org.springframework.beans.factory.InitializingBean;

public class Monkey implements Animal, InitializingBean {

    private String name;

    public Monkey() {
        System.out.println("Monkey初始化");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Monkey{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet执行了");
    }
}
