package dge1992.spring.ioc.beanFactory.second.beanPostProcessor;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class BeanPostProcessorTest {

    public static void main(String[] args) {
        ConfigurableBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("ioc/beanFactory/second/beanPostProcessor/beanPostProcessor.xml"));
        beanFactory.addBeanPostProcessor(new MonkeyPostProcessor());
        Monkey monkey = (Monkey) beanFactory.getBean("monkey");
        System.out.println(monkey);
    }
}
