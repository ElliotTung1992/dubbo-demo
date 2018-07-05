package dge1992.spring.ioc.applicationContext.resourceLoaderAndResource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ResourceLoader;

public class ResourceLoaderAwareTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc/applicationContext/resourceLoaderAndResource/hehe.xml");
        Hehe hehe = (Hehe) context.getBean("hehe");
        ResourceLoader resourceLoader = hehe.getResourceLoader();
        System.out.println(resourceLoader.getClass());
    }
}
