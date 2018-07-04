package dge1992.spring.ioc.beanFactory.second.beanFactoryPostProcessor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring IoC容器允许BeanFactoryPostProcessor在容器实例化任何bean之前读取bean的定义(配置元数据)，
 * 并可以修改它。同时可以定义多个BeanFactoryPostProcessor，
 * 通过设置'order'属性来确定各个BeanFactoryPostProcessor执行顺序。
 */
public class BeanFactoryPostProcessorTest {

    public static void main(String[] args) {
        ApplicationContext appletContext = new ClassPathXmlApplicationContext("ioc/beanFactory/second/beanFactoryPostProcessor/beanFactoryPostProcessor.xml");
        Student student = (Student) appletContext.getBean("student");
        System.out.println(student);


    }
}
