package dge1992.spring.ioc.beanFactory.second.beanPostProcessor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanPostProcessorTest2 {

    public static void main(String[] args) {
        ApplicationContext appletContext = new ClassPathXmlApplicationContext("ioc/beanFactory/second/beanPostProcessor/beanPostProcessor.xml");
        appletContext.getBean("monkey");
    }
}
