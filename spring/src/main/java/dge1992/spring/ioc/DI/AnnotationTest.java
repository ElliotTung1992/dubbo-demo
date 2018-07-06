package dge1992.spring.ioc.DI;

import dge1992.spring.ioc.DI.bean.People;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 基于注解的自动注入
 */
public class AnnotationTest {

    public static void main(String[] args) {
        ApplicationContext appletContext = new ClassPathXmlApplicationContext("ioc/DI/AnnotationTest.xml");
        People people = (People) appletContext.getBean("people");
        System.out.println(people.getAnimal());
    }
}
